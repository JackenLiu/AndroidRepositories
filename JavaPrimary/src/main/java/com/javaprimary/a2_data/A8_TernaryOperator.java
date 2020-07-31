package com.javaprimary.a2_data;

/**
 * 三元运算符
 */
public class A8_TernaryOperator {

    public static void main(String[] args) {
        /*
			A:案例演示
			比较两个整数是否相同
			B:案例演示
			获取三个整数中的最大值
		*/

        int x = 10;
        int y = 10;
        boolean b = x == y;
        boolean b2 = (x == y);

        System.out.println(b);
        System.out.println(b2);


        int a = 10;
        int b1 = 20;
        int c = 30;

        int temp = (a > b1) ? a : b1;
        System.out.println((temp > c) ? temp : c);
        int temp2 = (temp > c) ? temp : c;
    }



    /*  【三元运算符的基本用法】

	• A:三元运算符的格式
		○ (关系表达式) ? 表达式1 : 表达式2;

	• A:案例演示
		○ 比较两个整数是否相同
		int x = 10;
		int y = 10;
		boolean b = (x == y)? true : false;
		boolean b2 = (x == y);

	• B:案例演示
		○ 获取三个整数中的最大值
		int a = 10;
		int b = 20;
		int c = 30;

		int temp = (a > b) ? a : b;
		//System.out.println((temp > c) ? temp : c);
		int temp2 = (temp > c) ? temp : c;
     */
}
