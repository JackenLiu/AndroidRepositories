package com.javaprimary.a7_io_stream.fileReaderWriter;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * IO 字符流基本介绍
 */
public class A1_FileReaderWriterOutline {

    public static void main(String[] args) throws IOException {

//        testFileReader();
//        testFileWriter();
//        testCharFileCopy();
//        testCharFileCopyCustomArray();
    }

    public static void testFileReader() throws IOException {
        /*
        单次读取
         */
        FileReader fr = new FileReader("A1_FileReaderWriterOutline_01.txt");
        // 将 char 类型提升为 int 类型,因为文件结束标记都是-1,char 取值范围0到65535,不能存储-1
        int x = fr.read();
        System.out.println((char) x);
        int y = fr.read();
        System.out.println((char) y);
        int z = fr.read();
        System.out.println(z);
        int a = fr.read();
        System.out.println(a);
        fr.close();

        System.out.println("----------------");


        /*
        一次性读取
         */
        FileReader fr1 = new FileReader("A1_FileReaderWriterOutline_01.txt");
        int ch;
        while ((ch = fr1.read()) != -1) {            // read() 方法是通过编码表按照字符的大小读取
            System.out.print((char) ch);
        }

        fr1.close();

    }

    public static void testFileWriter() throws IOException {
        // 创建字符输出流对象,关联文本文件
        FileWriter fw = new FileWriter("A1_FileReaderWriterOutline_02.txt");
        fw.write(97);                                        // 写出一个字符
        fw.write("你要减肥,造吗?");                          // 写出一个字符串
        fw.close();                                            // 关流
    }

    // 测试文本文件拷贝
    public static void testCharFileCopy() throws IOException {
        FileReader fr = new FileReader("A1_FileReaderWriterOutline_01.txt");
        FileWriter fw = new FileWriter("A1_FileReaderWriterOutline_03.txt");

        int ch;
        while ((ch = fr.read()) != -1) {
            fw.write(ch);
        }

        fr.close();
        fw.close();
    }

    // 测试文本文件拷贝，自定义缓冲区
    public static void testCharFileCopyCustomArray() throws IOException {
        FileReader fr = new FileReader("A1_FileReaderWriterOutline_01.txt");
        FileWriter fw = new FileWriter("A1_FileReaderWriterOutline_03.txt");

        char[] arr = new char[8192];                    // 自定义缓冲区
        int len;

        while ((len = fr.read(arr)) != -1) {
            fw.write(arr, 0, len);
        }

        fr.close();
        fw.close();
    }



    /* 【字符流 FileReader】

	• 1.字符流是什么
		○ 字符流是可以直接读写字符的IO流
		○ 字符流读取字符, 就要先读取到字节数据, 然后转为字符。 如果要写出字符, 需要把字符转为字节再写出.
    */




    /* 【字符流 FileWriter】

    • FileWriter 类的 write() 方法可以自动把字符转为字节写出
    */




    /* 【什么情况下使用字符流】

	• 字符流也可以拷贝文本文件, 但不推荐使用。 因为读取时会把字节转为字符, 写出时还要把字符转回字节
    • 程序需要读取一段文本, 或者需要写出一段文本的时候可以使用字符流
    */



    /* 【字符流是否可以拷贝非纯文本的文件】

	• 不可以拷贝非纯文本的文件
	• 因为在读的时候会将字节转换为字符,在转换过程中,可能找不到对应的字符,就会用?代替,写出的时候会将字符转换成字节写出去
    • 如果是?,直接写出,这样写出之后的文件就乱了,看不了了
    */
}
