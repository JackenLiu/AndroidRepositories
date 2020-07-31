package com.javaprimary.a4_object_oriented;

/**
 * 接口
 */
public class A5_Interface {

    public static void main(String[] args) {
        Demo d = new Demo();
        d.print();
        System.out.println(Inter.num);
    }

    interface Inter {
        int num = 10;                // 接口中所有的变量都是常量

        void print();                    // 接口中所有的方法都是抽象的
    }

    static class Demo implements Inter {
        public void print() {                            // 重写接口中的方法,权限必须是public
            System.out.println("1111111111111");
        }
    }



    /*  【接口的概述及其特点】

	• A:接口概述
		○ 从狭义的角度讲就是指java中的interface
		○ 从广义的角度讲对外提供规则的都是接口

	• B:接口特点
		○ a:接口用关键字interface表示
			§ interface 接口名 {}
		○ b:类实现接口用implements表示
			§ class 类名 implements 接口名 {}
		○ c:接口不能实例化
			§ 那么，接口如何实例化呢?
			§ 按照多态的方式来实例化。
		○ copyFilesToOther:接口的子类
			§ a:可以是抽象类。但是意义不大。
			§ b:可以是具体类。要重写接口中的所有抽象方法。(推荐方案)

	• C:接口是否继承Object类呢?
		○  答:接口没有继承Object类,接口中所有的方法都是抽象的
		○   因为接口中有Object这个类所有方法的映射
     */





    /*  【接口成员特点】

		○ 成员变量；只能是常量，并且是静态的。
		    * 默认修饰符：public static final
		    * 建议：自己手动给出

		○ 构造方法：接口没有构造方法。

        ○ 成员方法：只能是抽象方法。
            * 默认修饰符：public abstract
            * 建议：自己手动给出
     */





    /*  【抽象类和接口的区别】

	• A:成员区别
		○ 抽象类：
			§ 成员变量：可以变量，也可以常量
			§ 构造方法：有
			§ 成员方法：可以抽象，也可以非抽象
		○ 接口：
			§ 成员变量：只可以常量
			§ 成员方法：只可以抽象

	• B:关系区别
		○ 类与类
			§ 继承，单继承
		○ 类与接口
			§ 实现，单实现，多实现
		○ 接口与接口
			§ 继承，单继承，多继承

	• C:设计理念区别
		○ 抽象类 被继承体现的是：”is a”的关系。抽象类中定义的是该继承体系的共性功能,共性功能可以实例化,因为有构造方法。
        ○ 接口 被实现体现的是：”like a”的关系。接口中定义的是该继承体系的扩展功能,扩展功能无法实例化,因为没有构造方法。
     */
}
