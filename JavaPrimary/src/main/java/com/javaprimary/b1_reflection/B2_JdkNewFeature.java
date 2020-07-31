package com.javaprimary.b1_reflection;

/**
 * JDK 新特性
 */
public class B2_JdkNewFeature {

    public static void main(String[] args) {
        System.out.println(0b110);
        System.out.println(100_000_000);

//        Inter.show();
    }

    // JDK 8 可以定义
    /*interface Inter {
        public default void print() {    // JDK 8 在接口可以定义有方法体的方法，但是要加 default
            System.out.println();
        }

        public static void print() {    // JDK 8 在接口可以定义静态的有方法体的方法
            System.out.println();
        }
    }
*/



    /* 【JDK7 的六个新特性回顾和讲解】

	• A:二进制字面量
	• B:数字字面量可以出现下划线
		• System.out.println(100_000_000);
	• C:switch 语句可以用字符串
	• D:泛型简化,菱形泛型
	• E:异常的多个catch合并,每个异常用或隔开
	• F:try-with-resources 语句
    */



    /* 【JDK8的新特性】

	• 接口中可以定义有方法体的方法,如果是非静态,必须用default修饰，如果是静态的就不用了
    • 局部内部类可以使用它存在的方法的局部变量，不需要加 final
    */
}
