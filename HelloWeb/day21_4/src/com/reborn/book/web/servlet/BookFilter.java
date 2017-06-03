package com.reborn.book.web.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

/**
 * Created by Reborn。 on 2017/5/18.
 * 实现页面静态化
 */
@WebFilter(filterName = "BookFilter",servletNames = {"BookServlet"})
public class BookFilter implements Filter {
    private FilterConfig config;
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        /**
         * 访问servlet时判断是否存在html页面
         * 如果存在就直接重定向到html页面，不需要访问数据库
         * 如果不存在，就放行，将response向jsp输出的数据绑定到html页面，而不是客户端（浏览器）,再重定向到html页面
         */
        /**
         * 一、获取category参数，有四种情况，根据不同的情况得到不同的html名称
         * 1. null.html
         * 2. 1.html
         * 3. 2.html
         * 4. 3.html
         * 二、在htmls目录下判断是否存在相应的html页面，如果存在，直接重定向！
         */
        HttpServletRequest request = (HttpServletRequest)req;
        HttpServletResponse response = (HttpServletResponse) resp;

        String category = request.getParameter("category");
        String htmlPage = category+".html";//得到html页面名称
        String htmlPath = config.getServletContext().getRealPath("/htmls");//得到html页面所再的具体盘符路径
        File destFile = new File(htmlPath,htmlPage);

        //如果存在，直接重定向！
        if(destFile.exists())
        {
            response.sendRedirect(request.getContextPath()+"/htmls/"+htmlPage);
            return;
        }

        //如果不存在，就要生成html页面
        /**
         * 1. 放行，show.jsp会做出很多的输出，要让它别再输出给客户端，而是输出到我们指定的一个html页面之中
         * 2. 调包response,让它的getWriter()与一个html文件绑定，这样show.jsp的内容就都输出到了html中
         */

        //调包response，生成html页面
        StaticResponse staticResponse = new StaticResponse(response,destFile.getAbsolutePath());
        chain.doFilter(req, staticResponse);

        response.sendRedirect(request.getContextPath()+"/htmls/"+htmlPage);
        System.out.println("转了");
    }

    public void init(FilterConfig config) throws ServletException {
        this.config = config;
    }

}
