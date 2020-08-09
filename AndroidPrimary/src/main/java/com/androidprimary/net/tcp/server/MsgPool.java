package com.androidprimary.net.tcp.server;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 消息统一管理类，通过观察者模式把消息推送到所有客户端
 */
public class MsgPool {

    private static MsgPool sInstance = new MsgPool();

    private LinkedBlockingQueue<String> mQueue = new LinkedBlockingQueue<>();

    public static MsgPool getInstance() {
        return sInstance;
    }

    private MsgPool() {

    }

    public void start() {
        new Thread() {
            @Override
            public void run() {
                while (true) {
                    try {
                        String msg = mQueue.take();
                        // 如果有消息则互调到客户端
                        notifyMsgComing(msg);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }

    private void notifyMsgComing(String msg) {
        for (MsgComingListener listener : mListeners) {
            listener.onMsgComing(msg);
        }
    }

    public interface MsgComingListener {
        void onMsgComing(String msg);
    }

    private List<MsgComingListener> mListeners = new ArrayList<>();

    public void addMsgComingListener(MsgComingListener listener) {
        mListeners.add(listener);
    }


    public void sendMsg(String msg) {
        try {
            mQueue.put(msg);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
