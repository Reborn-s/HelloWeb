package com.reborn.jdbcUtils;

import org.junit.Test;

import java.sql.SQLException;


/**
 * Created by Reborn。 on 2017/5/16.
 * 模拟service类
 */
public class ServiceDemo
{
    private AccountDao dao = new AccountDao();

    //service方法实现事务
    @Test
    public void transfer()
    {
        try
        {
            JdbcUtils.beginTransaction();

            dao.update("zs",100);

            if(true)
            {
                throw new RuntimeException("更新失败咯~");
            }

            dao.update("ls",-100);

            JdbcUtils.commitTransaction();
        }catch (Exception e)
        {
            try
            {
                JdbcUtils.rollbackTransaction();
            } catch (SQLException e1)
            {
                throw new RuntimeException(e);
            }
            throw new RuntimeException(e);
        }
    }
}
