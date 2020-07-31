package com.javaprimary.a5_common_object.string;

/**
 * String 类介绍，构造方法
 */
public class A1_StringConstructor {

    public static void main(String[] args) {
        demo1();
        demo2();
        demo3();
    }


    public static void demo1() {
        String s1 = "";                    // 创建一个空的字符串
        System.out.println("s1 =" + "\"" + s1 + "\"");

        String s2 = "";                                // 空的字符串
        System.out.println("s2 =" + "\"" + s2 + "\"");

        String s3 = " ";                                // 空格
        System.out.println("s3 =" + "\"" + s3 + "\"");

        /*											// 如果不是null就返回对象的toString方法
         * null 和"" 的区别
         * ""是一个String 类的对象,可以调用 String 类中所有方法
         * null 是一个空值,不能调用任何方法,因为调用就会报空指针异常
         */
        String s4 = null;
        System.out.println(s4);                    // 打印对象的引用如果是null就返回null
    }

    public static void demo2() {
        byte[] arr = {97, 98, 99};
        String s1 = new String(arr);                // 解码,将计算机能看懂的变成我们能看懂的
        System.out.println(s1);

        byte[] arr2 = {97, 98, 99, 100, 101, 102};
        // public String(byte[] bytes,int index,int length)将 byte数组解码,从index开始,解码length个
        String s2 = new String(arr2, 2, 3);
        System.out.println(s2);
    }

    public static void demo3() {
        char[] arr = {'a', 'b', 'c'};
        String s1 = new String(arr);                // 将字符数组转换为字符串
        System.out.println(s1);
        //String(char[] value, int offset, int count) 将char数组转换为String字符串,从offset开始,转换count个
        char[] arr2 = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i'};
        String s2 = new String(arr2, 3, 3);
        System.out.println(s2);
    }

    /*  【String类的构造方法】

	• public String():
	    空构造
	• public String(byte[] bytes):
	    把字节数组转成字符串
	• public String(byte[] bytes,int index,int length):
	    把字节数组的一部分转成字符串
	• public String(char[] value):
	    把字符数组转成字符串
	• public String(char[] value,int index,int count):
	    把字符数组的一部分转成字符串
    • public String(String original):
        把字符串常量值转成字符串
     */
}
