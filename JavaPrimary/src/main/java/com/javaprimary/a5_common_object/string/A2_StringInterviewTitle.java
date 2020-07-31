package com.javaprimary.a5_common_object.string;

/**
 * String 面试题
 */
public class A2_StringInterviewTitle {

    public static void main(String[] args) {
        demo1();
        demo2();
        demo3();
        demo4();
        demo5();
        testStringCount();
    }

    public static void demo1() {
        System.out.println("testDate --------");
        String s1 = "abc";                        // String s1 = "abc"会进常量池
        String s2 = "abc";                        // 先看常量池是否有"abc"对象,如果没有创建,如果有直接记录住
        System.out.println(s1 == s2);             // 已有对象"abc"的地址值
        System.out.println(s1.equals(s2));        // s1和s2指向的是同一个对象
    }

    public static void demo2() {
        System.out.println("testDateFormat --------");
        // 这句话在内存中创建几个对象
        // 创建了两个对象,一个在常量池里,一个在堆里(是常量池的副本)
        String s1 = "abc";
    }

    public static void demo3() {
        System.out.println("testEquals --------");
        // s1 记录的是堆内存的对象地址值
        String s1 = "abc";
        // s2 记录的是常量池的对象地址值
        String s2 = "abc";
        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));
    }

    public static void demo4() {
        System.out.println("testIsEmpty --------");
        // java 有常量优化机制,在编译时已经是"abc"字符串了
        String s1 = "a" + "b" + "c";
        String s2 = "abc";
        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));
    }

    public static void demo5() {
        System.out.println("testRemove --------");
        String s1 = "ab";                        // 在常量池中创建"ab"
        String s2 = "abc";                       // 在常量池中创建"abc"
        String s3 = s1 + "c";                    // 当字符串与对象用 + 连接的时候,底层会调用 StringBuffer 的
        // append 方法
        System.out.println(s2 == s3);            // 对字符串进行添加,然后将 StringBuffer 对象转换为 String 对象
        System.out.println(s3.equals(s2));       // 并赋值给s3,s3记录的是堆内存对象的地址值
    }

    /**
     * 需求：统计一个字符串中大写字母字符，小写字母字符，数字字符出现的次数,其他字符出现的次数。
     */
    public static void testStringCount() {
        System.out.println("testStringCount --------");
        String s = "Aabc4deBCD123567!@#$%^";
        int big = 0;                        // 记录大小字母字符的个数
        int small = 0;                      // 记录小写字母字符的个数
        int num = 0;                        // 记录数字字符的个数
        int other = 0;                      // 记录其他字符的个数

        for (int i = 0; i < s.length(); i++) { // 对字符串中所有的字符遍历
            char temp = s.charAt(i);           // 记录住字符串中的每一个字符
            if (temp >= 'A' && temp <= 'Z') {
                big++;
            } else if (temp >= 'a' && temp <= 'z') {
                small++;
            } else if (temp >= '0' && temp <= '9') {
                num++;
            } else {
                other++;
            }
        }
        System.out.println("字符s中有大写字母" + big + "个,有小写字母" + small + "个,有数字" +
                num + "个,其他字符" + other + "个");
    }
}
