package com.javaprimary.a5_common_object.regex;

/**
 * 正则表达式 数量词
 */
public class A4_RegexQuantifier {

    public static void main(String[] args) {
        demo1();
        demo2();
        demo3();
        demo4();
        demo5();
        demo6();
    }


    public static void demo1() {
        System.out.println("testDate ----------");
        String regex = "[abc]?";                    // 一次或一次也没有
        System.out.println("a".matches(regex)); // true
        System.out.println("copyFilesToOther".matches(regex)); // false
        System.out.println("c".matches(regex)); // true
        System.out.println("".matches(regex));  // true
        System.out.println("ab".matches(regex));// false
    }

    public static void demo2() {
        System.out.println("testDateFormat ----------");
        String regex = "[abc]*";                    // 出现零次或多次
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaa".matches(regex));// true
        System.out.println("aaaaaaaabbbbbbbbcccccccc".matches(regex));// true
        System.out.println("aaaaaaaabbbbbbbbccccccccdddddd".matches(regex));// false
        System.out.println("".matches(regex));// true
        System.out.println("dddddd".matches(regex));// false
    }

    public static void demo3() {
        System.out.println("testEquals ----------");
        String regex = "[abc]+";
        System.out.println("".matches(regex));// false
        System.out.println("aaaaaaaaaaaaaaaa".matches(regex));// true
        System.out.println("aaaabbbbccccccccccc".matches(regex));// true
        System.out.println("copyFilesToOther".matches(regex));// false
    }

    public static void demo4() {
        System.out.println("testIsEmpty ----------");
        String regex = "[abc]{5}";
        System.out.println("aaaa".matches(regex));// false
        System.out.println("aaaaa".matches(regex));// true
        System.out.println("aaaaaa".matches(regex));// false
        System.out.println("abcba".matches(regex));// true
    }

    public static void demo5() {
        System.out.println("testRemove ----------");
        String regex = "[abc]{5,}";
        System.out.println("abcba".matches(regex));
        System.out.println("abcbabbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb".matches(regex));
    }

    public static void demo6() {
        System.out.println("testSize ----------");
        String regex = "[abc]{5,15}";
        System.out.println("abcba".matches(regex));
        System.out.println("abcbaaaaaaaaaaa".matches(regex));
        System.out.println("aaaa".matches(regex));
        System.out.println("aaaaaaaaaaaaaaaaa".matches(regex));
        System.out.println("aaaaaaaabbbbbbbbccccccc".matches(regex));
    }





    /*  【数量词】

		○ X?        X 出现一次或一次也没有
		○ X*        X 出现零次或多次
		○ X+        X 出现一次或多次
		○ X{n}      X 出现恰好 n 次
		○ X{n,}     X 出现至少 n 次
		○ X{n,m}    X 出现至少 n 次，但是不超过 m 次
     */
}
