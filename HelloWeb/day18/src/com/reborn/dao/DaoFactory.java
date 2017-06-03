package com.reborn.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Reborn。 on 2017/5/13.
 */
public class DaoFactory {
    private static Properties props = null;
    static
    {
        try {
            props = new Properties();
            InputStream in = DaoFactory.class.getClassLoader().getResourceAsStream("resources/daoconfig.properties");

            props.load(in);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static AccountDao getDao()
    {
        String daoClassName = props.getProperty("daoClassName");
        AccountDao dao = null;
        try {
            dao = (AccountDao)Class.forName(daoClassName).newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return dao;
    }
}
