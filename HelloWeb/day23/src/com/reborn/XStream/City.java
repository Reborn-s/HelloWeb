package com.reborn.XStream;

/**
 * Created by Reborn。 on 2017/5/24.
 * JavaBean对象
 */
public class City {
    private String name;
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public City(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public City() {

    }
}
