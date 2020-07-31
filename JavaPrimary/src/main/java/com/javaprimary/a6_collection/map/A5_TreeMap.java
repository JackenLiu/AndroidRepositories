package com.javaprimary.a6_collection.map;


import java.util.Comparator;
import java.util.TreeMap;

/**
 * TreeMap 类
 */
//@RequiresApi(api = Build.VERSION_CODES.KITKAT)
public class A5_TreeMap {

    public static void main(String[] args) {
        demo1();
        demo2();
    }

    public static void demo1() {
        TreeMap<String, String> tm = new TreeMap<>();
        tm.put("c", "1");
        tm.put("a", "3");
        tm.put("b", "4");
        tm.put("copyFilesToOther", "2");
        System.out.println(tm);
    }

    // 同 TreeMap 原理一样，加 Comparator 进行自定义对比
    public static void demo2() {
        TreeMap<Person, String> tm = new TreeMap<>(new Comparator<Person>() {

            @Override
            public int compare(Person p1, Person p2) {
                int num = p1.getName().compareTo(p2.getName());
                return num == 0 ? p1.getAge() - p2.getAge() : num;
            }
        });
        tm.put(new Person("张三", 33), "北京");
        tm.put(new Person("王五", 23), "广州");
        tm.put(new Person("王五", 21), "广州");
        tm.put(new Person("李四", 13), "上海");
        tm.put(new Person("赵六", 43), "深圳");

        System.out.println(tm);
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

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }



    /* 【TreeMap的特点】

	• 会对键自动排序
    */
}
