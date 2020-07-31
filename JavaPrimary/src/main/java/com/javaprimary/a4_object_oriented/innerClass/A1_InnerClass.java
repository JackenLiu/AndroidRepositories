package com.javaprimary.a4_object_oriented.innerClass;

/**
 * 内部类
 */
public class A1_InnerClass {

    public static void main(String[] args) {
        Outer1.Inner1 i = new Outer1.Inner1();
        i.print();
        // 外部类名.内部类名 对象名 = 外部类对象.内部类对象;
        Outer.Inner o = new Outer().new Inner();
        o.print();

        Outer o1 = new Outer();
        o1.method();
    }

    static class Outer1 {                            // 外部类
        //成员内部类
        private int num = 10;

        static class Inner1 {                // 静态成员内部类
            public void print() {            //静态成员内部类的成员方法
                System.out.println("1111");
            }
        }

        public void method() {
            Inner1 i = new Inner1();            // 创建内部类对象
            i.print();                        // 调用内部类方法
        }
    }


    static class Outer {                            // 外部类
        //成员内部类
        private int num = 10;

        private class Inner {                // 内部类
            public void print() {            //内部类的成员方法
                System.out.println(Outer.this.num);
            }
        }

        public void method() {
            Inner i = new Inner();            // 创建内部类对象
            i.print();                        // 调用内部类方法
        }
    }




    /*  【内部类概述和访问特点】

	• A:内部类概述
	• B:内部类访问特点
		○ a:内部类可以直接访问外部类的成员，包括私有。
		○ b:外部类要访问内部类的成员，必须创建对象。
     */





    /*  【静态成员内部类】

	• Static 修饰
	• B:成员内部类被静态修饰后的访问方式是:
        外部类名.内部类名 对象名 = new 外部类名.内部类名()
     */
}
