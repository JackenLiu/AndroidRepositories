package com.architectdemo.handler.myhandler;

public class Message {
    // 标识
    private int what;
    public Handler target;
    // 消息内容
    public Object obj;

    public Message() {
    }

    public Message(Object obj) {
        this.obj = obj;
    }

    @Override
    public String toString() {
        return "Message{" +
                "obj=" + obj +
                '}';
    }
}
