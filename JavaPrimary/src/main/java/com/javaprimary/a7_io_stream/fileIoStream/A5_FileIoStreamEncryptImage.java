package com.javaprimary.a7_io_stream.fileIoStream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * IO 字节流对图片进行加密
 */
public class A5_FileIoStreamEncryptImage {

    private static final int key = 123;

    public static void main(String[] args) throws IOException {
//        encrypt();
//        decrypt();
    }

    // 图片解密
    public static void decrypt() throws IOException {
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("A5_FileIoStreamEncryptImage_02.png"));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("A5_FileIoStreamEncryptImage_03.png"));

        int b;
        while ((b = bis.read()) != -1) {
            bos.write(b ^ key);     // 对读到的字节进行异或上一个数（密钥）,异或两次等于本身，异或的定律
        }

        bis.close();
        bos.close();
    }


    // 图片加密
    public static void encrypt() throws IOException {
        FileInputStream fis = new FileInputStream("A5_FileIoStreamEncryptImage_01.png");
        FileOutputStream fos = new FileOutputStream("A5_FileIoStreamEncryptImage_02.png");

        int b;
        while ((b = fis.read()) != -1) {
            fos.write(b ^ key);     // 对读到的字节进行异或上一个数（密钥）
        }
        fis.close();
        fos.close();
    }
}
