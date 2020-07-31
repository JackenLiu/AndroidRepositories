package com.javaprimary.a8_multithreading.primary;

/**
 * 获取线程的属性
 */
public class A3_ThreadProperties {

    public static void main(String[] args) {

        testThreadName();
        testGetThread();
    }

    public static void testThreadName() {
        Thread t1 = new Thread("马哥") {                         // 通过构造方法给名字赋值
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(this.getName() + "....aaaaaaaaaaaaaaaaaaaaaa");
                }
            }
        };

        Thread t2 = new Thread("辉哥") {
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(this.getName() + "....bb");
                }
            }
        };

        t1.setName("凤姐");                                        // 通过setName()方法给名字赋值
        t2.setName("芙蓉姐姐");

        t1.start();
        t2.start();
    }

    public static void testGetThread() {
        Thread t1 = new Thread(new Runnable() {

            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(Thread.currentThread().getName() + "....aaaaaaaaaaaaaaaaaaaaaa");
                }
            }
        }, "张三");

        Thread t2 = new Thread(new Runnable() {

            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(Thread.currentThread().getName() + "....bb");
                }
            }
        }, "李四");

        // Thread.currentThread 写在哪个线程里就代表哪个线程引用
        Thread.currentThread().setName("我是主线程");
        System.out.println(Thread.currentThread().getName());

        t1.start();
        t2.start();
    }





    /* 【获取名字和设置名字】

	• 1.获取名字
		○ 通过getName()方法获取线程对象的名字

	• 2.设置名字
		○ 通过构造函数可以传入String类型的名字
    */




    /* 【获取当前线程的对象】

	• Thread.currentThread(), 主线程也可以获取
    */
}
