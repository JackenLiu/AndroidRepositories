package com.javareview.string;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

public class 乱码 {

    public static void main(String[] args) throws UnsupportedEncodingException {
        String s = "你";
        byte[] bytes = new byte[0];
        /*
        · 或者该字符在不同编码模式下的存储值
         */
        bytes = s.getBytes("GB2312");

        for (int i = 0; i < bytes.length; i++) {
            System.out.print(bytes[i] + " ");
        }
        System.out.println();
        // string 输出使用默认编码模式 UTF-8
        String messy = new String(bytes
//                Charset.forName("GB2312")
        );
        System.out.println(messy);

        bytes = messy.getBytes("GB2312");
        for (int i = 0; i < bytes.length; i++) {
            System.out.print(bytes[i] + " ");
        }
        System.out.println(new String(bytes));

        messy = messy;// 乱码
        bytes = messy.getBytes();
        System.out.println(new String(bytes,
                Charset.forName("GB2312")
        ));
    }
}
