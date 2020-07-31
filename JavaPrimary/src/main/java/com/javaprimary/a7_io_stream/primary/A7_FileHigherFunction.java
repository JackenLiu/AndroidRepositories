package com.javaprimary.a7_io_stream.primary;

import java.io.File;
import java.io.FilenameFilter;

/**
 * File 类高级功能
 */
public class A7_FileHigherFunction {

    public static void main(String[] args) {
        File dir = new File("D:\\");                // 将路径封装成File对象
        /*String[] arr = dir.list();					// 获取这个路径下所有的文件或文件夹路径

		for (String s : arr) {
			if(s.endsWith(".jpg")) {
				System.out.println(s);
			}
		}*/
		/*File[] subFiles = dir.listFiles();

		for (File subFile : subFiles) {
			if(subFile.isFile() && subFile.getName().endsWith(".jpg")) {
				System.out.println(subFile.getName());
			}
		}*/

        String[] arr = dir.list(new FilenameFilter() {

            @Override
            public boolean accept(File dir, String name) {
                File file = new File(dir, name);
                return file.isFile() && file.getName().endsWith(".dll");
            }
        });

        for (String s : arr) {
            System.out.println(s);
        }
    }



    /* 【文件名称过滤器的概述及使用】

	• A:文件名称过滤器的概述
		○ public String[] list(FilenameFilter filter)
		○ public File[] listFiles(FilenameFilter filter)

	• B:文件名称过滤器的使用
		○ 需求：判断E盘目录下是否有后缀名为.jpg的文件，如果有，就输出该文件名称

	• C:源码分析
		○ 带文件名称过滤器的list()方法的源码
    */
}
