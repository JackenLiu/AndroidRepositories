package com.javaprimary.a5_common_object.regex;

/**
 * 正则表达式 预定义字符类
 */
public class A3_RegexPredefineChar {

    public static void main(String[] args) {
        demo1();
        demo2();
        demo3();
        demo4();
        demo5();
        demo6();
        demo7();
    }

    public static void demo1() {
        System.out.println("testDate ----------");
        String regex = "..";                    // 一个点就代表任意的一个字符
        System.out.println("a".matches(regex));
        System.out.println("aa".matches(regex));
        System.out.println("%%".matches(regex));
    }

    public static void demo2() {
        System.out.println("testDateFormat ----------");
        String regex = "\\d";                    // 在字符串中\是转义字符
        System.out.println("1".matches(regex));
        System.out.println("10".matches(regex));
        System.out.println("a".matches(regex));
    }

    public static void demo3() {
        System.out.println("testEquals ----------");
        String regex = "\\D";
        System.out.println("a".matches(regex));
        System.out.println("5".matches(regex));
    }

    public static void demo4() {
        System.out.println("testIsEmpty ----------");
        String regex = "\\s";
        System.out.println(" ".matches(regex));
        System.out.println("    ".matches(regex));        // 四个空格
        System.out.println("	".matches(regex));        // tab 键
        System.out.println("a".matches(regex));
    }

    public static void demo5() {
        System.out.println("testRemove ----------");
        String regex = "\\S";
        System.out.println("a".matches(regex));
        System.out.println(" ".matches(regex));
        System.out.println("    ".matches(regex));
    }

    public static void demo6() {
        System.out.println("testSize ----------");
        String regex = "\\W";
        System.out.println(" ".matches(regex));
        System.out.println("a".matches(regex));
        System.out.println("9".matches(regex));
    }

    public static void demo7() {
        System.out.println("testToArrays1 ----------");
        String regex = "\\w";
        System.out.println(" ".matches(regex));
        System.out.println("a".matches(regex));
        System.out.println("9".matches(regex));
    }





    /*  【预定义字符类】

		○ . 任何单个字符
		○ \copyFilesToOther 数字：[0-9]
		○ \D 非数字： [^0-9]
		○ \s 空白字符：[ \t\n\x0B\f\r]
		○ \S 非空白字符：[^\s]
		○ \w 单词字符：[a-zA-Z_0-9]
		○ \W 非单词字符：[^\w]
     */
}
