package com.javaprimary.a7_io_stream.primary;

/**
 * throws 的使用
 */
public class A2_Throws {

    public static void main(String[] args) throws Exception {
        Test t = new Test();
        int x = t.div(10, 0);
        System.out.println(x);
    }

    static class Test {
        public int div(int a, int b) throws Exception {
            return a / b;
        }
    }


    /* 【throws 的方式处理异常】

	• A: throws 的方式处理异常
		○ 定义功能方法时，需要把出现的问题暴露出来让调用者去处理。
		○ 那么就通过 throws 在方法上标识。
    */




    /* 【throw 的概述以及和 throws 的区别】

    • A:throw的概述
		○ 在功能方法内部出现某种情况，程序不能继续运行，需要进行跳转时，就用 throw 把异常对象抛出。

	• B:案例演示
		○ 分别演示编译时异常对象和运行时异常对象的抛出

	• C: throws 和 throw 的区别
		○ 如果在方法内抛出的异常对象是一个编译时异常,在方法上必须用 throws 声明异常信息
		○ 如果在方法内抛出的异常对象是一个运行时异常,在方法上不用抛出

		○ a: throws
			§ 用在方法声明后面，跟的是异常类名
			§ 可以跟多个异常类名，用逗号隔开
			§ 表示抛出异常，由该方法的调用者来处理
		○ b: throw
			§ 用在方法体内，跟的是异常对象名
			§ 只能抛出一个异常对象名
			§ 表示抛出异常，由方法体内的语句处理
    */
}
