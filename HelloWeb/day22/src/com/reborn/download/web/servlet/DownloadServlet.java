package com.reborn.download.web.servlet;

import org.apache.commons.io.IOUtils;
import sun.misc.BASE64Encoder;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * Created by Reborn。 on 2017/5/18.
 */
@WebServlet(name = "DownloadServlet",urlPatterns = {"/DownloadServlet"})
public class DownloadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /**
         * 两个头一个流
         * 1. Content-Type:文件的MIME类型
         * 2. Content-Disposition
         * 3. 流：下载文件的数据
         */
        String filename = "你就不要想起我.mp3";

        String contentType = request.getServletContext().getMimeType(filename);
        String contentDisposition = "attachment;filename="+filenameEncoding(filename,request);
        FileInputStream inputStream = new FileInputStream("G://"+filename);

        //设置头
        response.setHeader("Content-Type",contentType);
        response.setHeader("Content-Disposition",contentDisposition);

        //获取绑定了客户端的流
        ServletOutputStream outputStream = response.getOutputStream();
        IOUtils.copy(inputStream,outputStream);
    }

    //为了使下载框中显示中文名称不出现乱码
    private String filenameEncoding(String filename,HttpServletRequest request) throws IOException
    {
        String agent = request.getHeader("User-Agent");
        if(agent.contains("Firefox"))
        {
            BASE64Encoder base64Encoder = new BASE64Encoder();
            filename = "=?utf-8?B?"
                    + base64Encoder.encode(filename.getBytes("utf-8"))
                    + "?=";

        }else if(agent.contains("HSIE"))
        {
            filename = URLEncoder.encode(filename,"utf-8");
        }else
            filename = URLEncoder.encode(filename,"utf-8");
        return filename;
    }
}
