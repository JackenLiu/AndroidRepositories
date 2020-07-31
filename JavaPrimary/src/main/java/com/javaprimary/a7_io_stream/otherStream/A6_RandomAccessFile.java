package com.javaprimary.a7_io_stream.otherStream;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 随机访问流
 */
public class A6_RandomAccessFile {

    public static void main(String[] args) throws IOException {
        RandomAccessFile raf = new RandomAccessFile("A6_RandomAccessFile_01.txt", "rw");
        int x = raf.read();   // 读取
        System.out.println(x);
        raf.seek(2);       // 设置指针的位置为10
        raf.write(97); // 写入 a
        int i = raf.read();   // 读取
        System.out.println(i);
        raf.close();
    }



    /* 【随机访问流概述和写出数据】

	• A:随机访问流概述
		○ RandomAccessFile 概述
		○ RandomAccessFile类不属于流，是Object类的子类。但它融合了 InputStream 和 OutputStream 的功能。
		○ 支持对随机访问文件的读取和写入。

	• B:read(),write(),seek()
    */
}
