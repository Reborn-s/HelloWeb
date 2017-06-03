package com.web.servlet;

import com.web.image.VerifyCode;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by Reborn。 on 2017/5/7.
 */
@WebServlet(name = "VerifyCodeServlet",urlPatterns = {"/VerifyCodeServlet"})
public class VerifyCodeServlet extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        VerifyCode vc = new VerifyCode();
        BufferedImage image = vc.getImage();
        HttpSession session = request.getSession();
        session.setAttribute("session_vcode",vc.getText());
        VerifyCode.output(image,response.getOutputStream());
    }
}
