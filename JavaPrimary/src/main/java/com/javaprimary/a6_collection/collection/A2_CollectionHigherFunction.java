package com.javaprimary.a6_collection.collection;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Collection 集合高级功能
 */
public class A2_CollectionHigherFunction {

    public static void main(String[] args) {
        testAddAll();
        testContainsAll();
        testRemoveAll();
        testRetainAll();
    }

    public static void testAddAll() {
        System.out.println("testAddAll ------------");
        Collection coll1 = new ArrayList();
        coll1.add("a");
        coll1.add("b");
        coll1.add("c");
        coll1.add("copyFilesToOther");

        Collection coll2 = new ArrayList();
        coll2.add("e");
        coll2.add("f");
        coll2.add("g");
        coll2.add("h");
        //[a, b, c, copyFilesToOther, e, f, g, h]
        coll1.addAll(coll2);                // 将集合对象中的每个对象遍历添加到调用集合对象中
//        coll1.add(coll2);					// 将整个集合对象当作一个对象,添加到调用的集合中

        System.out.println(coll1);
        System.out.println(coll1.size());
    }

    public static void testContainsAll() {
        System.out.println("testContainsAll ------------");
        Collection coll1 = new ArrayList();
        coll1.add("a");
        coll1.add("b");
        coll1.add("c");
        coll1.add("copyFilesToOther");

        Collection coll2 = new ArrayList();
        coll2.add("a");
        coll2.add("b");
        coll2.add("c");
        coll2.add("copyFilesToOther");

        Collection coll3 = new ArrayList();
        coll2.add("z");

        boolean b1 = coll1.containsAll(coll2);            // 判断调用的集合是否包含传入的集合
        System.out.println(b1);
        System.out.println(coll1.containsAll(coll3));
    }

    public static void testRemoveAll() {
        System.out.println("testRemoveAll ------------");
        Collection coll1 = new ArrayList();
        coll1.add("a");
        coll1.add("b");
        coll1.add("c");
        coll1.add("copyFilesToOther");

        Collection coll2 = new ArrayList();
        coll2.add("a");
        coll2.add("b");
        coll2.add("z");

        boolean b1 = coll1.removeAll(coll2);            // 删除的是交集,两个集合有交集返回true,并删除交集部分
        System.out.println(b1);
        System.out.println(coll1);
    }

    public static void testRetainAll() {
        System.out.println("testRetainAll ------------");
        Collection coll1 = new ArrayList();
        coll1.add("a");
        coll1.add("b");
        coll1.add("c");
        coll1.add("copyFilesToOther");

        Collection coll2 = new ArrayList();
        coll2.add("x");
        coll2.add("y");
        coll2.add("a");

        boolean b1 = coll1.retainAll(coll2);        // 取交集,看调用的集合是否改变,如果没有改变返回false,如果改变返回true
        System.out.println(b1);
        System.out.println(coll1);
    }



    /*  【Collection集合的高级功能测试】

    boolean addAll(Collection c)
    boolean removeAll(Collection c)
        删除的是交集
    boolean containsAll(Collection c)
    boolean retainAll(Collection c)
        取交集，取完交集后看调用的集合是否改变,如果没有改变返回false,如果改变返回true
     */
}
