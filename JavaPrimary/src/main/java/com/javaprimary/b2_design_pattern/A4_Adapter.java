package com.javaprimary.b2_design_pattern;

/**
 * 适配器设计模式
 */
public class A4_Adapter {

    public static void main(String[] args) {

    }

    interface 和尚 {

        void 念经();

        void 练武();
    }

    // 此为适配器类
    abstract class 天罡星 implements 和尚 {

        @Override
        public void 念经() {
        }

        @Override
        public void 练武() {
        }

    }

    /*
    定义花和尚类,花和尚不适合念经,只练武

    花和尚只适配了天罡星的练武
     */
    class 花和尚 extends 天罡星 {
        public void 练武() {
            System.out.println("倒拔垂杨柳");
            System.out.println("拳打镇关西");
            System.out.println("...");
        }
    }

    /*
    如果没有天罡星适配器,会把念经继承下来

    不适配
     */
    class 花和尚1 implements 和尚 {

        @Override
        public void 念经() {

        }

        @Override
        public void 练武() {

        }
    }



    /* 【适配器设计模式】

	• a.什么是适配器
		○ 在使用监听器的时候, 需要定义一个类事件监听器接口.
		○ 通常接口中有多个方法, 而程序中不一定所有的都用到, 但又必须重写, 这很繁琐.
		○ 适配器简化了这些操作, 我们定义监听器时只要继承适配器, 然后重写需要的方法即可.

	• b.适配器原理
		○ 适配器就是一个类, 实现了监听器接口, 所有抽象方法都重写了, 但是方法全是空的.
		○ 目的就是为了简化程序员的操作, 定义监听器时继承适配器, 只重写需要的方法就可以了.
    */
}
