package com.reborn.cstm.service;

import com.reborn.cstm.dao.CustomerDao;
import com.reborn.cstm.domain.Customer;

import java.util.List;

/**
 * Created by Reborn。 on 2017/5/17.
 */
public class CustomerService {
    private CustomerDao dao = new CustomerDao();

    public void add(Customer customer){
        dao.add(customer);
    }

    public List<Customer> findAll()
    {
        return dao.findAll();
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

    public List<Customer> query(Customer customer)
    {
        return  dao.query(customer);
    }
}
