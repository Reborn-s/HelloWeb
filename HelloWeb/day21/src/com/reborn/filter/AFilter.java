package com.reborn.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * Created by Reborn。 on 2017/5/17.
 */
@WebFilter(filterName = "AFilter",urlPatterns = {"/*"})
public class AFilter implements Filter {
    public void destroy() {

    }

    //每次过滤的时候即会调用此方法
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("Afilter#start");
        chain.doFilter(req, resp);
        System.out.println("Afilter#end");
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
