package com.reborn.book.dao;

import com.reborn.book.domain.Book;
import com.rebornJar.jdbcUtils.TxQueryRunner;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Reborn。 on 2017/5/18.
 */
public class BookDao {
    private QueryRunner qr = new TxQueryRunner();

    public List<Book> findAll()
    {
        String sql = "select * from t_book";
        try {
            return qr.query(sql,new BeanListHandler<Book>(Book.class));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Book> findByCategory(int category)
    {
        String sql = "select * from t_book where category=?";
        try {
            return qr.query(sql,new BeanListHandler<Book>(Book.class),category);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
