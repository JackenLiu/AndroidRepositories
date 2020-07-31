package com.javaprimary.a6_collection.generic;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 泛型概述
 */
public class A1_GenericOutline {

    public static void main(String[] args) {
        ArrayList<Person> list = new ArrayList<>();            // 1.7版本出现,菱形泛型
        list.add(new Person("张三", 23));
        list.add(new Person("李四", 24));
        list.add(new Person("王五", 25));

        Iterator<Person> it = list.iterator();
        while (it.hasNext()) {
            Person p = it.next();                            // 省去了强转的麻烦
            System.out.println(p.getName() + "," + p.getAge());
        }
    }

    private static class Person {
        private String name;
        private int age;

        public Person(String name, int age) {
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

    }





    /* 【泛型的由来】

		○ 泛型的由来:通过 Object 转型问题引入
        ○ 早期的 Object 类型可以接收任意的对象类型，但是在实际的使用中，会有类型转换的问题。也就存在这隐患，所以Java提
          供了泛型来解决这个安全问题。
    */




    /* 【泛型概述和基本使用】

	• A:泛型概述

	• B:泛型好处
		○ 提高安全性(将运行期的错误转换到编译期)
		○ 省去强转的麻烦

	• C:泛型基本使用
		○ <>中放的必须是引用数据类型

	• D:泛型使用注意事项
		○ 前后的泛型必须一致,或者后面的泛型可以省略不写(1.7的新特性菱形泛型)
    */
}
