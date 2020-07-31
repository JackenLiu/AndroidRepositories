package com.javaprimary.a7_io_stream.otherStream;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 数据输入输出流
 */
public class A7_DataIoStream {

    public static void main(String[] args) throws IOException {

        demo1();
        testDataIoStream();
    }

    // 测试字节流输入输出 int 的问题
    public static void demo1() throws IOException {
        /*
        字节流写 int 数
         */
        FileOutputStream fos = new FileOutputStream("A7_DataIoStream_01.txt");
        fos.write(997);   //  00000000 00000000 00000011 11100101 = 997
        fos.write(998);
        fos.write(999);
        fos.close();

        /*
        字节流读 int 数
         */
        FileInputStream fis = new FileInputStream("A7_DataIoStream_01.txt");
        int x = fis.read();  // 先变成byte，后前目三个字节补0： 00000000 00000000 00000000 11100101 = 229
        int y = fis.read();
        int z = fis.read();

        System.out.println(x);
        System.out.println(y);
        System.out.println(z);
        fis.close();
    }

    public static void testDataIoStream() throws IOException {
        DataOutputStream dos = new DataOutputStream(new FileOutputStream("A7_DataIoStream_01.txt"));
        dos.writeInt(997);    // 会转成 byte 数组存起来
        dos.writeInt(998);
        dos.writeInt(999);
        dos.close();

        DataInputStream dis = new DataInputStream(new FileInputStream("A7_DataIoStream_01.txt"));
        int x = dis.readInt();
        int y = dis.readInt();
        int z = dis.readInt();
        System.out.println(x);
        System.out.println(y);
        System.out.println(z);
        dis.close();
    }




    /* 【数据输入输出流】

	• 1.什么是数据输入输出流
		○ DataInputStream, DataOutputStream 可以按照基本数据类型大小读写数据
		○ 例如按Long大小写出一个数字, 写出时该数据占8字节. 读取的时候也可以按照 Long 类型读取, 一次读取8个字节.
    */
}
