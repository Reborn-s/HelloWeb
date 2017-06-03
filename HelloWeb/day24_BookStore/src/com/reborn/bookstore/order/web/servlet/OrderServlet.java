package com.reborn.bookstore.order.web.servlet;

import cn.itcast.commons.CommonUtils;
import cn.itcast.servlet.BaseServlet;
import com.reborn.bookstore.cart.domain.Cart;
import com.reborn.bookstore.cart.domain.CartItem;
import com.reborn.bookstore.order.domain.Order;
import com.reborn.bookstore.order.domain.OrderItem;
import com.reborn.bookstore.order.service.OrderException;
import com.reborn.bookstore.order.service.OrderService;
import com.reborn.bookstore.user.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

/**
 * Created by Reborn。 on 2017/5/28.
 */
@WebServlet(name = "OrderServlet",urlPatterns = {"/OrderServlet"})
public class OrderServlet extends BaseServlet {
    private OrderService orderService = new OrderService();

    public String back(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        request.setAttribute("msg","恭喜！支付成功！");
        response.getWriter().print("success");
        return "f:/jsps/msg.jsp";
    }

    public String prePay(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String oid = request.getParameter("oid");
        request.setAttribute("order",orderService.load(oid));
        return "f:/jsps/order/pay.jsp";
    }

    public void pay(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        /**
         * https://www.yeepay.com/app-merchant-proxy/node?p0_cmd=Buy&p1_MerId=10001126856&p2_Order=FD88DE8E9FA0443AA6DB11B7F20E9F57
         * &p3_Amt=0.01&p4_Cur=CNY&p5_Pid=&p6_Pcat=&p7_Pdesc=&p8_Url=http://localhost:808/bookstore/OrderServlet?method=back
         * &p9_SAF=&pa_MP=&pd_FrpId=ICBC-NET-B2C&pr_NeedResponse=1&hmac=345d1481ff3729026629185d87393745
         */

        //得到13+1个参数
        Properties props = new Properties();
        props.load(this.getClass().getClassLoader().getResourceAsStream("merchantInfo.properties"));
        String p0_Cmd = "Buy";
        String p1_MerId = props.getProperty("p1_MerId");
        String p2_Order = request.getParameter("oid");
        String p3_Amt = "0.01";
        String p4_Cur = "CNY";
        String p5_Pid = "";
        String p6_Pcat = "";
        String p7_Pdesc = "";
        String p8_Url = props.getProperty("p8_Url");
        String p9_SAF = "";
        String pa_MP = "";
        String pd_FrpId = request.getParameter("yh");
        String  pr_NeedResponse = "1";
        String hmac = PaymentUtil.buildHmac(p0_Cmd,p1_MerId,p2_Order,p3_Amt,p4_Cur,p5_Pid,p6_Pcat,
                p7_Pdesc,p8_Url,p9_SAF,pa_MP,pd_FrpId,pr_NeedResponse,props.getProperty("keyValue"));
        String url = "https://www.yeepay.com/app-merchant-proxy/node";
        StringBuilder sb = new StringBuilder(url);
        sb.append("?p0_cmd=");sb.append(p0_Cmd);
        sb.append("&p1_MerId=");sb.append(p1_MerId);
        sb.append("&p2_Order=");sb.append(p2_Order);
        sb.append("&p3_Amt=");sb.append(p3_Amt);
        sb.append("&p4_Cur=");sb.append(p4_Cur);
        sb.append("&p5_Pid=");sb.append(p5_Pid);
        sb.append("&p6_Pcat=");sb.append(p6_Pcat);
        sb.append("&p7_Pdesc=");sb.append(p7_Pdesc);
        sb.append("&p8_Url=");sb.append(p8_Url);
        sb.append("&p9_SAF=");sb.append(p9_SAF);
        sb.append("&pa_MP=");sb.append(pa_MP);
        sb.append("&pd_FrpId=");sb.append(pd_FrpId);
        sb.append("&pr_NeedResponse=");sb.append(pr_NeedResponse);
        sb.append("&hmac=");sb.append(hmac);

        System.out.println(sb.toString());

        response.sendRedirect(sb.toString());
    }

    public String confirm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String oid = request.getParameter("oid");
        try {
            orderService.confirm(oid);
            request.setAttribute("msg","确认收货成功！恭喜交易完成！");
        } catch (OrderException e) {
            request.setAttribute("msg",e.getMessage());
        }
        return "f:/jsps/msg.jsp";
    }

    public String load(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String oid = request.getParameter("oid");
        Order order = orderService.load(oid);
        request.setAttribute("order",order);
        return "f:/jsps/order/desc.jsp";
    }

    public String add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        request.setCharacterEncoding("utf-8");
        Cart cart = (Cart) request.getSession().getAttribute("session_cart");
        Collection<CartItem> cartItems = cart.getCartItems();

        Order order = new Order();
        order.setOid(CommonUtils.uuid());
        order.setOrdertime(String.format("%tF %<tT",new Date()));
        order.setTotal(cart.getTotal());
        order.setStatus(1);
        order.setUser((User) request.getSession().getAttribute("session_user"));
        order.setAddress(request.getParameter("address"));

        List<OrderItem> orderItemList = new LinkedList<>();
        for(CartItem cartItem:cartItems)
        {
            OrderItem orderItem = new OrderItem();
            orderItem.setOrderItemId(CommonUtils.uuid());
            orderItem.setQuantity(cartItem.getQuantity());
            orderItem.setSubtotal(cartItem.getSubtotal());
            orderItem.setOrder(order);
            orderItem.setBook(cartItem.getBook());

            orderItemList.add(orderItem);
        }
        order.setOrderItemList(orderItemList);

        cart.clear();
        orderService.add(order);
        request.setAttribute("order",order);
        return "f:/jsps/order/ordersucc.jsp";
    }

    public String myOrders(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        User user = (User)request.getSession().getAttribute("session_user");
        String uid=  user.getUid();
        List<Order> orderList = orderService.findByUid(uid);
        request.setAttribute("orderList",orderList);
        return "f:/jsps/order/list.jsp";
    }
}
