package com.javaprimary.a3_method;

/**
 * 方法重写
 */
public class A5_MethodOverwrite {

    public static void main(String[] args) {
        Zi z = new Zi();
        z.show1();
        z.show2();

    }


    static class Fu {
        public void show1() {
            System.out.println("show1");
        }
    }

    static class Zi extends Fu {

        public void show1() {                        // 方法的复写(重写)
//            super.show1();                           // 语句都需要定义在方法中
            System.out.println("Zi show1");          // 如果子父类方法构成重写,想访问父类的方法需要用super.
        }

        public void show2() {
            System.out.println("show2");
        }

    }



    /*  【方法重写】

    子类中的成员方法对继承父类的成员方法中的内容进行扩展或更改，叫做方法的重写。
    当子类需要父类的功能，而功能主体子类有自己特有内容时，可以重写父类中的方法。这样，即沿袭了父类的功能，又定义了子类特有
    的内容。

	• 方法重写两种方式：
		○ 子类方法对父类方法进行扩展，需加 super 调用父类，再加扩展内容
		○ 子类方法直接对父类方法进行修改

	○ A:方法重写注意事项
		○ a:父类中私有方法不能被重写
			○ 因为父类私有方法子类根本就无法继承
		○ b:子类重写父类方法时，访问权限不能更低
			○ 最好就一致
		○ c:父类静态方法，子类也必须通过静态方法进行重写
			○ 其实这个算不上方法重写，但是现象确实如此，至于为什么算不上方法重写，多态中会讲解(静态只能覆盖静态)
        ○ copyFilesToOther:子类重写父类方法的时候，最好声明一模一样。
     */
}
