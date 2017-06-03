package com.reborn.database;

import org.junit.Test;

import java.sql.*;

/**
 * Created by Reborn。 on 2017/5/11.
 * 对MySQL数据库做增删改查
 */
public class ManipulateDB {

    @Test
    public void fun() throws ClassNotFoundException
    {
        String driverClassName = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/mydb";
        String username = "root";
        String password = "p123";

        Class.forName(driverClassName);//加载数据库驱动（注册驱动）

        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            con = DriverManager.getConnection(url,username,password);//得到数据库连接
            stmt = con.createStatement();//Statment可以向数据库发送DML DDL语句
            int result;
            //增
            String insertSql = "insert into emp values('店小二','234',8000)";
            result = stmt.executeUpdate(insertSql);
            System.out.println(result);

            //改
            String updateSql = "update emp set salary=3300 where username='店小二'";
            result = stmt.executeUpdate(updateSql);
            System.out.println(result);

            //删
            String deleteSql = "delete from emp where username='张三'";
            result = stmt.executeUpdate(deleteSql);
            System.out.println(result);

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                //倒着关闭数据库资源
                if(rs!=null) rs.close();
                if(stmt!=null) stmt.close();
                if(con!=null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void query() throws ClassNotFoundException
    {
        String driverClassName = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/mydb";
        String username = "root";
        String password = "p123";

        Class.forName(driverClassName);

        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            con = DriverManager.getConnection(url,username,password);
            stmt = con.createStatement();

            //查询功能
            String selectSql = "select * from emp";
            rs = stmt.executeQuery(selectSql);
            /*while(rs.next())
            {
                String id = rs.getString(1);
                String name = (String)rs.getObject("name");
                double sal = rs.getDouble("sal");

                System.out.println(id+", "+name+", "+sal);
            }*/

            ResultSetMetaData data = rs.getMetaData();
            int columns = data.getColumnCount();
            while(rs.next())
            {
                for(int i=1;i<=columns;i++)
                {
                    String name = data.getColumnName(i);
                    String value = rs.getString(name);
                    System.out.print(value);
                    if(i<columns)
                        System.out.print(" , ");
                }
                System.out.println();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {

            try {
                if(rs!=null) rs.close();
                if(stmt!=null) stmt.close();
                if(con!=null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
