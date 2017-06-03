package com.reborn.jdbcUtils;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Reborn。 on 2017/5/16.
 * 此类中的方法，加入了如下功能：全部自己处理连接的问题，无需外接传递
 * 1. 得到连接：JdbcUtils.getConnection()，这个连接可能是事务连接也可能是普通连接
 * 2. 释放连接：JdbcUtils.releaseConnection()，如果是事务连接就通过commit和rollback来关闭，普通连接就自己关闭
 */
public class TxQueryRunner extends QueryRunner
{

    @Override
    public int[] batch(String sql, Object[][] params) throws SQLException
    {
        /**
         * 1. 得到连接
         * 2. 执行父类方法，传递连接对象
         * 3. 释放连接
         * 4. 返回值
         */
        Connection con = JdbcUtils.getConnection();
        int[] result = super.batch(con,sql, params);
        JdbcUtils.releaseConnection(con);
        return result;
    }

    @Override
    public <T> T query(String sql, ResultSetHandler<T> rsh, Object... params) throws SQLException
    {
        Connection con = JdbcUtils.getConnection();
        T result = super.query(con,sql, rsh,params);
        JdbcUtils.releaseConnection(con);
        return result;
    }

    @Override
    public <T> T query(String sql, ResultSetHandler<T> rsh) throws SQLException
    {
        Connection con = JdbcUtils.getConnection();
        T result = super.query(con,sql, rsh);
        JdbcUtils.releaseConnection(con);
        return result;
    }

    @Override
    public int update(String sql) throws SQLException
    {
        Connection con = JdbcUtils.getConnection();
        int result = super.update(con,sql);
        JdbcUtils.releaseConnection(con);
        return result;
    }

    @Override
    public int update(String sql, Object param) throws SQLException
    {
        Connection con = JdbcUtils.getConnection();
        int result = super.update(con,sql,param);
        JdbcUtils.releaseConnection(con);
        return result;
    }

    @Override
    public <T> T insert(String sql, ResultSetHandler<T> rsh) throws SQLException
    {
        Connection con = JdbcUtils.getConnection();
        T result = super.insert(con,sql,rsh);
        JdbcUtils.releaseConnection(con);
        return result;
    }

    @Override
    public int update(String sql, Object... params) throws SQLException
    {
        Connection con = JdbcUtils.getConnection();
        int result = super.update(con,sql,params);
        JdbcUtils.releaseConnection(con);
        return result;
    }

    @Override
    public <T> T insert(String sql, ResultSetHandler<T> rsh, Object... params) throws SQLException
    {
        Connection con = JdbcUtils.getConnection();
        T result = super.insert(con,sql,rsh,params);
        JdbcUtils.releaseConnection(con);
        return result;
    }

    @Override
    public <T> T insertBatch(String sql, ResultSetHandler<T> rsh, Object[][] params) throws SQLException
    {
        Connection con = JdbcUtils.getConnection();
        T result = super.insertBatch(con,sql,rsh,params);
        JdbcUtils.releaseConnection(con);
        return result;
    }
}
