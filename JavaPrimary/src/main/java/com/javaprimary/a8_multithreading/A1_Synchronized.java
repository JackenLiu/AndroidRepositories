package com.javaprimary.a8_multithreading;

/**
 * 线程同步
 */
public class A1_Synchronized {

    public static void main(String[] args) {
        final Printer p = new Printer();
        final Printer p2 = new Printer();

        new Thread() {
            public void run() {
                while (true) {
                    Printer.print1();
                }
            }
        }.start();

        new Thread() {
            public void run() {
                while (true) {
                    Printer.print2();
                }
            }
        }.start();
    }

    static class Printer {
        /*
         * 任意对象都可以当作锁对象
         * 注意:匿名对象不可以当作锁对象,因为不能保证两个锁对象是同一个对象
         * 非静态的同步方法,锁对象是this
         * 静态的同步方法,锁对象是当前类的字节码对象
         */
        static Object obj = new Object();

        public static void print1() {
            // 同步代码块
            synchronized (Printer.class) {                    // 获取锁，锁用this 也不一定唯一的
                System.out.print("黑");
                System.out.print("马");
                System.out.print("程");
                System.out.print("序");
                System.out.print("员");
                System.out.print("\r\n");
            }                                                // 释放锁
        }

        // 同步方法，因为是静态方法，所以这里的锁是本类字节码文件 Printer.class
        public static synchronized void print2() {
            //synchronized(obj) {
            System.out.print("传");
            System.out.print("智");
            System.out.print("播");
            System.out.print("客");
            System.out.print("\r\n");
            //}
        }

    }



    /* 【同步代码块】

    同步代码块

	• 1.什么情况下需要同步
		○ 当多线程并发, 有多段代码同时执行时, 我们希望某一段代码执行的过程中 CPU 不要切换到其他线程工作. 这时就需要同步
		○ 如果两段代码是同步的, 那么同一时间只能执行一段, 在一段代码没执行结束之前, 不会执行另外一段代码.

	• 2.同步代码块
		○ 使用 synchronized 关键字加上一个锁对象来定义一段代码, 这就叫同步代码块
        ○ 多个同步代码块如果使用相同的锁对象, 那么他们就是同步的
    */




    /* 【同步方法】

	• 使用synchronized关键字修饰一个方法, 该方法中所有的代码都是同步的
		○ 任意对象都可以当作锁对象
		○ 注意:匿名对象不可以当作锁对象,因为不能保证两个锁对象是同一个对象
		○ 非静态的同步方法,锁对象是this
		○ 静态的同步方法,锁对象是当前类的字节码对象
    */
}
