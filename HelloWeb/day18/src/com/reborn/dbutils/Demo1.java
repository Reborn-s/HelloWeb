package com.reborn.dbutils;

import com.reborn.jdbc.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.*;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * Created by Reborn。 on 2017/5/15.
 * 使用common-dbutils.jar中的QueryRunner与ResultHandler接口实现增删改查
 *
 * 五个ResultHandler接口的实现类要求Student类中的成员变量名与数据库中的属性名必须一样
 */
public class Demo1 {

    @org.junit.Test
    public void fun1() throws SQLException {
        QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
        String sql = "insert into t_stu value(?,?,?,?)";
        Object[] params = {2,"lisi",99,"女"};
        qr.update(sql,params);
    }


    @org.junit.Test
    public void fun2() throws SQLException {
        QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
        String sql = "select * from t_stu where sid =?";
        Object[] params = {2};

        /**
         * 执行query()方法，需要给出结果集处理器，即ResultHandler的实现类对象
         * 此处的BeanHandler是其中一个实现类
         * 它需要传进一个类型，然后它把rs中的数据封装到指定类型的javaBean对象中，最后返回这个对象
         */
        Student stu = qr.query(sql,new BeanHandler<Student>(Student.class),params);
        System.out.println(stu);
    }

    /**
     * BeanListHandler的应用：多行处理器，可处理得到的结果集是多行的情况
     * 每行对应一个Student对象，最后放在一起返回一个List
     * @throws SQLException
     */
    @org.junit.Test
    public void fun3() throws SQLException {
        QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
        String sql = "select * from t_stu";

        //没有参数
        List<Student> stuList = qr.query(sql,new BeanListHandler<Student>(Student.class));
        System.out.println(stuList);
    }

    /**
     * MapHandler的应用：处理单行结果集，并把一行结果封装成一个Map
     * @throws SQLException
     */
    @org.junit.Test
    public void fun4() throws SQLException {
        QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
        String sql = "select * from t_stu where sid= ?";
        Object[] params = {1};
        Map map = qr.query(sql,new MapHandler(),params);
        System.out.println(map);
    }

    /**
     * MapListHandler的应用:多行处理器，一行对应一个Student对象，封装成一个map，最后把多个map封装到一个list
     *
     * @throws SQLException
     */
    @org.junit.Test
    public void fun5() throws SQLException {
        QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
        String sql = "select * from t_stu";
        List<Map<String,Object>> stuList = qr.query(sql,new MapListHandler());
        System.out.println(stuList);
    }

    /**
     * ScalarHandler：单行单列使用，最后合适
     */
    @org.junit.Test
    public void fun6() throws SQLException {
        QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
        String sql = "select count(*) from t_stu";

        //不同版本的驱动和jar包返回的值类型不一样，可能会有Integer、Long和BigInteger类型
        //因此将返回值强转为Number类型，再通过Number转换为我们需要的数值类型（比如int或者long都行）就OK
        Number count = (Number) qr.query(sql,new ScalarHandler());
        int cnt = count.intValue();
        System.out.println(cnt);
    }
}
