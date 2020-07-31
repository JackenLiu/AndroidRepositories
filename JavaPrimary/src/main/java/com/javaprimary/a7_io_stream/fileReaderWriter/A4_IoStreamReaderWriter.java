package com.javaprimary.a7_io_stream.fileReaderWriter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

/**
 * IO 字符流 指定码表读写(在 Android Studio 貌似不行)
 */
public class A4_IoStreamReaderWriter {

    public static void main(String[] args) throws IOException {

        demo1();
        demo2();
    }


    // 测试不使用转码
    public static void demo1() throws IOException {
        FileReader fr = new FileReader("A4_IoStreamReaderWriter_UTF-8.txt");    // 字节流+GBK
        FileWriter fw = new FileWriter("A4_IoStreamReaderWriter_GBK.txt");

        int ch;
        while ((ch = fr.read()) != -1) {
            fw.write(ch);
        }

        fr.close();
        fw.close();
    }

    // 使用指定码表
    public static void demo2() throws IOException {
        BufferedReader br =
                new BufferedReader(
                        new InputStreamReader(       // InputStreamReader是字节通向字符的桥梁
                                new FileInputStream("A4_IoStreamReaderWriter_UTF-8.txt"), StandardCharsets.UTF_8));
        BufferedWriter bw =
                new BufferedWriter(
                        new OutputStreamWriter(     // OutputStreamWriter是字符通向字节的桥梁
                                new FileOutputStream("A4_IoStreamReaderWriter_GBK.txt"), StandardCharsets.UTF_8));

        int ch;
        while ((ch = br.read()) != -1) {
            bw.write(ch);
        }

        br.close();
        bw.close();
    }




    /* 【使用指定的码表读写字符】

	• FileReader 是使用默认码表读取文件, 如果需要使用指定码表读取, 那么可以使用 InputStreamReader (字节流,编码表)
	• FileWriter 是使用默认码表写出文件, 如果需要使用指定码表写出, 那么可以使用 OutputStreamWriter (字节流,编码表)
    */
}
