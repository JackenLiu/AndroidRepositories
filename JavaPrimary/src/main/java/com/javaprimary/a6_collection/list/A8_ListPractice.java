package com.javaprimary.a6_collection.list;

import java.util.ArrayList;
import java.util.List;

/**
 * List 集合练习
 */
public class A8_ListPractice {

    public static void main(String[] args) {

        /*
        元素排序练习
         */
        // 字符类型
        List<String> list1 = new ArrayList<>();
        list1.add("b");
        list1.add("f");
        list1.add("e");
        list1.add("c");
        list1.add("a");
        list1.add("copyFilesToOther");
        sort(list1);
        System.out.println(list1);    // a, b, c, copyFilesToOther, e, f
        // int 类型
        List<Integer> list2 = new ArrayList<>();
        list2.add(5);
        list2.add(8);
        list2.add(3);
        list2.add(1);
        list2.add(4);

        sort(list2);
        System.out.println(list2); // 1,3,4,5,8
    }


    // 将集合中的元素排序，Comparable 代表继承或实现该类的引用数据类型都可以作为集合的参数
    public static <E extends Comparable<E>> void sort(List<E> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i).compareTo(list.get(j)) > 0) {
                    // 更换位置，将集合中的两个元素交换位置
                    E e = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, e);
                }
            }
        }
    }


    /* 【集合中的元素排序】

    枚举：
        继承 Comparable ，代表继承或实现该类的引用数据类型都可以作为集合的参数
     */
}
