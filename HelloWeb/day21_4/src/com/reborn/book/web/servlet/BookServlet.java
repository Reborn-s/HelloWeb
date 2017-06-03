package com.reborn.book.web.servlet;

import com.reborn.book.service.BookService;
import com.rebornJar.servlet.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Reborn。 on 2017/5/18.
 */
@WebServlet(name = "BookServlet",urlPatterns = {"/BookServlet"})
public class BookServlet extends BaseServlet {
    private BookService service = new BookService();
    public String findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException
    {
        request.setAttribute("booklist",service.findAll());
        return "/show.jsp";
    }

    public String findByCategory(HttpServletRequest request, HttpServletResponse response)
            throws ServletException,IOException
    {
        String category = request.getParameter("category");
        int cate = Integer.parseInt(category);
        request.setAttribute("booklist",service.findByCategory(cate));
        return "/show.jsp";
    }
}
