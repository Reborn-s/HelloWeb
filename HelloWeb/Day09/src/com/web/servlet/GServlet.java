package com.web.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.Set;

/**
 * Created by Reborn。 on 2017/5/3.
 */
@WebServlet(name = "GServlet",urlPatterns = {"/GServlet"})
public class GServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext application = this.getServletContext();
        application.setAttribute("name","zhangsan");

        String path = application.getRealPath("a.txt");
        System.out.println(path);

        InputStream in = application.getResourceAsStream("a.txt");
        Set<String> paths = application.getResourcePaths("/WEB-INF");
        System.out.println(paths);

    }
}
