package com.reborn.book.service;

import com.reborn.book.dao.BookDao;
import com.reborn.book.domain.Book;

import java.util.List;

/**
 * Created by Reborn。 on 2017/5/18.
 */
public class BookService {
    private BookDao dao = new BookDao();

    public List<Book> findAll()
    {
        return dao.findAll();
    }

    public List<Book> findByCategory(int category)
    {
        return dao.findByCategory(category);
    }
}
