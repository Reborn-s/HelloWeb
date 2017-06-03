package com.reborn.dbutils;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Reborn。 on 2017/5/15.
 * 模拟common-dbutils.jar里的QueryRunner类中的部分update和query方法
 */
public class QueryRunnerMonitor<T> {
    private DataSource dataSource;

    public QueryRunnerMonitor() {
    }

    public QueryRunnerMonitor(DataSource dataSource) {
        this.dataSource = dataSource;

    }

    //执行增、删、改操作
    public int update(String sql,Object... params)
    {
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            con = dataSource.getConnection();//通过连接池得到对象
            pstmt = con.prepareStatement(sql);//使用sql创建pstmt
            initParams(pstmt,params);//设置参数
            return pstmt.executeUpdate();//执行

        }catch (Exception e)
        {
            throw new RuntimeException(e);
        }finally {
            try {
                if(pstmt!=null) pstmt.close();
                if(con!=null)   con.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public T query(String sql,RsHandler<T> rsh,Object... params)
    {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            con = dataSource.getConnection();//通过连接池得到对象
            pstmt = con.prepareStatement(sql);//使用sql创建pstmt
            initParams(pstmt,params);//设置参数
            rs = pstmt.executeQuery();//执行

            return rsh.handle(rs);

        }catch (Exception e)
        {
            throw new RuntimeException(e);
        }finally {

        }
    }

    //给sql参数赋值
    private void initParams(PreparedStatement pstmt,Object... params) throws SQLException
    {
        for(int i=0;i<params.length;i++)
            pstmt.setObject(i+1,params[i]);
    }
}
