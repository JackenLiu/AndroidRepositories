package com.javaprimary.a5_common_object.stringBuffer;

/**
 * StringBuffer 概述
 */
public class A1_StringBuffer {

    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer();
        System.out.println(sb.capacity());        // 理论值
        System.out.println(sb.length());        // 实际值

        StringBuffer sb2 = new StringBuffer(10);
        System.out.println(sb2.capacity());        // capacity() 返回的值就是底层字符数组的长度
        System.out.println(sb2.length());

        StringBuffer sb3 = new StringBuffer("abcdef");
        System.out.println(sb3.capacity());        // 传入的字符串的长度加上16(默认的char数组长度)
        System.out.println(sb3.length());
    }





    /*  【StringBuffer 类的概述】

	• A:StringBuffer类概述
		○ 通过JDK 提供的API，查看 StringBuffer 类的说明
		○ 线程安全的可变字符序列

	• B:简述安全问题
		○ 线程安全效率低

	• C:StringBuffer 和 String 的区别
		○ String 是一个不可变的字符序列
		○ StringBuffer 是一个可变的字符序列
     */







    /*  【StringBuffer 类的构造方法】

	• A:StringBuffer 的构造方法：
		○ public StringBuffer():无参构造方法
		○ public StringBuffer(int capacity):指定容量的字符串缓冲区对象
		○ public StringBuffer(String str):指定字符串内容的字符串缓冲区对象

	• B:StringBuffer 的方法：
		○ public int capacity()：返回当前容量。 理论值(不掌握)
		○ public int length():返回长度（字符数）。 实际值
     */






    /*  【String、StringBuffer 和 StringBuilder 的区别】

		○ String 是一个不可变的字符序列
        ○ StringBuffer,StringBuilder是可变的字符序列
        ○ StringBuffer是jdk1.0版本的,是线程安全的,效率低
        ○ StringBuilder是jdk1.5版本的,是线程不安全的,效率高
     */
}
