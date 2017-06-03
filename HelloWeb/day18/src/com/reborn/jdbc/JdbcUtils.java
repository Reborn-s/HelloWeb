package com.reborn.jdbc;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Reborn。 on 2017/5/13.
 * 使用数据库连接池得到数据库连接和连接池
 * JdbcUtils 2.0
 */
public class JdbcUtils {
    //配置文件的默认配置！要求必须在src目录下给出c3p0-config.xml！
    private static ComboPooledDataSource dataSource  = new ComboPooledDataSource();

    //使用连接池返回一个连接对象
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    //使用连接池返回连接池对象
    public static DataSource getDataSource()
    {
        return dataSource;
    }
}
