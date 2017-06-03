package com.reborn.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by Reborn。 on 2017/5/18.
 * 在过滤器中处理全站编码问题
 */
@WebFilter(filterName = "EncodingFilter",servletNames = {"AServlet"})
public class EncodingFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        System.out.println("start filter...");
        HttpServletRequest httpServletRequest = (HttpServletRequest)req;
        String method = httpServletRequest.getMethod();
        if(method.equals("POST"))
        {
            //处理post请求编码问题
            //这里不知道为啥没效果！！！？？？？求解答求填坑，在servlet里直接写却有效果
            req.setCharacterEncoding("utf-8");
            chain.doFilter(req, resp);
        }else if(method.equals("GET"))
        {
            //处理get请求编码问题
            //自定义一个request,调包这个req，将req的getParameter()方法进行编码功能的增强
            /**
             * 1. 继承request包装类，写一个自定义request
             * 2. 在放行时使用我们自己的request，此时getParameter()已经可以处理编码问题了
             */
            EncodingRequest request = new EncodingRequest(httpServletRequest);
            chain.doFilter(request, resp);
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
