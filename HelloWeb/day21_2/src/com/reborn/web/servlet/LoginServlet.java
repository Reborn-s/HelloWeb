package com.reborn.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Reborn。 on 2017/5/17.
 */
@WebServlet(name = "LoginServlet",urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("username");
        if(name!=null&&!name.trim().isEmpty())
        {
            if(name.equals("admin"))
            {
                request.getSession().setAttribute("admin",name);
                //request.getRequestDispatcher("/admin/admin.jsp").forward(request,response);
            }else
            {
                request.getSession().setAttribute("user",name);
                //request.getRequestDispatcher("/user/user.jsp").forward(request,response);
            }
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }else
        {
            request.setAttribute("msg","请输入用户名登录！");
            request.getRequestDispatcher("login.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
