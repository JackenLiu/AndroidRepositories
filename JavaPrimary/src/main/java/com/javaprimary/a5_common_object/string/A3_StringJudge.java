package com.javaprimary.a5_common_object.string;

/**
 * String 判断功能
 */
public class A3_StringJudge {

    public static void main(String[] args) {
        demo1();
        demo2();
        demo3();
        demo4();
    }

    public static void demo1() {
        System.out.println("testDate --------");
        String s1 = "abc";
        String s2 = "abc";
        String s3 = "AbC";
        System.out.println(s1.equals(s3));            // 相同字符序列返回true
        System.out.println(s1.equalsIgnoreCase(s3));  // 比较字符串的内容是否相同,忽略大小写
    }

    public static void demo2() {
        System.out.println("testDateFormat --------");
        String s1 = "javaitcastjava";
        String s2 = "itcast";
        String s3 = "heima";

        System.out.println(s1.contains(s2));        // 包含传入的字符串返回true
        System.out.println(s1.contains(s3));        // 不包含返回false
    }

    public static void demo3() {
        System.out.println("testEquals --------");
        String s1 = "aaaitcastbbbitcastccc";
        String s2 = "aaa";
        String s3 = "ccc";

        System.out.println(s1.startsWith(s2));      // 判断字符串是否以某个指定的字符串开头
        System.out.println(s1.startsWith(s3));
        System.out.println("---");
        System.out.println(s1.endsWith(s2));        // 判断字符串是否以某个指定的字符串结尾
        System.out.println(s1.endsWith(s3));
    }

    public static void demo4() {
        System.out.println("testIsEmpty --------");
        String s1 = "";
        String s2 = "itcast";
        String s3 = null;

        System.out.println(s1.isEmpty());
        System.out.println(s2.isEmpty());
//        System.out.println(s3.isEmpty());
    }




    /*  【String类的判断功能】

	• boolean equals(Object obj):
		○ 比较字符串的内容是否相同,区分大小写

	• boolean equalsIgnoreCase(String str):
		○ 比较字符串的内容是否相同,忽略大小写

	• boolean contains(String str):
		○ 判断大字符串中是否包含小字符串

	• boolean startsWith(String str):
		○ 判断字符串是否以某个指定的字符串开头

	• boolean endsWith(String str):
		○ 判断字符串是否以某个指定的字符串结尾

	• boolean isEmpty():
		○ 判断字符串是否为空。
     */
}
