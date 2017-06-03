package com.web.day10_1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Reborn。 on 2017/5/4.
 */
@WebServlet(name = "HServlet",urlPatterns = {"/Hservlet"})
public class HServlet extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String addr = request.getRemoteAddr();
        String method = request.getMethod();
        String userAgent = request.getHeader("User-Agent");

        System.out.println("IP:"+addr);
        System.out.println("method:"+method);
        System.out.println("userAgent:"+userAgent);

        if(userAgent.toLowerCase().contains("chrome"))
            response.getWriter().print("你好"+addr+":您的浏览器是：chorme");
        else if(userAgent.toLowerCase().contains("msie"))
            response.getWriter().print("你好"+addr+":您的浏览器是：ie");
        else if(userAgent.toLowerCase().contains("gecko"))
            response.getWriter().print("你好"+addr+":您的浏览器是：firefox");
    }
}
