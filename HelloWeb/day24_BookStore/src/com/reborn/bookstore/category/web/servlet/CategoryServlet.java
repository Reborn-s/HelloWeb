package com.reborn.bookstore.category.web.servlet;

import cn.itcast.servlet.BaseServlet;
import com.reborn.bookstore.category.domain.Category;
import com.reborn.bookstore.category.service.CategoryService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Reborn。 on 2017/5/28.
 */
@WebServlet(name = "CategoryServlet",urlPatterns = {"/CategoryServlet"})
public class CategoryServlet extends BaseServlet {
    private CategoryService categoryService = new CategoryService();

    public String findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Category> categoryList = categoryService.findAll();
        request.setAttribute("categoryList",categoryList);
        System.out.println(categoryList);
        return "f:/jsps/left.jsp";
    }

}
