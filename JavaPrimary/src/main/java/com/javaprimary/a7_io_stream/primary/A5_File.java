package com.javaprimary.a7_io_stream.primary;

import java.io.File;


public class A5_File {
    /**
     * 绝对路径
     */
    static final String definitelyPath = "D:\\ioTest";

    public static void main(String[] args) {
        demo1();
        demo2();
        demo3();
    }

    public static void demo1() {
        File file1 = new File(definitelyPath);        // 绝对路径
        /*
        相对路径,相对于 eclipse 前项目下:
            D:\Program\Android\Code\Github\ANDROID-COMPLETE\Java Primary
         */
        File file2 = new File("A5_File_01.txt");
        boolean b1 = file1.exists();                                // 判断是否存在
        System.out.println(b1);
        boolean b2 = file2.exists();
        System.out.println(b2);
    }

    public static void demo2() {
        String parent = definitelyPath;                            // 父级路径
        String child = "a01.txt";                                // 子级路径
        File file = new File(parent, child);
        System.out.println(file.exists());
    }

    public static void demo3() {
        File parent = new File(definitelyPath);             // 父级路径的文件对象
        String child = "a01.txt";                                // 子级路径
        File file = new File(parent, child);
        System.out.println(file.exists());
    }




    /* 【File类的概述和构造方法】

	• A:File类的概述
		○ File更应该叫做一个路径
			§ 文件路径或者文件夹路径
			§ 路径分为绝对路径和相对路径
				□ 绝对路径是一个固定的路径,从盘符开始
				□ 相对路径相对于某个位置,在eclipse下是指当前项目下,在dos下指的是当前路径
		○ 查看API
		○ 文件和目录路径名的抽象表示形式

	• B:构造方法
		○ File(String pathname)：根据一个路径得到File对象
		○ File(String parent, String child):根据一个目录和一个子文件/目录得到File对象
		○ File(File parent, String child):根据一个父File对象和一个子文件/目录得到File对象
    */
}
