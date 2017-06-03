package com.reborn.bookstore.user.web.servlet;

import com.reborn.bookstore.user.domain.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by Reborn。 on 2017/5/30.
 */
@WebFilter(filterName = "LoginFilter",
urlPatterns = {"/jsps/cart/*","/jsps/order/*"},
servletNames = {"CartServlet","OrderServlet"})
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        User user = (User) request.getSession().getAttribute("session_user");
        if(user!=null)
        {
            chain.doFilter(req,resp);
        }else
        {
            request.setAttribute("msg","您还没有登录，请登录！");
            request.getRequestDispatcher("/jsps/user/login.jsp").forward(request,resp);
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
