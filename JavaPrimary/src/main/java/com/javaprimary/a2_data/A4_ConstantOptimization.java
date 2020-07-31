package com.javaprimary.a2_data;

/**
 * java 常量优化机制
 */
public class A4_ConstantOptimization {

    // 【方法】测试常量优化机制
    public static void main(String[] args) {
        /*
        b1和b2是两个byte类型的变量,在进行运算的会自动类型提升为int类型
        b1和b2是两个变量,jvm 无法判断里面具体的值
         */
        byte b, b1, b2;
        b1 = 3;
        b2 = 4;
        //b = b1 + b2;		// 编译出错


        /*
        3和4是两个常量,java有一个常量优化机制,在编译直接讲常量相加的结果算出并赋值
         */
        b = 3 + 4;
        System.out.println(b);
    }


    /*  【常量优化机制】

	• A:案例演示
		○ 面试题:看下面的程序是否有问题，如果有问题，请指出并说明理由。
			§ byte b1 = 3;
			§ byte b2 = 4;
			§ byte b3 = b1 + b2;
			§ byte b4 = 3 + 4;
		○ 答案：b3出错，b4不报错。
		○ 从两方面去回答这个题
			§ b1和b2是两个变量,变量里面存储的值都是变化的,所以在程序运行中JVM是无法判断里面具体的值
			§ byte类型的变量在进行运算的时候,会自动类型提升为int类型
			§ 3和4都是常量,java有常量优化机制,就是在编译的的时候直接把3和4的结果赋值给b4了
     */
}
