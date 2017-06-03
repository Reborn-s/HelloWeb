package com.reborn.locale;

import org.junit.Test;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by Reborn。 on 2017/5/17.
 */

/**
 * 资源文件名称的格式：基本名称+Locale部分+.properties
 * 例如：res_zh_CN.properties 基本名称为res；Locale部分为zh_CN
 * 必须所有的资源文件基本名称要相同；不同之处就是Locale部分
 */
public class LocaleDemo {

    @Test
    public void fun()
    {
        Locale locale = Locale.CHINA;

        //得到ResouceBundle
        //第一个参数是：基本名称
        //第二个参数是：Locale
        ResourceBundle rb = ResourceBundle.getBundle("res",locale);

        //使用ResourceBundle获取资源信息
        System.out.println(rb.getString("username"));
        System.out.println(rb.getString("password"));
        System.out.println(rb.getString("login"));


    }


}
