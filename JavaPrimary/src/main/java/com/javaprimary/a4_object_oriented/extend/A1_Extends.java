package com.javaprimary.a4_object_oriented.extend;

/**
 * 继承
 */
public class A1_Extends {

    public static void main(String[] args) {
        DemoC d = new DemoC();
        d.show1();
        d.show2();
        d.show3();
    }

    static class DemoA {
        public void show1() {
            System.out.println("DemoA");
        }
    }

    static class DemoB extends DemoA {
        public void show2() {
            System.out.println("DemoB");
        }
    }

    static class DemoC extends DemoB {    //java只支持单继承,java支持的多层继承
        public void show3() {
            System.out.println("DemoC");
        }
    }




    /*  【Java中类的继承特点】

    • A:Java中类的继承特点
		○ a:Java只支持单继承，不支持多继承。(一个儿子只能有一个爹)
			§ 有些语言是支持多继承，格式：extends 类1,类2,...
		○ b:Java支持多层继承(继承体系)

	• B:案例演示
		○ Java中类的继承特点
			§ 如果想用这个体系的所有功能用最底层的类创建对象
			§ 如果想看这个体系的共性功能,看最顶层的类
     */




    /*  【优点和缺点】

    继承的优点

	• a:提高了代码的复用性
	• b:提高了代码的维护性
    • c:让类与类之间产生了关系，是多态的前提

    继承的缺点

	• 类的耦合性增强了。
	• 开发的原则：高内聚，低耦合。
	• 耦合：类与类的关系
	• 内聚：就是自己完成某件事情的能力
     */




    /*  【继承的注意事项和什么时候使用继承】

	• A:继承的注意事项
		○ a:子类只能继承父类所有非私有的成员(成员方法和成员变量)
		○ b:子类不能继承父类的构造方法，但是可以通过super(马上讲)关键字去访问父类构造方法。
		○ c:不要为了部分功能而去继承

	• B:什么时候使用继承
		○ 继承其实体现的是一种关系："is a"。 Person Student Teacher Fruit Apple 香蕉 橘子
        ○ 采用假设法。 如果有两个类A,B。只有他们符合A是B的一种，或者B是A的一种，就可以考虑使用继承。
     */
}
