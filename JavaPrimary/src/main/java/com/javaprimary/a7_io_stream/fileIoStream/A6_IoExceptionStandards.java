package com.javaprimary.a7_io_stream.fileIoStream;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 流的标准处理异常代码
 */
//@RequiresApi(api = Build.VERSION_CODES.KITKAT)
public class A6_IoExceptionStandards {

    public static void main(String[] args) throws IOException {
    }

    // 1.6 版本及其以前
    public static void testStandards16() throws IOException {
        //标准的异常处理代码
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream("aaa.txt");
            fos = new FileOutputStream("bbb.txt");
            int b;
            while ((b = fis.read()) != -1) {
                fos.write(b);
            }
        } finally {
            try {
                if (fis != null)
                    fis.close();
            } finally {
                if (fos != null)
                    fos.close();
            }
        }
    }

    // 1.7 版本
    public static void testStandards17() throws IOException {
        try (
                FileInputStream fis = new FileInputStream("aaa.txt");
                FileOutputStream fos = new FileOutputStream("bbb.txt");
                MyClose mc = new MyClose()
        ) {
            int b;
            while ((b = fis.read()) != -1) {
                fos.write(b);
            }
        }
    }


    static class MyClose implements AutoCloseable {
        public void close() {
            System.out.println("我关了");
        }
    }




    /* 【1.6 版本及其以前】

	• try finally嵌套
    */




    /* 【1.7 版本】

	• try close

	• 原理
        在 try() 中创建的流对象必须实现了 AutoCloseable 这个接口,如果实现了,在 try 后面的 {}(读写代码) 执行后就会
        自动调用流对象的 close 方法将流关掉
    */
}
