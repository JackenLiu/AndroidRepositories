package com.javaprimary.a6_collection;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Collections 工具类
 */
public class A2_Collections {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("c");
        list.add("a");
        list.add("b");
        list.add("e");
        list.add("copyFilesToOther");

        Collections.sort(list);                        // 排序
        int index = Collections.binarySearch(list, "c");// 二分查找法
        String max = Collections.max(list);            // 获取最大值
        System.out.println(index);
        System.out.println(list);
        System.out.println(max);

        Collections.reverse(list);                    // 将集合进行反转
        System.out.println(list);
        Collections.shuffle(list);                  // 随机进行排序
        System.out.println(list);
    }





    /* 【Collections 工具类的概述和常见方法讲解】

	• A:Collections类概述
		○ 针对集合操作 的工具类

	• B:Collections成员方法
		○ public static <T> void sort(List<T> list)
        ○ public static <T> int binarySearch(List<?> list,T key)
        ○ public static <T> T max(Collection<?> coll)
        ○ public static void reverse(List<?> list)
        ○ public static void shuffle(List<?> list)
    */
}
