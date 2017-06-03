package com.reborn.demo;

import com.reborn.dao.AccountDao;
import com.reborn.dao.DaoFactory;
import com.reborn.jdbc.JdbcUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Reborn。 on 2017/5/13.
 * 使用事务演示转账
 *
 * 所有对Connection 的操作都在service层进行的处理！大忌！
 * 这是需要把所有对Connection的操作隐藏起来的，把事务的操作变成另一个样子
 * 最终会把事务转移到配置文件中，代码中不会出现，由配置文件决定开不开事务
 */
public class transfer {
    private AccountDao dao = DaoFactory.getDao();
    public void transfer(String from,String to,double money)
    {
        Connection con = null;
        try {
            con = JdbcUtils.getConnection();

            //开启事务-->start transaction;
            con.setAutoCommit(false);

            //执行update insert delete操作
            dao.updateBalance(con,from,0-money);

            if(true)
            {
                throw new RuntimeException("更新失败咯~");
            }

            dao.updateBalance(con,to,money);

            //提交事务
            con.commit();
        }catch (Exception e)
        {
            //如果出现异常，肯定会在commit之前出现，那么就处理异常的时候把事务回滚
            try {
                con.rollback();
            } catch (SQLException e1) {

            }
            throw new RuntimeException(e);
        }finally {
            if(con!=null) try {
                con.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Test
    public void fun()
    {
        transfer("zs","ls",100);
    }
}
