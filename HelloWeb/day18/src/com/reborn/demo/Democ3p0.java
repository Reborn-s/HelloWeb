package com.reborn.demo;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Reborn。 on 2017/5/13.
 * c3p0数据库连接池使用
 */
public class Democ3p0 {

    @Test
    public void fun1() throws PropertyVetoException, SQLException {
        //创建连接池对象
        ComboPooledDataSource dataSource = new ComboPooledDataSource();

        //对池进行四大参数的设置
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/mydb");
        dataSource.setUser("root");
        dataSource.setPassword("p123");

        //对池进行参数配置
        dataSource.setAcquireIncrement(5);
        dataSource.setMaxPoolSize(50);
        dataSource.setMinPoolSize(3);
        dataSource.setInitialPoolSize(20);

        Connection con  =dataSource.getConnection();
        System.out.println(con);
        con.close();
    }

    //使用c3p0-config.xml的默认配置
    @Test
    public void fun2() throws SQLException {
        /**
         * 在创建连接池对象时，这个对象会自动加载src下的指定名称为c3p0-confg.xml的配置文件，不用我们指定
         */
        ComboPooledDataSource dataSource = new ComboPooledDataSource();

        //若在后面人为添加池参数，会覆盖初始化得到的池参数
        /*dataSource.setAcquireIncrement(5);
        dataSource.setMaxPoolSize(50);
        dataSource.setMinPoolSize(3);
        dataSource.setInitialPoolSize(20);*/

        Connection con = dataSource.getConnection();
        System.out.println(con);
        con.close();
    }

    //使用c3p0-config.xml的命名配置
    @Test
    public void fun3() throws SQLException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource("oracle-config");
        Connection con  =  dataSource.getConnection();
        System.out.println(con);
        con.close();
    }
}
