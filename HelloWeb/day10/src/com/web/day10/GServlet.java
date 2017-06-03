package com.web.day10;

import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by Reborn。 on 2017/5/4.
 * 使用PrintWriter发送字符数据
 * 使用ServletOutputStream发送字节数据
 */
@WebServlet(name = "GServlet",urlPatterns = {"/Gservlet"})
public class GServlet extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String s = "hello world!";
        byte[] bytes = s.getBytes();
        response.getOutputStream().write(bytes);

        String path = ("F:/123.JPG");
        System.out.println(path);
        FileInputStream in = new FileInputStream(path);
        byte[] pic = IOUtils.toByteArray(in);
        response.setContentType("text/html;charset=utf-8");
        response.getOutputStream().write(pic);
    }
}
