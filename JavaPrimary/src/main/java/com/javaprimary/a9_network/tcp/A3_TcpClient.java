package com.javaprimary.a9_network.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;

/**
 * TCP 协议 客户端
 */
public class A3_TcpClient {

    public static void main(String[] args) throws IOException {
//        testSimple();
        testOptimize();
    }

    // 测试优化
    public static void testOptimize() throws IOException {
        Socket socket = new Socket("127.0.0.1", 9999);            // 创建Socket
        BufferedReader br = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));    // 对输入流封装
        PrintStream ps = new PrintStream(socket.getOutputStream()); // 对输出流封装

        System.out.println(br.readLine());                          // 读取服务器的内容并打印
        ps.println("我想报名就业班");                                 // 向服务器写出数据
        System.out.println(br.readLine());
        ps.println("爷不学了");

        socket.close();
    }

    // 简单实现
    public static void testSimple() throws IOException {
        Socket socket = new Socket("127.0.0.1", 9999);  // 创建Socket,指定 IP 的 Service

        InputStream is = socket.getInputStream();                  // 获取输入流
        OutputStream os = socket.getOutputStream();                // 获取输出流

        byte[] arr = new byte[1024];                               // 创建字节数组
        int len = is.read(arr);                                    // 将服务端获取的数据读取到字节数组中
        System.out.println(new String(arr, 0, len));         // 转换成字符串

        os.write("学习挖掘机哪家强?".getBytes());                    // 将字符串转换成字节数组写到服务器去

        byte[] arr2 = new byte[1024];
        int len2 = is.read(arr2);
        System.out.println(new String(arr2, 0, len2));

        socket.close();
    }
}
