package com.reborn.bookstore.book.dao;

import cn.itcast.jdbc.TxQueryRunner;
import com.reborn.bookstore.book.domain.Book;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Reborn。 on 2017/5/28.
 */
public class BookDao {
    private QueryRunner qr = new TxQueryRunner();

    public List<Book> findByCategory(String cid)
    {
        String sql = "select * from t_book where cid=? and del=false order by orderBy desc";
        try {
            return qr.query(sql,new BeanListHandler<Book>(Book.class),cid);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Book> findAll()
    {
        String sql = "select * from t_book where del=false order by orderBy desc";
        try {
            return qr.query(sql,new BeanListHandler<Book>(Book.class));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Book load(String bid)
    {
        String sql = "select * from t_book where bid=? and del=false order by orderBy desc";
        try {
            return qr.query(sql,new BeanHandler<Book>(Book.class),bid);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void add(Book book) {
        String sql = "insert into t_book values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            qr.update(sql,book.getBid(),book.getBname(),book.getAuthor(),book.getPrice(),
                    book.getCurrPrice(),book.getDiscount(),book.getPress(),book.getPublishtime(),
                    book.getEdition(),book.getPageNum(),book.getWordNum(),book.getPrinttime(),
                    book.getBooksize(),book.getPaper(),book.getCatogory().getCid(),
                    book.getImage_w(),book.getImage_b(),null,false);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void delete(String bid) {
        String sql = "update t_book set del=true where bid=?";
        try {
            qr.update(sql,bid);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void edit(Book book) {
        String sql = "update t_book set bname=?,author=?,price=?,currPrice=?,discount=?," +
                "press=?,publishtime=?,edition=?,pageNum=?,wordNum=?,printtime=?,booksize=?," +
                "paper=?,image_w=?,image_b=?,del=? where bid=?";
        Object[] params=new Object[]{book.getBname(),book.getAuthor(),book.getPrice(),
                book.getCurrPrice(),book.getDiscount(),book.getPress(),book.getPublishtime(),
                book.getEdition(),book.getPageNum(),book.getWordNum(),book.getPrinttime(),
                book.getBooksize(),book.getPaper(),
                book.getImage_w(),book.getImage_b(),false,book.getBid()};
        try {
            qr.update(sql,params);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
