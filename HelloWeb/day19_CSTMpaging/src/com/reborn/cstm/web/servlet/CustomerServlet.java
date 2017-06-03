package com.reborn.cstm.web.servlet;

import com.reborn.cstm.domain.Customer;
import com.reborn.cstm.domain.PageBean;
import com.reborn.cstm.service.CustomerService;
import com.rebornJar.commons.CommonUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

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

    /*public String findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        List<Customer> customers = service.findAll();
        request.setAttribute("customersList",customers);
        return "f:/list.jsp";
    }*/

    public String findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        /**
         * 1. 获取页面传递的pageCode
         * 2. 给定pageSize的值
         * 3. 使用pageCode和pageSize调用service方法，得到PageBean，保存到request域
         * 4. 转发到list.jsp
         */

        /**
         * 1. 得到pc
         *  如果pc不存在，说明pc=1；如果存在，就转化为int数值
         */
        int pageCode = getPageCode(request);
        int pageSize = 10;
        PageBean<Customer> pageBean = service.findAll(pageCode,pageSize);
        //设置url
        pageBean.setUrl(getUrl(request));
        request.setAttribute("pageBean",pageBean);
        return "f:/list.jsp";
    }

    /**
     * 获取pageCode
     * @param request
     * @return
     */
    private int getPageCode(HttpServletRequest request)
    {
        String pageCode = request.getParameter("pageCode");
        if(pageCode==null||pageCode.trim().isEmpty())
            return 1;
        else
            return Integer.parseInt(pageCode);
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
        int pageCode = getPageCode(request);
        int pageSize = 10;

        Customer customer = CommonUtils.toBean(request.getParameterMap(),Customer.class);
        customer = encode(customer);

        PageBean<Customer> pageBean = service.query(customer,pageCode,pageSize);
        //含有参数的url保存到pageBean中
        pageBean.setUrl(getUrl(request));

        request.setAttribute("pageBean",pageBean);
        return "f:/list.jsp";
    }

    private String getUrl(HttpServletRequest request)
    {
        String contextPath = request.getContextPath();
        String servletPath = request.getServletPath();
        String param = request.getQueryString();

        String url = contextPath+servletPath+"?"+param;

        if(url.contains("pageCode="))
        {
            int index = url.indexOf("pageCode=");
            url = url.substring(0,index);
        }
        return url;
    }

    //处理get的编码问题
    private Customer encode(Customer customer) throws UnsupportedEncodingException {
        String cname = customer.getCname();
        String gender = customer.getGender();
        String email = customer.getEmail();
        String cellphone = customer.getCellphone();

        if(cname!=null&&!cname.trim().isEmpty())
        {
            cname = new String(cname.getBytes("utf-8"),"utf-8");
            customer.setCname(cname);
        }
        if(gender!=null&&!gender.trim().isEmpty())
        {
            gender = new String(gender.getBytes("utf-8"),"utf-8");
            customer.setGender(gender);
        }
        if(email!=null&&!email.trim().isEmpty())
        {
            email = new String(email.getBytes("utf-8"),"utf-8");
            customer.setEmail(email);
        }
        if(cellphone!=null&&!cellphone.trim().isEmpty())
        {
            cellphone = new String(cellphone.getBytes("utf-8"),"utf-8");
            customer.setCellphone(cellphone);
        }
        return customer;
    }
}
