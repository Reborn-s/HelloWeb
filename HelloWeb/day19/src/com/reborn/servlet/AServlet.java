package com.reborn.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Reborn。 on 2017/5/15.
 */
@WebServlet(name = "AServlet",urlPatterns = {"/Aservlet"})
public class AServlet extends BaseServlet {
    public void addUser(HttpServletRequest request,HttpServletResponse response)
            throws ServletException,IOException
    {
        System.out.println("addUser()...");
    }

    public void deleteUser(HttpServletRequest request,HttpServletResponse response)
            throws ServletException,IOException
    {
        System.out.println("deleteUser()...");
    }

    public void findUser(HttpServletRequest request,HttpServletResponse response)
            throws ServletException,IOException
    {
        System.out.println("findUser()...");
    }
}
