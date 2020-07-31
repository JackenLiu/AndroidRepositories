package com.javaprimary.a4_object_oriented.polymorphism;

/**
 * 多态中的成员访问
 */
public class A2_PolymorphismMember {

    public static void main(String[] args) {
        Fu f = new Zi();
        System.out.println(f.num);

        Zi z = new Zi();
        System.out.println(z.num);

        Fu f1 = new Zi();
        f1.print();
        Fu.method();
        Fu.method();
    }

    static class Fu {
        int num = 10;

        public void print() {
            System.out.println("Fu");
        }

        public static void method() {
            System.out.println("Fu static");
        }
    }

    static class Zi extends Fu {
        int num = 20;

        public void print() {
            System.out.println("Zi");
        }

        public static void method() {
            System.out.println("Zi static");
        }
    }




    /* 【多态中的成员访问特点】

	• A:多态中的成员访问特点
		○ a:成员变量
			§ 编译看左边，运行看左边。
		○ b:成员方法
			§ 编译看左边，运行看右边。（动态绑定：编译绑定父类方法，运行绑定子类）
		○ c:静态方法
			§ 编译看左边，运行看左边。
            § (静态和类相关，算不上重写，所以，访问还是左边的)
     */
}
