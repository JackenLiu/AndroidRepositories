package com.javaprimary.a3_method;

/**
 * 递归
 */
public class A7_MethodRecursion {

    public static void main(String[] args) {

        // 普通方法实现阶乘
        /*int result = 1;
		for(int i = 1; i <= 5; i++) {
			result = result * i;
		}

		System.out.println(result);*/

        // 使用递归计算阶乘：5 的阶乘
        System.out.println(fun(5));

    }

    public static int fun(int num) {
        if (num == 1) {
            return 1;
        } else {
            return num * fun(num - 1);
        }
    }



    /* 【递归的概述】

	• 方法自己调用自己

	• 优缺点
            ○ 好处:不用知道调用次数
            ○ 弊端:容易栈内存溢出
            • 注意事项
            ○ 构造函数不能使用递归
            ○ 递归调用可以有返回值也可以没有
    */
}
