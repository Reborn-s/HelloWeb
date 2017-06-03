package com.reborn.bookstore.cart.domain;

import com.reborn.bookstore.book.domain.Book;
import com.reborn.bookstore.user.domain.User;

import java.math.BigDecimal;

/**
 * Created by Reborn。 on 2017/5/28.
 */
public class CartItem {
    private String cartItemId;
    private int quantity;
    private Book book;
    private User user;

    public double getSubtotal()
    {
        BigDecimal price = new BigDecimal(""+book.getCurrPrice());
        BigDecimal subtotal = price.multiply(new BigDecimal(""+quantity));
        return subtotal.doubleValue();
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "cartItemId='" + cartItemId + '\'' +
                ", quantity=" + quantity +
                ", book=" + book +
                ", user=" + user +
                '}';
    }

    public String getCartItemId() {
        return cartItemId;
    }

    public void setCartItemId(String cartItemId) {
        this.cartItemId = cartItemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
