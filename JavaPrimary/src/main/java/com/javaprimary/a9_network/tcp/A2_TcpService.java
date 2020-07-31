package com.javaprimary.a9_network.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * TCP 协议 服务端
 */
public class A2_TcpService {

    public static void main(String[] args) throws IOException {
//        testSimple();
//        testOptimize();
        testMultithread();
    }

    // 测试多线程
    public static void testMultithread() throws IOException {
        ServerSocket server = new ServerSocket(9999);            // 创建服务器

        while (true) {
            final Socket socket = server.accept();                    // 接收客户端的请求
            new Thread() {
                public void run() {
                    try {
                        BufferedReader br = new BufferedReader(
                                new InputStreamReader(socket.getInputStream()));  // 对输入流包装
                        PrintStream ps = new PrintStream(
                                socket.getOutputStream());                        // 对输出流包装

                        ps.println("欢迎咨询传智播客");                             // 向客户端写出数据
                        System.out.println(br.readLine());                        // 读取并打印
                        ps.println("报满了");                                      // 向客户端再次写出数据
                        System.out.println(br.readLine());                        // 读取并打印

                        socket.close();
                    } catch (IOException e) {

                        e.printStackTrace();
                    }
                }
            }.start();
        }
    }

    // 测试优化
    public static void testOptimize() throws IOException {
        ServerSocket server = new ServerSocket(9999);            // 创建服务器
        Socket socket = server.accept();                            // 接收客户端的请求

        BufferedReader br = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));    // 对输入流包装
        PrintStream ps = new PrintStream(socket.getOutputStream()); // 对输出流包装

        ps.println("欢迎咨询传智播客");                                // 向客户端写出数据
        System.out.println(br.readLine());                            // 读取并打印
        ps.println("报满了");                                        // 向客户端再次写出数据
        System.out.println(br.readLine());                            // 读取并打印

        socket.close();
    }

    // 简单实现
    public static void testSimple() throws IOException {
        ServerSocket server = new ServerSocket(9999);      // 创建服务器
        Socket socket = server.accept();                        // 接收客户端的请求

        InputStream is = socket.getInputStream();               // 获取输入流
        OutputStream os = socket.getOutputStream();             // 获取输出流

        os.write("百度一下你就知道".getBytes());                  // 将字符串写到客户端

        byte[] arr = new byte[1024];                            // 创建字节数组
        int len = is.read(arr);                                 // 将数据读取到字节数组中
        System.out.println(new String(arr, 0, len));      // 将数组转换为字符串

        os.write("中国山东找蓝翔".getBytes());                    // 将字符串写到客户端

        server.close();
        socket.close();
    }
}
