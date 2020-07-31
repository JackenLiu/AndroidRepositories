package com.javaprimary.a8_multithreading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Callable 方式
 */
public class A7_Callable {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService pool = Executors.newFixedThreadPool(2);        // 创建线程池,可以放两条线程
        MyCallable mc1 = new MyCallable(100);
        MyCallable mc2 = new MyCallable(200);

        Future<Integer> f1 = pool.submit(mc1);                                // 放在线程池并提交
        Future<Integer> f2 = pool.submit(mc2);

        Integer i1 = f1.get();                                        // 获取结果
        Integer i2 = f2.get();

        System.out.println(i1);
        System.out.println(i2);
        pool.shutdown();                                            // 关掉线程池,不接受新任务
    }

    public static class MyCallable implements Callable<Integer> {

        private int num;

        public MyCallable(int num) {
            this.num = num;
        }

        @Override
        public Integer call() throws Exception {
            int sum = 0;
            for (int i = 1; i <= num; i++) {
                sum = sum + i;
            }
            return sum;
        }

    }





    /* 【多线程程序实现的方式3】

	• 提交的是Callable
	• 多线程程序实现的方式3的好处和弊端
		○ 好处：
			§ 可以有返回值
			§ 可以抛出异常
		○ 弊端：
			§ 代码比较复杂，所以一般不用
    */
}
