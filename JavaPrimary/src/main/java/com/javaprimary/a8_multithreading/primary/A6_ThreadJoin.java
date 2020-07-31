package com.javaprimary.a8_multithreading.primary;

/**
 * 加入线程
 */
public class A6_ThreadJoin {

    public static void main(String[] args) {

        final Thread t1 = new Thread() {
            public void run() {
                for (int i = 0; i < 50; i++) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(getName() + "...aaaaaaaaaaaaaaaaa" + i);
                }
            }
        };

        Thread t2 = new Thread() {
            public void run() {
                for (int i = 0; i < 50; i++) {
                    if (i == 2) {
                        try {
//                            t1.join();                // 插入线程,当前线程暂停到 t1 执行完为止

                            // 插入线程,t1只执行30毫秒，当前线程暂停30毫秒，
                            Thread.sleep(10);
                            t1.join(30);
                        } catch (InterruptedException e) {

                            e.printStackTrace();
                        }
                    }
                    System.out.println(getName() + "...bb" + i);
                }
            }
        };

        t1.start();
        t2.start();
    }






    /* 【加入线程】

	• join(), 当前线程暂停, 等待指定的线程执行结束后, 当前线程再继续
	• join(int), 可以等待指定的毫秒之后继续
    */
}
