package com.javaprimary.a6_collection.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * List 迭代器 ListIterator
 */
public class A2_ListIterator {

    public static void main(String[] args) {
        demo1();
        demo2();
    }

    public static void demo1() {
        List list = new ArrayList();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("copyFilesToOther");
        list.add("e");

        ListIterator lit = list.listIterator();
        while (lit.hasNext()) {
            System.out.println(lit.next());
        }

        System.out.println("----------------------");
        while (lit.hasPrevious()) {                        //倒着遍历
            System.out.println(lit.previous());
        }
    }

    public static void demo2() {
        List list = new ArrayList();
        list.add("a");
        list.add("b");
        list.add("world");
        list.add("copyFilesToOther");
        list.add("e");

        Iterator it = list.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (str.equals("world")) {
//                list.add("javaee");            // 这里会抛出ConcurrentModificationException并发修改异常
            }
        }

        // 如果想在遍历的过程中添加元素,可以用 ListIterator 中的 add 方法
        ListIterator lit = list.listIterator();
        while (lit.hasNext()) {
            String str = (String) lit.next();
            if (str.equals("world")) {
                lit.add("javaee");
                //list.add("javaee");
            }
        }
        System.out.println(list);
    }



    /*  【ListIterator】

    • boolean hasNext()是否有下一个
	• boolean hasPrevious()是否有前一个
	• Object next()返回下一个元素
    • Object previous();返回上一个元素
     */



    /*  【并发修改异常产生的原因及解决方案】
	• A:案例演示
		○ 在 List 集合进行遍历的过程中使用 List 的 add 等方法修改元素个数

	• B:ConcurrentModificationException出现
		○ 迭代器遍历，集合修改集合

	• C:解决方案
		○ a:迭代器迭代元素，迭代器修改元素(ListIterator的特有功能add)
		○ b:集合遍历元素，集合修改元素
     */
}
