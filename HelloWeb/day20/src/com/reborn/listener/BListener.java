package com.reborn.listener;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

/**
 * Created by Reborn。 on 2017/5/17.
 * 属性监听器
 */
public class BListener implements HttpSessionAttributeListener{
    @Override
    public void attributeAdded(HttpSessionBindingEvent httpSessionBindingEvent) {
        System.out.println("已添加属性"+httpSessionBindingEvent.getName()+",值为"+httpSessionBindingEvent.getValue());
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent httpSessionBindingEvent) {
        System.out.println("移除属性"+httpSessionBindingEvent.getName()+"="+httpSessionBindingEvent.getValue());
    }

    @Override
    //这个getValue()得到的是旧值
    public void attributeReplaced(HttpSessionBindingEvent httpSessionBindingEvent) {
        System.out.println("替换属性"+httpSessionBindingEvent.getName()+"="+httpSessionBindingEvent.getValue());
        System.out.println("替换的新值是："+httpSessionBindingEvent.getSession().getAttribute(httpSessionBindingEvent.getName()));
    }
}
