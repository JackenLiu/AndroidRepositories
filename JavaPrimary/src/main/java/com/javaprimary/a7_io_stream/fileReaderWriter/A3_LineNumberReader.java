package com.javaprimary.a7_io_stream.fileReaderWriter;

import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

/**
 * LineNumberReader 类的使用
 */
public class A3_LineNumberReader {

    public static void main(String[] args) throws IOException {
        LineNumberReader lnr = new LineNumberReader(new FileReader("A1_FileReaderWriterOutline_01.txt"));
        String line;
        lnr.setLineNumber(2);     // 设置的是初始行，这里代表从第3行开始
        while ((line = lnr.readLine()) != null) {
            System.out.println(lnr.getLineNumber() + ":" + line);
        }

        lnr.close();
    }


    /* 【LineNumberReader】

	• LineNumberReader 是 BufferedReader 的子类, 具有相同的功能, 并且可以统计行号
	• 调用 getLineNumber() 方法可以获取当前行号
	• 调用 setLineNumber() 方法可以设置当前行号
    */
}
