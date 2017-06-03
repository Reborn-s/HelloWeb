package com.reborn.domain;

import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Reborn。 on 2017/5/8.
 */
public class Demo1
{
    @Test
    public void fun1() throws Exception
    {
        String className = "com.reborn.domain.Person";
        Class clazz = Class.forName(className);
        Object bean = clazz.newInstance();

        BeanUtils.setProperty(bean,"username","zhangsan");
        BeanUtils.setProperty(bean,"age","12");
        BeanUtils.setProperty(bean,"gender","female");
        BeanUtils.setProperty(bean,"xxx","female");

        System.out.println(bean);
    }

    @Test
    //把map中的数据直接封装到一个javaBean中，map的key要与bean中的属性完全对应
    public void fun2() throws Exception
    {
        Map<String,String> map = new HashMap<>();
        map.put("username","zhangsan");
        map.put("password","123123");

        User user = new User();
        BeanUtils.populate(user,map);

        System.out.println(user);
    }

    @Test
    public void fun3()
    {
        Map<String,String> map = new HashMap<>();
        map.put("username","zhangsan");
        map.put("password","123123");

        User user = CommonUtils.toBean(map,User.class);

        System.out.println(user);
    }

}
