package com.javaprimary.a6_collection.map;

import java.util.HashMap;
import java.util.Hashtable;

/**
 * Hashtable 类
 */
public class A6_Hashtable {

    public static void main(String[] args) {

        Hashtable<String, String> ht = new Hashtable<>();
//        ht.put("abc", null);
        System.out.println(ht);
        HashMap<String, String> hm = new HashMap<>();
        hm.put("abc", null);
        System.out.println(hm);

    }



    /* 【HashMap 和 Hashtable 的区别】

	• Hashtable 是 JDK1.0 版本出现的,是线程安全的,效率低,HashMap 是JDK1.2 版本出现的,是线程不安全的,效率高
    • Hashtable 不可以存储 null 键和 null 值,HashMap 可以存储 null 键和 null 值
    */
}
