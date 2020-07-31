package com.javaprimary.a3_method;


/**
 * 可变参数
 */
public class A6_VariadicFunction {

    public static void main(String[] args) {
        int[] arr = {11, 22, 33, 44, 55};
        print(arr);
        print(11, 22, 33, 44, 55);
    }

    // 可变参数,其实就是一个可以变化的数组
    public static void print(int... arr) {
        for (int i : arr) {
            System.out.println(i);
        }
    }



    /* 【可变参数的概述和使用】

	• A:可变参数概述
		○ JDK 新特性
		○ 定义方法的时候不知道该定义多少个参数

	• B:格式
		○ 修饰符 返回值类型 方法名(数据类型… 变量名){}
		public static void print(int ... arr) {		// 可变参数,其实就是一个可以变化的数组
				for (int i : arr) {
					System.out.println(i);
				}
			}

	• C:注意事项：
		○ 这里的变量其实是一个数组
		○ 如果一个方法有可变参数，并且有多个参数，那么，可变参数肯定是最后一个
    */
}
