package com.javaprimary.a4_object_oriented.polymorphism;

/**
 * 多态
 */
public class A1_Polymorphism {

    public static void main(String[] args) {

        // 多态的好处例子，水果的多种形态
        Juicer juicer = new Juicer();
        juicer.run(new Apple());
        juicer.run(new Orange());
    }

    static class Fruit {
        public void juicing() {
            System.out.println("榨水果汁儿");
        }
    }

    static class Apple extends Fruit {
        public void juicing() {
            System.out.println("榨了一杯苹果汁儿");
        }
    }

    static class Orange extends Fruit {
        public void juicing() {
            System.out.println("榨了一杯橙子汁儿");
        }
    }

    static class Juicer {
	/*public void run(Apple a) {		//Apple a = new Apple();
		a.juicing();
	}

	public void run(Orange o) {
		o.juicing();
	}*/

        public void run(Fruit f) {        //Fruit f = new Apple();
            f.juicing();
        }
    }



    /*  【多态的概述及其代码体现】

	• A:多态概述
		○ 事物存在的多种形态

	• B:多态前提
		○ a:要有继承关系。
		○ b:要有方法重写。
		○ c:要有父类引用指向子类对象。
     */



    /*  【多态的好处和弊端】

	• A:多态的好处
		○ a:提高了代码的维护性(继承保证)
		○ b:提高了代码的扩展性(由多态保证)

	• B:多态的弊端
		○ 父类不能使用子类的特有功能，需要向下转型。
     */
}
