package com.javaprimary.a6_collection.list;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * ArrayList 类去重复用法举例
 */
public class A5_ArrayListRemoveDuplicate {

    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add("a");
        list.add("b");
        list.add("b");
        list.add("c");
        list.add("c");

        System.out.println(list);
        ArrayList newList = removeDuplicateChar(list);
        System.out.println(newList);


        ArrayList list1 = new ArrayList();
        list1.add(new Person("张三", 23));
        list1.add(new Person("李四", 24));
        list1.add(new Person("李四", 24));
        list1.add(new Person("李五", 24));


        System.out.println(list1);
        ArrayList newList1 = removeDuplicateObject(list1);
        System.out.println(newList1);
        boolean b1 = list1.remove(new Person("张三", 23));
        System.out.println(b1);
        System.out.println(list1);
    }


    /*
     * 去除重复字符串元素
     */
    public static ArrayList removeDuplicateChar(ArrayList list) {
        ArrayList newList = new ArrayList();            // 创建一个新集合
        Iterator it = list.iterator();                    // 获取迭代器
        while (it.hasNext()) {                            // 判断老集合中是否有元素
            String temp = (String) it.next();            // 将每一个元素临时记录住
            if (!newList.contains(temp)) {                // 如果新集合中不包含该元素
                newList.add(temp);                        // 将该元素添加到新集合中
            }
        }
        return newList;                                    // 将新集合返回
    }


    /*
     * 去除重复自定义对象元素
     *
     * contains 和 remove 方法底层依赖 equals 方法,如果没有重写 equals 方法,比较的是对象的地址值,重写之后比较的是
     * 对象的属性值
     */
    public static ArrayList removeDuplicateObject(ArrayList list) {
        ArrayList newList = new ArrayList();            // 创建一个新集合
        Iterator it = list.iterator();                    // 获取迭代器
        while (it.hasNext()) {                            // 判断老集合中是否有元素
            Person temp = (Person) it.next();            // 将每一个元素临时记录住
            if (!newList.contains(temp)) {                // 如果新集合中不包含该元素
                newList.add(temp);                        // 将该元素添加到新集合中
            }
        }
        return newList;                                    // 将新集合返回
    }

    /**
     * 重写 equals 方法
     */
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

        @Override
        public String toString() {
            return "Person [name=" + name + ", age=" + age + "]";
        }

        @Override
        public boolean equals(Object obj) {
            Person p = (Person) obj;
            return this.name.equals(p.name) && this.age == p.age;
        }
    }





    /*  【去除ArrayList中重复元素】

	• A:案例演示
		○ 去除重复字符串元素
		○ 去除重复自定义对象元素

	• B:注意事项
		○ 对移除的对象类里面，重写equals()方法的
     */
}
