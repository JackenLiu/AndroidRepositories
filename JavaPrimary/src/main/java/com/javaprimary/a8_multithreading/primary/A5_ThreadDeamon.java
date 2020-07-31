package com.javaprimary.a8_multithreading.primary;

/**
 * 守护线程
 */
public class A5_ThreadDeamon {

    public static void main(String[] args) {
        Thread t1 = new Thread() {
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println(getName() + "...aaaaaaaaaaaaaaaaa");
                }
            }
        };

        Thread t2 = new Thread() {
            public void run() {
                for (int i = 0; i < 2; i++) {
                    System.out.println(getName() + "...bb");
                }
            }
        };

        t1.setDaemon(true);                        // 设置t1为守护线程,该线程结束，其他线程一起结束

        t1.start();
        t2.start(); // t1 线程执行完后， t2 也结束，不会执行到100次，但是有时间缓冲，还会执行一点点
    }




    /* 【守护线程】

    setDaemon(), 设置一个线程为守护线程, 该线程不会单独执行, 当其他非守护线程都执行结束后, 自动退出
    */
}
