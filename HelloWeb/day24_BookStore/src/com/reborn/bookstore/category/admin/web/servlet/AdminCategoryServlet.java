package com.reborn.bookstore.category.admin.web.servlet;

import cn.itcast.commons.CommonUtils;
import cn.itcast.servlet.BaseServlet;
import com.reborn.bookstore.category.domain.Category;
import com.reborn.bookstore.category.service.CategoryException;
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
@WebServlet(name = "AdminCategoryServlet",urlPatterns = {"/admin/AdminCategoryServlet"})
public class AdminCategoryServlet extends BaseServlet {
    private CategoryService categoryService = new CategoryService();

    public String deleteOneLevel(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String cid = request.getParameter("cid");
        try {
            categoryService.deleteOneLevel(cid);
            System.out.println(cid);
            return findAll(request,response);
        } catch (CategoryException e) {
            request.setAttribute("msg",e.getMessage());
            return "f:/adminjsps/admin/msg.jsp";
        }
    }

    public String deleteTwoLevel(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String cid = request.getParameter("cid");
        try {
            categoryService.deleteTwoLevel(cid);
            return findAll(request,response);
        } catch (CategoryException e) {
            request.setAttribute("msg",e.getMessage());
            return "f:/adminjsps/admin/msg.jsp";
        }
    }

    public String editTwoLevel(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        request.setCharacterEncoding("utf-8");
        String cid = request.getParameter("cid");
        Category category = CommonUtils.toBean(request.getParameterMap(),Category.class);
        Category parent=  categoryService.findByCid(request.getParameter("pid"));
        category.setParents(parent);
        categoryService.edit(category);
        return findAll(request,response);
    }

    public String preEditTwo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        Category category = categoryService.findByCid(request.getParameter("cid"));
        request.setAttribute("category",category);

        List<Category> categoryList = categoryService.findAll();
        request.setAttribute("categoryList", categoryList);
        request.setAttribute("selectedCategory",request.getParameter("pid"));
        return "f:/adminjsps/admin/category/edit2.jsp";
    }

    public String editOneLevel(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        request.setCharacterEncoding("utf-8");
        String cid = request.getParameter("cid");
        Category category = CommonUtils.toBean(request.getParameterMap(),Category.class);
        categoryService.edit(category);
        return findAll(request,response);
    }

    public String preEditOne(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        Category category = categoryService.findByCid(request.getParameter("cid"));
        request.setAttribute("category",category);
        return "f:/adminjsps/admin/category/edit.jsp";
    }

    public String preAddTwo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        List<Category> categoryList = categoryService.findAll();
        request.setAttribute("categoryList", categoryList);
        request.setAttribute("selectedCategory",request.getParameter("pid"));
        return "f:/adminjsps/admin/category/add2.jsp";
    }

    public String addTwoLevel(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        request.setCharacterEncoding("utf-8");
        Category child = CommonUtils.toBean(request.getParameterMap(),Category.class);
        child.setCid(CommonUtils.uuid());
        Category parent = categoryService.findByCid(request.getParameter("pid"));
        child.setParents(parent);
        categoryService.add(child);
        return findAll(request,response);
    }

    public String addOneLevel(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        request.setCharacterEncoding("utf-8");
        Category category = CommonUtils.toBean(request.getParameterMap(),Category.class);
        category.setCid(CommonUtils.uuid());
        categoryService.add(category);
        return findAll(request,response);
    }

    public String findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Category> categoryList = categoryService.findAll();
        request.setAttribute("categoryList", categoryList);
        return "f:/adminjsps/admin/category/list.jsp";
    }

}
