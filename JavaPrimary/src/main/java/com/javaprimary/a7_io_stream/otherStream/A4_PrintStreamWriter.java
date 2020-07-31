package com.javaprimary.a7_io_stream.otherStream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.Serializable;

/**
 * 打印流
 */
public class A4_PrintStreamWriter {

    public static void main(String[] args) throws FileNotFoundException {
//        testPrintStream();

//        testPrintWriter();
    }

    public static void testPrintStream() throws FileNotFoundException {
        Person p = new Person("张三", 23);
        PrintStream ps = System.out;
        ps.println(p);
        ps.println(97);                    // 底层通过 Integer.toString(97) 将 97 转换成字符串
        ps.write(97);                   // 不会将其转换成对应的字符串
        ps.close();


        PrintStream ps1 = new PrintStream("A4_PrintStreamWriter_01.txt");
        ps1.println(97);
        ps1.write(97);
        ps1.close();
    }

    public static void testPrintWriter() throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(new FileOutputStream("A4_PrintStreamWriter_02.txt"), true);
        pw.write(97);
        pw.print(97);
        pw.println(97);
        pw.close();
    }


    public static class Person implements Serializable {// 可以被序列化的
        private String name;
        private int age;

        public Person() {
            super();

        }

        public Person(String name, int age) {
            super();
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person [name=" + name + ", age=" + age + "]";
        }


    }




    /* 【打印流的概述和特点】


	• 1.PrintStream
		○ 该流可以很方便的将对象的toString()结果输出, 并且自动加上换行, 而且可以使用自动刷出的模式
        ○ System.out 就是一个PrintStream, 其默认向控制台输出信息

	• 2.PrintWriter
		○ 打印: print(), println()
		○ 当前者的自动清空缓冲区的功能被使能时(构造函数中autoFlush置为true)，仅当println()方法被调用时才自动清缓冲
		  区，而不是像 PrintStream 一样遇到一个换行符就清缓冲。
		○ 自动刷出: PrintWriter(OutputStream out, boolean autoFlush, String encoding)
        ○ 打印流只操作数据目的
    */
}
