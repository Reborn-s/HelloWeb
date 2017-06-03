package com.web.day10_encode;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Arrays;

/**
 * Created by Reborn。 on 2017/5/5.
 * utf-8:一个中文三个字符
 * gbk:一个中文两个字符
 */
public class URLEncode
{
    public static void main(String[] args) throws UnsupportedEncodingException
    {
        String name="张三";
        byte[] bytes = name.getBytes("utf-8");
        System.out.println(Arrays.toString(bytes));

        String s = URLEncoder.encode(name,"utf-8");
        System.out.println(s);

        s = URLDecoder.decode(s,"utf-8");
        System.out.println(s);

        String sgbk = URLEncoder.encode(name,"gbk");
        System.out.println(sgbk);

        s = URLDecoder.decode(sgbk,"gbk");
        System.out.println(s);



    }
}
