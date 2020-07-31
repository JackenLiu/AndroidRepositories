package com.javaprimary.b1_reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 反射获取类的方法和属性
 */
public class A5_ReflectionAcquire {

    public static void main(String[] args) throws NoSuchMethodException,
            IllegalAccessException, InvocationTargetException, InstantiationException,
            ClassNotFoundException, NoSuchFieldException {

//        testGetConstructor();
//        testGetVariable();
        testGetMethod();
    }

    // 测试获取构造方法
    public static void testGetConstructor() throws ClassNotFoundException, NoSuchMethodException,
            IllegalAccessException, InstantiationException, InvocationTargetException {
        Class<?> clazz = Class.forName("com.javaprimary.b1_reflection.A2_Person");

        //Person p = (Person) clazz.newInstance(); // 此方式如果注释了无参构造，无法获取
        //System.out.println(p);
        Constructor<?> c = clazz.getConstructor(String.class, int.class);    // 获取有参的构造
        A2_Person p = (A2_Person) c.newInstance("张三", 23);         // 通过有参构造创建对象

        System.out.println(p);
    }

    // 测试获取成员变量
    public static void testGetVariable() throws ClassNotFoundException, NoSuchMethodException,
            IllegalAccessException, InstantiationException, InvocationTargetException,
            NoSuchFieldException {

        Class<?> clazz = Class.forName("com.javaprimary.b1_reflection.A2_Person");
        Constructor<?> c = clazz.getConstructor(String.class, int.class);        // 获取有参的构造
        A2_Person p = (A2_Person) c.newInstance("张三", 23);             // 通过有参构造创建对象
        //Field f = clazz.getField("name");                   // 非私有使用次方法
        //f.set(p, "李四");
        Field f = clazz.getDeclaredField("name");       // 私有使用此方法
        f.setAccessible(true);                                                    // 去掉访问权限
        f.set(p, "李四");
        System.out.println(p);
    }

    // 测试获取方法
    public static void testGetMethod() throws ClassNotFoundException, NoSuchMethodException,
            IllegalAccessException, InstantiationException, InvocationTargetException {
        Class<?> clazz = Class.forName("com.javaprimary.b1_reflection.A2_Person");
        Constructor<?> c = clazz.getConstructor(String.class, int.class);        // 获取有参的构造
        A2_Person p = (A2_Person) c.newInstance("张三", 23);                // 通过有参构造创建对象
        //Method m = clazz.getMethod("eat");
        //m.invoke(p);          // 调用无参方法

        Method m = clazz.getMethod("eat", int.class);       // 调用有参方法
        m.invoke(p, 10);
    }

    /* 【通过反射获取带参构造方法并使用】

	• Constructor
		○ Class 类的 newInstance() 方法是使用该类无参的构造函数创建对象, 如果一个类没有无参的构造函数, 就不能这样创
		  建了,可以调用 Class 类的 getConstructor(String.class,int.class) 方法获取一个指定的构造函数然后再调用
		  Constructor 类的 newInstance("张三",20) 方法创建对象
    */




    /* 【通过反射获取成员变量并使用】

	• Field
		○ Class.getField(String) 方法可以获取类中的指定字段(可见的), 如果是私有的可以用
		  getDeclaedField("name") 方法获取,通过 set(obj, "李四") 方法可以设置指定对象上该字段的值, 如果是私有的
		  需要先调用 setAccessible(true) 设置访问权限,用获取的指定的字段调用 get(obj) 可以获取指定对象中该字段的值
    */




    /* 【通过反射获取方法并使用】

	• Method
		○ Class.getMethod(String, Class...) 和 Class.getDeclaredMethod(String, Class...)方法可以获取类
		  中的指定方法,调用invoke(Object, Object...)可以调用该方法,
		  Class.getMethod("eat") invoke(obj)
		  Class.getMethod("eat",int.class) invoke(obj,10)
    */
}
