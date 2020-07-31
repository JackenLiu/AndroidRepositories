package com.javaprimary.a7_io_stream.fileIoStream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * IO 字节流基本介绍
 */
public class A1_FileIoStreamOutline {

    public static void main(String[] args) throws IOException {
//        testRead();
//        testWrite();
    }


    // 测试字节输入流读取方法
    public static void testRead() throws IOException {
        /*
        测试一次读取一个字节
         */
        // 创建一个文件输入流对象,并关联aaa.txt
        FileInputStream fis = new FileInputStream("A1_IOStreamOutline_01.txt");
        // 每读取一次就向后移动一次
        int x = fis.read();
        System.out.println(x);
        int y = fis.read();
        System.out.println(y);
        int z = fis.read();
        System.out.println(z);
        int a = fis.read();
        System.out.println(a);
        int b = fis.read();
        System.out.println(b);
        fis.close();

        System.out.println("----------------");
        
        /*
        测试循环读取所有字节
         */
        // 创建一个文件输入流对象,并关联aaa.txt
        FileInputStream fis1 = new FileInputStream("A1_IOStreamOutline_01.txt");
        // 定义变量,记录每次读到的字节
        int b1;
        // 将每次读到的字节赋值给b 并判断是否是-1
        while ((b1 = fis1.read()) != -1) {
            // 打印每一个字节
            System.out.println(b1);
        }

        fis1.close();
    }


    // 测试字节输出流写入方法
    public static void testWrite() throws IOException {
        /*
        文件清空，不会追加写入
         */
        // 如果没有 A1_IOStreamOutline_02.txt, 会创建出一个
        FileOutputStream fos = new FileOutputStream("A1_IOStreamOutline_02.txt");
        // 虽然写出的是一个int数,但是在写出的时候会将前面的24个0去掉,所以写出的一个byte
        fos.write(98);
        fos.write(99);
        fos.write(100);
        fos.close();

        /*
        文件不清空，追加写入
         */
        // 如果没有 A1_IOStreamOutline_02.txt, 会创建出一个
        FileOutputStream fos1 = new FileOutputStream("A1_IOStreamOutline_03.txt", true);
        fos1.write(97);
        fos1.close();
    }


    /* 【FileInputStream】

    读取(读进内存)
        read()一次读取一个字节
        读到 -1 结束读取
    */



    /* 【FileInputStream 返回值为什么是 int】

    因为字节输入流可以操作任意类型的文件,比如图片音频等,这些文件底层都是以二进制形式的存储的,如果每次读取都返回 byte ,有
    可能在读到中间的时候遇到 111111111 ，那么这 11111111 是 byte 类型的 -1,我们的程序是遇到 -1 就会停止不读了, 后
    面的数据就读不到了,所以在读取的时候用 int 类型接收, 如果 11111111 会在其前面补上 24 个 0 凑足 4 个字节,那么
     byte 类型的 -1 就变成 int 类型的 255 了这样可以保证整个数据读完, 而结束标记的 -1 就是int类型
    */




    /* 【FileOutputStream】

    写入（内存写出）
	    write()一次写出一个字节
    */
}
