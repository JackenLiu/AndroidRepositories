package com.javaprimary.a2_data.array;

import java.util.Arrays;

/**
 * 数组
 */
public class A1_Array {

    public static void main(String[] args) {
        testInitArray();


        /*
        测试数组排序
         */
        int[] ints1 = new int[]{6, 1, 3, 9, 0, 6, 3};
        char[] chars = {'d', 'a', 'v', 'j', 'f', 'z', 'd', 'e', 'a'};
        Arrays.sort(ints1);
        Arrays.sort(chars);
        System.out.println(Arrays.toString(ints1));
        System.out.println(Arrays.toString(chars));


        /*
        测试数组反转
         */
        int[] ints = new int[]{1, 2, 3, 4, 5, 6};
        for (int i : ints) {
            System.out.print(i + " ");
        }
        revArray(ints);
        for (int i : ints) {
            System.out.print(i + " ");
        }
    }


    // 【方法】测试初始化数组
    public static void testInitArray() {
        int[] arr = new int[5];
        int[] arr1 = new int[]{1, 2, 3, 4, 5};
        int[] arr2 = {1, 2, 3, 4, 5};

        int[][] arr3 = new int[3][2];
        int[][] arr4 = new int[3][];
        int[][] arr5 = {{1, 2, 3}, {4, 5}, {6, 7, 8, 9}};

        System.out.println(arr.length);
        System.out.println(arr1.length);
        System.out.println(arr2.length);
    }


    // 【方法】数组反转
    public static void revArray(int[] arr) {
        for (int x = 0; x < arr.length / 2; x++) {
            int temp = arr[x];
            arr[x] = arr[arr.length - 1 - x];
            arr[arr.length - 1 - x] = temp;
        }
    }


    /* 【数组概述与数组初始化】

	• 数组是装数据类型的容器
	• 数组大小限制就是字符数组的最大长度也是2G，占用内存是4GB。 一个数组最大的长度是一个 int 的最大值，也就是
	  2147483647，而一个字符串在 Java 内部是使用 char[] 来表示的，也就是说一个字符串的最大长度是 2147483647。

	• 如何对数组进行初始化
		○ a:动态初始化 只指定长度，由系统给出初始化值
			§ int[] arr = new int[5];
		○ b:静态初始化 给出初始化值，由系统决定长度
			§ int[] arr = new int[]{1,2,3,4,5};
			§ int[] arr = {1,2,3,4,5};
			§ 错误写法：
				□ int[] arr = new int[3]{1,2,3};
				□ int[] arr ; arr = {1,2,3,4,5};
		○ c:二维数组
		    § int[][] arr = new int[3][2];
            § int[][] arr = new int[3][];
            § int[][] arr = {{1,2,3},{4,5},{6,7,8,9}};
     */




    /*  【数组元素类型的默认初始化】

    • 整数都是0
    • 小数都是0.0
    • 布尔都是false
    • 字符都是'\u0000'
    • 引用数据类型都是null
     */



    /* 【数组常用方法】

    • 数组排序
        Arrays.sort()
    • 数组转换成字符串
        Arrays.toString(数组)
    */



    /*  【Java中到底是传值还是传址?】

    Java中是传值,非传址,因为地址值也是值(高司令支持)
     */
}
