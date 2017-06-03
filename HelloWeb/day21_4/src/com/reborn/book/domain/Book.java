package com.reborn.book.domain;

/**
 * Created by Reborn。 on 2017/5/18.
 */
public class Book {
    private String bid;
    private String bname;
    private double price;
    private int category;

    @Override
    public String toString() {
        return "Book{" +
                "bid='" + bid + '\'' +
                ", bname='" + bname + '\'' +
                ", price=" + price +
                ", category=" + category +
                '}';
    }

    public Book() {
    }

    public Book(String bid, String bname, double price, int category) {

        this.bid = bid;
        this.bname = bname;
        this.price = price;
        this.category = category;
    }

    public String getBid() {

        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }
}
