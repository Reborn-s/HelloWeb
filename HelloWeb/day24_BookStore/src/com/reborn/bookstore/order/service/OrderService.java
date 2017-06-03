package com.reborn.bookstore.order.service;

import cn.itcast.jdbc.JdbcUtils;
import com.reborn.bookstore.order.dao.OrderDao;
import com.reborn.bookstore.order.domain.Order;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Reborn。 on 2017/5/28.
 */
public class OrderService {
    private OrderDao orderDao = new OrderDao();

    public void add(Order order)
    {
        try {
            JdbcUtils.beginTransaction();

            orderDao.addOrder(order);
            orderDao.addOrderItem(order);

            JdbcUtils.commitTransaction();
        } catch (SQLException e) {
            try {
                JdbcUtils.rollbackTransaction();
            } catch (SQLException e1) {
            }
            throw new RuntimeException(e);
        }
    }

    public List<Order> findByUid(String uid)
    {
        return orderDao.findByUid(uid);
    }

    public Order load(String oid)
    {
        return orderDao.findByOid(oid);
    }

    public void confirm(String oid) throws OrderException {
        int status = orderDao.getStatusByOid(oid);
        if(status!=3)   throw new OrderException("订单状态不对劲！");
        orderDao.updateStatus(oid,4);
    }
}
