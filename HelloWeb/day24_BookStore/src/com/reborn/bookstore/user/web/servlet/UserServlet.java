package com.reborn.bookstore.user.web.servlet;

import cn.itcast.commons.CommonUtils;
import cn.itcast.mail.Mail;
import cn.itcast.mail.MailUtils;
import cn.itcast.servlet.BaseServlet;
import com.reborn.bookstore.cart.domain.Cart;
import com.reborn.bookstore.user.domain.User;
import com.reborn.bookstore.user.service.UserException;
import com.reborn.bookstore.user.service.UserService;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created by Reborn。 on 2017/5/27.
 */
@WebServlet(name="UserServlet", urlPatterns = {"/UserServlet"})
public class UserServlet extends BaseServlet{
    private UserService userService = new UserService();

    public String quit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        request.getSession().invalidate();
        return "r:/index.jsp";
    }

    public String login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        User form = CommonUtils.toBean(request.getParameterMap(),User.class);
        String username = form.getLoginname();
        String password = form.getLoginpass();
        String verifyCode = form.getVerifyCode();

        Map<String,String> errors = new HashMap<>();
        if(username==null||username.trim().isEmpty())
            errors.put("username","用户名不能为空！");

        if(password==null||password.trim().isEmpty())
            errors.put("password","密码不能为空！");

        if(verifyCode==null||verifyCode.trim().isEmpty())
            errors.put("verifyCode","验证码不能为空！");
        else if(verifyCode.length()!=4||
                !verifyCode.equalsIgnoreCase((String) request.getSession().getAttribute("verifyCode")))
            errors.put("verifyCode","验证码错误！");

        if(!errors.isEmpty())
        {
            request.setAttribute("errors",errors);
            request.setAttribute("form",form);
            return "f:/jsps/user/login.jsp";
        }

        try {
            User user = userService.login(form);
            request.getSession().setAttribute("session_user",user);
            request.getSession().setAttribute("session_cart",new Cart());

            Cookie cookie = new Cookie("loginname",user.getLoginname());
            cookie.setMaxAge(60*60*24);
            response.addCookie(cookie);

            return "r:/index.jsp";
        } catch (UserException e) {
            request.setAttribute("msg",e.getMessage());
            request.setAttribute("form",form);
            return "f:/jsps/user/login.jsp";
        }
    }

    public String activate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String activationCode = request.getParameter("activationCode");
        try {
            userService.activate(activationCode);
            request.setAttribute("msg","激活账户成功！");
            return "f:/jsps/msg.jsp";
        } catch (UserException e) {
            request.setAttribute("msg",e.getMessage());
            return "f:/jsps/msg.jsp";
        }
    }

    public String regist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        User form = CommonUtils.toBean(request.getParameterMap(),User.class);
        String username = form.getLoginname();
        String password = form.getLoginpass();
        String email = form.getEmail();
        String verifyCode = form.getVerifyCode();

        Map<String,String> errors = new HashMap<>();
        if(username==null||username.trim().isEmpty())
            errors.put("username","用户名不能为空！");
        else if(username.length()<3||username.length()>15)
            errors.put("username","用户名长度应在3~15之间！");

        if(password==null||password.trim().isEmpty())
            errors.put("password","密码不能为空！");
        else if(password.length()<3||password.length()>15)
            errors.put("password","密码长度应在3~15之间！");

        if(email==null||email.trim().isEmpty())
            errors.put("email","邮箱不能为空！");
        else if(!email.matches("\\w+@\\w+\\.com"))
            errors.put("email","邮箱格式不正确！");

        if(verifyCode==null||verifyCode.trim().isEmpty())
            errors.put("verifyCode","验证码不能为空！");
        else if(verifyCode.length()!=4||
                !verifyCode.equalsIgnoreCase((String) request.getSession().getAttribute("verifyCode")))
            errors.put("verifyCode","验证码错误！");

        if(!errors.isEmpty())
        {
            request.setAttribute("errors",errors);
            request.setAttribute("form",form);
            return "f:/jsps/user/regist.jsp";
        }

        form.setUid(CommonUtils.uuid());
        form.setActivationCode(CommonUtils.uuid()+CommonUtils.uuid());
        try {
            userService.regist(form);

            //发邮件
            Properties props = new Properties();
            props.load(this.getClass().getClassLoader().getResourceAsStream("email_template.properties"));
            String host = props.getProperty("host");
            String mailName = props.getProperty("username");
            String mailPass = props.getProperty("password");
            String from = props.getProperty("from");
            //String to = props.getProperty("to");
            String to = email;
            String subject = props.getProperty("subject");
            String content = props.getProperty("content");
            content = MessageFormat.format(content,form.getActivationCode());
            System.out.println(content);

            Session session = MailUtils.createSession(host,mailName,mailPass);
            Mail mail = new Mail(from,to,subject,content);
            try {
                MailUtils.send(session,mail);
            } catch (MessagingException e) {
                throw new RuntimeException(e);
            }
            request.setAttribute("msg","恭喜！注册成功！请尽快到注册邮箱激活账户...");
            return "f:/jsps/msg.jsp";
        } catch (UserException e) {
            request.setAttribute("msg",e.getMessage());
            request.setAttribute("form",form);
            return "f:/jsps/user/regist.jsp";
        }
    }
}
