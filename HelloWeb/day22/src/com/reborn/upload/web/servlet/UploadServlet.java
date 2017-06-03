package com.reborn.upload.web.servlet;

import com.rebornJar.commons.CommonUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by Reborn。 on 2017/5/18.
 */
@WebServlet(name = "UploadServlet",urlPatterns = {"/UploadServlet"})
public class UploadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //上传三步骤
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        DiskFileItemFactory factory = new DiskFileItemFactory(50*1024,new File("F://temp"));//设置工厂的参数：缓存大小与临时存放目录
        ServletFileUpload servletFileUpload = new ServletFileUpload(factory);
        //servletFileUpload.setFileSizeMax(50*1024);//设置单个文件能够上传的大小为50KB
        try {
            List<FileItem> fileItemList = servletFileUpload.parseRequest(request);
            FileItem fileItem1 = fileItemList.get(0);
            System.out.println("普通表单项:" + fileItem1.getFieldName() + "=" + fileItem1.getString("utf-8"));

            FileItem fileItem2 = fileItemList.get(1);
            System.out.println("文件表单项：" + fileItem2.getFieldName()); //表单项名称
            System.out.println(fileItem2.getName());//上传文件的名称即filename
            System.out.println(fileItem2.getSize());//上传文件的大小

            //如果浏览器上传的文件名称包含绝对路径，则需要进行切割
            String name = fileItem2.getName();
            int index = name.indexOf("\\");
            if(index!=-1)
            {
                name = name.substring(index+1);
            }

            //在文件名前加上uuid，处理文件同名问题
            String saveName = CommonUtils.getUuid() + "_" + name;

            //将存放上传文件的目录打散
            String path = request.getServletContext().getRealPath("/WEB-INF");
            int hash = name.hashCode();
            String hexString = Integer.toHexString(hash);
            String savePath = path+"/"+hexString.charAt(0)+"/"+hexString.charAt(1);
            File dirFile = new File(savePath);
            dirFile.mkdirs();
            File destFile = new File(dirFile,saveName);

            try {
                //将上传的文件保存到本地
                fileItem2.write(destFile);
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }

        } catch (FileUploadException e) {
            if(e instanceof FileUploadBase.FileSizeLimitExceededException)
            {
                request.setAttribute("msg","您上传的文件大小超过了50KB！");
                request.getRequestDispatcher(request.getContextPath()+"/upload/form1.jsp").forward(request,response);
            }
            //e.printStackTrace();
            //throw new RuntimeException(e);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
