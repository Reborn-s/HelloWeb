package com.web.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Reborn。 on 2017/5/3.
 */
@WebServlet(name = "GetStatisticSevlet",urlPatterns = {"/SServlet"})
public class GetStatisticSevlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext app = this.getServletContext();
        Integer count = (Integer)app.getAttribute("count");
        if(count==null)
        {
            app.setAttribute("count",1);
        }else
        {
            app.setAttribute("count",count+1);
        }
        PrintWriter out = response.getWriter();
        out.print("<h1>"+app.getAttribute("count")+"</h1>");
    }
}
