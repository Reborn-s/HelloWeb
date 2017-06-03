package com.reborn.cstm.dao;

import com.reborn.cstm.domain.Customer;
import com.rebornJar.jdbcUtils.TxQueryRunner;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Reborn。 on 2017/5/17.
 */
public class CustomerDao {
    private QueryRunner qr = new TxQueryRunner();

    public void add(Customer customer){
        String sql = "insert into t_customer values(?,?,?,?,?,?,?)";
        Object[] params = {customer.getCid(),customer.getCname(),customer.getGender(),
        customer.getBirthday(),customer.getCellphone(),customer.getEmail(),customer.getDescription()};

        try {
            qr.update(sql,params);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public List<Customer> findAll(){
        String sql = "select * from t_customer order by cname";
        try {
            return qr.query(sql,new BeanListHandler<Customer>(Customer.class));
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public Customer find(String cid) {
        String sql = "select * from t_customer where cid=?";
        try {
            return qr.query(sql,new BeanHandler<Customer>(Customer.class),cid);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public void edit(Customer customer)
    {
        String sql = "update t_customer set cname=?,gender=?,birthday=?,cellphone=?,email=?,description=?" +
                "where cid =? ";
        try {
            qr.update(sql,customer.getCname(),customer.getGender(),customer.getBirthday(),
                    customer.getCellphone(),customer.getEmail(),customer.getDescription(),customer.getCid());
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public void delete(String cid)
    {
        String sql = "delete from t_customer where cid=?";
        try {
            qr.update(sql,cid);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public List<Customer> query(Customer c)
    {
        StringBuilder sql = new StringBuilder("select * from t_customer where 1=1");
        List<String> params = new ArrayList<>();
        if(c.getCname()!=null&&!c.getCname().trim().isEmpty())
        {
            sql.append(" and cname like ?");
            params.add("%"+c.getCname()+"%");
        }
        if(c.getGender()!=null&&!c.getGender().trim().isEmpty())
        {
            sql.append(" and gender=?");
            params.add(c.getGender());
        }
        if(c.getCellphone()!=null&&!c.getCellphone().trim().isEmpty())
        {
            sql.append(" and cellphone like ?");
            params.add("%"+c.getCellphone()+"%");
        }
        if(c.getEmail()!=null&&!c.getEmail().trim().isEmpty())
        {
            sql.append(" and email like ?");
            params.add("%"+c.getEmail()+"%");
        }
        try {
            System.out.println(sql);
            System.out.println(params);
            return qr.query(sql.toString(),new BeanListHandler<Customer>(Customer.class),params.toArray());
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

}
