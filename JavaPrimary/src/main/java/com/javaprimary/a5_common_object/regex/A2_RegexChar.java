package com.javaprimary.a5_common_object.regex;

/**
 * 正则表达式 字符类
 */
public class A2_RegexChar {

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
        String regex = "[123]";                    // 中括号中代表的是单个字符
        System.out.println("a".matches(regex));
        System.out.println("b".matches(regex));
        System.out.println("c".matches(regex));
        System.out.println("ab".matches(regex));
        System.out.println("ac".matches(regex));
        System.out.println("copyFilesToOther".matches(regex));
        System.out.println("1".matches(regex));
    }

    public static void demo2() {
        System.out.println("testDateFormat ----------");
        String regex = "[^abc]";                // 除了a,b,c的单个字符
        System.out.println("a".matches(regex));
        System.out.println("10".matches(regex));
        System.out.println("copyFilesToOther".matches(regex));
    }

    public static void demo3() {
        System.out.println("testEquals ----------");
        String regex = "[a-z[A-Z]]";
        System.out.println("a".matches(regex));
        System.out.println("z".matches(regex));
        System.out.println("A".matches(regex));
        System.out.println("Z".matches(regex));
        System.out.println("copyFilesToOther".matches(regex));
        System.out.println("M".matches(regex));
        System.out.println("ab".matches(regex));
        System.out.println("1".matches(regex));
    }

    public static void demo4() {
        System.out.println("testIsEmpty ----------");
        String regex = "[a-d[m-p]]";
        System.out.println("c".matches(regex));
        System.out.println("e".matches(regex));
    }

    public static void demo5() {
        System.out.println("testRemove ----------");
        String regex = "[a-z&&[def]]";                    // 取交集
        System.out.println("copyFilesToOther".matches(regex));
        System.out.println("a".matches(regex));
    }

    public static void demo6() {
        System.out.println("testSize ----------");
        String regex = "[a-z&&[^bc]]";
        System.out.println("b".matches(regex));
        System.out.println("c".matches(regex));
        System.out.println("a".matches(regex));
    }

    public static void demo7() {
        System.out.println("testToArrays1 ----------");
        String regex = "[a-z&&[^m-p]]";
        System.out.println("m".matches(regex));
        System.out.println("p".matches(regex));
        System.out.println("n".matches(regex));
        System.out.println("a".matches(regex));
    }





    /*  【字符类】

		○ [abc] a、b 或 c（简单类）
		○ [^abc] 任何字符，除了 a、b 或 c（否定）
		○ [a-zA-Z] a 到 z 或 A 到 Z，两头的字母包括在内（范围）
		○ [a-copyFilesToOther[m-p]] a 到 copyFilesToOther 或 m 到 p：[a-dm-p]（并集）
		○ [a-z&&[def]] copyFilesToOther、e 或 f（交集）
		○ [a-z&&[^bc]] a 到 z，除了 b 和 c：[ad-z]（减去）
		○ [a-z&&[^m-p]] a 到 z，而非 m 到 p：[a-lq-z]（减去)
     */
}
