package com.reborn.threadLocal;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Reborn。 on 2017/5/15.
 */
public class ThreadLocalEaxm {
    public void fun()
    {
        ThreadLocal<String> tl = new ThreadLocal<>();
        tl.set("hello");
        tl.set("world");
        System.out.println(tl.get());

        tl.remove();
    }

}

//ThreadLocal的内部实现原理
class MyThreadLocal<T>
{
    private Map<Thread,T> map = new HashMap<>();
    public void set(T t)
    {
        map.put(Thread.currentThread(),t);
    }

    public T get()
    {
        return map.get(Thread.currentThread());
    }

    public void remove()
    {
        map.remove(Thread.currentThread());
    }
}

/**
 *ThreadLocal通常用作一个类的成员变量
 * 多个线程访问它时，每个线程都有自己的副本，互不干扰
 * Spring中把Connection放到了ThreadLocal中
 */
class Accout
{
    private ThreadLocal<Integer> tl = new ThreadLocal<>();
}
