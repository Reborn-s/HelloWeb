package com.reborn.listener;
/**
 * Created by Reborn。 on 2017/5/17.
 * 生命周期监听器
 */

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener()
public class AListener implements ServletContextListener {


    // -------------------------------------------------------
    // ServletContextListener implementation
    // -------------------------------------------------------
    //可以在这个监听方法里放一些服务器启动时需要设置的数据
    public void contextInitialized(ServletContextEvent sce) {
      /* This method is called when the servlet context is
         initialized(when the Web application is deployed). 
         You can initialize servlet context related data here.
      */
        System.out.println("我随着服务器一起出生啦");
    }

    public void contextDestroyed(ServletContextEvent sce) {
      /* This method is invoked when the Servlet Context 
         (the Web application) is undeployed or 
         Application Server shuts down.
      */
        System.out.println("我随着服务器一起挂啦");
    }

}
