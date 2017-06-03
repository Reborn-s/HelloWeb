package com.reborn.proxy.demo2;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by Reborn。 on 2017/6/1.
 */
public class Demo2 {
    @Test
    public void fun()
    {
        Waiter waiter = new ManWaiter();

        ClassLoader classLoader = this.getClass().getClassLoader();
        Class[] interfaces = {Waiter.class};
        InvocationHandler handler = new WaiterInvocationHandler(waiter);
        Waiter proxyWaiter = (Waiter) Proxy.newProxyInstance(classLoader,interfaces,handler);
        proxyWaiter.serve();
    }
}

class WaiterInvocationHandler implements InvocationHandler
{
    private Waiter waiter;

    public WaiterInvocationHandler(Waiter waiter) {
        this.waiter = waiter;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("您好!");
        waiter.serve();
        System.out.println("再见！");
        return null;
    }
}
