package com.javaprimary.a8_multithreading;

/**
 * 线程组
 */
public class A5_ThreadGroup {

    public static void main(String[] args) {

        // main 线程组
        MyRunnable mr = new MyRunnable();
        Thread t1 = new Thread(mr, "张三");
        Thread t2 = new Thread(mr, "李四");
        ThreadGroup tg1 = t1.getThreadGroup();
        ThreadGroup tg2 = t2.getThreadGroup();
        System.out.println(tg1.getName());  // main 线程组
        System.out.println(tg2.getName());  // main 线程组


        // 自定义线程组
        ThreadGroup tg = new ThreadGroup("我是一个线程组");
        Thread t3 = new Thread(tg, new MyRunnable(), "张三");        // 将指定线程加入指定的线程组
        Thread t4 = new Thread(tg, new MyRunnable(), "李四");        // 将指定线程加入指定的线程组

        //tg.setDaemon(true);   // 对整组的线程进行操作
        System.out.println(tg.getName());
    }


    public static class MyRunnable implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 1000; i++) {
                System.out.println(Thread.currentThread().getName() + "..." + i);
            }
        }
    }





    /* 【线程组的概述和使用】

	• A:线程组概述
		○ Java中使用ThreadGroup来表示线程组，它可以对一批线程进行分类管理，Java允许程序直接对线程组进行控制。
		○ 默认情况下，所有的线程都属于主线程组。
			§ public final ThreadGroup getThreadGroup() // 通过线程对象获取他所属于的组
			§ public final String getName() // 通过线程组对象获取他组的名字
		○ 我们也可以给线程设置分组
			§ 1,ThreadGroup(String name) 创建线程组对象并给其赋值名字
			§ 2,创建线程对象
			§ 3,Thread(ThreadGroup?group, Runnable?target, String?name)
			§ 4,设置整组的优先级或者守护线程
    */
}
