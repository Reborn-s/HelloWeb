package com.web.day10_1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;

/**
 * Created by Reborn。 on 2017/5/4.
 */
@WebServlet(name = "JServlet",urlPatterns = {"/Jservlet"})
public class JServlet extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        Enumeration e = request.getParameterNames();
        while(e.hasMoreElements())
        {
            System.out.println(e.nextElement());
        }

        System.out.println("hobby:"+Arrays.toString(request.getParameterValues("hobby")));

        Map<String,String[]> map = request.getParameterMap();
        for(String key:map.keySet())
        {
            String[] value = map.get(key);
            System.out.println(key+"="+Arrays.toString(value)+"  ");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String a = request.getParameter("aaa");
        String b = request.getParameter("bbb");
        System.out.println(a);
        System.out.println(b);
    }
}
