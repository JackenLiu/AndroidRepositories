package com.javaprimary.a7_io_stream.otherStream;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * 内存输出流
 */
public class A2_ByteArrayOutputStream {

    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("A1_FileReaderWriterOutline_01.txt");
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        int b;
        while ((b = fis.read()) != -1) {
            baos.write(b);                        // 将字节写到内存中
        }

        //byte[] arr = baos.toByteArray();
        //System.out.println(new String(arr));
        //String str = baos.toString();			// 将内存中的字节转换为字符串
        System.out.println(baos.toString());
        fis.close();
    }





    /* 【内存输出流】

	• 1.什么是内存输出流
		○ 该输出流可以向内存中写数据, 把内存当作一个缓冲区, 写出之后可以一次性获取出所有数据
		○ 作用是通过内存输出流直接在内存一次性读出文件的名称，所以不用传入 file 文件名

	• 2.使用方式
		○ 创建对象: new ByteArrayOutputStream()
		○ 写出数据: write(int), write(byte[])
		○ 获取数据: toByteArray()
    */
}
