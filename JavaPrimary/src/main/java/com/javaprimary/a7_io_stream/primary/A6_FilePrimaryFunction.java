package com.javaprimary.a7_io_stream.primary;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * File 类基本功能
 */
public class A6_FilePrimaryFunction {

    public static void main(String[] args) throws IOException {
        testCreate();
//        testDelete();
//        testRename();
//        testJudge();
//        testAcquire();
    }

    // 测试 File 类的创建功能
    public static void testCreate() throws IOException {
        File file = new File("A6_FilePrimaryFunction_01.txt");
        boolean b1 = file.createNewFile();                    // 创建新文件
        System.out.println(b1);
        System.out.println(file.exists());

        File file2 = new File("A6_FilePrimaryFunction_02.txt");
        boolean b2 = file2.createNewFile();                    // 创建一个新文件,如果文件不存在就创建返回true
        System.out.println(b2);                                // 如果文件存在,就不创建,返回false
        System.out.println(file2.exists());


        File dir1 = new File("A6_FilePrimaryFunction_03");
        boolean b3 = dir1.mkdir();                  // 创建单级目录
        System.out.println(b3);

        File dir2 = new File("A6_FilePrimaryFunction_04.txt");
        boolean b4 = dir2.mkdir();                    // 创建单级目录
        System.out.println(b4);

        File dir3 = new File("A6_FilePrimaryFunction_05\\01");
        boolean b5 = dir3.mkdirs();                    // 创建多级目录
        System.out.println(b5);
    }

    // 测试 File 类的删除功能
    public static void testDelete() throws IOException {

        File file1 = new File("xxx.txt");
        boolean b1 = file1.delete();
        System.out.println(b1);

        File file2 = new File("bbb.txt");
        boolean b2 = file2.delete();                // 删除文件夹,必须删的是空的
        System.out.println(b2);
    }

    // 测试 File 类的重命名功能
    public static void testRename() throws IOException {

        File file1 = new File("ccc");
        File file2 = new File("bbb");
        boolean b = file1.renameTo(file2);
        System.out.println(b);
    }

    // 测试 File 类的判断功能
    public static void testJudge() throws IOException {

        File file1 = new File("aaa");
        File file2 = new File("a01.txt");
        System.out.println(file1.isDirectory());
        System.out.println(file2.isDirectory());

        System.out.println("---------------------------");
        System.out.println(file1.isFile());
        System.out.println(file2.isFile());

        System.out.println("---------------------------");


        File file = new File("bbb.txt");
        file.setReadable(false);                // 在windows系统下所有的文件都是可读
        boolean b1 = file.canRead();
        System.out.println(b1);

        file.setWritable(true);                    // 在windows系统下可以设置为不可写
        boolean b2 = file.canWrite();
        System.out.println(b2);

        File file3 = new File("ccc.txt");
        System.out.println(file3.isHidden());    // 判断是否是隐藏文件
        System.out.println(file.isHidden());
    }

    // 测试 File 类的获取功能
    public static void testAcquire() throws IOException {

        File file1 = new File("a01.txt");
        System.out.println(file1.getAbsolutePath());        // 获取绝对路径
        System.out.println(file1.getPath());                // 获取相对路径
        System.out.println(file1.getName());

        File file2 = new File("aaa");
        System.out.println(file2.getName());                // 获取名称(文件和文件夹)

        System.out.println("-------------------");

        File file = new File("a02.txt");
        long len = file.length();                // 如果获取的是文件返回的是字节个数
        System.out.println(len);

        File file3 = new File("aaa");
        long len2 = file3.length();                // 如果直接获取文件夹的大小返回就是0
        System.out.println(len2);

        System.out.println("-------------------");

        File file4 = new File("a01.txt");
        long time = file4.lastModified();        // 获取文件最后的修改时间
        System.out.println(time);

        Date d = new Date(time);
        System.out.println(d);

        System.out.println("-------------------");

        File dir = new File("bbb\\ddd");
        String[] arr1 = dir.list();                    // 只是为了获取名字

        for (String string : arr1) {
            System.out.println(string);
        }

        File[] subFiles = dir.listFiles();            // 为了获取File对象,对其做各种操作
        for (File file5 : subFiles) {
            System.out.println(file5);

        }
    }


    /* 【File 类的创建功能】

	• A:创建功能
		○ public boolean createNewFile():创建文件 如果存在这样的文件，就不创建了
		○ public boolean mkdir():创建文件夹 如果存在这样的文件夹，就不创建了
		○ public boolean mkdirs():创建文件夹,如果父文件夹不存在，会帮你创建出来

	• B:注意事项：
		○ 如果你创建文件或者文件夹忘了写盘符路径，那么，默认在项目路径下。
    */




    /* 【File 类的删除功能】

	• A:删除功能
		○ public boolean delete():删除文件或者文件夹

	• B:注意事项：
		○ Java中的删除不走回收站。
		○ 要删除一个文件夹，请注意该文件夹内不能包含文件或者文件夹
    */




    /* 【File 类的重命名功能】

	• A:重命名功能
		○ public boolean renameTo(File dest):把文件重命名为指定的文件路径

	• B:注意事项：
		○ 如果路径名相同，就是改名。
		○ 如果路径名不同，就是改名并剪切。
    */




    /* 【File 类的判断功能】

	• A:判断功能
		○ public boolean isDirectory():判断是否是目录
		○ public boolean isFile():判断是否是文件
		○ public boolean exists():判断是否存在
		○ public boolean canRead():判断是否可读
		○ public boolean canWrite():判断是否可写
        ○ public boolean isHidden():判断是否隐藏
    */




    /* 【File 类的获取功能】

	• A:获取功能
		○ public String getAbsolutePath()：获取绝对路径
		○ public String getPath():获取相对路径
		○ public String getName():获取名称
			§ 既可以获取文件的也可以获取文件夹的
		○ public long length():获取长度。字节数
			§ 只能获取文件的大小长度，文件夹返回0
		○ public long lastModified():获取最后一次的修改时间，毫秒值
		○ public String[] list():获取指定目录下的所有文件或者文件夹的名称数组
			§ 只是获取文件和文件夹的名字
		○ public File[] listFiles():获取指定目录下的所有文件或者文件夹的 File 数组
        ○ 获取 file 对象
    */
}
