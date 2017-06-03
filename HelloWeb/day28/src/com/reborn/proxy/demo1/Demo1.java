package com.reborn.proxy.demo1;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by Reborn。 on 2017/6/1.
 */
public class Demo1 {
    @Test
    public void fun()
    {
        ClassLoader classLoader = this.getClass().getClassLoader();
        Class[] interfaces = new Class[]{A.class,B.class};
        InvocationHandler handler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("你好啊");
                return "小hebe";
            }
        };
        Object proxyObject = Proxy.newProxyInstance(classLoader,interfaces,handler);
        A a = (A)proxyObject;
        B b = (B)proxyObject;

        a.add();
        Object o = a.aaa("selina",80000);
        b.update();
        System.out.println(o);
    }
}

interface A
{
    void add();
    String aaa(String name,int salary);
}

interface B
{
    void update();
}
