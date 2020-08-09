package com.androidprimary.net.udp.java;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class UdpClient {

    private String mServerIp = "192.168.137.1";
    private InetAddress mServerAddress;
    private int mServerPort = 7777;
    private DatagramSocket mSocket;
    private Scanner mScanner;

    public UdpClient() {
        try {
            mServerAddress = InetAddress.getByName(mServerIp);
            mSocket = new DatagramSocket();
            mScanner = new Scanner(System.in);
            mScanner.useDelimiter("\n");
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    public void start() {
        while (true) {
            try {
                // 发送
                String clientMsg = mScanner.next();
                byte[] clientMsgBytes = clientMsg.getBytes();
                DatagramPacket clientPacket = new DatagramPacket(clientMsgBytes, clientMsgBytes.length
                        , mServerAddress, mServerPort);
                mSocket.send(clientPacket);

                // 接收
                byte[] buf = new byte[1024];
                DatagramPacket serverMsgPacket = new DatagramPacket(buf, buf.length);
                mSocket.receive(serverMsgPacket);

                // 打印
                InetAddress address = serverMsgPacket.getAddress();
                int port = serverMsgPacket.getPort();
                String serverMsg = new String(serverMsgPacket.getData(),
                        0, serverMsgPacket.getLength());
                System.out.println("【Client】-- address = " + address +
                        ", port = " + port + ", msg = " + serverMsg);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {
        new UdpClient().start();
    }
}
