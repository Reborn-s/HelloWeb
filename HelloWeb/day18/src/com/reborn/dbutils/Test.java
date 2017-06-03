package com.reborn.dbutils;

import com.reborn.jdbc.JdbcUtils;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Reborn。 on 2017/5/15.
 * 对QueryRunnerMonitor类中的方法进行调用
 */
public class Test {

    @org.junit.Test
    public void fun1()
    {
        Student s = new Student(1,"zhangsan",18,"男");
        addStu(s);
        System.out.println(queryStu(1));
    }

    public void addStu(Student stu)
    {
        //1.给出连接池
        QueryRunnerMonitor qr = new QueryRunnerMonitor(JdbcUtils.getDataSource());
        //2.给出sql模板
        String sql = "insert into t_stu values(?,?,?,?)";
        //3.给出参数
        Object[] params = {stu.getSid(),stu.getSname(),stu.getAge(),stu.getGender()};
        //4.调用update进行增、删、改
        qr.update(sql,params);
    }

    public Student queryStu(int sid)
    {
        QueryRunnerMonitor qr = new QueryRunnerMonitor(JdbcUtils.getDataSource());
        String sql = "select * from t_stu where sid = ?";
        Object[] params = {sid};
        RsHandler<Student> rsHandler = new RsHandler<Student>() {
            @Override
            public Student handle(ResultSet rs) throws SQLException {
                if(!rs.next())  return null;
                Student student = new Student();
                student.setSid(sid);
                student.setAge(rs.getInt("age"));
                student.setSname(rs.getString("sname"));
                student.setGender(rs.getString("gender"));
                return student;
            }
        };

        return (Student) qr.query(sql,rsHandler,params);
    }
}
