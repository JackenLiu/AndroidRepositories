package com.javaprimary.a2_data;

/**
 * 字符运算
 */
public class A5_CharOperation {

    public static void main(String[] args) {
        System.out.println('a' + 1);
        System.out.println((char) ('a' + 1));
        System.out.println((char) 1000);
        System.out.println("hello" + 'a' + 1);    //任何数据用+与字符串连接都会产生新的字符串
        System.out.println('a' + 1 + "hello");
        System.out.println("5+5=" + 5 + 5);
        System.out.println("5+5=" + (5 + 5)); // 括号优先级最高
    }


    /*  【字符和字符串参与运算】

	• A:案例演示
		○ System.out.println('a');
			§ 输出 a
		○ System.out.println('a'+1);
			§ 输出 98
		○ 通过看结果知道'a'的值是多少,由此引出 ASCII 码表

	• B:ASCII码表的概述
		○ 记住三个值：
			§ '0' 48
			§ 'A' 65
			§ 'a' 97

	• C:案例演示
		○ System.out.println("hello"+'a'+1);
			§ 输出 helloa1
		○ System.out.println('a'+1+"hello");
			§ 输出 98hello

	• D:+在有字符串参与中被称为字符串连接符
		○ System.out.println("5+5="+5+5);
			§ 输出 5+5=55
		○ System.out.println(5+5+"=5+5");
			§ 输出10=5+5

     */
}
