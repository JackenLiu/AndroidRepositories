package com.javaprimary.a4_object_oriented.indexTerm;

/**
 * super 关键字
 */
public class A3_SuperIndexTerm {

    public static void main(String[] args) {
        Zi z = new Zi();
        z.show();
    }
}

class Fu {
    public int num = 10;

    public Fu() {
        super();
        System.out.println("fu");
    }
}

class Zi extends Fu {
    public int num = 20;

    public Zi() {
        super();                                //访问父类中空参的构造函数
        System.out.println("zi");
    }

    public void show() {
        int num = 30;
        System.out.println(num);
        System.out.println(this.num);
        System.out.println(super.num);
    }




    /*  【super的作用】

	• 子类局部范围访问父类成员变量
     */





    /*  【this和super的区别】

	• 成员变量
		○ This 可以访问自己的成员变量，也可以访问父类的成员变量（本类没有这个成员变量前提下）
		○ super 只能访问父类的成员变量
		○ Super 与 this 不能同时存在
     */
}
