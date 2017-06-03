package com.reborn.base64;

import org.junit.Test;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;

/**
 * Created by Reborn。 on 2017/5/18.
 * BASE64的编码与解码
 */
public class Demo {
    @Test
    public void fun1() throws IOException {
        String s = "hebela";
        BASE64Encoder base64Encoder = new BASE64Encoder();
        s = base64Encoder.encode(s.getBytes("utf-8"));
        System.out.println(s);

        BASE64Decoder base64Decoder = new BASE64Decoder();
        byte[] bytes = base64Decoder.decodeBuffer(s);
        System.out.println(new String(bytes));
    }
}
