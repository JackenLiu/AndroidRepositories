package com.javaprimary.a7_io_stream.primary;

/**
 * 异常概述
 */
public class A1_Exception {

    public static void main(String[] args) {
        singleException();
        moreException();
        testThrowableMethod();
    }

    public static void testThrowableMethod() {
        try {
            System.out.println(1 / 0);        // new ArithmeticException("/ by zero");
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());        // 获取异常信息
            System.out.println(e.toString());            // 错误类名+异常信息
            // 错误类名+异常信息+错误位置(行号)jvm 默认处理异常使用此方法
            e.printStackTrace();
        }
    }

    public static void singleException() {
        Demo d = new Demo();
        try {
            int x = d.div(10, 0);
            System.out.println(x);
        } catch (ArithmeticException e) { // ArithmeticException e = new ArithmeticException(" / by zero")
            System.out.println("除数为零了");
        }
    }

    public static void moreException() {
        int a = 10;
        int b = 0;
        int[] arr = {11, 22, 33};

        try {
            System.out.println(a / b);
            System.out.println(arr[5]);
            arr = null;
            System.out.println(arr[0]);
        } catch (ArithmeticException e) {
            System.out.println("除数为零了");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("出问题了");
        }

        //1.7 版本的异常处理,注意不能子父类同时放
        /*try {
            //System.out.println(a / b);
            System.out.println(arr[5]);

        } catch (ArithmeticException | ArrayIndexOutOfBoundsException e) {
            System.out.println("除数为零了");
        } catch (Exception e3) {
            System.out.println("出问题了");
        }*/


        System.out.println("over");
    }

    static class Demo {
        public int div(int a, int b) {//a = 10,b = 0
            return a / b;            // 除数不能为0
            // 除数为0后,创建一个异常对象 new ArithmeticException(" / by zero")
        }
    }



    /* 【异常的概述和分类】

	• A:异常的概述
		○ 异常就是Java程序在运行过程中出现的错误。

	• B:异常的分类
		○ 通过API查看Throwable
		○ Error
			§ 服务器宕机,数据库崩溃等
		○ Exception C:异常的继承体系
		○ Throwable
			§ Error
			§ Exception
				□ RuntimeException
    */





    /* 【JVM 默认是如何处理异常的】

	• A:JVM默认是如何处理异常的
		○ testDeadLock 函数收到这个问题时,有两种处理方式:
			§ a:自己将该问题处理,然后继续运行
			§ b:自己没有针对的处理方式,只有交给调用 testDeadLock 的 jvm 来处理
		○ jvm 有一个默认的异常处理机制,就将该异常进行处理.
		○ 并将该异常的名称,异常的信息.异常出现的位置打印在了控制台上,同时将程序停止运行
    */





    /* 【异常的注意事项及如何使用异常处理】

	• A:异常注意事项
		○ a:子类重写父类方法时，子类的方法必须抛出相同的异常或父类异常的子类。(父亲坏了,儿子不能比父亲更坏)
		○ b:如果父类抛出了多个异常,子类重写父类时,只能抛出相同的异常或者是他的子集,子类不能抛出父类没有的异常
		○ c:如果被重写的方法没有异常抛出,那么子类的方法绝对不可以抛出异常,如果子类方法内有异常发生,那么子类只能try,不能
		    throws


	• B:如何使用异常处理
		○ 原则:如果该功能内部可以将问题处理,用 try,如果处理不了,交由调用者处理,这是用 throws
		○ 区别:
			§ 后续程序需要继续运行就 try
			§ 后续程序不需要继续运行就 throws
		○ 如果JDK没有提供对应的异常，需要自定义异常。
    */
}
