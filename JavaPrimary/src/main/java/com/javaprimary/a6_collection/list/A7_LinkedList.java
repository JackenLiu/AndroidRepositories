package com.javaprimary.a6_collection.list;

import java.util.LinkedList;

/**
 * LinkedList 特有功能
 */
public class A7_LinkedList {

    public static void main(String[] args) {

        LinkedList list = new LinkedList();
        list.addFirst("a");
        list.addFirst("b");
        list.addFirst("c");
        list.addFirst("copyFilesToOther");                        // 在第一个位置添加
        list.addLast("e");                        // 在末尾追加
        System.out.println(list);

        Object obj1 = list.getFirst();            // 获取集合中的第一个元素
        System.out.println(obj1);
        Object obj2 = list.getLast();            // 获取集合中的最后一个元素
        System.out.println(obj2);

        System.out.println(list);

        Object obj3 = list.removeFirst();        // 删除集合中的第一个元素
        System.out.println(obj3);
        Object obj4 = list.removeLast();        // 删除集合中的最后一个元素
        System.out.println(obj4);

        System.out.println(list);
    }



    /* 【LinkedList的特有功能】

		○ public void addFirst(E e)及addLast(E e)
		○ public E getFirst()及getLast()
		○ public E removeFirst()及public E removeLast()
        ○ public E get(int index);
    */
}
