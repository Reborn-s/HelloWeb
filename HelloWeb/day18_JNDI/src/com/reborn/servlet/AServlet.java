package com.reborn.servlet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Reborn。 on 2017/5/14.
 * 获取JNDI中的资源
 */
@WebServlet(name = "AServlet",urlPatterns = {"/Aservlet"})
public class AServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection con = null;
        try {
            //1.创建JNDI的上下文对象
            Context context = new InitialContext();

            //2.查询出入口
            Context envContext = (Context) context.lookup("java:comp/env");

            //3.进行二次查找，找到需要的资源
            //使用的参数与server.xml中<Resource>元素的name属性一致
            DataSource dataSource = (DataSource) envContext.lookup("jdbc/dataSource");

            con = dataSource.getConnection();
            System.out.println(con);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            try {
                if(con!=null)   con.close();
                else System.out.println("null");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
