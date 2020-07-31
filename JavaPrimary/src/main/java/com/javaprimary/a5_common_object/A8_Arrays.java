package com.javaprimary.a5_common_object;

import java.util.Arrays;
import java.util.List;

/**
 * Arrays类
 */
public class A8_Arrays {

    public static void main(String[] args) {

        /*
        测试基本功能
         */
        int[] arr = {12, 32, 1, 2, 4, 13, 5};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

        int[] arr2 = {11, 22, 33, 44, 55, 66, 77};
        System.out.println(Arrays.binarySearch(arr2, 22));
        System.out.println(Arrays.binarySearch(arr2, 66));
        System.out.println(Arrays.binarySearch(arr2, 88));
        System.out.println(Arrays.binarySearch(arr2, 9));
        System.out.println(Arrays.binarySearch(arr2, 24));



        /*
        测试 AsList
         */
        testAsList();
    }


    public static void testAsList() {
        String[] arr = {"a", "b", "c"};
        List<String> list = Arrays.asList(arr);
        System.out.println(list);
        // 数组转换成集合不能改变长度,但是可以应用集合中其他的方法
//        list.add("copyFilesToOther");


//        int[] arr = {11,22,33,44,55};
//        List<int[]> list = Arrays.asList(arr);
//        System.out.println(list);

        // 11,22,33,44,55是Integer类型,自动装箱
        Integer[] arr2 = {11, 22, 33, 44, 55};
        // 把数组转换成集合,必须是引用数据类型的数组,否则会将整个数组当作一个对象
        List<Integer> list2 = Arrays.asList(arr2);
        System.out.println(list2);
    }



    /* 【Arrays类的概述和方法使用】

	• A:Arrays类概述
		○ 针对数组进行操作的工具类。
		○ 提供了排序，查找等功能。

	• B:成员方法
		○ public static String toString(int[] a)
			§ 输出数组
		○ public static void sort(int[] a)
			§ 数组排序，升序
		○ public static int binarySearch(int[] a,int key)
			§ 二分法查找
    */





    /* 【Arrays 工具类的 asList() 方法的使用】

	• A:案例演示
		○ Arrays工具类的asList()方法的使用
		Integer[] arr2 = {11,22,33,44,55};
				List<Integer> list2 = Arrays.asList(arr2);
				System.out.println(list2);

		○ Collection中toArray(T[] a)泛型版的集合转数组
    */
}
