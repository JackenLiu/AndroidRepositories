package com.javaprimary.a8_multithreading.communication;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 多线程通信：互斥锁
 */
public class A6_ReentrantLock {

    public static void main(String[] args) {
        final Printer2 p = new Printer2();

        new Thread() {
            public void run() {
                while (true) {
                    try {
                        p.print1();
                    } catch (InterruptedException e) {

                        e.printStackTrace();
                    }
                }
            }
        }.start();

        new Thread() {
            public void run() {
                while (true) {
                    try {
                        p.print2();
                    } catch (InterruptedException e) {

                        e.printStackTrace();
                    }
                }
            }
        }.start();

        new Thread() {
            public void run() {
                while (true) {
                    try {
                        p.print3();
                    } catch (InterruptedException e) {

                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }


    static class Printer2 {
        private ReentrantLock r = new ReentrantLock();      // 创建互斥锁对象
        private Condition c1 = r.newCondition();            // 创建监视器
        private Condition c2 = r.newCondition();
        private Condition c3 = r.newCondition();
        private int flag = 1;                               // 定义标记

        //private Object obj = new Object();
        public void print1() throws InterruptedException {
            r.lock();
            if (flag != 1) {
                c1.await();
            }
            System.out.print("黑");
            System.out.print("马");
            System.out.print("程");
            System.out.print("序");
            System.out.print("员");
            System.out.print("\r\n");
            flag = 2;
            c2.signal();
            r.unlock();
        }

        public void print2() throws InterruptedException {
            r.lock();
            if (flag != 2) {
                c2.await();
            }
            System.out.print("传");
            System.out.print("智");
            System.out.print("播");
            System.out.print("客");
            System.out.print("\r\n");
            flag = 3;
            c3.signal();
            r.unlock();
        }

        public void print3() throws InterruptedException {
            r.lock();
            if (flag != 3) {
                c3.await();
            }
            System.out.print("i");
            System.out.print("t");
            System.out.print("c");
            System.out.print("a");
            System.out.print("s");
            System.out.print("t");
            System.out.print("\r\n");
            flag = 1;
            c1.signal();
            r.unlock();
        }
    }





    /* 【JDK1.5 的新特性互斥锁】

	• 1.同步
		○ 使用ReentrantLock类的 lock() 和 unlock() 方法进行同步

	• 2.通信
		○ 使用ReentrantLock类的newCondition()方法可以获取 Condition 对象
		○ 需要等待的时候使用Condition的await()方法, 唤醒的时候用signal()方法
		○ 不同的线程使用不同的Condition, 这样就能区分唤醒的时候找哪个线程了
    */
}
