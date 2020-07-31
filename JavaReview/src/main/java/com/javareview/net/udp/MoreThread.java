package com.javareview.net.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class MoreThread {
    public static void main(String[] args) {

        new Receive().start();
        new Send().start();

    }
}

class Send extends Thread {
    @Override
    public void run() {
        try {
            String s = "哇哈哈哈 avc";
            DatagramSocket socket = new DatagramSocket();
            DatagramPacket packet = new DatagramPacket(
                    s.getBytes(), s.getBytes().length, InetAddress.getByName("127.0.0.1"), 666
            );
            socket.send(packet);
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Receive extends Thread {
    @Override
    public void run() {
        try {
            DatagramSocket socket = new DatagramSocket(666);
            DatagramPacket packet = new DatagramPacket(
                    new byte[1024], 1024
            );
            socket.receive(packet);
            byte[] arr = packet.getData();
            int len = packet.getLength();
            System.out.println(new String(arr, 0, len));
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}