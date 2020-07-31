package com.javaprimary.a2_data;

/**
 * 赋值运算符
 */
public class A6_AssignmentOperation {

    public static void main(String[] args) {
        int a = 10;
        //a += 20;			// a = a + 20;相当于将左右两边相加的结果再赋值给左边,
        a *= 20;
        System.out.println(a);


        // 隐式强转
        short s = 1;
        s += 1;
        /*
        等于s = (short)(s + 1); +=号是一个赋值运算符,所以为了能够保证赋值成功,会把int类型强转为short类型
         */
        System.out.println(s);


        // 隐式赋值
        Boolean flag = false;
        // 其中 flag = true 这个赋值表达式也有返回值，返回左边变量的值，这里也就是 falg
        if (flag = true) {
            System.out.println("True");
        } else {
            System.out.println("false");
        }

    }


    /*  【赋值运算符的面试题】
	• A:案例演示
		○ 面试题:看下面的程序是否有问题，如果有问题，请指出并说明理由。
			§ short s=1;
			§ s = s+1;

			§ short s=1;
			§ s+=1;

		○ 第一个出错，因为右边进行了 int 的类型提升。第二个不会出错，因为 += 是赋值运算符，计算过程为
		s = (short) s+1，赋值进行了强转

     */
}
