package com.javaprimary.a5_common_object.string;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

/**
 * String 转换功能
 */
public class A5_StringChange {

    public static void main(String[] args) throws UnsupportedEncodingException {
        demo1();
        demo2();
        demo3();
        demo4();
    }

    public static void demo1() throws UnsupportedEncodingException {
        System.out.println("testDate --------");
        String s1 = "abc";
        byte[] arr = s1.getBytes();                    // 编码,将我们看的懂的,变成计算机看的懂的
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        String s2 = "你好你好";
        byte[] arr2 = s2.getBytes(StandardCharsets.UTF_8);
        for (int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i] + " ");
        }
        System.out.println();
        // 用什么码表编就用什么码表解
        //-60 -29 -70 -61 -60 -29 -70 -61 通过String的构造函数解码
        //-28 -67 -96 -27 -91 -67 -28 -67 -96 -27 -91 -67 utf-8编码
        byte[] arr3 = {-28, -67, -96, -27, -91, -67, -28, -67, -96, -27, -91, -67};
        String s3 = new String(arr3);
        System.out.println(s3);
    }

    public static void demo2() {
        System.out.println("testDateFormat --------");
        String s = "itcast传智播客";
        char[] arr = s.toCharArray();                // 将字符串转换为字符数组
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void demo3() {
        System.out.println("testEquals --------");
        char[] arr = {'1', '2', '3'};
        String s1 = String.valueOf(arr);            // 将字符数组转换成对应的字符串
        System.out.println(s1);

        String s2 = String.valueOf(10);
        System.out.println(s2);
        System.out.println(10 + "");                // 也可以将10转换成对应的字符串
    }

    public static void demo4() {
        System.out.println("testIsEmpty --------");
        String s1 = "abcDEFgh";
        System.out.println(s1.toLowerCase());        // 将所有的字符转换成小写
        System.out.println(s1.toUpperCase());        // 将所有的字符转换成大写
        System.out.println(s1);

        String s2 = "abc";
        String s3 = "def";
        String s4 = s2.concat(s3);                    // 将两个字符串连接
        System.out.println(s4);
    }




    /*  【String类的转换功能】

	• byte[] getBytes():
		○ 把字符串转换为字节数组。
		○ 注意以下代码：
		String s2 = "你好你好";
		byte[] arr2 = s2.getBytes("UTF-8");
		for (int i = 0; i < arr2.length; i++) {
			System.out.print(arr2[i] + " ");
		}
		//用什么码表编就用什么码表解
		//-60 -29 -70 -61 -60 -29 -70 -61 通过String的构造函数解码
		//-28 -67 -96 -27 -91 -67 -28 -67 -96 -27 -91 -67 utf-8编码
		byte[] arr3 = {-28,-67,-96,-27,-91,-67,-28,-67,-96,-27,-91,-67};
		String s3 = new String(arr3,"UTF-8");
		System.out.println(s3);


	• char[] toCharArray():
		○ 把字符串转换为字符数组。

	• static String valueOf(char[] chs):
		○ 把字符数组转成字符串。

	• static String valueOf(int i):
		○ 把int类型的数据转成字符串。
		○ 注意：String类的valueOf方法可以把任意类型的数据转成字符串。

	• String toLowerCase():
		○ 把字符串转成小写。
	• String toUpperCase():
		○ 把字符串转成大写。

	• String concat(String str):
		○ 把字符串拼接。
     */
}
