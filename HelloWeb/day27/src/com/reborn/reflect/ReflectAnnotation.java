package com.reborn.reflect;

import org.junit.Test;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

/**
 * Created by Reborn。 on 2017/5/31.
 */
public class ReflectAnnotation {
    @Test
    public void fun1() throws NoSuchMethodException {
        Class clazz = com.reborn.reflect.C.class;
        MyAnno3 annotation1 = (MyAnno3) clazz.getAnnotation(MyAnno3.class);
        System.out.println(annotation1.value()+", "+annotation1.name());

        Method method = clazz.getMethod("fun");
        MyAnno3 annotation2 = method.getAnnotation(MyAnno3.class);
        System.out.println(annotation2);
    }
}

@MyAnno3(value=100,name="class")
class C{
    @MyAnno3(value=2,name="method")
    public void fun(){}
}

@Retention(RetentionPolicy.RUNTIME)
@interface MyAnno3
{
    int value();
    String name();
}