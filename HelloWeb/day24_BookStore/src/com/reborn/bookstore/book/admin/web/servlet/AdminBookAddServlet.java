package com.reborn.bookstore.book.admin.web.servlet;

import cn.itcast.commons.CommonUtils;
import com.reborn.bookstore.book.domain.Book;
import com.reborn.bookstore.book.service.BookService;
import com.reborn.bookstore.category.domain.Category;
import com.reborn.bookstore.category.service.CategoryService;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Reborn。 on 2017/5/30.
 */
@WebServlet(name = "AdminBookAddServlet",urlPatterns = {"/admin/AdminBookAddServlet"})
public class AdminBookAddServlet extends HttpServlet {
    private BookService bookService = new BookService();
    private CategoryService categoryService = new CategoryService();

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        //上传图片
        DiskFileItemFactory factory = new DiskFileItemFactory(15*1024,new File("F://temp"));
        ServletFileUpload sfu = new ServletFileUpload(factory);
        sfu.setFileSizeMax(100*1024);
        try {
            List<FileItem> fileItemList = sfu.parseRequest(request);
            Map<String,String> map = new HashMap<>();
            for(FileItem fileItem:fileItemList)
            {
                if(fileItem.isFormField())
                    map.put(fileItem.getFieldName(),fileItem.getString("utf-8"));
            }
            Book book = CommonUtils.toBean(map,Book.class);
            book.setBid(CommonUtils.uuid());
            Category category = CommonUtils.toBean(map,Category.class);
            book.setCatogory(category);

            String savePath = this.getServletContext().getRealPath("/book_img");
            String wfilename = CommonUtils.uuid()+"_"+fileItemList.get(1).getName();
            File wfile = new File(savePath,wfilename);
            fileItemList.get(1).write(wfile);

            book.setImage_w("/book_img/"+wfilename);

            String bfilename = CommonUtils.uuid()+"_"+fileItemList.get(2).getName();
            File bfile = new File(savePath,bfilename);
            fileItemList.get(2).write(bfile);

            book.setImage_b("/book_img/"+bfilename);

            //校验文件扩展名
            if(!wfilename.toLowerCase().endsWith("jpg")||!bfilename.toLowerCase().endsWith("jpg"))
            {
                request.setAttribute("msg", "您上传的文件不是jpg图片");
                request.setAttribute("categoryList",categoryService.findAll());
                request.getRequestDispatcher("/adminjsps/admin/book/add.jsp").forward(request, response);
                return;
            }

            bookService.add(book);
            request.setAttribute("book",book);

            //校验图片尺寸
            Image wimage = new ImageIcon(wfile.getAbsolutePath()).getImage();
            if(wimage.getWidth(null)>1000||wimage.getHeight(null)>1000)
            {
                wfile.delete();
                request.setAttribute("msg", "您上传的文件长宽超出了1000！");
                request.setAttribute("categoryList",categoryService.findAll());
                request.getRequestDispatcher("/adminjsps/admin/book/add.jsp").forward(request, response);
                return;
            }

            Image bimage = new ImageIcon(bfile.getAbsolutePath()).getImage();
            if(bimage.getWidth(null)>1000||bimage.getHeight(null)>1000)
            {
                bfile.delete();
                request.setAttribute("msg", "您上传的文件长宽超出了1000！");
                request.setAttribute("categoryList",categoryService.findAll());
                request.getRequestDispatcher("/adminjsps/admin/book/add.jsp").forward(request, response);
                return;
            }

            request.getRequestDispatcher("/admin/AdminBookServlet?method=findAll").forward(request,response);

        } catch (Exception e) {
            if(e instanceof FileUploadBase.FileSizeLimitExceededException) {
                request.setAttribute("msg", "上传文件超出100kb！");
                request.setAttribute("categoryList",categoryService.findAll());
                request.getRequestDispatcher("/adminjsps/admin/book/add.jsp").forward(request, response);
            }
        }
    }

}
