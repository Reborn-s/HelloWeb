package com.web.day10;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Reborn。 on 2017/5/4.
 * 实现定时更新
 */
@WebServlet(name = "DServlet",urlPatterns = {"/Dservlet"})
public class DServlet extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        //发送响应体
        PrintWriter writer = response.getWriter();
        writer.print("欢迎登陆！5秒后自动跳转到另一个页面");

        response.setHeader("Refresh","5;URL=/Eservlet");

    }
}
