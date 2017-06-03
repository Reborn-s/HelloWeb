package com.web.servlet;

import javax.servlet.*;
import java.io.IOException;
import java.util.Enumeration;

/**
 * Created by Reborn。 on 2017/5/3.
 * 模拟GenericServlet
 */
public class BServlet implements Servlet {
    private ServletConfig config;

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        this.config = servletConfig;
        init();
    }

    public void init()
    {
        System.out.print("我出生了！");
    }

    @Override
    public void destroy() {

    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {

    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public ServletConfig getServletConfig() {
        return this.config;
    }

    public String getServletName()
    {
        return this.getServletConfig().getServletName();
    }

    public String getInitParameter(String name)
    {
        return this.getServletConfig().getInitParameter(name);
    }

    public Enumeration<String> getInitParameterNames(String name)
    {
        return this.getServletConfig().getInitParameterNames();
    }

    public ServletContext getServletContext()
    {
        return this.config.getServletContext();
    }
}
