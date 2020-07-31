package com.javaprimary.a4_object_oriented.extend;

/**
 * 继承中构造方法
 */
public class A3_ExtendsConstructor {

    public static void main(String[] args) {
        Student s = new Student("张三", 23);
        System.out.println(s.getName() + "," + s.getAge());

        Student s1 = new Student();
        System.out.println(s1.getName() + "," + s1.getAge());
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

    static class Student extends Person {
        public Student() {
            //super("李四",24);					// 构造函数中有super没this,有this没super
            //this和super语句必须放在构造函数的第一行
            //无论如何子类必须要访问父类的构造函数
            this("李四", 24);                    // 调用本类其他的构造方法
        }

        public Student(String name, int age) {    // name 李四,age 24
//            super(name, age);
        }

    }


    /*  【调用构造方法】

	• this(...) 调用本类的构造方法
    • super(...) 调用父类的构造方法
     */





    /*  【继承中构造方法的关系】

	• A:案例演示
		○ 子类中所有的构造方法默认都会访问父类中空参数的构造方法
	• B:为什么呢?
		○ 因为子类会继承父类中的数据，可能还会使用父类的数据。
		○ 所以，子类初始化之前，一定要先完成父类数据的初始化。
		○ 其实：
            每一个构造方法的第一条语句默认都是：super()在这里简单的提一句，Object类。否则有人就会针对父类的构造方法有
            疑问。Object在类就没有父类了
     */





    /*  【继承中构造方法的注意事项】

	• A:案例演示
		○ 父类没有无参构造方法,子类怎么办?
			§ super解决（直接调用父类有参构造方法）
				□ 使用 super 调用父类有参构造方法
			§ this解决（间接调用父类有参构造方法）
				□ 子类的其中一个构造方法使用 super 调用父类有参构造方法
				□ 子类其他构造方法使用 this 调用上面已经调用super的子类构造方法

	• B:注意事项
		○ super(…)或者this(….)必须出现在第一条语句上
		○ Super 与 this 不能同时存在
     */
}
