package com.web.day10;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Reborn。 on 2017/5/4.
 */
@WebServlet(name = "FServlet",urlPatterns = {"/Fservlet"})
public class FServlet extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        //jsp页面的meta头也可以充当响应头，起到相同的作用
        response.setHeader("Cache-control","no-cache");
        response.setHeader("pragma","no-cache");
        response.setDateHeader("expires",-1);

        response.getWriter().print("hello world!");
    }
}
