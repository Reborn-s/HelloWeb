package com.reborn.jdbcUtils;

import org.apache.commons.dbutils.QueryRunner;

import java.sql.SQLException;

/**
 * Created by Reborn。 on 2017/5/16.
 */
public class AccountDao
{
    public void update(String name,double money) throws SQLException
    {
        QueryRunner qr = new TxQueryRunner();
        String sql = "update account set balance = balance+? where name=?";
        Object[] params = {money,name};
        qr.update(sql,params);

    }
}
