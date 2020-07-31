package com.javaprimary.a5_common_object.wrapsClass;

/**
 * Integer 类面试题
 */
public class A3_IntegerInterviewTitle {

    public static void main(String[] args) {
        Integer i1 = new Integer(97);
        Integer i2 = new Integer(97);
        System.out.println(i1 == i2);            // false
        System.out.println(i1.equals(i2));        // true
        System.out.println("-----------");

        Integer i3 = new Integer(197);
        Integer i4 = new Integer(197);
        System.out.println(i3 == i4);            // false
        System.out.println(i3.equals(i4));        // true
        System.out.println("-----------");


        /*
         * 当Integer直接赋值的范围是在-128到127之间,也就是一个byte的取值范围,不会创建多个对象
         * 第一次Integer = -128,会在底层有一个数组存储-128到127之间的Integer对象值,直接从数组中获取Integer对象
         * 第二次Integer = -128,不会重新创建对象,继续从数组中获取
         */
        Integer i5 = -128;
        Integer i6 = -128;
        System.out.println(i5 == i6);            // true
        System.out.println(i5.equals(i6));        // true
        System.out.println("-----------");

        Integer i7 = 128;
        Integer i8 = 128;
        System.out.println(i7 == i8);            // false
        System.out.println(i7.equals(i8));        // true


        Integer[] arr = {new Integer(-128), 127, -126};    // 数组中可以存储引用数据类型

    }
}
