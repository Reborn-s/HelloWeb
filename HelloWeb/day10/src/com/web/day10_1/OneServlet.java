package com.web.day10_1;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Reborn。 on 2017/5/4.
 * 实现请求转发和包含
 * forward:留头不留体
 * include:留头又留体
 */
@WebServlet(name = "OneServlet",urlPatterns = {"/Oneservlet"})
public class OneServlet extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        System.out.println("OneServlet...");

        RequestDispatcher rd = request.getRequestDispatcher("/Twoservlet");
        response.setHeader("aaa","AAA");
        response.getWriter().print("I'm OneServlet!<br/>");

        request.setAttribute("name","zhangsan");
        //rd.include(request,response);
        rd.forward(request,response);

    }
}
