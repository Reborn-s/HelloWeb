package com.reborn.bookstore.order.domain;

import com.reborn.bookstore.user.domain.User;

import java.util.List;

/**
 * Created by Reborn。 on 2017/5/28.
 */
public class Order {
    private String oid;
    private String ordertime;
    private double total;
    private int status;//订单有四种状态：1. 未付款 2. 等待发货 3. 确认收货 4. 交易完成
    private String address;
    private User owner;
    private List<OrderItem> orderItemList;

    public List<OrderItem> getOrderItemList() {
        return orderItemList;
    }

    public void setOrderItemList(List<OrderItem> orderItemList) {
        this.orderItemList = orderItemList;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(String ordertime) {
        this.ordertime = ordertime;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public User getUser() {
        return owner;
    }

    public void setUser(User user) {
        this.owner = user;
    }
}
