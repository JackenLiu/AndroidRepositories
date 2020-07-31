package com.javaprimary.b2_design_pattern;

/**
 * 单例模式
 */
public class A2_Singleton {

    public static void main(String[] args) {

        // 测试饿汉式
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        System.out.println(s1 == s2);

        // 测试懒汉式
        Singleton1 s3 = Singleton1.getInstance();
        Singleton1 s4 = Singleton1.getInstance();
        System.out.println(s3 == s4);

        // 测试自定义
        Singleton2 s5 = Singleton2.s;
        Singleton2 s6 = Singleton2.s;
        System.out.println(s5 == s6);
    }

    // 饿汉式
    static class Singleton {
        private Singleton() {
        }                               // 私有构造方法,不让其他类创建本类对象

        private static Singleton s = new Singleton();        // 创建本类对象

        public static Singleton getInstance() {              // 对外提供公共的访问方法,返回本类对象
            return s;
        }
    }

    // 懒汉式,单例的延迟加载
    static class Singleton1 {
        private Singleton1() {
        }                                // 私有构造方法,不让其他类创建本类对象

        private static Singleton1 s;

        public static Singleton1 getInstance() {               // 对外提供公共的访问方法,返回本类对象
            if (s == null)
                //线程1,线程2
                s = new Singleton1();
            return s;
        }
    }

    // 自定义
    static class Singleton2 {
        private Singleton2() {
        }                                // 私有构造方法,不让其他类创建本类对象

        public final static Singleton2 s = new Singleton2();    // 创建本类公共的静态的final修饰的对象

    }


    /* 【单例设计模式】

	• 单例设计模式：保证类在内存中只有一个对象。
	• 如何保证类在内存中只有一个对象呢？
		○ (1)控制类的创建，不让其他类来创建本类的对象。private
		○ (2)在本类中定义一个本类的对象。Singleton1 s;
		○ (3)提供公共的访问方式。 public static Singleton1 getInstance(){return s}
    */




    /* 【饿汉式和懒汉式的区别】

	•  都是单线程
		• 饿汉式是空间换时间
		• 懒汉式是时间换空间

	•  都是多线程
		• 饿汉式是没有安全隐患的
		• 懒汉式是可能会出现安全隐患,又可能创建多个对象
    */
}
