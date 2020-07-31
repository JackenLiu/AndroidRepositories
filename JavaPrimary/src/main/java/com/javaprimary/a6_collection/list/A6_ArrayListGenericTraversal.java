package com.javaprimary.a6_collection.list;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * ArrayList 泛型遍历
 */
public class A6_ArrayListGenericTraversal {

    public static void main(String[] args) {
        testCharTraversal();
        testObjectTraversal();
    }

    // 测试自定义对象泛型遍历
    public static void testObjectTraversal() {
        ArrayList<Person> list = new ArrayList<>();
        list.add(new Person("张三", 23));
        list.add(new Person("李四", 24));
        list.add(new Person("王五", 25));
        list.add(new Person("赵六", 26));
//        list.add(new Student("马哥", 18));				// 父类引用指向子类对象

        Iterator<Person> it = list.iterator();
        while (it.hasNext()) {
            Person p = it.next();
            System.out.println(p.getName() + "," + p.getAge());
        }
    }

    // 测试字符泛型遍历
    public static void testCharTraversal() {
        ArrayList<String> list = new ArrayList<>();    // 创建集合对象
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("copyFilesToOther");

        Iterator<String> it = list.iterator();        // 获取迭代器
        while (it.hasNext()) {                        // 判断集合中是否有元素
            String s = it.next();                    // 获取集合中的元素
            System.out.println(s);                    // 打印
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

}
