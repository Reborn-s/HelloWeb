package com.reborn.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;

/**
 * Created by Reborn。 on 2017/5/17.
 * 对于不同的IP分别统计其访问次数
 */
@WebFilter(filterName = "IPFilter",urlPatterns = {"/*"})
public class IPFilter implements Filter {
    private FilterConfig config;
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        ServletContext application = config.getServletContext();
        Map<String,Integer> map = (Map<String, Integer>) application.getAttribute("map");
        HttpServletRequest request = (HttpServletRequest)req;
        String ip = request.getRemoteAddr();

        if(map.containsKey(ip))
        {
            int cnt = map.get(ip);
            map.put(ip,cnt+1);
        }else
            map.put(ip,1);

        application.setAttribute("map",map);

        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {
        this.config  = config;
    }

}
