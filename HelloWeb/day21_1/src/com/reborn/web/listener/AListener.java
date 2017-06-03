package com.reborn.web.listener; /**
 * Created by Reborn。 on 2017/5/17.
 */

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.HashMap;
import java.util.Map;

@WebListener()
public class AListener implements ServletContextListener{


    // -------------------------------------------------------
    // ServletContextListener implementation
    // -------------------------------------------------------
    public void contextInitialized(ServletContextEvent sce) {
      /* This method is called when the servlet context is
         initialized(when the Web application is deployed). 
         You can initialize servlet context related data here.
      */
      //因为ServeletContext监听器是在服务器启动时创建的，全局map也是需要在服务器启动时创建
        //因此将map的创建放在这个方法里比较合适，并且将其存在context里，以便其余地方可以获取到
        Map<String,Integer> map = new HashMap<>();
        sce.getServletContext().setAttribute("map",map);
    }

    public void contextDestroyed(ServletContextEvent sce) {
      /* This method is invoked when the Servlet Context 
         (the Web application) is undeployed or 
         Application Server shuts down.
      */
    }


}
