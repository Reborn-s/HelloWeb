package com.reborn.bookstore.order.dao;

import cn.itcast.commons.CommonUtils;
import cn.itcast.jdbc.TxQueryRunner;
import com.reborn.bookstore.book.domain.Book;
import com.reborn.bookstore.order.domain.Order;
import com.reborn.bookstore.order.domain.OrderItem;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Reborn。 on 2017/5/28.
 */
public class OrderDao {
    private QueryRunner qr = new TxQueryRunner();

    public int getStatusByOid(String oid)
    {
        String sql = "select status from t_order where oid=? order by ordertime";
        try {
            return (Integer) qr.query(sql,new ScalarHandler(),oid);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateStatus(String oid,int status)
    {
        String sql = "update t_order set status=? where oid=?";
        try {
            qr.update(sql,status,oid);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Order findByOid(String oid)
    {
        String sql = "select * from t_order where oid=? order by ordertime";
        try {
            Order order = qr.query(sql,new BeanHandler<Order>(Order.class),oid);
            loadOrderItemList(order);
            return order;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Order> findByUid(String uid)
    {
        String sql = "select * from t_order where uid=? order by ordertime";
        try {
            List<Order> orderlist = qr.query(sql,new BeanListHandler<Order>(Order.class),uid);
            for(Order order:orderlist)
                loadOrderItemList(order);
            return orderlist;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void loadOrderItemList(Order order) {
        String sql = "select * from t_orderitem i,t_book b where i.bid=b.bid and oid=?";
        try {
            List<Map<String,Object>> mapList = qr.query(sql,new MapListHandler(),order.getOid());
            List<OrderItem> orderItemList = new ArrayList<>();
            for(Map map:mapList)
            {
                OrderItem orderItem = loadOrderItem(map,order);
                orderItemList.add(orderItem);
            }
            order.setOrderItemList(orderItemList);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private OrderItem loadOrderItem(Map map,Order order) {
        OrderItem orderItem = CommonUtils.toBean(map,OrderItem.class);
        Book book = CommonUtils.toBean(map,Book.class);
        orderItem.setBook(book);
        orderItem.setOrder(order);
        return orderItem;
    }

    public void addOrder(Order order)
    {
        String sql = "insert into t_order values(?,?,?,?,?,?)";
        Object[] params = {order.getOid(),order.getOrdertime(),order.getTotal(),
                            order.getStatus(),order.getAddress(),order.getUser().getUid()};
        try {
            qr.update(sql,params);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void addOrderItem(Order order)
    {
        List<OrderItem> orderItems = order.getOrderItemList();
        String sql = "insert into t_orderitem values(?,?,?,?,?,?,?,?)";
        Object[][] params = new Object[orderItems.size()][];
        for(int i=0;i<orderItems.size();i++)
        {
            OrderItem orderItem = orderItems.get(i);
            params[i] = new Object[]{orderItem.getOrderItemId(),orderItem.getQuantity(),
                                    orderItem.getSubtotal(),orderItem.getBook().getBid(),
                                    orderItem.getBook().getBname(),orderItem.getBook().getCurrPrice(),
                                    orderItem.getBook().getImage_b(),orderItem.getOrder().getOid()};
        }
        try {
            qr.batch(sql,params);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
