package com.javaprimary.b2_design_pattern;

/**
 * 装饰设计模式
 */
public class A1_Decorator {

    public static void main(String[] args) {
        Car car = new Car();
        car.move();

        System.out.println("增加新的功能，飞行--------------");
        FlyCar flyCar = new FlyCar(car);
        flyCar.move();

        System.out.println("增加新的功能，水上游--------------");
        WaterCar waterCar = new WaterCar(car);
        waterCar.move();

        // 装饰模式的优点在此，要结合两种子类 “飞行”，“水上游” 的类型的车不用创新新的子类，直接像下面代码调用就行
        System.out.println("增加两个新的功能：飞行，水上游----------------");
        WaterCar waterCar2 = new WaterCar(new FlyCar(car));
        waterCar2.move();
    }

    // Component 抽象构件角色
    public interface ICar {
        void move();
    }

    // ConcreteComponent 具体构件角色(真实对象)
    static class Car implements ICar {
        @Override
        public void move() {
            System.out.println("陆地上跑！");
        }
    }

    // Decorator 装饰角色
    static class SuperCar implements ICar {
        protected ICar car;

        public SuperCar(ICar car) {
            super();
            this.car = car;
        }

        @Override
        public void move() {
            car.move();
        }
    }

    // ConcreteDecorator 具体装饰角色
    static class FlyCar extends SuperCar {

        public FlyCar(ICar car) {
            super(car);
        }

        public void fly() {
            System.out.println("天上飞！");
        }

        @Override
        public void move() {
            super.move();
            fly();
        }
    }

    // ConcreteDecorator 具体装饰角色
    static class WaterCar extends SuperCar {

        public WaterCar(ICar car) {
            super(car);
        }

        public void swim() {
            System.out.println("水上游！");
        }

        @Override
        public void move() {
            super.move();
            swim();
        }
    }

    // ConcreteDecorator 具体装饰角色
    class AICar extends SuperCar {

        public AICar(ICar car) {
            super(car);
        }

        public void autoMove() {
            System.out.println("自动跑！");
        }

        @Override
        public void move() {
            super.move();
            autoMove();
        }
    }




    /* 【什么是装饰模式】

    • 动态的为一个对象增加新的功能
    • 装饰器是一种代替继承的技术,无需通过继承增加子类就能扩展对象的新功能.使用对象的关联关系代替继承关系,更加灵活,同时避
      免类型体系的快速膨胀
    */
}
