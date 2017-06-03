package com.web.day10_encode;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Reborn。 on 2017/5/5.
 * tomcat8.5对请求参数默认使用utf-8编码
 */
@WebServlet(name = "EncodeServlet",urlPatterns = {"/EncodeServlet"})
public class EncodeServlet extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        request.setCharacterEncoding("utf-8");
        String s = request.getParameter("username");
        System.out.println(s);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String s = request.getParameter("username");
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().print(s+"<br/>");
        System.out.println(s);
        byte[] bytes = s.getBytes("utf-8");
        s = new String(bytes,"utf-8");
        System.out.println(s);

        response.getWriter().print(s);
    }
}
