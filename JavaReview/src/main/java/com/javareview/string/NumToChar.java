package com.javareview.string;

import java.nio.charset.Charset;

public class NumToChar {
    public static void main(String[] args) {
        System.out.println("------------    数直接转为 char  --------------");
        byte b = 0b01100001;
        System.out.println(b);
        // 从 byte 到 char 的过程其实是 byte-->int-->char,所以需要强制类型转换
        char c = (char) b;
        byte a = (byte) c;
        System.out.println(c);
        System.out.println(a);

        System.out.println("------------    数组转为 char（string）  --------------");
        String s = new String(new byte[]{0b01100001, 0b01100010, 0b01100011});
        String s1 = new String(new int[]{100, 101, 102, 30023, 100000}, 0, 5);
        System.out.println(s);
        System.out.println(s1);

        System.out.println("----------  数组通过不同编码方式转为 char（string）   ----------------");
        String s2 = new String(
                new byte[]{(byte) 0xD5, (byte) 0xC5},
                Charset.forName("gbk")
        );
        String s3 = new String(
                new byte[]{(byte) 0xE5, (byte) 0xBC, (byte) 0xA0},
                Charset.forName("utf-8")
        );
        String s4 = new String(
                new byte[]{(byte) 0xE5, (byte) 0xBC, (byte) 0xA0});
        /*
        E5           BC         A0
        229          188        160
        ‭11100101‬     ‭10111100‬   ‭10100000‬
        10011011     11000100   ‭11100000
        -27          -68        -96
         */
        String s5 = new String(new byte[]{-27, -68, -96});
        System.out.println(s2 + ",1");
        System.out.println(s3 + ",2");
        System.out.println(s4 + ",3");
        System.out.println(s5 + ",4");

        /*
        · 24352 是 '张' 的 Unicode
        · char 默认是 Unicode
        · string 默认是 uft-8
         */
        System.out.println((int) '张'); // 24352
        System.out.println((char) 24352);// 张
        System.out.println((char) 0x5F20); // 24352
        System.out.println(new String(new int[]{24352}, 0, 1));


        System.out.println("----------  超出 65535 的 char 表示   ----------------");
        System.out.println((char) 128514);// 0x1F602
        System.out.println(0x1F602);// 128514
        System.out.println(new String(new int[]{128514, 128515}, 0, 2));
        System.out.println((int) '✌');

    }
}
