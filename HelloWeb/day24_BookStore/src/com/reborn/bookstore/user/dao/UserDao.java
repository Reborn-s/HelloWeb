package com.reborn.bookstore.user.dao;

import cn.itcast.jdbc.TxQueryRunner;
import com.reborn.bookstore.user.domain.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

/**
 * Created by Reborn。 on 2017/5/27.
 */
public class UserDao {
    private QueryRunner qr = new TxQueryRunner();

    public User findByActivationCode(String activationCode)
    {
        String sql = "select * from t_user where activationCode=?";
        try {
            return qr.query(sql,new BeanHandler<User>(User.class),activationCode);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public void updateActivationCode(String uid,boolean status)
    {
        String sql = "update t_user set status=? where uid=?";
        try {
            qr.update(sql,status,uid);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public User findByUsername(String username)
    {
        String sql = "select * from t_user where loginname=?";
        try {
            return qr.query(sql,new BeanHandler<User>(User.class),username);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public User findByEmail(String email)
    {
        String sql = "select * from t_user where email=?";
        try {
            return qr.query(sql,new BeanHandler<User>(User.class),email);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public void add(User user)
    {
        String sql = "insert into t_user values(?,?,?,?,?,?)";
        Object[] params = {user.getUid(),user.getLoginname(),user.getLoginpass(),
                        user.getEmail(),user.isStatus(),user.getActivationCode()};
        try {
            qr.update(sql,params);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
