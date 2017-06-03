package com.reborn.cstm.web.servlet;

import com.reborn.cstm.domain.Customer;
import com.reborn.cstm.service.CustomerService;
import com.rebornJar.commons.CommonUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Reborn。 on 2017/5/17.
 */
@WebServlet(name = "CustomerServlet",urlPatterns = {"/CustomerServlet"})
public class CustomerServlet extends BaseServlet{
    private CustomerService service = new CustomerService();

    public String add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        Customer customer = CommonUtils.toBean(request.getParameterMap(),Customer.class);
        customer.setCid(CommonUtils.getUuid());
        System.out.println(customer);

        service.add(customer);

        request.setAttribute("msg","恭喜，添加客户成功！");
        return "f:/msg.jsp";
    }

    public String findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        List<Customer> customers = service.findAll();
        request.setAttribute("customersList",customers);
        return "f:/list.jsp";
    }

    public String load(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String cid = request.getParameter("cid");
        Customer customer = service.find(cid);
        request.setAttribute("customer",customer);
        return "f:/edit.jsp";
    }

    public String edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        Customer customer = CommonUtils.toBean(request.getParameterMap(),Customer.class);
        customer.setCid(request.getParameter("cid"));
        service.edit(customer);
        request.setAttribute("msg","编辑客户成功！");
        return "f:/msg.jsp";
    }

    public String delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String cid = request.getParameter("cid");
        service.delete(cid);
        request.setAttribute("msg","删除用户成功！");
        return "f:/msg.jsp";
    }

    public String query(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        Customer customer = CommonUtils.toBean(request.getParameterMap(),Customer.class);
        System.out.println(customer);
        List<Customer> customerList = service.query(customer);
        request.setAttribute("customersList",customerList);
        return "f:/list.jsp";
    }
}
