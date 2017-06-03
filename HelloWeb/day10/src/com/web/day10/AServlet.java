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
@WebServlet(name = "AServlet",urlPatterns = {"/AServlet"})
public class AServlet extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setHeader("aaa","AAA");
        response.addHeader("aaa","BBB");
        response.setIntHeader("Content-Length",330);
        response.setDateHeader("expires",-1);//禁止浏览器缓存

        response.sendError(404,"就不给你看！");

    }
}
