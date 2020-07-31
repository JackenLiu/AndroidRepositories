package com.javaprimary.a6_collection.generic;

import java.util.ArrayList;

/**
 * 泛型通配符
 */
public class A4_GenericWildcard {

    public static void main(String[] args) {
        testExtends();
        testSuper();
    }

    // 测试 super
    public static void testSuper() {

        /*
        ? super E 只能存入 E 类型及 E 类型的子类对象
        */


        ArrayList<? super BadStudent> super1 = new ArrayList<>();
        // 只可以添加 BadStudent 或 BadStudent 的子类，因为一定可以向上转型
        super1.add(new BadStudent("肯定", 122));
//        super1.add(new Student("定", 22)); // 编译错误，BadStudent 或 BadStudent 的子类
        System.out.println(((Person) (super1.get(0))).getName()); // 方式

        // 只可以添加 Student 或 Student 的子类，因为一定可以向上转型
        ArrayList<? super Student> super2 = new ArrayList<>();
        super2.add(new BadStudent("欧文你", 12)); // Student 的子类
        System.out.println((super2.get(0)));
    }

    // 测试 ? extends E
    public static void testExtends() {

        /*
        ? extends E 不能加，只能取，所以只能对已有的本类或子类的集合进行指引
         */

        ArrayList<Person> peoples = new ArrayList<>();
        peoples.add(new Person("张三", 23));
        peoples.add(new Person("王五", 25));

        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("马哥", 18));
        students.add(new Student("马哥粉丝团秘书", 16));


        // 可以指引到 Person 类
        ArrayList<? extends Person> extends1;
        extends1 = peoples;
        Person person = extends1.get(0);      // 可以获取 person
        System.out.println(person.getName()); // 张三
//        extends1.add(new Person("接口", 12));            // 编译出错，不能加


        // 可以指引到 Person 子类 Student
        ArrayList<? extends Person> extends2;
        extends2 = students;
        Student student = (Student) extends2.get(0); // 获取 student
        System.out.println(student.getName()); // 马哥
//        extends2.add(new Student("接口", 12));          // 编译出错，不能加

    }

    public static class BadStudent extends Student {

        public BadStudent(String name, int age) {
            super(name, age);

        }

    }

    public static class Student extends Person {

        public Student(String name, int age) {
            super(name, age);

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





    /* 【泛型高级之通配符】

	• A:泛型通配符<?>
		○ 任意类型，如果没有明确，那么就是Object以及任意的Java类了

	• B:? extends E
		○ 向下限定，E 及其子类
		○ extends通配符的缺陷
		    其无法向其中添加任何对象，只能从中读取对象
		    原因：
		        因为 JVM 不能确定我们加的对象是 E 的哪个子类， E 有可能有多个子类，所以禁止添加对象
		        取出对象的时候因为遵循向上转型，所以可以取出

	• C:? super E
		○ 向上限定，E 及其父类
		○ super 通配符的缺陷
		    只能存入 E 类型及 E 类型的子类对象
		    原因：只有E 类型及 E 类型的子类对象才能够转成 E 类型或者 E 类型的父类

    */
}
