package com.javaprimary.a6_collection.set;

import java.util.LinkedHashSet;

/**
 * LinkedHashSet 类
 */
public class A2_LinkedHashSet {

    public static void main(String[] args) {
        LinkedHashSet<String> lh = new LinkedHashSet<>();        //可以怎么存就怎么取
        lh.add("a");
        lh.add("a");
        lh.add("b");
        lh.add("c");
        lh.add("copyFilesToOther");

        System.out.println(lh);
    }


    /* 【LinkedHashSet的概述和使用】

	• A:LinkedHashSet的特点
		○ HashSet 子类
		○ 保证顺序存入的元素有顺序性

	• B:案例演示
		○ LinkedHashSet的特点
		○ 可以保证怎么存就怎么取
    */
}
