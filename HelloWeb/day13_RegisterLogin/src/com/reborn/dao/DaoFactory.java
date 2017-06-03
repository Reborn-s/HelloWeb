package com.reborn.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Reborn。 on 2017/5/12.
 * 通过配置文件得到dao实现类的名称
 * 通过类名称完成创建类对象（反射完成）
 */
public class DaoFactory {

    private static Properties props = null;
    static {
        //加载配置文件内容到Properties对象中
        try {
            InputStream in = DaoFactory.class.getClassLoader().getResourceAsStream("resources/dao.properties");
            props = new Properties();
            props.load(in);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 根据配置文件，返回一个具体的实现类对象
     * 这样要切换返回不同的实现类，只需要修改配置文件，把变化的部分转移到配置文件中
     * 配置文件中给出实现类的类名称，通过类型和反射完成创建对象
     */

    public static UserDao getUserDao() {
        String daoClassName = props.getProperty("com.reborn.usermng.dao.UserDao");
        Class clazz = null;
        try {
            clazz = Class.forName(daoClassName);
            return (UserDao)clazz.newInstance();
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
