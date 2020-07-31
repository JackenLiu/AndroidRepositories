package com.javaprimary.a4_object_oriented.polymorphism;

/**
 * 多态面试题
 */
public class A3_PolymorphismInterviewTitle {

    public static void main(String[] args) {
        A a = new B();
        a.show();

        B b = new C();
        b.show();
    }


    static class A {
        public void show() {
            show2();
        }

        public void show2() {  // 父类调用此方法时，因为子类重写了，所以运行看子类的show2()
            System.out.println("我");
        }
    }

    static class B extends A {
        public void show2() {
            System.out.println("爱");
        }
    }

    static class C extends B {
        public void show() {
            super.show();
        }

        public void show2() {
            System.out.println("你");
        }
    }
}
