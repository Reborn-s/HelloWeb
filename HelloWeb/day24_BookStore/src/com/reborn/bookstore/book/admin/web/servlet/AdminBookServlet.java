package com.reborn.bookstore.book.admin.web.servlet;

import cn.itcast.commons.CommonUtils;
import cn.itcast.servlet.BaseServlet;
import com.reborn.bookstore.book.domain.Book;
import com.reborn.bookstore.book.service.BookService;
import com.reborn.bookstore.category.domain.Category;
import com.reborn.bookstore.category.service.CategoryService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Reborn。 on 2017/5/30.
 */
@WebServlet(name = "AdminBookServlet",urlPatterns = {"/admin/AdminBookServlet"})
public class AdminBookServlet extends BaseServlet {
    private BookService bookService = new BookService();
    private CategoryService categoryService = new CategoryService();

    public String findByCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String cid = request.getParameter("cid");
        List<Book> bookList = bookService.findByCategory(cid);
        request.setAttribute("bookList",bookList);
        return "f:/adminjsps/admin/book/list.jsp";
    }

    public String showAllCategories(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        List<Category> categoryList = categoryService.findAll();
        request.setAttribute("categoryList",categoryList);
        return "f:/adminjsps/admin/book/left.jsp";
    }

    public String findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        request.setAttribute("bookList",bookService.findAll());
        return "f:/adminjsps/admin/book/list.jsp";
    }

    public String load(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String bid=  request.getParameter("bid");
        String cid = request.getParameter("cid");
        request.setAttribute("book",bookService.load(bid));
        request.setAttribute("selectedCategory",cid);
        request.setAttribute("categoryList",categoryService.findAll());
        return "f:/adminjsps/admin/book/desc.jsp";
    }

    public String preAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        List<Category> categoryList = categoryService.findAll();
        request.setAttribute("categoryList",categoryList);
        return "f:/adminjsps/admin/book/add.jsp";

    }

    public String delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        bookService.delete(request.getParameter("bid"));
        return findAll(request,response);
    }

    public String edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        Book book = CommonUtils.toBean(request.getParameterMap(),Book.class);
        Category category = CommonUtils.toBean(request.getParameterMap(),Category.class);
        book.setCatogory(category);
        bookService.edit(book);
        System.out.println(book);
        return findAll(request,response);
    }
}
