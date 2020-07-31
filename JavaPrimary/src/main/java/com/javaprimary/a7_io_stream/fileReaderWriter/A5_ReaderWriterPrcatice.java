package com.javaprimary.a7_io_stream.fileReaderWriter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * 字符流相关练习
 */
public class A5_ReaderWriterPrcatice {

    public static void main(String[] args) throws IOException {
//        testCharNumFromFile();

        // 测试文件夹下所有文件的大小
//        System.out.println(TestFilesLength.getFileLen(TestFilesLength.getDir()));
    }

    // 测试 一个文本上每个字符出现的次数
    public static void testCharNumFromFile() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("A5_ReaderWriterPrcatice_01.txt"));
        TreeMap<Character, Integer> tm = new TreeMap<>();

        int ch;
        while ((ch = br.read()) != -1) {            // read() 方法读一次会将缓冲区读满,从缓冲区将字符返给 ch
            char c = (char) ch;                     // 读到的字符提升为 int 类型需要强转为 char
			/*if(!tm.containsKey(c)) {				// 如果集合中不包含这个键
				tm.put(c, 1);						// 将键和值为1存入
			}else {									// 如果集合中包含这个键
				tm.put(c, tm.get(c) + 1);			// 将键和值+1存进去
			}*/

            tm.put(c, !tm.containsKey(c) ? 1 : tm.get(c) + 1);
        }
        br.close();                                                    // 及时关闭输入流

        BufferedWriter bw = new BufferedWriter(
                new FileWriter("A5_ReaderWriterPrcatice_02.txt"));  // 创建输出流对象
        for (Character key : tm.keySet()) {                              // 遍历双列集合
            switch (key) {
                case '\t':                                               // 写出\t和出现的次数
                    bw.write("\\t" + "=" + tm.get(key));
                    break;
                case '\r':
                    bw.write("\\r" + "=" + tm.get(key));             // 写出\r和出现的次数
                    break;
                case '\n':
                    bw.write("\\n" + "=" + tm.get(key));             // 写出\n和出现的次数
                    break;
                default:
                    bw.write(key + "=" + tm.get(key));               // 写出其他字符和出现的次数
                    break;
            }
            bw.newLine();                                                // 写出换行
        }
        bw.close();                                                      // 关闭写出流
    }

    // 测试文件夹下所有文件的大小类
    static class TestFilesLength {
        // 键盘录入一个文件夹路径
        public static File getDir() {
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入一个文件夹路径:");
            while (true) {
                String line = sc.nextLine();                // 将键盘录入的路径存储在line中
                File dir = new File(line);                    // 封装成File对象
                if (!dir.exists()) {                            // 判断是否存在
                    System.out.println("重输");
                } else if (dir.isFile()) {                    // 判断是否是文件
                    System.out.println("重输");
                } else {
                    return dir;                                // 返回文件夹路径
                }
            }
        }

        // 统计文件夹的大小
        public static long getFileLen(File dir) {
            long len = 0;
            File[] subFiles = dir.listFiles();            // 获取 dir 路径下的所有的文件和文件夹

            for (File subFile : subFiles) {
                if (subFile.isFile()) {
                    len = len + subFile.length();
                } else {
                    len = len + getFileLen(subFile);    // 递归进入次级文件夹
                }
            }
            return len;
        }
    }


}
