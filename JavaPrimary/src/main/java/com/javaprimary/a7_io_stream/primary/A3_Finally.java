package com.javaprimary.a7_io_stream.primary;

/**
 * Finally 使用
 */
public class A3_Finally {

    public static void main(String[] args) {
        demo1();
        System.out.println(getNum());
    }

    public static void demo1() {
        try {
            System.out.println(1 / 0);
        } catch (Exception e) {
            System.out.println("catch 执行了吗");
            //System.exit(0);	// 如果先退出虚拟机就不会执行finally了
            return;                // return在将死之前,会让finally完成未完成的遗愿
        } finally {
            System.out.println("finally 执行了吗");
        }
    }

    // 测试 finally 面试题
    public static int getNum() {
        int x = 10;
        try {
            System.out.println(10 / 0);
            return x;                        // try和catch里面都应该 有return 语句,如果 try 没有检测到问题
        } catch (Exception e) {                // 不会跳转到 catch 里面去,那么需要 try 里面有返回
            x = 20;
            return x; // 这里先执行 return 将 x 是 20 的值返出去，再执行 finally 里的 x = 30
        } finally {
            x = 30;
            System.out.println("执行了吗");
            //return x;						// finally 可以写 return语句,但是不要这么写,因为会将结果改变
        }                                    // 将前面的返回值覆盖掉
    }



    /* 【finally 关键字的特点及作用】

	• A:finally 的特点
		○ 被 finally 控制的语句体一定会执行
		○ 特殊情况：在执行到 finally 之前 jvm 退出了(比如System.exit(0))

	• B:finally 的作用
	• 用于释放资源，在 IO 流操作和数据库操作中会见到
    */





    /* 【finally 关键字的面试题】

	• A:面试题1
		○ final,finally 和 finalize 的区别
			○ final 可以修饰类,方法,变量(常量)
			○ finally 写在 try catch 语句用于释放资源(关闭数据库,关闭流)
			○ finalize() 是一个方法,在垃圾回收的时候调用

	• B:面试题2
		○ 如果catch里面有return语句，请问finally的代码还会执行吗?如果会，请问是在return前还是return后。

			○ public static int getZeroNum() {
				int x = 10;
				try {
					System.out.println(10 / 0);
					return x;						// try和catch里面都应该有return语句,如果try没有检测到问题
				} catch (Exception e) {				// 不会跳转到catch里面去,那么需要try里面有返回
					x = 20;
					return x;
				}finally {
					x = 30;
					System.out.println("执行了吗");
					//return x;						// finally可以写return语句,但是不要这么写,因为会将结果改变
				}									// 将前面的返回值覆盖掉
            }
    */
}
