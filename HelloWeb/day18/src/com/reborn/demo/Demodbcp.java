package com.reborn.demo;

import org.apache.commons.dbcp2.BasicDataSource;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Reborn。 on 2017/5/13.
 * dbcp连接池
 */
public class Demodbcp  {

    @Test
    public void fun() throws SQLException {
        /**
         * 1. 创建连接池对象
         * 2. 配置四大参数
         * 3. 配置连接池参数
         * 4. 获得Connection对象
         */

        //Step 1
        BasicDataSource dataSource = new BasicDataSource();

        //Step 2
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/mydb");
        dataSource.setUsername("root");
        dataSource.setPassword("p123");

        //Step 3
        dataSource.setMaxTotal(20);//设置最大连接数，包括空闲和非空闲的
        dataSource.setMaxIdle(10);//设置最大空闲连接数
        dataSource.setMinIdle(3);//设置最小空闲连接数
        dataSource.setMaxWaitMillis(1000);//设置最大等待时间，如果等待时间过了还没有连接归还回来就抛出异常

        //step 4
        Connection con  =dataSource.getConnection();
        System.out.println(con.getClass().getName());
        con.close();
    }
}
