package com.javaprimary.a4_object_oriented.innerClass;

/**
 * 匿名内部类
 */
public class A2_AnonymousInnerClass {

    public static void main(String[] args) {

        PersonDemo pd = new PersonDemo();

        // 普通实现
        Student student = new Student();
        pd.method(student);

        // 匿名内部类
        pd.method(new Person() {
            @Override
            public void show() {
                System.out.println("111");
            }
        });

    }


    abstract static class Person {
        public abstract void show();
    }


    static class PersonDemo {
        public void method(Person p) {
            p.show();
        }

    }

    static class Student extends Person {
        @Override
        public void show() {
            System.out.println("Student");
        }
    }


    /*  【匿名内部类的格式和理解】

	• A:匿名内部类
		○ 就是内部类的简化写法。
	• B:前提：存在一个类或者接口
		○ 这里的类可以是具体类也可以是抽象类。
	• C:格式：
		○ new 类名或者接口名(){
		○     重写方法;
		○ }.调用方法；

	• D:本质是什么呢?
		○ 是一个继承了该类或者实现了该接口的子类匿名对象。

	• 作用：
		○ 重写一个方法的时候少写一个类，节省代码
     */
}
