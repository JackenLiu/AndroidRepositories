package com.javaprimary.a4_object_oriented.extend;

/**
 * 继承中成员变量
 */
public class A2_ExtendsVariable {

    public static void main(String[] args) {
        Zi z = new Zi();
        z.show();
    }

    static class Fu {
        int num1 = 10;
        int num2 = 30;
    }

    static class Zi extends Fu {
//        int num2 = 20;

        public void show() {
            System.out.println(super.num1);
            // 如果子类的 num2 注释掉，show 方法里使用 this.num2 可以访问父类的num2
            System.out.println(this.num2);  // 就近原则,自己有就不用父类的
            System.out.println(super.num2);    // super可以调用父类的成员变量
        }
    }



    /*  【调用成员变量】

	• this.成员变量 调用本类的成员变量,也可以调用父类的成员变量
	• super.成员变量 调用父类的成员变量
     */
}
