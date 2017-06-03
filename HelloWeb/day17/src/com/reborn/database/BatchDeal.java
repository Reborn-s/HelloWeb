package com.reborn.database;

import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * Created by Reborn。 on 2017/5/13.
 * 使用批处理向数据库中添加数据
 */
public class BatchDeal {

    /**
     * pstmt对象内部有集合
     * 1.用循环疯狂向pstmt中添加sql参数，它自己又模板，使用一组参数与模板可以匹配出一条sql
     * 2.调用他的执行批方法，完成向数据库发送数据
     */
    @Test
    public void batchInsert()
    {
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            con = JdbcUtils.getConnection();

            String sql = "insert into t_stu values(?,?,?,?)";
            pstmt = con.prepareStatement(sql);

            //添加参数到批中，执行批
            for(int i = 0;i<5000;i++)
            {
                pstmt.setInt(1,i);
                pstmt.setString(2,"stu_"+i);
                pstmt.setInt(3,i+1);
                pstmt.setString(4,i%2==0?"男":"女");

                pstmt.addBatch();//添加批，这一组数据就保存到集合中了
            }
            long start = System.currentTimeMillis();
            pstmt.executeBatch();//执行批
            long end = System.currentTimeMillis();
            System.out.println(end-start);
        }catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }
}
