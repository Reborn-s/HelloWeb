package com.reborn.web.servlet;

import com.reborn.domain.User;
import com.reborn.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Reborn。 on 2017/5/10.
 */
@WebServlet(name = "UserServlet",urlPatterns={"/UserServlet"})
public class UserServlet extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        /*
        在servlet中service，然后通过service完成功能，把结果保存在request中并转发到jsp显示
         */
        UserService userService = new UserService();
        User user = userService.find();
        request.setAttribute("user",user);

        request.getRequestDispatcher("show.jsp").forward(request,response);
    }
}
