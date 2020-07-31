package com.javaprimary.a9_network.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * UDP 接收端
 */
public class A2_UdpReceive {

    /**
     * 2.接收Receive
     * 创建DatagramSocket, 指定端口号
     * 创建DatagramPacket, 指定数组, 长度
     * 使用DatagramSocket接收DatagramPacket
     * 关闭DatagramSocket
     * 从DatagramPacket中获取数据
     * 3.接收方获取ip和端口号
     * String ip = packet.getAddress().getHostAddress();
     * int port = packet.getPort();
     *
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(12345);                    // 创建Socket相当于创建一个码头
        DatagramPacket packet = new DatagramPacket(new byte[1024], 1024);    // 创建Packet相当于创建一个集装箱
        System.out.println("等待接收数据中...");

        socket.receive(packet);

        byte[] arr = packet.getData();                                       // 从集装箱中获取数据
        int len = packet.getLength();                                        // 获取发过来的有效字节个数
        System.out.println("已接到数据:" + new String(arr, 0, len));
        socket.close();
    }
}
