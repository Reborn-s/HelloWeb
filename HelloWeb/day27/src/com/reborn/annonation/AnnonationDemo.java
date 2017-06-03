package com.reborn.annonation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Reborn。 on 2017/5/31.
 */
public class AnnonationDemo {
    @MyAnno3(
            value=100,
            name="zhangsan",
            enum1=MyEnum.A,
            clazz = String.class,
            anno=@MyAnno2(90),
            arr = "50"
    )
    public AnnonationDemo()
    {

    }

    @MyAnno2(90)
    private int word;

    @MyAnnona1(value=100,name="lisi")
    public void fun()
    {

    }
}

@Target(ElementType.METHOD)//是作用在方法上，其余地方不能用这个注解
@interface MyAnnona1
{
    int value();
    String name();
}

@Retention(RetentionPolicy.RUNTIME)//加载进源码、字节码以及jvm内存中
    @Target(ElementType.FIELD)
@interface MyAnno2
{
    int value();
}

@Target(ElementType.CONSTRUCTOR)
@interface MyAnno3
{
    int value();
    String name();
    MyEnum enum1();
    Class clazz();
    MyAnno2 anno();
    String[] arr();
}

enum MyEnum
{
    A,B,C
}
