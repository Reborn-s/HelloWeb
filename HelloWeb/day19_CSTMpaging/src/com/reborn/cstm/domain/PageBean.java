package com.reborn.cstm.domain;

import java.util.List;

/**
 * Created by Reborn。 on 2017/5/24.
 */
public class PageBean<T> {
    private int pageCode;//当前页码
    private int totalPages;//总页数
    private int totalRecord;//总记录数
    private int pageSize;//每页记录数
    private List<T> beanList;

    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getPageCode() {
        return pageCode;
    }

    public int getTotalPages() {
        return this.totalRecord/this.pageSize+1;
    }

    public PageBean(int pageCode, int totalRecord, int pageSize, List<T> beanList) {
        this.pageCode = pageCode;
        this.totalRecord = totalRecord;
        this.pageSize = pageSize;
        this.beanList = beanList;
    }

    @Override
    public String toString() {
        return "PageBean{" +
                "pageCode=" + pageCode +
                ", totalRecord=" + totalRecord +
                ", pageSize=" + pageSize +
                ", beanList=" + beanList +
                '}';
    }

    public void setPageCode(int pageCode) {
        this.pageCode = pageCode;
    }

    public int getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(int totalRecord) {
        this.totalRecord = totalRecord;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public List<T> getBeanList() {
        return beanList;
    }

    public void setBeanList(List<T> beanList) {
        this.beanList = beanList;
    }

    public PageBean() {

    }
}
