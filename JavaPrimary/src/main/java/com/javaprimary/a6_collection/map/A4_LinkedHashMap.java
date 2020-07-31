package com.javaprimary.a6_collection.map;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * LinkedHashMap 类
 */
public class A4_LinkedHashMap {

    public static void main(String[] args) {
        /*
        LinkedHashMap的特点 ：
          • 底层是链表实现的可以保证怎么存就怎么取
         */

        HashMap<String, Integer> hm = new LinkedHashMap<>();                        // 怎么存就怎么取
        hm.put("张三", 23);
        hm.put("李四", 24);
        hm.put("王五", 25);
        hm.put("赵六", 26);

        System.out.println(hm);
    }
}
