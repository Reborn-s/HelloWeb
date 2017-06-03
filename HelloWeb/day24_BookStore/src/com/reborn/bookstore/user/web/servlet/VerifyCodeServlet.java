package com.reborn.bookstore.user.web.servlet;

import cn.itcast.vcode.utils.VerifyCode;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by Reborn。 on 2017/5/28.
 */
@WebServlet(name = "VerifyCodeServlet",urlPatterns = {"/VerifyCodeServlet"})
public class VerifyCodeServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        VerifyCode verifyCode = new VerifyCode();
        BufferedImage image = verifyCode.getImage();
        request.getSession().setAttribute("verifyCode",verifyCode.getText());
        System.out.println(verifyCode.getText());
        VerifyCode.output(image,response.getOutputStream());
    }

}
