package com.javaprimary.a4_object_oriented;

/**
 * 构造方法
 */
public class A2_Constructor {

    public static void main(String[] args) {
        Student s1 = new Student();
        Student s = new Student("张三", 23);
    }


    static class Student {
        private String name;
        private int age;

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

        /*
        1.如果在一个类中没有定义构造方法,系统会默认给一个空参的构造方法
        格式是:public 类名(Student)(){}
        2,如果定义有参构造函数,没有定义空参构造函数,系统不会默认再给空参构造函数
        3,空参什么用,有参什么用?
            a 有参的构造函数就是为了给对象中的属性进行初始化用的
            b 空参在不需要给属性进行初始化,但是还要创建对象的时候使用
        4,定义了有参构造函数,要不要再定义空参的呢?
            建议把空参的加上,为了创建对象,调用成员使用
        */
        public Student() {                    //构造方法:给对象的数据(属性)进行初始化
            name = "张";
            age = 2;
            System.out.println("构造方法    " + name + age);
        }

        public Student(String name, int age) {
            this.name = name;
            this.age = age;
            System.out.println("有参构造方法  " + name + age);
        }

    }

    /*  【构造方法的重载及注意事项】

	• A:案例演示
		○ 构造方法的重载

	• B:构造方法注意事项
		○ a:如果我们没有给出构造方法，系统将自动提供一个无参构造方法。
		○ b:如果我们给出了构造方法，系统将不再提供默认的无参构造方法。
		○ 注意：这个时候，如果我们还想使用无参构造方法，就必须自己给出。建议永远自己给出无参构造方法

	• C:给成员变量赋值的两种方式
		○ a:setXxx()方法
		○ b:构造方法
     */
}
