package com.javaprimary.a7_io_stream.otherStream;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Enumeration;
import java.util.Properties;

/**
 * Properties 类的使用
 */
public class A8_Properties {

    public static void main(String[] args) throws IOException {
        demo1();
        demo2();
        demo3();
    }

    public static void demo1() {
        System.out.println("demo1 ----------");
        Properties prop = new Properties();
        prop.setProperty("username", "zhangsan");
        prop.setProperty("password", "123456");
        prop.setProperty("qq", "654321");
        prop.setProperty("tel", "18987654321");

        String value = prop.getProperty("username");
        System.out.println(value);
        System.out.println(prop);
    }

    public static void demo2() {
        System.out.println("demo2 ----------");
        Properties prop = new Properties();
        prop.setProperty("username", "zhangsan");
        prop.setProperty("password", "123456");
        prop.setProperty("qq", "654321");
        prop.setProperty("tel", "18987654321");

        Enumeration<String> en = (Enumeration<String>) prop.propertyNames();
        while (en.hasMoreElements()) {
            String key = en.nextElement();
            String value = prop.getProperty(key);
            System.out.println(key + "=" + value);
        }
    }

    public static void demo3() throws IOException {
        System.out.println("demo3 ----------");
        Properties prop = new Properties();
        prop.load(new FileInputStream("A8_Properties.properties"));    // 获取文件上的数据
        prop.setProperty("username", "lisi");
        prop.list(new PrintStream("config.properties"));            // 将数据写到文件上
        System.out.println(prop);
    }




    /* 【Properties 的概述和作为 Map 集合的使用】

	• A:Properties的概述
		○ Properties 类表示了一个持久的属性集。
		○ Properties 可保存在流中或从流中加载。
		○ 属性列表中每个键及其对应值都是一个字符串。
    */




    /* 【Properties 的特殊功能使用】

	• A:Properties的特殊功能
		○ public Object setProperty(String key,String value)
		○ public String getProperty(String key)
        ○ public Enumeration stringPropertyNames()
    */




    /* 【Properties 的 load() 和 store() 功能】

    • A:Properties的load()和list()功能
    */
}
