package com.javareview.string;

/**
 * 经典面试题
 */
public class Interview {
    public static void main(String[] args) {
        /*
        · 指向同一个常量池对象（不同类中也一样）
         */
        String s = "abc";
        String s4 = "abc";
        System.out.println(s == s4);
        System.out.println("----------------------------------");


        /*
        · 此代码创建了多少个对象？
        分两种情况：
            · 如果 ”abc“ 在之前没有被创建过，则创建两个对象，一个常量池对象 ”abc“，一个 new String();
            · 反之，如在此 main 方法中，上面 ”abc“ 已创建过，则只创建一个对象： new String();
         */
        String s5 = new String("abc");


        /*
        · s8 指向的是一个 String 对象，s9 指向的是一个常量池对象
         */
        String s8 = new String("abc");
        String s9 = "abc";
        System.out.println(s8 == s9);
        System.out.println("----------------------------------");



        /*
        · 常量优化机制，"a" + "b" + "c" 就直接等同于 "abc"，是同一个常量池对象
         */
        String s6 = "a" + "b" + "c";
        String s7 = "abc";
        System.out.println(s6 == s7);
        System.out.println("----------------------------------");



        /*
        · 字符串联是通过 StringBuffer 或 StringBuilder 对象使用 append 方法实现，然后使用 toString 方法生成
        新的 String 对象。
         */
        String s1 = "abc";
        String s2 = "ab";
        String s3 = s2 + "c";
//        String s3 = new StringBuilder().append(s2).append("c").toString();
        System.out.println(s1 == s3);
        System.out.println("----------------------------------");



        /*
        ·  final 变量在编译后会直接替换成对应的值，所以实际上等于 s4=”a”+”bc”，而这种情况下，编译器会直接合并为
         s4=”abc”，所以最终 s1==s4
         */
        String s10 = "abc";
        final String s11 = "a";
        final String s12 = "bc";
        String s13 = s11 + s12;
        System.out.println(s13 == s10);
        System.out.println("----------------------------------");



        /*
        · new String 都是在堆上创建字符串对象。当调用 intern () 方法时，编译器会将字符串添加到常量池中
        （stringTable 维护），并返回指向该常量的引用
         */
        String s14 = new String("abc");
        String s15 = "abc";
        String s16 = new String("abc");
        System.out.println(s14 == s15.intern());
        System.out.println(s14 == s16.intern());
        System.out.println(s15 == s16.intern());
        System.out.println("----------------------------------");

    }
}
