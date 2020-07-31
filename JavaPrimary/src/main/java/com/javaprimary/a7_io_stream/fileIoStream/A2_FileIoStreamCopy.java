package com.javaprimary.a7_io_stream.fileIoStream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * IO 字节流拷贝功能
 */
public class A2_FileIoStreamCopy {

    public static void main(String[] args) throws IOException {
//        testCopyByByte();
//        testCopyByAvailable();
//        testCustomArrayCopyPrinciple();
        testCustomArrayCopy();
    }

    // 测试获取读的文件所有的字节个数拷贝
    public static void testCopyByAvailable() throws IOException {
        FileInputStream fis = new FileInputStream("A2_FileIoStreamCopy_03.mp4");
        FileOutputStream fos = new FileOutputStream("A2_FileIoStreamCopy_04.mp4");
        byte[] arr = new byte[fis.available()];                    // 根据文件大小做一个字节数组
        fis.read(arr);                                            // 将文件上的所有字节读取到数组中
        fos.write(arr);                                            // 将数组中的所有字节一次写到了文件上
        fis.close();
        fos.close();
    }

    // 测试单个字节拷贝
    public static void testCopyByByte() throws IOException {
        /*
        创建输入流对象,关联需要拷贝的文件
        创建输出流对象,关联需要拷贝出去的文件
         */

        // 测试拷贝图片
//        FileInputStream fis = new FileInputStream("A2_FileIoStreamCopy_01.png");
//        FileOutputStream fos = new FileOutputStream("A2_FileIoStreamCopy_02.png");

        // 测试拷贝图片
        FileInputStream fis = new FileInputStream("A2_FileIoStreamCopy_03.mp4");
        FileOutputStream fos = new FileOutputStream("A2_FileIoStreamCopy_04.mp4");

        int b;
        while ((b = fis.read()) != -1) {
            fos.write(b);
        }

        fis.close();
        fos.close();
    }

    // 测试自定义小数组拷贝原理
    public static void testCustomArrayCopyPrinciple() throws IOException {
        FileInputStream fis = new FileInputStream("A2_FileIoStreamCopy_05.txt");
        byte[] arr = new byte[2];
        int x = fis.read(arr);    // 将文件上的字节数据读取到字节数组中，返回读取有效的字节个数
        for (byte b : arr) {
            System.out.println(b);
        }

        System.out.println(x);

        System.out.println("-----------------------");

        int y = fis.read(arr);
        for (byte b : arr) {
            System.out.println(b);
        }
        System.out.println(y);

        System.out.println("-----------------------");
        int z = fis.read(arr);                        // 如果文件上有数据读取的是字节数据,如果没有读取的-1
        for (byte b : arr) {
            System.out.println(b);
        }
        System.out.println(z);
        fis.close();
    }

    // 测试自定义小数组拷贝
    public static void testCustomArrayCopy() throws IOException {
        FileInputStream fis = new FileInputStream("A2_FileIoStreamCopy_03.mp4");
        FileOutputStream fos = new FileOutputStream("A2_FileIoStreamCopy_04.mp4");
        int len;
        byte[] arr = new byte[1024 * 8];

        // 如果 read 方法忘记写字节数组了,就会返回的字节的码表值,写出就会比原来的文件大的多，因为有很多的空字节
        while ((len = fis.read(arr)) != -1) {
            //fos.write(arr);
            fos.write(arr, 0, len); // 避免写入的有效字节数出错，使用此 write 方式
        }

        fis.close();
        fos.close();
    }



    /* 【拷贝音频文件原理】

		○ 字节流一次读写一个字节复制音频
	        • 弊端:效率太低
            • 优点:节省内存
    */




    /* 【字节数组拷贝之 available() 方法】

	• A:案例演示
		○ int read(byte[] b):一次读取一个字节数组
		○ write(byte[] b):一次写出一个字节数组
		○ available()获取读的文件所有的字节个数

	• 弊端:有可能会内存溢出
    • 优点:效率高
    */





    /* 【定义小数组拷贝】

	• write(byte[] b)
    • write(byte[] b, int off, int len)写出有效的字节个数（最常用）
    */
}
