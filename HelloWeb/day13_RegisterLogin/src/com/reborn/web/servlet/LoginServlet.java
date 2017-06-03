package com.reborn.web.servlet;

import com.reborn.domain.User;
import com.reborn.service.UserException;
import com.reborn.service.UserService;
import com.rebornJar.commons.CommonUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Reborn。 on 2017/5/10.
 */
@WebServlet(name = "LoginServlet",urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        UserService service = new UserService();
        User form = CommonUtils.toBean(request.getParameterMap(),User.class);
        try {
            User user = service.login(form);

            //添加Cookie
            Cookie cookie = new Cookie("user",user.getUsername());
            cookie.setMaxAge(60*60*24);
            response.addCookie(cookie);

            request.getSession().setAttribute("session_user",user);
            response.sendRedirect(request.getContextPath()+"/user/Welcome.jsp");
        } catch (UserException e) {
            request.setAttribute("msg",e.getMessage());
            request.setAttribute("user",form);
            request.getRequestDispatcher(request.getContextPath()+"/user/Login.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }
}
