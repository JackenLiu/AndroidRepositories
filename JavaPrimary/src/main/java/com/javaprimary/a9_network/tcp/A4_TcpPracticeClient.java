package com.javaprimary.a9_network.tcp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * 测试服务器上传客户端
 */
public class A4_TcpPracticeClient {

    /**
     * @param args 客户端向服务器上传文件
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        // 1.提示输入要上传的文件路径, 验证路径是否存在以及是否是文件夹
        File file = getFile();
        // 2.发送文件名到服务端
        Socket socket = new Socket("127.0.0.1", 12345);
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintStream ps = new PrintStream(socket.getOutputStream());
        ps.println(file.getName());
        // 6.接收结果, 如果存在给予提示, 程序直接退出
        String result = br.readLine();                        // 这个结果要么是存在要么是不存在
        if ("存在".equals(result)) {
            System.out.println("您上传的文件已经存在,请不要重复上传");
            socket.close();
            return;
        }
        // 7.如果不存在, 定义 FileInputStream 读取文件, 写出到网络
        FileInputStream fis = new FileInputStream(file);
        byte[] arr = new byte[8192];
        int len;
        while ((len = fis.read(arr)) != -1) {
            ps.write(arr, 0, len);
        }

        fis.close();
        socket.close();
    }

    /*
     * 获取文件路径
     * 1,File
     * 2,无
     */
    public static File getFile() {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个文件路径:");

        while (true) {
            String line = sc.nextLine();
            File file = new File(line);

            if (!file.exists()) {
                System.out.println("重输:");
            } else if (file.isDirectory()) {
                System.out.println("重输:");
            } else {
                return file;
            }
        }
    }

}
