package com.reborn.XStream;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Reborn。 on 2017/5/24.
 */
public class Province {
    private String name;
    private List<City> cities = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }

    @Override
    public String toString() {
        return "Province{" +
                "name='" + name + '\'' +
                ", cities=" + cities +
                '}';
    }

    public Province(String name, List<City> cities) {
        this.name = name;
        this.cities = cities;
    }

    public Province() {

    }

    public void addCity(City city)
    {
        cities.add(city);
    }
}
