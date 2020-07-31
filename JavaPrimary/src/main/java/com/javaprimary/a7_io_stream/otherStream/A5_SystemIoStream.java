package com.javaprimary.a7_io_stream.otherStream;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

/**
 * 标准输入输出流
 */
public class A5_SystemIoStream {

    public static void main(String[] args) throws IOException {
        demo1();
    }

    // 修改标准输入输出流，开发不用
    public static void demo1() throws IOException {
        System.setIn(new FileInputStream("A5_SystemIoStream_01.txt")); // 改变标准输入流
        System.setOut(new PrintStream("A5_SystemIoStream_02.txt"));  // 改变标准输出流

        InputStream is = System.in;                 // 标准键盘输入流已经被改变
        PrintStream ps = System.out;                // 标准键盘输出流已经被改变
        int b;
        while ((b = is.read()) != -1) {
            ps.write(b);
        }

        is.close();
        ps.close();
    }





    /* 【标准输入输出流概述和输出语句】

	• 1.什么是标准输入输出流
		○ System.in是InputStream, 标准输入流, 默认可以从键盘输入读取字节数据
		○ System.out是PrintStream, 标准输出流, 默认可以向Console中输出字符和字节数据

	• 2.修改标准输入输出流
		○ 修改输入流: System.setIn(InputStream)
		○ 修改输出流: System.setOut(PrintStream)
    */

}
