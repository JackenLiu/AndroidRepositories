package com.javaprimary.a7_io_stream.otherStream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.util.Enumeration;
import java.util.Vector;

/**
 * 序列流
 */
public class A1_SequenceInputStream {

    public static void main(String[] args) throws IOException {
//        testTwoInOne();
//        testManyInOne();
    }

    // 测试序列流整合两个流对象
    public static void testTwoInOne() throws IOException {
        FileInputStream fis1 = new FileInputStream("A1_SequenceInputStream_01.txt");
        FileInputStream fis2 = new FileInputStream("A1_SequenceInputStream_02.txt");
        // 将两个流对象整合成一个
        SequenceInputStream sis = new SequenceInputStream(fis1, fis2);
        FileOutputStream fos = new FileOutputStream("A1_SequenceInputStream_03.txt");

        int b;
        while ((b = sis.read()) != -1) {
            fos.write(b);
        }

        sis.close();
        fos.close();
    }

    // 测试序列流整合多个流对象
    public static void testManyInOne() throws IOException {
        FileInputStream fis1 = new FileInputStream("A1_SequenceInputStream_01.txt");
        FileInputStream fis2 = new FileInputStream("A1_SequenceInputStream_02.txt");
        FileInputStream fis3 = new FileInputStream("A1_SequenceInputStream_03.txt");
        Vector<FileInputStream> v = new Vector<>();
        v.add(fis1);
        v.add(fis2);
        v.add(fis3);

        Enumeration<FileInputStream> en = v.elements();
        SequenceInputStream sis = new SequenceInputStream(en);
        FileOutputStream fos = new FileOutputStream("A1_SequenceInputStream_04.txt");

        int b;
        while ((b = sis.read()) != -1) {
            fos.write(b);
        }

        sis.close();
        fos.close();
    }



    /* 【序列流】

	• 1.什么是序列流
		○ 序列流可以把多个字节输入流整合成一个, 从序列流中读取数据时, 将从被整合的第一个流开始读, 读完一个之后继续读第
		  二个, 以此类推
		○ 简单来说就是进行同时读多个文件
    */
}
