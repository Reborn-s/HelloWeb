package com.reborn.database;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by Reborn。 on 2017/5/12.
 * 通过配置文件获得数据库连接工具类
 * JdbcUtils.java 1.0
 */
public class JdbcUtils {
    private static Properties props = null;

    //只在JdbcUtils类被加载时执行一次
    static
    {
        try {
            //1.加载配置文件
            InputStream in = JdbcUtils.class.getClassLoader().
                    getResourceAsStream("resources/dbconfig.properties");
            props = new Properties();
            props.load(in);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //2. 加载驱动类
        try {
            Class.forName(props.getProperty("driverClassName"));
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                props.getProperty("url"),props.getProperty("username"),props.getProperty("password"));
    }
}
