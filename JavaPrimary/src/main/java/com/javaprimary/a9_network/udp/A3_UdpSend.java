package com.javaprimary.a9_network.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * UDP 发送端
 */
public class A3_UdpSend {

    /**
     * 1.发送Send
     * 创建DatagramSocket, 随机端口号
     * 创建DatagramPacket, 指定数据, 长度, 地址, 端口
     * 使用DatagramSocket发送DatagramPacket
     * 关闭DatagramSocket
     *
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        String str = "红鲤鱼与绿鲤鱼与驴";                                    // 要发送的数据
        DatagramSocket socket = new DatagramSocket();                    // 创建Socket相当于创建码头
        DatagramPacket packet =                                        // 创建Packet相当于创建集装箱
                new DatagramPacket(
                        str.getBytes(), str.getBytes().length,
                        InetAddress.getByName("192.168.137.1"), 12345); // 指定 IP 的接收端
        System.out.println("数据已发送");
        socket.send(packet);                                            // 发送数据
        socket.close();
    }
}
