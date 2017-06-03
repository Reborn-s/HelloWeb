package com.reborn.bookstore.category.dao;

import cn.itcast.jdbc.TxQueryRunner;
import com.reborn.bookstore.category.domain.Category;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Reborn。 on 2017/5/28.
 */
public class CategoryDao {
    private QueryRunner qr = new TxQueryRunner();

    public List<Category> findAll()
    {
        String sql = "select * from t_category where pid is null order by orderBy";
        try {
            List<Category> parents=   qr.query(sql,new BeanListHandler<Category>(Category.class));
            String sql2 = "select * from t_category where pid=? order by orderBy";
            for(Category category:parents)
            {
                List<Category> children = qr.query(sql2,new BeanListHandler<Category>(Category.class),category.getCid());
                category.setChildren(children);
                for(Category child:children)
                    child.setParents(category);
            }
            return parents;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void add(Category category) {
        String sql = "insert into t_category values(?,?,?,?,?)";
        String pid = null;
        if(category.getParents()!=null)
            pid = category.getParents().getCid();
        Object[] params = {category.getCid(),category.getCname(),pid,category.getDesc(),null};
        try {
            qr.update(sql,params);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Category findByCid(String cid) {
        String sql = "select * from t_category where cid=?";
        try {
            return qr.query(sql,new BeanHandler<Category>(Category.class),cid);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Category> findByPid(String pid)
    {
        String sql = "select * from t_category where pid=?";
        try {
            return qr.query(sql,new BeanListHandler<Category>(Category.class),pid);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void edit(Category category) {
        String sql = "update t_category set cname=?, pid=? where cid=?";
        String pid=null;
        if(category.getParents()!=null)
            pid=category.getParents().getCid();
        try {
            qr.update(sql,category.getCname(),pid,category.getCid());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(String cid)
    {
        String sql = "delete from t_category where cid=?";
        try {
            qr.update(sql,cid);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
