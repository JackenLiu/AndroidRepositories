package com.androidprimary.net.tcp.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class TcpServer {

    public void start() {

        ServerSocket serverSocket;
        try {
            serverSocket = new ServerSocket(9090);
            // 一开始是阻塞的
            MsgPool.getInstance().start();

            while (true) {
                // 等待客户端到来，获取连接上客户端的 Socket，会先阻塞
                Socket socket = serverSocket.accept();
                System.out.println("ip = " + socket.getInetAddress().getHostAddress()
                        + " , port = " + socket.getPort() + " is online...");

                // 每来一次客户端连接成功，服务器都开启一个线程去处理可能阻塞的消息，多个线程就可以避免多个客户端同时访问产生阻塞
                ClientTask clientTask = new ClientTask(socket);
                MsgPool.getInstance().addMsgComingListener(clientTask);
                clientTask.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new TcpServer().start();
    }

}
