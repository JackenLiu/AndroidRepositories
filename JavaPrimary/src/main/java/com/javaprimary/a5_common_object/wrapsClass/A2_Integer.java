package com.javaprimary.a5_common_object.wrapsClass;

/**
 * Integer 包装类
 */
public class A2_Integer {

    public static void main(String[] args) {
        demo1();
        demo2();
        demo3();
        demo4();
        demo5();
    }

    public static void demo1() {
        System.out.println("testDate --------");
        String line = "12";                        // 录入的所有元素都能存储在line中
        //可以对line进行操作
        int x = Integer.parseInt(line);                        // 将一个数字字符串转换成数字

        System.out.println(x);
    }

    public static void demo2() {
        System.out.println("testDateFormat --------");
        Integer i = new Integer(100);            // 将一个int数转换成Integer的对象
        Integer i2 = new Integer("100");        // 将数字字符串转换成Integer对象
        System.out.println(i);
        System.out.println(i2);
    }

    public static void demo3() {
        System.out.println("testEquals --------");
        //int ---> String
        int num = 100;
        String x = num + "";                    // 任何数据与字符串用+连接都会产生新的字符串
        String y = String.valueOf(num);            // valueOf可以将任何数据转换成字符串
        System.out.println(x);
        System.out.println(y);
    }

    public static void demo4() {
        System.out.println("testIsEmpty --------");
        String s = "100";
        byte b = Byte.parseByte(s);
        short sh = Short.parseShort(s);
        int i = Integer.parseInt(s);
        long l = Long.parseLong(s);
        float f = Float.parseFloat(s);
        double d = Double.parseDouble(s);

        String s2 = "true";
        boolean b2 = Boolean.parseBoolean(s2);
        System.out.println(b2);
        String s3 = "我不爱北京";                    // 只有Character中没有parseXxx方法,因为字符串是由多个字符组成
        // 转换的时候char只能接收一个字符,字符串转成字符有toCharArray()方法
    }

    public static void demo5() {
        System.out.println("testRemove --------");
        int x = 10;
        Integer i = new Integer(x);                // 1.5版本之前将x变成对象

        Integer i2 = x;                            // 自动装箱,把基本数据类型变成对象
        x = i2.intValue();                        // 手动将Integer对象转换成基本数据类型
        int y = i2 + 20;                        // 自动拆箱,把对象变成基本数据类型
    }





    /*  【Integer 类的概述和构造方法】

	• A:Integer类概述
		○ 通过JDK提供的API，查看Integer类的说明
		○ Integer 类在对象中包装了一个基本类型 int 的值,
		○ 该类提供了多个方法，能在 int 类型和 String 类型之间互相转换，
		○ 还提供了处理 int 类型时非常有用的其他一些常量和方法

	• B:构造方法
		○ public Integer(int value)
		○ public Integer(String s)

	• C:案例演示
		○ 使用构造方法创建对象
     */






    /*  【String 和 int 类型的相互转换】

	• A:int -- String
		○ a:和""进行拼接
		○ b:public static String valueOf(int i)
		○ c:int -- Integer -- String(Integer类的toString方法())
		○ copyFilesToOther:public static String toString(int i)(Integer类的静态方法)

	• B:String -- int
		○ a:String -- Integer -- int
			§ public static int parseInt(String s)
     */






    /*  【自动拆装箱JDK5的新特性】

	• A:JDK5的新特性
		○ 自动装箱：把基本类型转换为包装类类型
		○ 自动拆箱：把包装类类型转换为基本类型

	• B:案例演示
		○ JDK5的新特性自动装箱和拆箱
		○ Integer ii = 100;
		○ ii += 200;

	• C:注意事项
		○ 在使用时，Integer x = null;代码就会出现NullPointerException。
        ○ 建议先判断是否为null，然后再使用。
     */
}
