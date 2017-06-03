package com.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * Created by Reborn。 on 2017/5/3.
 */
@WebServlet(name = "GetClassResServlet",urlPatterns = {"/ClassServelet"})
public class GetClassResServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ClassLoader cl = this.getClass().getClassLoader();
        InputStream in = cl.getResourceAsStream("a.txt");
        BufferedReader sb = new BufferedReader(new InputStreamReader(in));
        String line = null;
        while((line=sb.readLine())!=null)
            System.out.print(line);
    }
}
