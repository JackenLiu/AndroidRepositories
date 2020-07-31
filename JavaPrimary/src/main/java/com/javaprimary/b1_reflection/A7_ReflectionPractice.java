package com.javaprimary.b1_reflection;

import java.lang.reflect.Field;

/**
 * 反射应用练习
 */
public class A7_ReflectionPractice {

    public static void main(String[] args) throws Exception {
        Student s = new Student();
        System.out.println(s);

        setProperty(s, "name", "李四");
        setProperty(s, "age", 24);

        System.out.println(s);
    }

    // 此方法可将 obj 对象中名为 propertyName 的属性的值设置为 value 。
    public static void setProperty(Object obj, String propertyName, Object value) throws Exception {
        Class<?> clazz = obj.getClass();                    // 获取到该对象的字节码对象
        Field f = clazz.getDeclaredField(propertyName);        // 暴力获取该字段的名字
        f.setAccessible(true);                                // 去除权限
        f.set(obj, value);                                    // 修改属性值
    }

    static class Student {
        private String name;
        public int age;

        public String toString() {
            return name + " ," + age;
        }
    }

    /* 【通过反射写一个通用的设置某个对象的某个属性为指定的值】

	• A:案例演示
		○ public void setProperty(Object obj, String propertyName, Object value){}，
		  此方法可将 obj 对象中名为 propertyName 的属性的值设置为 value。
    */
}
