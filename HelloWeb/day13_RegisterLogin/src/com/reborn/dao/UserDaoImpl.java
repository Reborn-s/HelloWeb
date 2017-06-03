package com.reborn.dao;

import com.reborn.domain.User;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

/**
 * Created by Reborn。 on 2017/5/10.
 * 持久层（数据库层）
 * 具体某一实现类：用来访问xml文件
 */
public class UserDaoImpl implements UserDao
{
    private String path = "E:\\Java\\HelloWeb\\day13_RegisterLogin\\src\\resources\\user.xml";

    //根据用户名从xml(也就是数据库)中查询用户并返回User对象
    public User findUserByName(String name)
    {
        //创建解析器
        SAXReader reader = new SAXReader();
        try
        {
            //得到Document对象
            Document document = reader.read(path);
            //通过xpath查询得到Element
            Element ele = (Element)document.selectSingleNode("//user[@username='" + name + "']");
            if(ele==null)   return null;

            //把ele的数据封装进User对象中
            User user = new User();
            user.setUsername(name);
            user.setPassword(ele.attributeValue("password"));
            return user;

        } catch (DocumentException e)
        {
            throw new RuntimeException(e.getMessage());
        }

    }

    //添加用户
    public void addUser(User user)
    {
        SAXReader reader = new SAXReader();
        try
        {
            //得到Document对象
            Document document = reader.read(path);
            //得到根元素
            Element root = document.getRootElement();
            //通过根元素创建新元素
            Element ele = root.addElement("user");
            //为新元素设置属性
            ele.addAttribute("username",user.getUsername());
            ele.addAttribute("password",user.getPassword());

            //保存文档
            OutputFormat format = new OutputFormat("\t",true);//缩进使用\t，允许使用换行
            //防止原先的换行等格式和新加的格式重叠，于是清空原有的换行和缩进
            format.setTrimText(true);

            //创建XMLWriter对象
            XMLWriter writer = new XMLWriter(new OutputStreamWriter(new FileOutputStream(path),"utf-8"),format);
            writer.write(document);//保存document对象
            writer.close();

        } catch (Exception e)
        {
            throw new RuntimeException(e.getMessage());
        }

    }
}
