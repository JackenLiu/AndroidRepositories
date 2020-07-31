package com.javaprimary.a6_collection.list;

import java.util.ArrayList;
import java.util.List;

/**
 * List 基本功能
 */
public class A1_ListPrimaryFunction {

    public static void main(String[] args) {
        testAdd();
        testAddAll();
        demo3();
        testRemove();
        demo5();
        testForTraversal();
    }

    public static void testAdd() {
        System.out.println("testAdd --------------");
        List list = new ArrayList();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("copyFilesToOther");

        list.add(1, "z");                    // 在指定位置添加元素
        list.add(4, "z");
        System.out.println(list);
    }

    public static void testAddAll() {
        System.out.println("testAddAll --------------");
        List list1 = new ArrayList();
        list1.add("a");
        list1.add("b");
        list1.add("c");
        list1.add("copyFilesToOther");

        List list2 = new ArrayList();
        list2.add("e");
        list2.add("f");
        list2.add("g");
        list2.add("h");

        list1.addAll(1, list2);                // 在指定位置向调用的集合中添加集合
        System.out.println(list1);
    }

    public static void demo3() {
        System.out.println("testJudge --------------");
        List list = new ArrayList();
        list.add("a");
        list.add("b");
        list.add("b");
        list.add("c");
        list.add("copyFilesToOther");

        Object obj = list.get(1);                // 通过索引获取集合中的元素,如果索引不存在会抛出IndexOutOfBoundsException
        System.out.println(obj);

        int index = list.indexOf("b");            // 通过对象获取索引
        System.out.println(index);

        int index2 = list.lastIndexOf("b");        // 从后向前遍历,获取对象的索引
        System.out.println(index2);
    }

    public static void testRemove() {
        System.out.println("testRemove --------------");
        List list = new ArrayList();
        list.add("a");
        list.add("b");
        list.add("b");
        list.add("b");
        list.add("c");
        list.add("copyFilesToOther");

        Object obj = list.remove(1);        // 根据索引删除,返回被删除的对象
        System.out.println(obj);
        System.out.println(list);

        boolean b1 = list.remove("b");        // 根据对象删除
        System.out.println(b1);

        System.out.println(list);
    }

    public static void demo5() {
        System.out.println("demo5 --------------");
        List list = new ArrayList();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("copyFilesToOther");
        list.add("e");
        list.add("f");

        list.set(1, "z");                        // 在指定位置修改
        List newList = list.subList(2, 4);        // 截取子集合,包含头,不包含尾
        System.out.println(list);
        System.out.println(newList);
    }

    // 测试 for 循环遍历
    public static void testForTraversal() {
        System.out.println("testForTraversal --------------");
        List list = new ArrayList();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("copyFilesToOther");
        list.add("e");

        //这种遍历只支持list集合,set集合不可以,因为set集合无索引
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));                //根据索引获取值
        }
    }



    /*  【List集合的特有功能概述和测试】

	• A:List集合的特有功能概述
		○ void add(int index,E element)
		○ E remove(int index)
		○ E get(int index)
		○ E set(int index,E element)
     */




    /*  【List集合的特有遍历功能】

    通过size()和get()方法结合使用遍历。
     */
}
