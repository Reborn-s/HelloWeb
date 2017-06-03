package com.reborn.web.servlet;

import com.reborn.domain.User;
import com.reborn.service.UserException;
import com.reborn.service.UserService;
import com.rebornJar.commons.CommonUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Reborn。 on 2017/5/10.
 */
@WebServlet(name = "RegisterServlet",urlPatterns = {"/RegisterServlet"})
public class RegisterServlet extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        UserService service = new UserService();
        User user = CommonUtils.toBean(request.getParameterMap(),User.class);

        //新增功能：服务器端表单校验
        Map<String,String> errors = new HashMap<>();
        String username = user.getUsername();
        String password = user.getPassword();
        int age = user.getAge();
        String gender = user.getGender();
        String verifyCode = user.getVerifyCode();

        //用户名校验
        if(username==null||user!=null&&username.trim().length()==0)
        {
            errors.put("username","用户名不能为空！");
        }else if(username.length()<3||username.length()>15)
        {
            errors.put("username","用户名长度应在3~15之间！");
        }

        //密码校验
        if(password==null||password!=null&&password.trim().length()==0)
        {
            errors.put("password","密码不能为空！");
        }else if(password.length()<3||password.length()>15)
        {
            errors.put("password","密码长度应在3~15之间！");
        }

        //年龄校验
        if(age==0)
        {
            errors.put("age","年龄不能为空！");
        }else if(age<0)
        {
            errors.put("age","年龄应该大于0！");
        }

        //校验性别
        if(gender==null||gender!=null&&gender.trim().length()==0)
        {
            errors.put("gender","性别不能为空！");
        }else if(!gender.equals("男")&&!gender.equals("女"))
        {
            errors.put("gender","性别错误！");
        }

        //验证码校验
        String vcode = (String) request.getSession().getAttribute("verifyCode");
        if(verifyCode==null||verifyCode!=null&&verifyCode.trim().length()==0)
        {
            errors.put("verifyCode","验证码不能为空！");
        }else if(verifyCode.length()!=4)
        {
            errors.put("verifyCode","验证码长度应该为4！");
        }else if(!verifyCode.equalsIgnoreCase(vcode))
        {
            errors.put("verifyCode","验证码错误！请重新输入！");
        }

        //综合校验信息
        if(!errors.isEmpty())
        {
            request.setAttribute("errors",errors);
            request.setAttribute("user",user);
            request.getRequestDispatcher(request.getContextPath()+"/user/Register.jsp").forward(request,response);
            return;
        }

        try
        {
            service.register(user);
            response.getWriter().print("<h1>注册成功！</h1><<br/><a href='"+request.getContextPath()+"/user/Login.jsp"+"'>点击这里进行登录</a><br/>");
            response.getWriter().print("5秒后自动跳转到登录页面...");
            response.setHeader("Refresh","5;URL=/user/Login.jsp");

        } catch (UserException e)
        {
            //获取异常信息，保存到request域中
            request.setAttribute("msg",e.getMessage());
            //还要保存表单数据到request域中，实现状态回显
            request.setAttribute("user",user);
            request.getRequestDispatcher("/user/Register.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }
}
