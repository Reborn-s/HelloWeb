package com.reborn.bookstore.category.domain;

import java.util.List;

/**
 * Created by Reborn。 on 2017/5/28.
 */
public class Category {
    private String cid;
    private String cname;
    private Category parents;
    private String desc;
    private List<Category> children;

    public Category getParents() {
        return parents;
    }

    public void setParents(Category parents) {
        this.parents = parents;
    }

    public List<Category> getChildren() {
        return children;
    }

    public void setChildren(List<Category> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "Category{" +
                "cid='" + cid + '\'' +
                ", cname='" + cname + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

}
