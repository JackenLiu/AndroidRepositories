package com.javaprimary.a2_data;

/**
 * 数据类型
 */
public class A2_DataTypeOutline {

    //  【方法】展示基本数据类型
    public static void main(String[] args) {

        // 整数类型
        byte b = 100;
        short s = 1000;
        int i = 10000;
        long l = 123456789012345678L;
        /*
        切记 如果想标识long 类型的数,超过了int的取值范围,需要在末尾加上L,最好是大写,因为小写的太像1这个数字;
        此处进行了数据运算的自动类型提升
         */
        System.out.println(12345 + 5432l);

        //浮点类型
        float f = 12.3f;
        double d = 13.4d;        //13.4后面的d 可以省略,copyFilesToOther 可以是大写也可以是小写

        //字符类型
        char c1 = 'a';
        char c2 = '0';
        char c3 = '中';

        //字符是否可以存储中文?
        //可以,java 是unicode 编码,char 类型占的两个字节,而一个中文占的也是两个字节
        System.out.println(c3);

        //布尔类型
        boolean b1 = true;
        boolean b2 = false;

    }




    /*  【数据类型的概述和分类】

    • A:为什么有数据类型
		○ Java 语言是强类型语言，对于每一种数据都定义了明确的具体数据类型，在内存总分配了不同大小的内存空间

	• B:Java 中数据类型的分类
		○ 基本数据类型
		○ 引用数据类型

	• C:基本数据类型分类(4 类 8 种)
		○ 整数型
			§ byte（占1个字节，-128 至127）
			§ short（占2 个字节）
			§ Int (占4 个字节，默认类型)
			§ long（占8 个字节）
		○ 浮点型（二进制没办法准确表示小数，只能无限接近，如12.3 可能内存里表示为12.299999）
			§ float（占4个字节，单精度）
			§ double（占8个字节，双精度，默认类型）
		○ 字符型（可以存储单个中文字，Java采用Unicode 编码）
			§ char（占2 个字节，0 到65535）
		○ 布尔型
			§ boolean（理论上占八分之一个字节，Java中没有明确指定大小）

	• 注意：局部变量即方法内定义的数据类型必须赋值才能用，这点与在方法外类内定义的成员变量不一样，成员变量有默认值，
	       但是数组里面也不用赋值也有默认值，局部变量没有默认值。
     */

}
