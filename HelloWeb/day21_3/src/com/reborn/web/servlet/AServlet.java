package com.reborn.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Reborn。 on 2017/5/18.
 */
@WebServlet(name = "AServlet",urlPatterns = {"/Aservlet"})
public class AServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //这个响应头是针对servlet的，不是jsp的
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        String name = request.getParameter("username");
        System.out.println(name);
        response.getWriter().print(name);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        String name = request.getParameter("username");
        System.out.println(name);
        response.getWriter().print(name);
    }
}
