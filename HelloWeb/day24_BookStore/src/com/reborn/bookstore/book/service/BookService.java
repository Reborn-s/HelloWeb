package com.reborn.bookstore.book.service;

import com.reborn.bookstore.book.dao.BookDao;
import com.reborn.bookstore.book.domain.Book;

import java.util.List;

/**
 * Created by Reborn。 on 2017/5/28.
 */
public class BookService {
    private BookDao bookDao = new BookDao();

    public List<Book> findByCategory(String cid)
    {
        return bookDao.findByCategory(cid);
    }

    public List<Book> findAll()
    {
        return bookDao.findAll();
    }

    public Book load(String bid)
    {
        return bookDao.load(bid);
    }

    public void add(Book book) {
        bookDao.add(book);
    }

    public void delete(String bid) {
        bookDao.delete(bid);
    }

    public void edit(Book book) {
        bookDao.edit(book);
    }
}
