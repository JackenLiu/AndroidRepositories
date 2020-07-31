package com.javaprimary.a3_method;

/**
 * 方法重载
 */
public class A4_MethodOverload {

    public static void main(String[] args) {

        // 重载test()方法并测试
        A4_MethodOverload o = new A4_MethodOverload();
        System.out.println(o.test());
        o.test(1);
        System.out.println(o.test(1, "test3"));
        System.out.println(o.test("test4", 1));
    }

    public int test() {
        System.out.println("test1");
        return 1;
    }

    public void test(int a) {
        System.out.println("test2");
    }

    //以下两个参数类型顺序不同
    public String test(int a, String s) {
        System.out.println("test3");
        return "returntest3";
    }

    public String test(String s, int a) {
        System.out.println("test4");
        return "returntest4";
    }


    /*  【方法重载】

		○ 在同一个类中，方法名相同，参数列表不同。与返回值类型无关（即重载可以更改返回值类型），对权限没有要求。
		○ 参数列表不同：
			§ A:参数个数不同
			§ B:参数类型不同
			§ C:参数的顺序不同 (算重载,但是在开发中不用)
     */
}
