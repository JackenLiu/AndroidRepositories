package com.javaprimary.a7_io_stream.otherStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 * 算法等练习
 */
public class A9_Practice {
    public static void main(String[] args) throws IOException {
//        testPrint0_9();
//        copyFilesToOther();
//        printLevFile(getDir(), 0);

        /**
         * 100!尾部有多少个零
         * 5 10 15 20 25 30 35 40 45 50 55 60 65 70 75 80 85 90 95 100  20个 100 / 5 = 20
         * 25 50 75 100 20 / 5 = 4
         * 5 * 5 * 5 * 1 = 125有3个5的一共有8个
         * 5 * 5 * 5 * 2 = 250
         * 5 * 5 * 5 * 3 = 375
         * 5 * 5 * 5 * 4 = 500
         *
         * 5 * 5 * 5 * 5 = 625有4个5的一共有1个
         * 1000!尾部有多少个零
         * 1000 / 5 = 200
         * 200 / 5 = 40
         * 40 / 5 = 8
         * 8 / 5 = 1
         */
        System.out.println(getZeroNum(1000));
    }


    // 获取 num 阶乘后面 0 的个数
    public static int getZeroNum(int num) {
        if (num < 5) {
            return 0;
        } else {
            return num / 5 + getZeroNum(num / 5);
        }
    }

    // 打印文件夹层级目录
    public static void printLevFile(File dir, int lev) {
        File[] subFiles = dir.listFiles();                // 获取到 dir 下的所有的文件和文件夹

        for (File subFile : subFiles) {                    // 遍历
            for (int i = 0; i <= lev; i++) {                // 根据传入的lev值
                System.out.print('\t');                    // 打印\t
            }
            System.out.println(subFile);                // 打印文件或文件夹
            if (subFile.isDirectory()) {                    // 如果是文件夹
                printLevFile(subFile, lev + 1);            // 递归调用
                //printLevFile(subFile,lev++);			// 会改变 lev 的值
                //printLevFile(subFile,++lev);
            }
        }
    }

    // 从键盘接收两个文件夹路径,把其中一个文件夹中(包含内容)拷贝到另一个文件夹中
    public static void copyFilesToOther() throws IOException {
        File src = getDir();                    // 获取源文件
        File dest = getDir();                   // 拷贝到目的文件夹中
        if (src.equals(dest)) {
            System.out.println("目标文件是源文件的子文件夹");
        } else {
            copyFile(src, dest);
        }
    }

    // 获取文件夹路径
    public static File getDir() {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个文件夹路径:");
        while (true) {
            String line = sc.nextLine();
            File dir = new File(line);
            if (!dir.exists()) {
                System.out.println("重输:");
            } else if (dir.isFile()) {
                System.out.println("重输");
            } else {
                return dir;
            }
        }
    }

    // 拷贝带内容的文件夹
    public static void copyFile(File src, File dest) throws IOException {
        File newDir = new File(dest, src.getName());
        newDir.mkdir();                                           // 创建空文件夹
        File[] subFiles = src.listFiles();                        // 获取到源文件夹中所有的文件和文件夹
        for (File subFile : subFiles) {
            if (subFile.isFile()) {
                FileInputStream fis = new FileInputStream(subFile);
                FileOutputStream fos = new FileOutputStream(new File(newDir, subFile.getName()));
                byte[] arr = new byte[8192];
                int len;
                while ((len = fis.read(arr)) != -1) {
                    fos.write(arr, 0, len);
                }

                fis.close();
                fos.close();
            } else {
                copyFile(subFile, newDir);
            }
        }
    }


    /*
     1,有 x 个人,分配房间,每个房间住6个人,问 x 个人住几个房间
	   (x + 5) / 6
	 2,在控制台无限打印0-9
     */
    public static void testPrint0_9() {
        int x = -1;
        while (true) {
            x = ++x % 10;
            System.out.println(x);
        }

        /*int x = 0;
        while (true) {
            if (x == 1000) {
                x = 0;
            }
            System.out.println(x++ % 10);
        }*/
    }
}
