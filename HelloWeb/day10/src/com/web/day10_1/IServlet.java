package com.web.day10_1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Reborn。 on 2017/5/4.
 */
@WebServlet(name = "IServlet",urlPatterns = {"/Iservlet"})
public class IServlet extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String http = request.getScheme();
        String server = request.getServerName();
        int port = request.getServerPort();
        String app = request.getContextPath();
        String servlet = request.getServletPath();
        String param = request.getQueryString();
        String uri = request.getRequestURI();
        StringBuffer url = request.getRequestURL();

        response.getWriter().print(http+"<br/>");
        response.getWriter().print(server+"<br/>");
        response.getWriter().print(port+"<br/>");
        response.getWriter().print(app+"<br/>");
        response.getWriter().print(servlet+"<br/>");
        response.getWriter().print(param+"<br/>");
        response.getWriter().print(uri+"<br/>");
        response.getWriter().print(url+"<br/>");
        response.getWriter().print("<br/>");

        String referer = request.getHeader("Referer");
        response.getWriter().print(referer+"<br/>");
        if(referer==null||!referer.contains("localhost"))
            response.sendRedirect("/Hservlet");
        else
            response.getWriter().print("hello!<br/>");

    }
}
