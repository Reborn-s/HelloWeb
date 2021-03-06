package com.reborn.bookstore.book.domain;

import com.reborn.bookstore.category.domain.Category;

import java.text.DecimalFormat;

/**
 * Created by Reborn。 on 2017/5/28.
 */
public class Book {
    private String bid;
    private String bname;
    private String author;
    private double price;
    private double currPrice;
    private double discount;
    private String press;
    private String publishtime;
    private int edition;
    private int pageNum;
    private int wordNum;
    private String printtime;
    private int booksize;
    private String paper;
    private Category category;
    private String image_w;
    private String image_b;
    private int orderBy;
    private boolean deleted;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public Category getCatogory() {
        return category;
    }

    public void setCatogory(Category catogory) {
        this.category = catogory;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bid='" + bid + '\'' +
                ", bname='" + bname + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", currPrice=" + currPrice +
                ", discount=" + discount +
                ", press='" + press + '\'' +
                ", publishtime='" + publishtime + '\'' +
                ", edition=" + edition +
                ", pageNum=" + pageNum +
                ", wordNum=" + wordNum +
                ", printtime='" + printtime + '\'' +
                ", booksize=" + booksize +
                ", paper='" + paper + '\'' +
                ", catogory=" + category +
                ", image_w='" + image_w + '\'' +
                ", image_b='" + image_b + '\'' +
                ", orderBy=" + orderBy +
                '}';
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getCurrPrice() {
        return currPrice;
    }

    public void setCurrPrice(double currPrice) {
        this.currPrice = currPrice;
    }

    public double getDiscount() {
        return Double.parseDouble(new DecimalFormat("#.00").format(this.currPrice/this.price));
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
    }

    public String getPublishtime() {
        return publishtime;
    }

    public void setPublishtime(String publishtime) {
        this.publishtime = publishtime;
    }

    public int getEdition() {
        return edition;
    }

    public void setEdition(int edition) {
        this.edition = edition;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getWordNum() {
        return wordNum;
    }

    public void setWordNum(int wordNum) {
        this.wordNum = wordNum;
    }

    public String getPrinttime() {
        return printtime;
    }

    public void setPrinttime(String printtime) {
        this.printtime = printtime;
    }

    public int getBooksize() {
        return booksize;
    }

    public void setBooksize(int booksize) {
        this.booksize = booksize;
    }

    public String getPaper() {
        return paper;
    }

    public void setPaper(String paper) {
        this.paper = paper;
    }

    public String getImage_w() {
        return image_w;
    }

    public void setImage_w(String image_w) {
        this.image_w = image_w;
    }

    public String getImage_b() {
        return image_b;
    }

    public void setImage_b(String image_b) {
        this.image_b = image_b;
    }

    public int getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(int orderBy) {
        this.orderBy = orderBy;
    }
}
