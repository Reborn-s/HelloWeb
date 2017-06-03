package com.reborn.bookstore.category.service;

import com.reborn.bookstore.book.dao.BookDao;
import com.reborn.bookstore.book.domain.Book;
import com.reborn.bookstore.category.dao.CategoryDao;
import com.reborn.bookstore.category.domain.Category;

import java.util.List;

/**
 * Created by Reborn。 on 2017/5/28.
 */
public class CategoryService {
    private CategoryDao categoryDao = new CategoryDao();
    private BookDao bookDao = new BookDao();

    public List<Category> findAll()
    {
        return categoryDao.findAll();
    }

    public void add(Category category)
    {
        categoryDao.add(category);
    }

    public Category findByCid(String cid) {
        return categoryDao.findByCid(cid);
    }

    public void edit(Category category) {
        categoryDao.edit(category);
    }

    public void deleteTwoLevel(String cid) throws CategoryException {
        List<Book> bookList = bookDao.findByCategory(cid);
        if(!bookList.isEmpty())  throw new CategoryException("此分类下有图书，不能删除！");
        categoryDao.delete(cid);
    }

    public void deleteOneLevel(String cid) throws CategoryException {
        List<Category> categoryList = categoryDao.findByPid(cid);
        System.out.println(categoryList);
        if(!categoryList.isEmpty()) throw new CategoryException("此分类下有子类，不能删除！");
        categoryDao.delete(cid);
    }
}
