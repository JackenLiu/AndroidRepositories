package com.javaprimary.a8_multithreading.primary;

/**
 * 休眠线程
 */
public class A4_ThreadSleep {

    public static void main(String[] args) throws InterruptedException {
        demo1();
//        demo2();
    }

    public static void demo2() {
        new Thread() {
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        Thread.sleep(10);               // 遇到 sleep 就会根据毫秒值休眠
                    } catch (InterruptedException e) {

                        e.printStackTrace();
                    }
                    System.out.println(getName() + "...aaaaaaaaaaaaaaaaaa");
                }
            }
        }.start();

        new Thread() {
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {

                        e.printStackTrace();
                    }
                    System.out.println(getName() + "...bbbbb");
                }
            }
        }.start();
    }

    public static void demo1() throws InterruptedException {
        for (int i = 20; i >= 0; i--) {
            Thread.sleep(1000);                        // 线程的休眠
            System.out.println("这是第" + i + "秒");
        }
    }




    /* 【休眠线程】

	• Thread.sleep(毫秒,纳秒), 控制当前线程休眠若干毫秒1秒= 1000毫秒 1秒 = 1000 * 1000 * 1000纳秒 1000000000
    */
}
