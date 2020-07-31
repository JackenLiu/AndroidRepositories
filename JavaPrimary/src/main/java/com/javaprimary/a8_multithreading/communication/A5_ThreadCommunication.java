package com.javaprimary.a8_multithreading.communication;

/**
 * 线程间通信
 */
public class A5_ThreadCommunication {

    public static void main(String[] args) {

        /*
        测试线程通信
         */
        final Printer p = new Printer();

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


    /*

    在同步代码块中锁对象是谁,就用哪个对象来调用wait

   【为什么三个线程以上用notifyAll()?】
    如果用随机唤醒的 notify 可能出现的极端例子（此时 flag 的条件判断不是用 while ，使用 if）：

     * 程序一开始可能先执行线程方法的 print2 和 print3 ，此时代码在 wait 处停止，此时 flag = 1
     * 程序返回执行线程方法 print1 此时 flag = 2，执行完后可能随机唤醒的是在 wait 停止的 print3, print3 开始执行
     * 此时的情况就相当于在 flag = 2 的情况下执行了 print3 的方法，出现错误。
     *
     * 因为 if 判断条件起不了作用，此时将 if 换成 while :
     * flag = 1 且 print1 执行, 此时  flag = 2 , 接下来可能执行 print2, print1 停;
     * flag = 2 且 print2 执行, 此时  flag = 3 , 接下来可能执行 print3, print2 停;
     * flag = 3 且 print3 执行, 此时  flag = 1 , 接下来如果执行 print2, print3 停(出现问题的极端情况);
     * flag = 1 且 print2 执行, 此时  print2 停, 三个线程都被停掉, 无法被唤醒, 程序卡住

     */
    static class Printer {
        private int flag = 1;                                // 定义标记
        private Object obj = new Object();

        public void print1() throws InterruptedException {
            synchronized (this) {
                while (flag != 1) {                                // 如果标记不为1就等待
                    System.out.println(flag + ":print1");
                    this.wait();
                }
                System.out.print("黑");
                System.out.print("马");
                System.out.print("程");
                System.out.print("序");
                System.out.print("员");
                System.out.print("\r\n");
                flag = 2;
//                this.notify();                                // 随机唤醒另一条线程，比较适合用于两个线程
                this.notifyAll();                                // 唤醒所有等待的线程
            }
        }

        public void print2() throws InterruptedException {
            synchronized (this) {
                while (flag != 2) {                                // 如果标记不为2就等待
                    System.out.println(flag + ":print2");
                    this.wait();                            // 线程2等待
                }
                System.out.print("传");
                System.out.print("智");
                System.out.print("播");
                System.out.print("客");
                System.out.print("\r\n");
                flag = 3;
//                this.notify();                                // 随机唤醒另一条线程，比较适合用于两个线程
                this.notifyAll();                                // 唤醒所有等待的线程
            }
        }

        public void print3() throws InterruptedException {
            synchronized (this) {
                while (flag != 3) {                                // 如果标记不为2就等待
                    System.out.println(flag + ":print3");
                    this.wait();                            // 线程3等待
                }
                System.out.print("i");
                System.out.print("t");
                System.out.print("c");
                System.out.print("a");
                System.out.print("s");
                System.out.print("t");
                System.out.print("\r\n");
                flag = 1;
//                this.notify();                                // 随机唤醒另一条线程，比较适合用于两个线程
                this.notifyAll();                               // 唤醒所有等待的线程
            }
        }
    }




    /* 【两个线程间的通信】

	• 1.什么时候需要通信
		○ 多个线程并发执行时, 在默认情况下CPU是随机切换线程的
		○ 如果我们希望他们有规律的执行, 就可以使用通信, 例如每个线程执行一次打印

	• 2.怎么通信
		○ 如果希望线程等待, 就调用wait()
		○ 如果希望唤醒等待的线程, 就调用notify();
		○ 这两个方法必须在同步代码中执行, 并且使用同步锁对象来调用
		○ 在同步代码块中锁对象是谁,就用哪个对象来调用wait

	○ 3.为什么wait方法和notify方法需要定义在Object
        ○ 所有的对象都是Object的子类对象,而所有的对象都可以当作锁对象

	○ 4.sleep方法和wait方法的区别【面试题】
		○ sleep方法必须传入参数,参数就是时间,当时间到了,不用唤醒自动醒来
		○ wait方法不是必须传入参数,如果没有参数,遇到wait就等待,如果传入参数,等参数的时间到后等待
		○ sleep方法在同步中不释放锁
        ○ wait方法在同步中释放锁
    */





    /* 【三个或三个以上间的线程通信】

	• 多个线程通信的问题
		○ notify()方法是随机唤醒一个线程
		○ notifyAll()方法是唤醒所有线程
		○ JDK5之前无法唤醒指定的一个线程
        ○ 如果多个线程之间通信, 需要使用notifyAll()通知所有线程, 用while来反复判断条件
    */

}
