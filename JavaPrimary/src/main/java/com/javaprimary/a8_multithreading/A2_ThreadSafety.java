package com.javaprimary.a8_multithreading;

/**
 * 线程安全
 */
public class A2_ThreadSafety {

    /**
     * 死锁
     */
    private static String s1 = "筷子左";
    private static String s2 = "筷子右";

    public static void main(String[] args) {
        /*
        四个窗口卖100张票，继承 Thread 实现
         */
        /*new TicketSeller("窗口1").start();
        new TicketSeller("窗口2").start();
        new TicketSeller("窗口3").start();
        new TicketSeller("窗口4").start();*/

        /*
        四个窗口卖100张票，继承 Runnable 实现
         */
        /*Ticket t = new Ticket();
        new Thread(t, "窗口1").start();
        new Thread(t, "窗口2").start();
        new Thread(t, "窗口3").start();
        new Thread(t, "窗口4").start();*/


        testDeadLock();
    }

    static class TicketSeller extends Thread {
        private static int tickets = 100;                                // 定义了100 张票

        public TicketSeller(String name) {
            super(name);
        }

        public synchronized void run() {
            while (true) {
                synchronized (TicketSeller.class) {        // 用字节码对象可以保证四条线程是同一个锁对象
                    if (tickets <= 0)
                        break;
                    /* 【如果没有加锁】
                    假设当 tickets = 1 的时候
                        线程1睡,线程2睡,线程3睡,线程4睡
                        线程1醒来，tickets = 0，
                        线程2醒来，tickets = -1
                        ...
                     */
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {

                        e.printStackTrace();
                    }
                    System.out.println(getName() + "....这是第" + tickets-- + "号票");
                }
            }
        }
    }

    static class Ticket implements Runnable {
        private int tickets = 100;

        @Override
        public void run() {
            while (true) {
                synchronized (this) {

                    if (tickets <= 0)
                        break;
                    try {
                        Thread.sleep(10);            //线程1睡,线程2睡,线程3睡,线程4睡
                    } catch (InterruptedException e) {

                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() +
                            "....这是第" + tickets-- + "号票");
                }
            }
        }

    }

    // 测试死锁
    public static void testDeadLock() {

        /*  【原理】

        1. 第一个线程有可能同时拿到 s1 和 s2 ，然后执行完代码
        2. 但当第一个线程拿到 s1 的同时，第二个线程拿到了 s2 的话，两个线程就会同时等待对方的锁
        3. 这时程序出现死锁，不会执行也不会停止
         */
        new Thread() {
            public void run() {
                while (true) {
                    synchronized (s1) {
                        System.out.println(getName() + "获取" + s1 + "等待" + s2);
                        synchronized (s2) {
                            System.out.println(getName() + "获取" + s2 + "开吃");
                        }
                    }
                }
            }
        }.start();

        new Thread() {
            public void run() {
                while (true) {
                    synchronized (s2) {
                        System.out.println(getName() + "获取" + s2 + "等待" + s1);
                        synchronized (s1) {
                            System.out.println(getName() + "获取" + s1 + "开吃");
                        }
                    }
                }
            }
        }.start();
    }


    /* 【线程安全问题】

	• 多线程并发操作同一数据时, 就有可能出现线程安全问题
    • 使用同步技术可以解决这种问题, 把操作数据的代码进行同步, 不要多个线程一起操作
    */




    /* 【死锁】

	• 多线程同步的时候, 如果同步代码嵌套, 使用相同锁, 就有可能出现死锁
    • 尽量不要嵌套使用
    */




    /* 【集合变成线程安全】

    使用 Collections.synchroinzed(xxx) 方法，都可以变
    */
}
