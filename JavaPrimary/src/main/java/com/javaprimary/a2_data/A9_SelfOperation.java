package com.javaprimary.a2_data;

/**
 * 自加自减算术运算符
 */
public class A9_SelfOperation {

    public static void main(String[] args) {
        int a = 10;
        int b = 10;
        int c = 10;

        a = b++;                        //a = 10 b = 11
        System.out.println(a);            //10
        c = --a;                        //c = 9 a = 9
        b = ++a;                        //b = 10 a = 10
        a = c--;                        //a = 9 c = 8
        System.out.println("=================================");
        System.out.println(a);            //9
        System.out.println(b);            //10
        System.out.println(c);            //8

        int x = 4;
        //		4    + 6   + 6 * 10 = 70
        int y = (x++) + (++x) + (x * 10);

        System.out.println(x);
        System.out.println(y);
    }


    /*	【算术运算符++和--的用法】

	• A:++,--运算符的作用
		○ 自加（++）自减（--）运算
			§ ++:自加。对原有的数据进行+1
			§ --:自减。对原有的数据进行-1
	• B:案例演示
		○ a:单独使用：
			§ 放在操作数的前面和后面效果一样。(这种用法是我们比较常见的)
		○ b:参与运算使用：
			§ 放在操作数的前面，先自增或者自减，然后再参与运算。
			§ 放在操作数的后面，先参与运算，再自增或者自减。
     */
}
