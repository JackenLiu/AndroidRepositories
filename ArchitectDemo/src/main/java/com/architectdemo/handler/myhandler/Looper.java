package com.architectdemo.handler.myhandler;

public class Looper {
    public MessageQueue mQueue;
    static final ThreadLocal<Looper> sThreadLocal = new ThreadLocal<Looper>();

    public Looper() {
        this.mQueue = new MessageQueue();
    }

    public static void prepare() {
        // 主线程只有唯一一个 Looper 对象
        if (sThreadLocal.get() != null) {
            throw new RuntimeException("Only one Looper may be created per thread");
        }
        // 应用启动时，初始化赋值
        sThreadLocal.set(new Looper());
    }

    public static Looper myLooper() {
        return sThreadLocal.get();
    }

    // 轮询，提取消息
    public static void loop() {
        // 从全局 ThreadLocalMap 中获取唯一的 Looper 对象
        Looper me = myLooper();
        // 从 Looper 对象中获取全局唯一消息队列 MessageQueue 对象
        final MessageQueue queue = me.mQueue;
        Message resultMessage;
        while (true) {
            // 从消息队列中取消息
            Message msg = queue.next();
            if (msg != null) {
                if (msg.target != null) msg.target.dispatchMessage(msg);
            }
        }
    }
}
