package com.javaprimary.a4_object_oriented.indexTerm;

/**
 * final 关键字
 */
public class A4_FinalIndexTerm {

    public static void main(String[] args) {

        final int num = 10;                //final修饰基本数据类型变量不改变其值
        System.out.println(num);

        final Person p1 = new Person("张三", 23);//0x0011
        //p1 = new Person("李四",24);//0x0022
        p1.setName("李四");                //final修饰引用数据类型变量不改变其地址值
        p1.setAge(24);                    //但是可以改变对象的属性值

        System.out.println(p1.getName() + "," + p1.getAge());
    }


    static class Person {
        private String name;
        private int age;

        public Person() {
        }

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }
    }




    /*  【final 概述】

    限制类、方法、变量被改动的关键字。
     */




    /*  【修饰特点】

	• 修饰类，类不能被继承
	• 修饰变量，变量就变成了常量，只能被赋值一次
		○ 基本类型，是值不能被改变
		○ 引用类型，是地址值不能被改变 ，如一个对象引用，它不可以重新 new 但是可以更改它的成员变量属性。

	• 修饰方法，方法不能被重写
     */
}


