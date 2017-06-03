package com.reborn.bookstore.book.web.servlet;

import cn.itcast.servlet.BaseServlet;
import com.reborn.bookstore.book.domain.Book;
import com.reborn.bookstore.book.service.BookService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Reborn。 on 2017/5/28.
 */
@WebServlet(name = "BookServlet",urlPatterns = {"/BookServlet"})
public class BookServlet extends BaseServlet {
    private BookService bookService = new BookService();

    public String findByCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String cid = request.getParameter("cid");
        List<Book> bookList = bookService.findByCategory(cid);
        request.setAttribute("bookList",bookList);
        return "f:/jsps/book/list.jsp";
    }

    public String findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        request.setAttribute("bookList",bookService.findAll());
        return "f:/jsps/book/list.jsp";
    }

    public String load(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String bid = request.getParameter("bid");
        request.setAttribute("book",bookService.load(bid));
        return "f:/jsps/book/desc.jsp";
    }

}
