package com.reborn.jdbcUtils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Reborn。 on 2017/5/13.
 * 使用数据库连接池得到数据库连接和连接池
 * JdbcUtils 3.0
 * add：添加事务处理功能，不再让service感染sql的东西，service层只需要调用JdbcUtils中的事务方法就行
 *      解决多线程并发访问问题
 */
public class JdbcUtils
{
    //配置文件的默认配置！要求必须在src目录下给出c3p0-config.xml！
    private static ComboPooledDataSource dataSource  = new ComboPooledDataSource();

    //事务专用连接，并保存到每个线程的本地变量中，使多线程可以并发处理事务
    private static ThreadLocal<Connection> tl = new ThreadLocal<>();

    //使用连接池返回一个连接对象
    public static Connection getConnection() throws SQLException {

        Connection con = tl.get();
        //当con不为null时，说明已经调用过beginTransaction，表示已经开启了事务，于是就返回这个专用事务Connection
        if(con!=null)   return con;
        //如果con为null,说明此线程并没有开启事务，就直接从数据库连接池得到一个连接就行
        return dataSource.getConnection();
    }

    //使用连接池返回连接池对象
    public static DataSource getDataSource()
    {
        return dataSource;
    }

    /**
     * 开启事务
     * 1. 获取当前线程中的本地事务Connection，设置它的setAutoCommit(false)来开启事务
     * 2. 并且要保证dao中使用的连接是对应的同一个连接
     * ----------------------------
     * 1. 创建一个Connection，设置为手动提交
     * 2. 把这个Connection给dao用
     * 3. 让commitTransaction或rollbackTransation可以获取到这个Connection
     */
    public static void beginTransaction() throws SQLException
    {
        Connection con = tl.get();

        if(con!=null)
            throw new RuntimeException("事务已经开启，请不要重复开启！");
        /**
         * con为空说明需要人为开启事务
         * --------------------------
         * 1. 给con赋值
         * 2. 给con设置为手动提交
         */
        con = getConnection();//给con赋值，表示事务已经开启
        con.setAutoCommit(false);
        //把当前线程的连接保存到当前线程之中，这样之后就可以获取属于同一个线程的同一个连接
        tl.set(con);
    }

    /**
     * 提交事务
     * 获取当前线程的Connection，然后调用commit方法
     */
    public static void commitTransaction() throws SQLException
    {
        Connection con = tl.get();//获取当前线程的专用事务连接
        con.commit();
        con.close();
        tl.remove();//从tl中移除连接，表示当前线程的事务已经结束，这样下次获取con就会返回null
    }

    /**
     * 回滚事务
     * 获取当前线程的Connection，然后调用rollback方法
     */
    public static void rollbackTransaction() throws SQLException
    {
        Connection con  =tl.get();
        con.rollback();
        con.close();
        tl.remove();
    }

    /**
     * 普通连接的释放关闭
     * 判断需要关闭的连接是不是事务专用连接：
     * 是，就不关闭，因为在commit和rollback中已经关闭了
     * 不是，就要在此方法中关闭
     */
    public static void releaseConnection(Connection connection) throws SQLException
    {
        Connection con  =tl.get();
        if(con==null)   connection.close();
        if(con!=connection) connection.close();
    }

}
