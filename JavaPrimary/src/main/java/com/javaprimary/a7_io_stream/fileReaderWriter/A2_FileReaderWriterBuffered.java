package com.javaprimary.a7_io_stream.fileReaderWriter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 带缓冲的字符流
 */
public class A2_FileReaderWriterBuffered {

    public static void main(String[] args) throws IOException {
//        testCharFileCopyBuffered();
        testLine();
    }

    public static void testCharFileCopyBuffered() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("A1_FileReaderWriterOutline_01.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("A1_FileReaderWriterBuffered_01.txt"));

        int ch;
        while ((ch = br.read()) != -1) {
            bw.write(ch);
        }
        br.close();
        bw.close();
    }

    // 测试 readLine() 和 newLine() 方法
    public static void testLine() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("A1_FileReaderWriterOutline_01.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("A1_FileReaderWriterBuffered_02.txt"));

        String line;
        while ((line = br.readLine()) != null) {
            bw.write(line);             // 读出一整行，返回 string
            //bw.write("\r\n");			// 只支持的是windows系统
            bw.newLine();               // 可以跨平台(操作系统)
        }

        br.close();
        bw.close();
    }




    /* 【带缓冲的字符流】

	• BufferedReader 的 read() 方法读取字符时会一次读取若干字符到缓冲区, 然后逐个返回给程序, 降低读取文件的次数,
	  提高效率
	• BufferedWriter 的 write() 方法写出字符时会先写到缓冲区, 缓冲区写满时才会写到文件, 降低写文件的次数, 提高效率
    */




    /* 【readLine() 和 newLine() 方法】

	• BufferedReader 的 readLine() 方法可以读取一行字符(不包含换行符号)
    • BufferedWriter 的 newLine() 可以输出一个跨平台的换行符号"\r\n"
    */
}
