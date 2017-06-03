package com.reborn.proxy.Demo3;

import org.junit.Test;

/**
 * Created by Reborn。 on 2017/6/1.
 */
public class Demo3 {
    @Test
    public void fun()
    {
        ProxyFactory factory = new ProxyFactory();
        factory.setTargetObject(new ManWaiter());
        factory.setBeforeAdvice(new BeforeAdvice() {
            @Override
            public void before() {
                System.out.println("Morning!");
            }
        });
        factory.setAfterAdvice(new AfterAdvice() {
            @Override
            public void after() {
                System.out.println("night!");
            }
        });
        Waiter proxyWaiter = (Waiter) factory.createProxy();
        proxyWaiter.serve();
    }
}
