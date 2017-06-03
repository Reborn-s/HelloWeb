package com.reborn.web.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.UnsupportedEncodingException;

/**
 * Created by Reborn。 on 2017/5/18.
 * request具体装饰类，给getParameter()方法修改为解决编码问题的功能
 */
public class EncodingRequest extends HttpServletRequestWrapper {
    private HttpServletRequest request;
    public EncodingRequest(HttpServletRequest request) {
        super(request);
        this.request = request;
    }

    @Override
    public String getParameter(String name) {
        //处理编码问题
        String value = request.getParameter(name);
        try {
            //value = new String(value.getBytes("iso-8859-1"),"utf-8");
            value = new String(value.getBytes("utf-8"),"utf-8");
        }catch (UnsupportedEncodingException e)
        {
            throw new RuntimeException(e);
        }
        return value;
    }
}
