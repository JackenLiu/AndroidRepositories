package com.javaprimary.a7_io_stream.fileIoStream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * IO 字节流读中文
 */
public class A4_FileIoStreamReadChinese {

    public static void main(String[] args) throws IOException {
//        testReadChinese();
//        testWriteChinese();
        testCopyChinese();
    }

    public static void testReadChinese() throws IOException {
        FileInputStream fis = new FileInputStream("A4_FileIoStreamReadChinese_01.txt");
        // 创建字节数组，大小为单数
        byte[] arr = new byte[5];
        int len;
        while ((len = fis.read(arr)) != -1) {
            // 转换成字符串打印在控制台,转换的时候有可能乱码,因为一个中文是 2 个字节
            System.out.println(new String(arr, 0, len));
        }
        fis.close();
    }

    public static void testWriteChinese() throws IOException {
        FileOutputStream fos = new FileOutputStream("A4_FileIoStreamReadChinese_01.txt");
        fos.write("你好".getBytes());                         // 字节流写出中文的时候要转换成字节数组
        fos.write("\r\n".getBytes());                         // 写出回车换行
        fos.write("你好".getBytes());
        fos.close();
    }

    // 字节流可以拷贝任意数据，直接搬字节，没有做任何的转换
    public static void testCopyChinese() throws IOException {
        FileInputStream fis = new FileInputStream("A4_FileIoStreamReadChinese_01.txt");
        FileOutputStream fos = new FileOutputStream("A4_FileIoStreamReadChinese_02.txt");

        int b;
        while ((b = fis.read()) != -1) {
            fos.write(b);
        }

        fis.close();
        fos.close();
    }




    /* 【字节流读写中文】

	• 字节流读取中文的问题
		○ 字节流在读中文的时候有可能会读到半个中文,造成乱码

	• 字节流写出中文的问题
		○ 字节流直接操作的字节,所以写出中文必须将字符串转换成字节数组
        ○ 写出回车换行 write("\r\n".getBytes());
    */
}
