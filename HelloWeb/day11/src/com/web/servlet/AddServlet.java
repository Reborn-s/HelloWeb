package com.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Reborn。 on 2017/5/6.
 */
@WebServlet(name = "AddServlet",urlPatterns = {"/AddServlet"})
public class AddServlet extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String one = request.getParameter("one");
        String two = request.getParameter("two");
        int num1 = Integer.parseInt(one);
        int num2 = Integer.parseInt(two);

        int sum  =num1+num2;

        request.setAttribute("result",sum);

        request.getRequestDispatcher("/add/result.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }
}
