package com.reborn.proxy.demo2;

/**
 * Created by Reborn。 on 2017/6/1.
 */
public class ManWaiter implements Waiter{

    @Override
    public void serve() {
        System.out.println("服务中...");
    }
}
