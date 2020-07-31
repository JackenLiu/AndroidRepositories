package com.javaprimary.a5_common_object;

import java.math.BigDecimal;

/**
 * BigDecimal 类
 */
public class A6_BigDecimal {

    public static void main(String[] args) {
        System.out.println(2.0 - 1.1);
        BigDecimal b1 = new BigDecimal(2.0);        // 用double 数当作参数可以,但是开发不用
        BigDecimal b2 = new BigDecimal(1.1);

        System.out.println(b1.subtract(b2));
        BigDecimal b0 = new BigDecimal("2.0");        // 推荐使用
        BigDecimal b3 = new BigDecimal("1.1");
        System.out.println(b0.subtract(b3));

        BigDecimal b4 = BigDecimal.valueOf(2.0);    // 推荐使用
        BigDecimal b5 = BigDecimal.valueOf(1.1);
        System.out.println(b4.subtract(b5));
        System.out.println(2.0 - 1.1);
    }




    /*  【BigDecimal类的概述和方法使用】

	• A:BigDecimal的概述
		○ 由于在运算的时候，float类型和double很容易丢失精度，演示案例。
		○ 所以，为了能精确的表示、计算浮点数，Java 提供 了BigDecimal
		○ 不可变的、任意精度的有符号十进制数。
	• B:构造方法
		○ public BigDecimal(String val)

	• C:成员方法
		○ public BigDecimal add(BigDecimal augend)
		○ public BigDecimal subtract(BigDecimal subtrahend)
		○ public BigDecimal multiply(BigDecimal multiplicand)
		○ public BigDecimal divide(BigDecimal divisor)

	• D:案例演示
		○ BigDecimal类的构造方法和成员方法使用

			○ BigDecimal b1 = BigDecimal.valueOf(2.0);	//推荐使用
			○ BigDecimal b2 = BigDecimal.valueOf(1.1);
			○ System.out.println(b1.subtract(b2));
		○
		○ 结果是 0.9 ，而不是普通运算的 0.8999999
     */
}
