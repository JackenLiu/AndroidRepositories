package com.javaprimary.a8_multithreading;

/**
 * 多线程方法
 */
public class A3_MultithreadMethod {

    public static void main(String[] args) {
        // 测试 yield
//        new MyThread().start();
//        new MyThread().start();

        testSetPriority();
    }

    // 测试 setPriority
    public static void testSetPriority() {
        Thread t1 = new Thread() {
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    System.out.println(getName() + "...aaaaaaaaaaaaa");
                }
            }
        };

        Thread t2 = new Thread() {
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    System.out.println(getName() + "...bb");
                }
            }
        };

        t1.setPriority(Thread.MIN_PRIORITY);    // 优先级低，执行少一点
        t2.setPriority(Thread.MAX_PRIORITY);    // 优先级高，执行多一点

        t1.start();
        t2.start();
    }


    static class MyThread extends Thread {
        public void run() {
            for (int i = 1; i <= 1000; i++) {
                // 当 i 是 10 的倍数时，让出 CPU 给下一个线程
                if (i % 10 == 0) {
                    Thread.yield();
                }
                System.out.println(getName() + "...." + i);
            }
        }
    }



    /* 【多线程方法 (支持不好)】

	• 1.yield 让出cpu
    • 2.setPriority() 设置线程的优先级
    */
}
