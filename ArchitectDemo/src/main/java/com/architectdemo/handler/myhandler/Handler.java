package com.architectdemo.handler.myhandler;

public class Handler {

    private MessageQueue mQueue;
    private Looper mLooper;

    public Handler() {
        mLooper = Looper.myLooper();
        if (mLooper == null) {
            throw new RuntimeException(
                    "Can't create handler inside thread " + Thread.currentThread()
                            + " that has not called Looper.prepare()");
        }
        mQueue = mLooper.mQueue;
    }

    public void sendMessage(Message message) {
        // 将消息放入消息队列中
        enququeMessage(message);
    }

    private void enququeMessage(Message message) {
        // 赋值当前 Handler
        message.target = this;

        // 使用 mQueue 将消息放入
        mQueue.enququeMessage(message);

    }

    public void dispatchMessage(Message msg) {
        handleMessage(msg);
    }

    // 给开发者提供的开发 API，用于重写和回调监听
    public void handleMessage(Message msg) {
    }

}
