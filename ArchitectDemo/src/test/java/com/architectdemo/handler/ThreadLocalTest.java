package com.architectdemo.handler;

import org.junit.Test;

public class ThreadLocalTest {

    @Test
    public void test() {
        final ThreadLocal<String> threadLocal = new ThreadLocal<String>() {
            @Override
            protected String initialValue() {
                // 重写初始化方法，默认返回 null，如果 ThreadLocalMap 拿不到值再调用初始化方法
//                threadLocal.get();
                return "哈哈哈";
//                return super.initialValue();
            }
        };
        // 从 ThreadLocalMap 中获取 String 值， key 是主线程
        System.out.println(threadLocal.get());

        // --------------------- thread-0
        new Thread() {
            @Override
            public void run() {
                // 从 ThreadLocalMap 中获取 String 值， key 是此子线程，拿不到所以获取默认值
                System.out.println("thread-0：" + threadLocal.get());

                // 往 ThreadLocalMap 存值
                threadLocal.set("哈尼玛");
                System.out.println("thread-0：" + threadLocal.get());

                // 使用完成建议 remove，避免大量无意义的
                threadLocal.remove();
            }
        }.start();
    }
}
