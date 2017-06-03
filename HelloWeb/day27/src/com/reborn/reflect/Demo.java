package com.reborn.reflect;

import org.junit.Test;

import java.lang.reflect.ParameterizedType;

/**
 * Created by Reborn。 on 2017/5/31.
 */
public class Demo {
    @Test
    public void fun()
    {
        new B();
    }
}

class A<T>
{
    public A()
    {
        //获取子类传递得到的泛型种类
        Class c = (Class) ((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        System.out.println(c.getName());
    }
}

class B extends A<String>
{

}
