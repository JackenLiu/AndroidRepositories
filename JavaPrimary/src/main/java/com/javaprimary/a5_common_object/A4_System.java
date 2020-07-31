package com.javaprimary.a5_common_object;

/**
 * system 类
 */
public class A4_System {

    public static void main(String[] args) {
//        testDate();
//        testDateFormat();
        demo3();
    }


    public static void demo1() {
        Object p = new Object();
        System.out.println(p);
        p = null;
        System.gc();                    // 启动垃圾回收
    }

    public static void demo2() {
        Object p1 = new Object();
        System.out.println(p1);

        System.exit(0);                        // 退出jvm虚拟机
        Object p2 = new Object();
        System.out.println(p2);
    }

    public static void demo3() {
        long start = System.currentTimeMillis();

        for (int i = 0; i < 100000; i++) {
            System.out.print("*");
        }
        System.out.println();
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }




    /*  【System类的概述和方法使用】

	• A:System类的概述
		○ System 类包含一些有用的类字段和方法。它不能被实例化。

	• B:成员方法
		○ public static void gc()
			§ 运行垃圾回收器
		○ public static void exit(int status)
			§ 退出jvm(虚拟机)
		○ public static long currentTimeMillis()

	• C:案例演示
		○ System类的成员方法使用
     */
}
