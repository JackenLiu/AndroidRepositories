package com.architectdemo.handler;

import com.architectdemo.handler.myhandler.Handler;
import com.architectdemo.handler.myhandler.Looper;
import com.architectdemo.handler.myhandler.Message;

import org.junit.Test;

public class ActivityThread {

    @Test
    public void main() {

        // 创建全局唯一的，主线程 Looper 对象，以及 MessageQueue 消息队列对象
        Looper.prepare();

        // 模拟 Activity 中，创建 Handler 对象
        final Handler handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                System.out.println(msg.toString());
            }
        };

        // 消费消息，回调方法（接口方法）

        // 子线程发送消息
        new Thread(){
            @Override
            public void run() {
                Message message = new Message();
                message.obj = "apple";
                handler.sendMessage(message);
            }
        }.start();

        // 轮询，取出消息
        Looper.loop();
    }
}
