package com.javaprimary.a7_io_stream.otherStream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * 对象操作流
 */
public class A3_ObjecIoStream {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        testObjectOutputStream();
//        testObjectOutputStreamExtend();
//        testObjectInputStream();
//        testObjectInputStreamExtend();
    }

    // 简单存对象
    public static void testObjectOutputStream() throws IOException {
        Person p1 = new Person("张三", 23);
        Person p2 = new Person("李四", 24);
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("A3_ObjecOutputStream_01.txt"));
        oos.writeObject(p1);
        oos.writeObject(p2);
        oos.close();
    }

    // 测试存多个对象
    public static void testObjectOutputStreamExtend() throws IOException {
        Person p1 = new Person("张三", 23);
        Person p2 = new Person("李四", 24);
        Person p3 = new Person("马哥", 18);
        Person p4 = new Person("辉哥", 20);

        ArrayList<Person> list = new ArrayList<>();
        list.add(p1);
        list.add(p2);
        list.add(p3);
        list.add(p4);

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("A3_ObjecOutputStream_02.txt"));
        oos.writeObject(list);                                    // 写出集合对象
        oos.close();
    }

    // 读简单对象
    public static void testObjectInputStream() throws IOException,
            ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("A3_ObjecOutputStream_01.txt"));
        Person p1 = (Person) ois.readObject();                // 读一个对象
        Person p2 = (Person) ois.readObject();
        //Person p3 = (Person)ois.readObject();

        System.out.println(p1);
        System.out.println(p2);
        //System.out.println(p3);
        ois.close();
    }

    // 读多个对象
    public static void testObjectInputStreamExtend() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream("A3_ObjecOutputStream_02.txt"));
        // 泛型在运行期会被擦除,索引运行期相当于没有泛型
        ArrayList<Person> list = (ArrayList<Person>) ois.readObject();
        for (Person person : list) {
            System.out.println(person);
        }

        ois.close();
    }


    static class Person implements Serializable {   // 可以被序列化的
        // private static final long serialVersionUID = 3L;		// 对版本升级
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



    /* 【ObjecOutputStream】

	• 1.什么是对象操作流
		○ 该流可以将一个对象写出, 或者读取一个对象到程序中. 也就是执行了序列化和反序列化的操作.

	• 2.使用方式
        • 写出: new ObjectOutputStream(OutputStream), writeObject()
    */




    /* 【ObjectInputStream】

    	• 读取: new ObjectInputStream(InputStream), readObject()
    */





    /* 【加上id 号】

	• 注意
		○ 要写出的对象必须实现 Serializable 接口才能被序列化
        ○ 不用必须加 id 号
    */
}
