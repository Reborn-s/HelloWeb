package com.reborn.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by Reborn。 on 2017/5/17.
 * 对admin下的资源添加过滤器
 */
@WebFilter(filterName = "AdminFilter",urlPatterns = {"/admin/*"})
public class AdminFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest)req;
        String name = (String) request.getSession().getAttribute("admin");
        if(name!=null)
        {
            chain.doFilter(req, resp);

        } else
        {
            request.setAttribute("msg","您肯定不是管理员，也请不要瞎溜达");
            request.getRequestDispatcher("/login.jsp").forward(req,resp);
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
