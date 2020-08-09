package com.androidprimary.net.tcp.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

/**
 * 获取客户端信息、向客户端发送信息线程类
 */
public class ClientTask extends Thread implements MsgPool.MsgComingListener {

    private Socket mSocket;
    private InputStream mIs;
    private OutputStream mOs;

    public ClientTask(Socket socket) {
        try {
            mSocket = socket;
            mIs = socket.getInputStream();
            mOs = socket.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void run() {
        // 等待客户端写信息
        BufferedReader br = new BufferedReader(new InputStreamReader(mIs));
        String line;
        try {
            while ((line = br.readLine()) != null) {
                System.out.println(getName() + ", read from " + mSocket.getPort() + ": " + line);
                // 转发消息至其他 Socket
                MsgPool.getInstance().sendMsg(mSocket.getPort() + " : " + line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onMsgComing(String msg) {
        // 消息写到客户端
        try {
            mOs.write(msg.getBytes());
            mOs.write("\n".getBytes());
            mOs.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
