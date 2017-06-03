package com.reborn.book.web.servlet;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

/**
 * Created by Reborn。 on 2017/5/18.
 */
public class StaticResponse extends HttpServletResponseWrapper {
    private PrintWriter printWriter;
    public StaticResponse(HttpServletResponse response, String path) throws FileNotFoundException, UnsupportedEncodingException {
        super(response);

        //创建一个与html文件路径在一起的流对象
        this.printWriter = new PrintWriter(path,"UTF-8");
    }

    public PrintWriter getPrintWriter()
    {
        //返回一个与html绑定在一起的printWriter对象
        //jsp会使用它进行输出，这样数据都输出到html文件了
        return this.printWriter;
    }
}
