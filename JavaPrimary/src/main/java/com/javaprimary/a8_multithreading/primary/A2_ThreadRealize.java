package com.javaprimary.a8_multithreading.primary;

/**
 * 线程的实现
 */
public class A2_ThreadRealize {

    public static void main(String[] args) {
        testThread();
        testRunnable();

        for (int i = 0; i < 10000; i++) {
            System.out.println("bbb");
        }

        testAnonymous();
    }

    public static void testThread() {
        MyThread mt = new MyThread();                       // 4,创建该类对象
        //mt.run();											// 并没有开启线程
        mt.start();                                         // 5,开启新线程
    }

    public static void testRunnable() {
        MyRunnable mr = new MyRunnable();              // 4,创建Runnable接口的子类对象 mr = 0x0011
        Thread t = new Thread(mr);                     // 5,创建线程对象,将Runnable接口的子类对象以参数传递
        //Runnable target = new MyRunnable();
        t.start();
    }

    public static void testAnonymous() {
        new Thread() {                                                //1,继承Thread类
            public void run() {                                        //2,重写run方法
                for (int i = 0; i < 1000; i++) {                        //3,将要执行的代码写在run方法中
                    System.out.println("aaaaaaaaaaaaaaaaaaaaaa");
                }
            }
        }.start();                                                    //4,开启线程

        new Thread(new Runnable() {                                    //1,实现Runnable接口

            @Override
            public void run() {                                        //2,重写run方法
                for (int i = 0; i < 1000; i++) {                        //3,将要执行的代码写在run方法中
                    System.out.println("bb");
                }
            }

        }).start();                                                    //4,开启线程
    }

    static class MyThread extends Thread {                                // 1,自定义类继承Thread
        public void run() {                                        // 2,重写run方法
            for (int i = 0; i < 10000; i++) {                         // 3,将要执行的代码写在run方法中
                System.out.println("aaaaaaaaaa");
            }
        }
    }

    static class MyRunnable implements Runnable {                        // 1,自定义类实现Runnable

        @Override
        public void run() {                                        // 2,重写run方法
            for (int i = 0; i < 1000; i++) {                        // 3,将要执行的代码写在run方法中
                System.out.println("aaaaaaaaaaaaaaaaaaaaaa");
            }
        }
    }




    /* 【多线程程序实现的方式1】

    继承Thread
		○ 定义类继承 Thread
		○ 重写 run 方法
		○ 把新线程要做的事写在 run 方法中
		○ 创建线程对象
		○ 开启新线程, 内部会自动执行 run 方法
    */



    /* 【多线程程序实现的方式2】

    实现 Runnable
		○ 定义类实现 Runnable 接口
		○ 实现 run 方法
		○ 把新线程要做的事写在 run 方法中
		○ 创建自定义的 Runnable 的子类对象
		○ 创建 Thread 对象, 传入 Runnable
        ○ 调用 start() 开启新线程, 内部会自动调用 Runnable 的 run() 方法

    实现 Runnable的原理
    	○ 1,看 Thread 类的构造函数,传递了 Runnable 接口的引用
		○ 2,通过 init() 方法找到传递的 target 给成员变量的 target 赋值
        ○ 3,查看 run 方法,发现 run 方法中有判断,如果 target 不为 null 就会调用 Runnable 接口子类对象的 run 方法
    */



    /* 【两种方式的区别】

	• 查看源码的区别:
		○ a.继承 Thread : 由于子类重写了 Thread类的run(), 当调用start()时, 直接找子类的run()方法
		○ b.实现 Runnable : 构造函数中传入了Runnable的引用, 成员变量记住了它, start()调用run()方法时内部判断成员
		  变量 Runnable 的引用是否为空, 不为空编译时看的是 Runnable 的 run(),运行时执行的是子类的 run()方法

	• 继承 Thread
		○ 好处是:可以直接使用 Thread 类中的方法,代码简单
		○ 弊端是:如果已经有了父类,就不能用这种方法

	• 实现 Runnable 接口
		○ 好处是:即使自己定义的线程类有了父类也没关系,因为有了父类也可以实现接口,而且接口是可以多实现的
		○ 弊端是:不能直接使用 Thread 中的方法需要先获取到线程对象后,才能得到 Thread 的方法,代码复杂
    */
}
