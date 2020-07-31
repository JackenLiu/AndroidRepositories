package com.javaprimary.a5_common_object;

import java.util.Random;

/**
 * Random 类
 */
public class A3_Random {

    public static void main(String[] args) {
        //Random r = new Random();
        Random r = new Random(1111);                // 通过种子算出随机数，种子是 1111

        for (int i = 0; i < 3; i++) {
            System.out.println(r.nextInt()); // int 取值范围之内随机数
            System.out.println(r.nextInt(1000)); // 现在随机数在 0~1000 范围内
        }
    }




    /*  【Random类的概述和方法使用】

	• A:Random类的概述
		○ 此类用于产生随机数如果用相同的种子创建两个 Random 实例，
		○ 则对每个实例进行相同的方法调用序列，它们将生成并返回相同的数字序列。

	• B:构造方法
		○ public Random()
		○ public Random(long seed)
			§ 通过种子算出随机数

	• C:成员方法
		○ public int nextInt()
		○ public int nextInt(int n)(重点掌握)
        ○ 限制随机数范围为 0 至 n
     */
}
