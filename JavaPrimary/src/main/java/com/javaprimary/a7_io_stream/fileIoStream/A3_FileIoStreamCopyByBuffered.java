package com.javaprimary.a7_io_stream.fileIoStream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * IO 字节流 Buffered 拷贝功能
 */
public class A3_FileIoStreamCopyByBuffered {

    public static void main(String[] args) throws IOException {

        FileInputStream fis = new FileInputStream("A2_FileIoStreamCopyByBuffered_01.mp4");
        // 创建缓冲区对 fis 装饰
        BufferedInputStream bis = new BufferedInputStream(fis);
        FileOutputStream fos = new FileOutputStream("A2_FileIoStreamCopyByBuffered_02.mp4");
        // 创建缓冲区对 fos 装饰
        BufferedOutputStream bos = new BufferedOutputStream(fos);

        int b;
        while ((b = bis.read()) != -1) {
            bos.write(b);
//            bos.flush();                  // 需要随时刷新缓冲区内容的时候,用 flush
        }

        bis.close();                        // 只关装饰后的对象即可
        bos.close();
    }




    /* 【BufferedInputStream 和 BufferOutputStream 拷贝】

	• A:缓冲思想
		○ 字节流一次读写一个数组的速度明显比一次读写一个字节的速度快很多，
		○ 这是加入了数组这样的缓冲区效果，java本身在设计的时候，
		○ 也考虑到了这样的设计思想(装饰设计模式后面讲解)，所以提供了字节缓冲区流

	• B.BufferedInputStream
		○ BufferedInputStream 内置了一个缓冲区(数组)
		○ 从 BufferedInputStream 中读取一个字节时
		○ BufferedInputStream 会一次性从文件中读取 8192 个, 存在缓冲区中, 返回给程序一个
		○ 程序再次读取时, 就不用找文件了, 直接从缓冲区中获取
		○ 直到缓冲区中所有的都被使用过, 才重新从文件中读取 8192 个

	• C.BufferedOutputStream
		○ BufferedOutputStream 也内置了一个缓冲区(数组)
		○ 程序向流中写出字节时, 不会直接写到文件, 先写到缓冲区中
		○ 直到缓冲区写满, BufferedOutputStream 才会把缓冲区中的数据一次性写到文件里
    */





    /* 【小数组的读写和带 Buffered 的读取哪个更快】

    • 定义小数组如果是 8192 个字节大小和 Buffered 比较的话
	• 定义小数组会略胜一筹,因为读和写操作的是同一个数组
    • 而 Buffered 操作的是两个数组
    */





    /* 【flush 和 close 方法的区别】

	• flush()方法
		○ 用来刷新缓冲区的,刷新后可以再次写出（如 QQ 实时聊天）

	• close()方法
        ○ 用来关闭流释放资源的的,如果是带缓冲区的流对象的 close() 方法,不但会关闭流,还会再关闭流之前刷新缓冲区,关闭后
          不能再写出
    */
}
