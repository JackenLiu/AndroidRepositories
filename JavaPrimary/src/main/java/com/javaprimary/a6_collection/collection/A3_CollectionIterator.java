package com.javaprimary.a6_collection.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * Collection 迭代器
 */
public class A3_CollectionIterator {

    public static void main(String[] args) {
        demo1();
        demo2();
        demo3();
    }

    public static void demo1() {
        System.out.println("testAdd -------------");
        Collection c = new ArrayList();
        c.add("a");
        c.add("b");
        c.add("c");
        c.add("copyFilesToOther");

        Iterator it = c.iterator();
        boolean b1 = it.hasNext();
        Object obj1 = it.next();
        System.out.println(b1);
        System.out.println(obj1);

        boolean b2 = it.hasNext();            // alt + shift + r 改名
        Object obj2 = it.next();
        System.out.println(b2);
        System.out.println(obj2);

        boolean b3 = it.hasNext();
        Object obj3 = it.next();            // NoSuchElementException找不到元素异常
        System.out.println(b3);
        System.out.println(obj3);
    }

    public static void demo2() {
        System.out.println("testAddAll -------------");
        Collection c = new ArrayList();
        c.add("a");
        c.add("b");
        c.add("c");
        c.add("copyFilesToOther");

        Iterator it = c.iterator();                        // 获取迭代器的引用
        while (it.hasNext()) {                            // 集合中的迭代方法(遍历)
            System.out.println(it.next());
        }
    }

    public static void demo3() {
        System.out.println("testJudge -------------");
        Collection c = new ArrayList();

        c.add(new Student("张三", 23));
        c.add(new Student("李四", 24));
        c.add(new Student("王五", 25));
        c.add(new Student("赵六", 26));
        c.add(new Student("赵六", 26));

        for (Iterator it = c.iterator(); it.hasNext(); ) {
            Student s = (Student) it.next();                        // 向下转型
            System.out.println(s.getName() + "," + s.getAge());    // 获取对象中的姓名和年龄
        }
        System.out.println("------------------------------");
        Iterator it = c.iterator();                                // 获取迭代器
        while (it.hasNext()) {                                    // 判断集合中是否有元素

            // 此句运行出错，因为迭代器获取了两次next()，不是同一个对象的属性，故遍历到到最后一个的时候出错
//            System.out.println(((Student)(it.next())).getName() + "," + ((Student)(it.next())).getAge());
            Student s = (Student) it.next();                        // 向下转型
            System.out.println(s.getName() + "," + s.getAge());    // 获取对象中的姓名和年龄
        }
    }

    private static class Student {
        private String name;
        private int age;

        public Student(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }





    /*  【集合的遍历之迭代器遍历】

	• A:迭代器概述
           集合是用来存储元素,存储的元素需要查看,那么就需要迭代(遍历)
	• A:迭代器原理
            迭代器原理:迭代器是对集合进行遍历,而每一个集合内部的存储结构都是不同的,所以每一个集合存和取都是不一样,那么
            就需要在每一个类中定义 hasNext() 和 next() 方法,这样做是可以的,但是会让整个集合体系过于臃肿,迭代器是将
            这样的方法向上抽取出接口,然后在每个类的内部,定义自己迭代方式,这样做的好处有二,第一规定了整个集合体系的遍历
            方式都是hasNext()和next()方法,第二,代码有底层内部实现,使用者不用管怎么实现的,会用即可
     */
}
