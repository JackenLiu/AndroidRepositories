package com.javaprimary.b1_reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * 越过泛型
 */
public class A6_AcrossGenericity {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException,
            InvocationTargetException, IllegalAccessException {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(111);
        list.add(222);
        list.add(333);
        list.add(444);

        Class<?> clazz = Class.forName("java.util.ArrayList");
        Method m = clazz.getMethod("add", Object.class);
        Object obj = m.invoke(list, "abc");
        System.out.println(obj);                                    // 打印的是 add 方法的返回值
        System.out.println(list);
    }


    /* 【通过反射越过泛型检查】

	• A:案例演示
		○ ArrayList的一个对象，在这个集合中添加一个字符串数据，如何实现呢？
		○ 泛型是在编译时期检查的,但是在运行期会被擦除掉
    */
}
