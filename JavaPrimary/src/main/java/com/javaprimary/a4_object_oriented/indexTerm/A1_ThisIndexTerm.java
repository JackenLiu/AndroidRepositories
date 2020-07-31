package com.javaprimary.a4_object_oriented.indexTerm;

/**
 * this 关键字
 */
public class A1_ThisIndexTerm {

    public static void main(String[] args) {
        Mytest mytest = new Mytest();
        System.out.println(mytest.i);

        Mytest mytest1 = new Mytest(2);
        System.out.println(mytest1.i);
    }


    public static class Mytest {
        int i;

        public Mytest() {
            // 使用 this 调用本类构造方法
            this(1);
        }

        public Mytest(int i) {
            // 使用 this 调用本类成员变量
            this.i = i;
        }
    }


    /*  【this关键字的概述和应用】
	• 用来区分成员变量和局部变量重名，用 this 调用成员变量
	• 可以调用成员方法，一般会自动隐藏
	• 调用构造方法
		○ this(...) 调用本类的构造方法
     */
}
