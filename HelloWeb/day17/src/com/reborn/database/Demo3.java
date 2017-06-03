package com.reborn.database;

import org.junit.Test;

import java.sql.*;

/**
 * Created by Reborn。 on 2017/5/11.
 * 使用PrepareStatement防止SQL注入
 */
public class Demo3 {
    public boolean login(String username,String password) throws ClassNotFoundException
    {
        String driverClassName = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/mydb";
        String mysqlUsername = "root";
        String mysqlPassword = "p123";

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        Class.forName(driverClassName);
        try {
            con = DriverManager.getConnection(url,mysqlUsername,mysqlPassword);

            //定义sql模板
            String sql = "select * from emp where username=? and password=?";
            //通过sql模板获得PreparedStatement对象，使sql模板与此对象绑定在一起
            pstmt = con.prepareStatement(sql);

            //为sql模板传参，PreparedStatement的executeQuery()就不需要参数了，这种传参方式就防止了SQL注入
            pstmt.setString(1,username);
            pstmt.setString(2,password);
            //执行查询获得结果集
            rs = pstmt.executeQuery();

            return rs.next();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if(rs!=null)    rs.close();
                if(pstmt!=null) pstmt.close();
                if(con!=null)   con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void fun() throws Exception
    {
        String username = "a or 'a=a'";
        String password = "a or 'a==a'";
        System.out.println(login(username,password));
    }
}
