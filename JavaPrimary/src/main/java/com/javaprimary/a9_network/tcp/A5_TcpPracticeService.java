package com.javaprimary.a9_network.tcp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 测试服务器上传服务端
 */
public class A5_TcpPracticeService {

    public static void main(String[] args) throws IOException {
        // 3,建立多线程的服务器
        ServerSocket server = new ServerSocket(12345);
        System.out.println("服务器启动,绑定12345端口号");
        while (true) {
            final Socket socket = server.accept();
            new Thread() {
                public void run() {
                    // 4.读取文件名
                    try {
                        InputStream is = socket.getInputStream();
                        BufferedReader br = new BufferedReader(new InputStreamReader(is));
                        PrintStream ps = new PrintStream(socket.getOutputStream());
                        String fileName = br.readLine();

                        File dir = new File("Upload");
                        dir.mkdir();                                    // 创建文件夹

                        File file = new File(dir, fileName);
                        // 5.判断文件是否存在, 将结果发回客户端
                        if (file.exists()) {
                            ps.println("存在");
                            socket.close();
                            return;
                        } else {
                            ps.println("不存在");
                        }
                        // 8.定义FileOutputStream, 从网络读取数据, 存储到本地
                        FileOutputStream fos = new FileOutputStream(file);
                        byte[] arr = new byte[8192];
                        int len;
                        while ((len = is.read(arr)) != -1) {
                            fos.write(arr, 0, len);
                        }

                        fos.close();
                        socket.close();
                    } catch (IOException e) {

                        e.printStackTrace();
                    }
                }
            }.start();
        }

    }
}
