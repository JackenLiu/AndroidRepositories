package com.javareview.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class InputOutputStream {

    public static void main(String[] args) throws IOException {
        // jdk 1.6 之前最标准代码
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            fileInputStream = new FileInputStream("D:\\a.txt");
            fileOutputStream = new FileOutputStream("D:\\b.txt");

            byte[] bytes = new byte[1];
            int i;
            while ((i = fileInputStream.read(bytes)) != -1) {
//            fileOutputStream.write(bytes, 0, i);
                System.out.println(new String(bytes, 0, i));
            }
        } finally {
            try {
                if (fileInputStream != null)
                    fileInputStream.close();
            } finally {
                if (fileOutputStream != null)
                    fileOutputStream.close();
            }
        }


        // 数组封装
        FileInputStream fis = new FileInputStream("D:\\a.zip");
        FileOutputStream fos = new FileOutputStream("D:\\b.zip");
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fis);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fos);

        int i;
        while ((i = bufferedInputStream.read()) != -1) {
            bufferedOutputStream.write(i);
        }
        fis.close();
        fos.close();
    }
}
