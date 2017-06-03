package com.reborn.cstm.service;

import com.reborn.cstm.dao.CustomerDao;
import com.reborn.cstm.domain.Customer;
import com.reborn.cstm.domain.PageBean;

/**
 * Created by Reborn。 on 2017/5/17.
 */
public class CustomerService {
    private CustomerDao dao = new CustomerDao();

    public void add(Customer customer){
        dao.add(customer);
    }

    /*public List<Customer> findAll()
    {
        return dao.findAll();
    }*/

    public PageBean<Customer> findAll(int pageCode,int pageSize)
    {
        return  dao.findAll(pageCode,pageSize);
    }

    public Customer find(String cid) {
        return dao.find(cid);
    }

    public void edit(Customer customer)
    {
        dao.edit(customer);
    }

    public void delete(String cid)
    {
        dao.delete(cid);
    }

    public PageBean<Customer> query(Customer customer,int pageCode,int pageSize)
    {
        return  dao.query(customer,pageCode,pageSize);
    }
}
