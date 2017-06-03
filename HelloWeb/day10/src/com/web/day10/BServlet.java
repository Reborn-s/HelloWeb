package com.web.day10;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Reborn。 on 2017/5/4.
 * 实现重定向：从Bservlet重定向到Cservlet
 */
@WebServlet(name = "BServlet",urlPatterns = {"/Bservlet"})
public class BServlet extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
//        System.out.println("BServlet");
//        response.setHeader("Location","/Cservlet");
//        response.setStatus(302);

        //快速重定向
        response.sendRedirect("/Cservlet");

    }
}
