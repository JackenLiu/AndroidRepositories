package com.javaprimary.a4_object_oriented.indexTerm;

/**
 * static 关键字
 */
public class A2_StaticIndexTerm {

    public static void main(String[] args) {

        Test t = new Test();
        t.print1();

        Test.print2();
        method();                                // method 方法是静态的,直接能调用,是因为系统会默认加上类名.
        A2_StaticIndexTerm.method();
    }


    public static void method() {
        System.out.println("method");
    }


    static class Test {
        int num1 = 10;
        static int num2 = 20;

        public void print1() {                    // 非静态的成员方法可以访问静态的成员
            System.out.println(num1);
            System.out.println(num2);
        }

        public static void print2() {                // 静态方法不能访问非静态的成员
//            System.out.println(this.num1);
            System.out.println(num2);                // 静态只能访问静态
        }
    }

    /*  【static关键字的特点】

	• A:static关键字的特点
		○ a:随着类的加载而加载
		○ b:优先于对象存在
		○ c:被类的所有对象共享
			§ 举例：咱们班级的学生应该共用同一个班级编号。
			§ 其实这个特点也是在告诉我们什么时候使用静态?
				□ 如果某个成员变量是被所有对象共享的，那么它就应该定义为静态的。
			§ 举例：
				□ 饮水机(用静态修饰)
				□ 水杯(不能用静态修饰)
		○ copyFilesToOther:可以通过类名调用
			§ 其实它本身也可以通过对象名调用。
			§ 推荐使用类名调用。
			§ 静态修饰的内容一般我们称其为：与类相关的，类成员
     */




    /*  【static的注意事项】

	• a:在静态方法中是没有this关键字的
		○ 如何理解呢?
			§ 静态是随着类的加载而加载，this是随着对象的创建而存在。
			§ 静态比对象先存在。
	• b:静态方法只能访问静态的成员变量和静态的成员方法
		○ 静态方法：
			§ 成员变量：只能访问静态变量
			§ 成员方法：只能访问静态成员方法
		○ 非静态方法：
			§ 成员变量：可以是静态的，也可以是非静态的
			§ 成员方法：可是是静态的成员方法，也可以是非静态的成员方法。
		○ 简单记：
			§ 静态只能访问静态。
	• c:当一个类中所有的方法都是静态的，需要私有化该类的构造方法，目的是不让创造该类对象，节省内存
     */
}
