package com.reborn.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * Created by Reborn。 on 2017/5/17.
 */
@WebFilter(filterName = "BFilter",urlPatterns = {"/*"},dispatcherTypes={DispatcherType.FORWARD})
public class BFilter implements Filter {
    public void destroy() {

    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("Bfilter#start");
        chain.doFilter(req, resp);
        System.out.println("Bfilter#end");
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
