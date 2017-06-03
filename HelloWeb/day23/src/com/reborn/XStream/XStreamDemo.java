package com.reborn.XStream;

import com.thoughtworks.xstream.XStream;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Reborn。 on 2017/5/24.
 */
public class XStreamDemo {
    @Test
    public void fun()
    {
        Province hubei = new Province();
        City wuhan = new City("武汉","wuhan");
        City xinzhou = new City("新洲","xinzhou");
        hubei.setName("湖北");
        hubei.addCity(wuhan);
        hubei.addCity(xinzhou);

        Province taipei = new Province();
        City gaoxiong = new City("高雄","gaoxiong");
        City taibei = new City("台北","taibei");
        taipei.setName("Taipei");
        taipei.addCity(gaoxiong);
        taipei.addCity(taibei);

        List<Province> provinces = new ArrayList<>();
        provinces.add(hubei);
        provinces.add(taipei);

        XStream xstream = new XStream();

        xstream.alias("China",List.class);
        xstream.alias("Province",Province.class);
        xstream.alias("City",City.class);

        xstream.useAttributeFor(Province.class,"name");

        xstream.addImplicitCollection(Province.class,"cities");

        xstream.omitField(City.class,"description");

        String s = xstream.toXML(provinces);

        System.out.println(s);
    }
}
