package com.reborn.database;

import org.junit.Test;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

/**
 * Created by Reborn。 on 2017/5/11.
 * ClassNotFoundException:
 * > 没导包
 * > driverClassName打错
 *
 * SQLException:
 * > 检查三个参数：url,username,password
 * > 检查是否开启MySQL服务器
 */
public class ConnectDB {
    @Test
    public void fun1() throws ClassNotFoundException, SQLException
    {
        /*jdbc四大配置参数：
        driverClassName: com.mysql.jdbc.Driver
        url: jdbc:mysql://localhost:3306/数据库名
        username: root
        password: p123
         */

        //加载数据库驱动
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/mydb";
        String username = "root";
        String password = "p123";
        //获取数据库连接
        Connection con = DriverManager.getConnection(url,username,password);
        System.out.println(con);

    }

    //使用JdbcUtils获得数据库连接
    @Test
    public void fun2() throws SQLException {
        Connection con = JdbcUtils.getConnection();
        System.out.println(con);

    }
}
