package com.rebornJar.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * Created by Reborn。 on 2017/5/15.
 * 定义一个servlet抽象类，在其中实现调用多个请求处理方法
 */
public abstract class BaseServlet extends HttpServlet{
    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        /**
         * 1. 获取method参数，用来识别用户想请求的方法
         * 2. 判断是哪一个方法，并且调用相应名称的方法
         */
        String methodName = request.getParameter("method");

        if(methodName==null||methodName.isEmpty())
            throw new RuntimeException("您没有传递method参数！无法确定您想调用的方法！");
        /**
         * 通过方法名和反射机制得到Method对象
         *  需要得到Class，然后调用其getMethod()得到Method对象
         *  因为要查询的是当前类的方法，因此需要得到当前类的class
         */
        Class c = this.getClass();
        Method method = null;
        try {
            method = c.getMethod(methodName,HttpServletRequest.class,HttpServletResponse.class);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException("您要调用的方法"+methodName+"()不存在！");
        }

        //调用method表示的对象
        try {
            String result = (String) method.invoke(this,request,response);

            /**
             * 获取请求处理方法执行后返回的字符串，它表示转发或重定向的路径
             * 在这里帮其完成转发或者重定向！
             */
            /**
             * 查看字符串中是否有冒号
             * 如果没有，默认表示转发；如果有，使用冒号分割字符串得到前缀和后缀
             * f:表示forward；r:表示重定向
             */
            //如果用户返回的字符串为null或者为空，直接return
            if(result==null||result.trim().isEmpty())
                return;

            if(result.contains(":"))
            {
                int index = result.indexOf(":");
                String s = result.substring(0,index);
                String path = result.substring(index+1);
                if(s.equals("f"))
                    request.getRequestDispatcher(path).forward(request,response);
                else if(s.equals("r"))
                    response.sendRedirect(request.getContextPath()+path);
                else
                    throw new RuntimeException("不好意思，您指定的操作 "+s+" 目前还不支持！");
            }else
            {
                //没有冒号，默认为转发
                request.getRequestDispatcher(result).forward(request,response);
            }

        } catch (Exception e) {
            throw new RuntimeException("您调用的方法内部抛出异常！");
        }
    }
}
