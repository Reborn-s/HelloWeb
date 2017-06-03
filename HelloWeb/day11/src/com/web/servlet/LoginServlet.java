package com.web.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * Created by Reborn。 on 2017/5/6.
 */
@WebServlet(name = "LoginServlet",urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String vcode = request.getParameter("verifyCode");

        HttpSession session = request.getSession();
        String trueCode = (String)session.getAttribute("session_vcode");
        System.out.println(vcode);
        System.out.println(trueCode);
        if(!trueCode.equalsIgnoreCase(vcode))
        {
            request.setAttribute("msg","验证码错误！请重新输入！");
            request.getRequestDispatcher("LoginSession/login.jsp").forward(request,response);
            return;
        }

        if(username.equals("selina")||username.equals("hebe")||username.equals("ella"))//登录成功
        {
            //把用户名保存到cookie中发送到客户端浏览器
            // 当再次打开login.jsp时,login.jsp会读取request中的cookie，把它显示到用户名中
            Cookie cookie = new Cookie("username",username);
            cookie.setMaxAge(60*60*24);//设置Cookie生命周期为1天
            response.addCookie(cookie);
            session.setAttribute("username",username);
            response.sendRedirect("LoginSession/success1.jsp");

        }else
        {
            request.setAttribute("msg","用户名或者密码错误！请重新输入！");
            RequestDispatcher rd = request.getRequestDispatcher("LoginSession/login.jsp");
            rd.forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
    }
}
