package com.javaprimary.a4_object_oriented;

/**
 * 抽象
 */
public class A4_Abstract {

    public static void main(String[] args) {
        Zi z = new Zi();
        z.print();
    }


    static abstract class Fu {
        /*
        错误: 非法的修饰符组合: abstract 和 private
        private是私有不让子类看到,abstract是抽象就是为了让子类重写,他俩矛盾的
         */
        //private abstract void print();

        /*
        错误: 非法的修饰符组合: abstract 和 static
        静态修饰的方法,可以直接类名.调用,而类名.调用抽象方法是没有意义的
         */
        //static abstract void print();

        /*
        错误: 非法的修饰符组合: abstract和final
        final是最终的,修饰的方法不让子类重写,而abstract修饰的方法就是为了让子类重写
         */
        //final abstract void print();

        abstract void print();

        void print1() {
        }

    }

    static class Zi extends Fu {
        public void print() {
            System.out.println("Hello World!");
        }
    }



    /*  【抽象类的概述及其特点】

	• A:抽象类概述
		○ 无法描述的类和方法，属于范围大的情况。

	• B:抽象类特点
		○ a:抽象类和抽象方法必须用abstract关键字修饰
			§ abstract class 类名 {}
			§ public abstract void eat();
		○ b:抽象类不一定有抽象方法，有抽象方法的类一定是抽象类
		○ c:抽象类不能实例化那么，抽象类如何实例化呢?
			§ 按照多态的方式，由具体的子类实例化。其实这也是多态的一种，抽象类多态。
		○ copyFilesToOther:抽象类的子类
			§ 要么是抽象类
            § 要么重写抽象类中的所有抽象方法
     */





    /*  【抽象类的成员特点】

	• A:抽象类的成员特点
		○ a:成员变量：既可以是变量，也可以是常量。
		○ b:构造方法：有。
			§ 用于子类访问父类数据的初始化。
		○ c:成员方法：既可以是抽象的，也可以是非抽象的。
		    § 抽象成员方法子类必须重写

	• B:抽象类的成员方法特性：
		○ a:抽象方法 强制要求子类做的事情。
		○ b:非抽象方法 子类继承的事情，提高代码复用性。
     */
}
