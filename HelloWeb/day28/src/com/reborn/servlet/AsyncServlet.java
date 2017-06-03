package com.reborn.servlet;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Reborn。 on 2017/5/31.
 */
@WebServlet(name = "AsyncServlet",urlPatterns = {"/AsyncServlet"},asyncSupported = true)
public class AsyncServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");

        for(int i=0;i<=512;i++)
            response.getWriter().print(i);
        response.getWriter().flush();

        AsyncContext asyncContext = request.startAsync(request,response);
        asyncContext.start(new Runnable() {
            @Override
            public void run() {
                println(response,"开始吧！<br/>");
                sleep(2000);
                for(char i='a';i<='z';i++)
                {
                    println(response,i+"");
                    sleep(250);
                }
            }
        });
        asyncContext.complete();
    }

    private void println(HttpServletResponse response,String s)
    {
        try {
            response.getWriter().print(s);
            //response.getWriter().flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private void sleep(long time)
    {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
