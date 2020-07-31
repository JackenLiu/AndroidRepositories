package com.javaprimary.a6_collection.generic;

/**
 * 泛型类
 */
public class A2_GenericClass {

    public static void main(String[] args) {

        Tool<Person> t = new Tool<>();
        t.setObj(new Person("张三", 12));
        Person p = t.getObj();
        System.out.println(p.name);

        Tool.print(new Person("张四", 14).age);

    }


    static public class Tool<W> {
        private W e;

        public W getObj() {
            return e;
        }

        public void setObj(W e) { // Ojbect obj = new Person();
            this.e = e;
        }

        public void show(W w) {
            System.out.println(w);
        }

        public static <T> void print(T t) {            // 静态方法的泛型不能和类的泛型一致
            System.out.println(t);
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


    /* 【泛型类的概述及使用】

	• A:泛型类概述
		○ 把泛型定义在类上

	• B:定义格式
		○ public class 类名<泛型类型1,…>

	• C:注意事项
		○ 泛型类型必须是引用类型
		○ 泛型对象成员在创建对象的时候赋值

	• D:案例演示
		○ 泛型类的使用
    */
}
