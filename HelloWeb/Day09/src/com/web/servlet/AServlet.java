package com.web.servlet;

import javax.servlet.*;
import java.io.IOException;
import java.util.Enumeration;

/**
 * Created by Reborn。 on 2017/5/3.
 */
public class AServlet implements Servlet{

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("init()...");

        System.out.println(servletConfig.getServletName());
        System.out.println(servletConfig.getInitParameter("p1"));
        System.out.println(servletConfig.getInitParameter("p2"));

        Enumeration e = servletConfig.getInitParameterNames();
        while(e.hasMoreElements())
        {
            System.out.println(e.nextElement());
        }
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("service()...");
    }

    @Override
    public void destroy() {
        System.out.println("destroy()...");
    }
}
