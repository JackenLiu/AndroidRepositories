package com.javaprimary.a6_collection.collection;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Collection 集合基本功能
 */
public class A1_CollectionPrimaryFunction {

    public static void main(String[] args) {
        testAdd();
        testContains();
        testEquals();
        testIsEmpty();
        testRemove();
        testSize();
        testToArrays1();
        testToArrays2();
    }

    public static void testAdd() {
        System.out.println("testAdd ------------");
        Collection coll = new ArrayList();
        boolean b1 = coll.add(1);                // new Integer(1);自动装箱
        boolean b4 = coll.add(1);                // new Integer(1);自动装箱
        boolean b2 = coll.add("abc");
        boolean b3 = coll.add(new Student("马哥", 18));

        System.out.println(b1);
        System.out.println(b2);
        System.out.println(b3);
        System.out.println(b4);

        System.out.println(coll);                // ArrayList的间接父类重写了toString方法
    }

    public static void testContains() {
        System.out.println("testContains ------------");
        Collection coll = new ArrayList();
        coll.add("a");
        coll.add("b");
        coll.add("c");
        coll.add("copyFilesToOther");
        //coll.clear();							// 清空集合
        boolean b1 = coll.contains("a");        // 判断是否包含传入的元素,包含返回true
        boolean b2 = coll.contains("e");
        System.out.println(b1);
        System.out.println(b2);
        System.out.println(coll);
    }

    public static void testEquals() {
        System.out.println("testEquals ------------");
        Collection coll1 = new ArrayList();
        coll1.add("a");
        coll1.add("b");
        coll1.add("c");
        coll1.add("copyFilesToOther");

        boolean b1 = coll1.equals("abcd");        // equals不是集合和元素之间的比较
        System.out.println(b1); // false

        Collection coll2 = new ArrayList();
        coll2.add("a");
        coll2.add("b");
        coll2.add("c");
        coll2.add("copyFilesToOther");

        boolean b2 = coll1.equals(coll2);        // 集合和集合之间的比较,元素一样,顺序一致返回true
        System.out.println(b2); // true
    }

    public static void testIsEmpty() {
        System.out.println("testIsEmpty ------------");
        Collection coll = new ArrayList();
        boolean b1 = coll.isEmpty();            // 判断集合是否为空,为空返回true
        System.out.println(b1);

        coll.add("a");
        boolean b2 = coll.isEmpty();
        System.out.println(b2);
    }

    public static void testRemove() {
        System.out.println("testRemove ------------");
        Collection coll = new ArrayList();
        coll.add("a");
        coll.add("b");
        coll.add("c");
        coll.add("copyFilesToOther");

        boolean b1 = coll.remove("b");            // 删除成功返回true
        boolean b2 = coll.remove("z");

        System.out.println(b1);
        System.out.println(b2);
    }

    public static void testSize() {
        System.out.println("testSize ------------");
        Collection coll = new ArrayList();
        coll.add("a");
        coll.add("b");
        coll.add("c");
        coll.add("copyFilesToOther");

        System.out.println(coll.size());        //返回集合中元素个数
    }

    public static void testToArrays1() {
        System.out.println("testToArrays1 ------------");
        Collection coll = new ArrayList();
        coll.add("a");
        coll.add("b");
        coll.add("c");
        coll.add("copyFilesToOther");

        Object[] arr = coll.toArray();            // 集合转化成数组

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void testToArrays2() {
        System.out.println("testToArrays2 ------------");
        Collection coll = new ArrayList();
        coll.add(new Student("张三", 23));                // Object obj = new Student("张三",23)
        coll.add(new Student("李四", 24));
        coll.add(new Student("王五", 25));
        coll.add(new Student("赵六", 26));

        Object[] arr = coll.toArray();                // 将集合转换成数组
        for (int i = 0; i < arr.length; i++) {
            Student s = (Student) arr[i];            // 强转成Student
            System.out.println(s.getName() + "," + s.getAge());
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




    /*  【Collection集合的基本功能测试】

        boolean add(E e)
        boolean remove(Object o)
        void clear()
        boolean contains(Object o)
        boolean isEmpty()
        int size()
        Object[] toArray()
     */




    /*  【集合的遍历之集合转数组遍历】

	• A:集合的遍历
		○ 其实就是依次获取集合中的每一个元素。
        ○ 把集合转成数组，可以实现集合的遍历
     */
}
