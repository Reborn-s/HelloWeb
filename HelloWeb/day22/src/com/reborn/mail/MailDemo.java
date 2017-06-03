package com.reborn.mail;

import org.junit.Test;

import javax.mail.*;
import javax.mail.internet.*;
import java.io.File;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by Reborn。 on 2017/5/18.
 * 实现发邮件
 */
public class MailDemo {
    @Test
    //无附件的邮件
    public void fun1() throws MessagingException {
        Properties properties = new Properties();
        properties.setProperty("mail.host","smtp.163.com");//设置服务器主机名
        properties.setProperty("mail.smtp.auth","true");//设置是否需要认证

        Authenticator authenticator = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("Reborn651","cherish651314");//用户名和密码
            }
        };
        Session session = Session.getInstance(properties,authenticator);//得到用于连接的session对象

        //创建MimeMessage对象来设置发送方、接收方、发送主题以及发送内容
        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress("Reborn651@163.com"));
        message.setRecipients(MimeMessage.RecipientType.TO,"653213604@qq.com");
        message.setRecipients(Message.RecipientType.CC,"Reborn651@163.com");
        message.setSubject("主题是：你好！");
        message.setContent("这是一封来自java的邮件！","text/html;charset=utf-8");

        //发送
        Transport.send(message);


    }

    //发送有附件的邮件
    @Test
    public void fun2() throws MessagingException, IOException {
        Properties properties = new Properties();
        properties.setProperty("mail.host","smtp.163.com");
        properties.setProperty("mail.smtp.auth","true");

        Authenticator authenticator = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("Reborn651","cherish651314");
            }
        };

        Session session = Session.getInstance(properties,authenticator);

        //创建MimeMessage
        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress("Reborn651@163.com"));
        message.setRecipients(Message.RecipientType.TO,"653213604@qq.com");
        message.setSubject("你好啊我又来了");

        /**
         * 当发送包含附件的邮件时，邮件体就为多部件形式
         * 1. 创建一个多部件的部件内容MimeMultiPart
         *      MimeMultiPart就是一个集合，用来装载多个主体
         * 2. 创建两个主体部件，一个是文本内容，一个是附件
         * 3. 把MimeMultiPart设置给MimeMessage的内容
         */
        MimeMultipart list = new MimeMultipart();

        //创建MimeBodyPart
        MimeBodyPart part1 = new MimeBodyPart();
        part1.setContent("hello 小hebe","text/html;charset=utf-8");//设置正文内容

        MimeBodyPart part2 = new MimeBodyPart();
        part2.attachFile(new File("G://小埋.jpg"));//设置附件内容
        part2.setFileName(MimeUtility.encodeText("小埋.jpg"));//设置显示的附件名称，其中encodeText处理中文乱码问题

        list.addBodyPart(part1);
        list.addBodyPart(part2);

        message.setContent(list);

        Transport.send(message);
    }
}


