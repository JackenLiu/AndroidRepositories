package com.javaprimary.a4_object_oriented;

/**
 * 代码块
 */
public class A3_CodeBlock {

    static {
        System.out.println("Demo1Code");
    }

    public static void main(String[] args) {
        {                                    //局部代码块,开发不用
            int x = 10;                        //限定变量的生命周期
            System.out.println(x);
        }

        Person p1 = new Person();
        p1.name = "张三";
        p1.age = 23;

        System.out.println("-------------------------");
        Person p2 = new Person("李四", 24);

    }

    static {
        System.out.println("Demo1Code222222222222");
    }
}

class Person {
    String name;
    int age;

    public Person() {
        //cry();
        System.out.println("空参构造");
    }

    public Person(String name, int age) {
        //cry();
        this.name = name;
        this.age = age;
        System.out.println("有参构造");
    }

    {                                            // 构造代码块(初始化块),开发很少用
        System.out.println("构造代码块");        // 构造代码块的作用,当对象具备相同的属性或相同的行为
        cry();                                    // 就需要在每个构造函数中定义相同的属性或行为,那么太麻烦
    }                                            // 都在构造代码块中定义即可

    static {                                    // 静态代码块是随着类的加载而加载,而且只执行一次
        System.out.println("静态代码块");        // 静态代码块是优先于主方法执行的
    }                                            // 静态代码块的作用,用于加载驱动

    public void cry() {
        System.out.println("哇哇!!!");
    }




    /*  【代码块概述】

    在Java中，使用{}括起来的代码被称为代码块。
     */




    /*  【常见代码块的应用】

	• a:局部代码块
		○ 在方法中出现；限定变量生命周期，及早释放，提高内存利用率
	• b:构造代码块
		○ 在类中方法外出现；多个构造方法方法中相同的代码存放到一起，每次调用构造都执行，并且在构造方法前执行
	• c:静态代码块
		○ 在类中方法外出现，加了static修饰
		○ 在类中方法外出现，并加上static修饰；用于给类进行初始化，如加载驱动。在加载的时候就执行，并且只执行一次。
     */
}
