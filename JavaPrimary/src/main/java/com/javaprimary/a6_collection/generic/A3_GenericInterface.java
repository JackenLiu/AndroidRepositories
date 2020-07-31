package com.javaprimary.a6_collection.generic;

/**
 * 泛型接口
 */
public class A3_GenericInterface {

    public static void main(String[] args) {

        Demo2 demo2 = new Demo2();
        demo2.show("111");
    }

    // 指定类型，开发推荐
    public static class Demo2 implements Inter<String> {
        @Override
        public void show(String s) {
            System.out.println(s);
        }
    }

    // 把泛型也继承下来了
    public class Demo1<T> implements Inter<T> {
        @Override
        public void show(T t) {
        }

    }

    // 没有指定类型则重写的方法默认为 object
    public class Demo implements Inter {
        @Override
        public void show(Object o) {

        }
    }

    // 泛型接口定义
    interface Inter<T> {
        void show(T t);
    }


    /* 【泛型接口的概述和使用】

    • A:泛型接口概述
		○ 把泛型定义在接口上

	• B:定义格式
		○ public interface 接口名<泛型类型>
    */
}
