package com.javaprimary.b2_design_pattern;

/**
 * 工厂设计模式
 */
public class A3_FactoryMethod {

    public static void main(String[] args) {
//        testSimpleFactory();

        // 测试工厂方法模式
        DogFactory df = new DogFactory();
        Animal a = df.createAnimal();
        a.eat();
    }

    // 测试简单工厂模式
    public static void testSimpleFactory() {
        // 初级
        Dog d = AnimalFactory.createDog();                    // 获取狗对象
        Cat c = AnimalFactory.createCat();
        d.eat();
        c.eat();

        // 改进
        Animal a1 = AnimalFactory.createAnimal("dog");
        a1.eat();

        Animal a2 = AnimalFactory.createAnimal("cat");
        a2.eat();

        Animal a3 = AnimalFactory.createAnimal("pig");
        if (a3 != null) {
            a3.eat();
        } else {
            System.out.println("没有这个动物");
        }
    }

    // 工厂方法模式,子类工厂
    public static class DogFactory implements Factory {

        @Override
        public Animal createAnimal() {
            return new Dog();
        }

    }

    // 工厂方法模式,工厂原型
    interface Factory {
        Animal createAnimal();
    }

    // 简单工厂模式,动物工厂
    static class AnimalFactory {
        private AnimalFactory() {
        }                    //不让其他类创建本类对象

        // 创建一个狗对象
        public static Dog createDog() {
            return new Dog();
        }

        // 创建一个猫对象
        public static Cat createCat() {
            return new Cat();
        }

        //改进
        public static Animal createAnimal(String name) {
            if (name.equals("dog")) {
                return new Dog();
            } else if (name.equals("cat")) {
                return new Cat();
            } else {
                return null;
            }
        }
    }

    static abstract class Animal {
        public abstract void eat();
    }

    static class Cat extends Animal {

        @Override
        public void eat() {
            System.out.println("猫吃鱼");
        }

    }

    static class Dog extends Animal {

        @Override
        public void eat() {
            System.out.println("狗吃肉");
        }

    }




    /* 【简单工厂模式概述和使用】

    A:简单工厂模式概述
	    • 又叫静态工厂方法模式，它定义一个具体的工厂类负责创建一些类的实例

    B:优点
	    • 客户端不需要在负责对象的创建，从而明确了各个类的职责

    C:缺点
	    • 这个静态工厂类负责所有对象的创建，如果有新的对象增加，或者某些对象的创建方式不同，就需要不断的修改工厂类，不利
	    于后期的维护
    */




    /* 【工厂方法模式】

	• A:工厂方法模式概述
		○ 工厂方法模式中抽象工厂类负责定义创建对象的接口，具体对象的创建工作由继承抽象工厂的具体类实现。

	• B:优点
		○ 客户端不需要在负责对象的创建，从而明确了各个类的职责，如果有新的对象增加，只需要增加一个具体的类和具体的工厂类
		  即可，不影响已有的代码，后期维护容易，增强了系统的扩展性

	• C:缺点
		○ 需要额外的编写代码，增加了工作量
    */
}
