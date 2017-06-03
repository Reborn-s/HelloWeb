package com.reborn.dao;

import com.reborn.domain.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Reborn。 on 2017/5/12.
 * 持久层（数据库层）
 * 具体某一实现类：用jdbc来访问数据库
 */
public class JdbcUserDaoImpl implements UserDao {

    @Override
    public void addUser(User form) {
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            //得到数据库连接
            con = JdbcUtils.getConnection();

            //创建sql模板
            String sql  = "insert into t_user values(?,?,?,?)";
            //获取PreparedStatement对象
            pstmt = con.prepareStatement(sql);
            //设置查询参数
            pstmt.setString(1,form.getUsername());
            pstmt.setString(2,form.getPassword());
            pstmt.setInt(3,form.getAge());
            pstmt.setString(4,form.getGender());

            //执行sql语句
            pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                if(pstmt!=null) pstmt.close();
                if(con!=null)   con.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public User findUserByName(String username) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            con = JdbcUtils.getConnection();
            String sql = "select * from t_user where username=?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1,username);
            rs = pstmt.executeQuery();

            //把rs转换成User类型并返回
            if(rs==null)
                return null;

            if(rs.next())
            {
                //ORM-->对象关系映射，ORM工具：hibernate!
                User user = new User();
                user.setUsername(rs.getString(1));
                user.setPassword(rs.getString(2));
                user.setAge(rs.getInt(3));
                user.setGender(rs.getString(4));
                return user;
            }else
                return null;

        }catch (Exception e)
        {
            throw  new RuntimeException(e);
        }finally {
            try {
                if(rs!=null)    rs.close();
                if(pstmt!=null) pstmt.close();
                if(con!=null)   con.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
