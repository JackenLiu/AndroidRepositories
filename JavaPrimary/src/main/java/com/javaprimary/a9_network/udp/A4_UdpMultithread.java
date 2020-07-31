package com.javaprimary.a9_network.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

/**
 * UDP 传输协议,多线程
 */
public class A4_UdpMultithread {

    /**
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        new Receive().start();
        Thread.sleep(1000);   // 保证接收端先启动
        new Send().start();
    }


    // 接收端
    static class Receive extends Thread {
        public void run() {
            try {
                // 创建 Socket 相当于创建一个码头,指定端口去接
                DatagramSocket socket = new DatagramSocket(12345);
                // 创建 Packet 相当于创建一个集装箱
                DatagramPacket packet = new DatagramPacket(new byte[1024], 1024);

                while (true) {
                    socket.receive(packet);
                    byte[] arr = packet.getData();                       // 从集装箱中获取数据
                    int len = packet.getLength();                        // 获取发过来的有效字节个数
                    String ip = packet.getAddress().getHostAddress();    // 获取ip地址
                    int port = packet.getPort();                         // 获取端口号
                    System.out.println("receive:" + ip + ":" + port + ":" + new String(arr, 0, len));
                }
            } catch (IOException e) {

                e.printStackTrace();
            }
        }
    }

    // 发送端
    static class Send extends Thread {
        public void run() {
            try {
                // 创建 Socket 相当于创建码头
                DatagramSocket socket = new DatagramSocket();
                Scanner sc = new Scanner(System.in);
                while (true) {
                    System.out.println("输入发送内容");
                    String line = sc.nextLine();
                    if ("quit".equals(line))
                        break;
                    DatagramPacket packet =             // 创建Packet相当于创建集装箱
                            new DatagramPacket(
                                    line.getBytes(), line.getBytes().length,
                                    // 指定发送到哪个 IP 地址的接收端和端口
                                    InetAddress.getByName("127.0.0.1"), 12345);
                    socket.send(packet);                // 发送数据
                }
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}




