package com.javaprimary.a6_collection.map;

import java.util.Collection;
import java.util.HashMap;

/**
 * Map 集合
 */
public class A1_Map {

    public static void main(String[] args) {
        testAdd();
        testRemove();
        testJudge();
        testGet();
    }

    public static void testAdd() {
        System.out.println("testAdd ----------");
        HashMap<String, String> hm = new HashMap<>();
        String s1 = hm.put("张三", "北京");            // 第一次存储返回的是null
        String s2 = hm.put("张三", "上海");            // 第二次存储返回的是被覆盖的值
        String s3 = hm.put("李四", "广州");            // HashMap的键是唯一的
        String s4 = hm.put("李四", "深圳");
        String s5 = hm.put("王五", "深圳");            // HashMap的值不是唯一的

        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        System.out.println(s4);
        System.out.println(hm);
    }

    public static void testRemove() {
        System.out.println("testRemove ----------");
        HashMap<String, String> hm = new HashMap<>();
        hm.put("张三", "北京");
        hm.put("李四", "上海");
        hm.put("王五", "广州");
        hm.put("赵六", "北京");
        System.out.println(hm);
        //hm.clear();
        String value = hm.remove("张三");        // 根据键删除,返回的是键对应的值
        System.out.println(value);
        System.out.println(hm);
    }

    public static void testJudge() {
        System.out.println("testJudge ----------");
        HashMap<String, String> hm = new HashMap<>();
        hm.put("张三", "北京");
        hm.put("李四", "上海");
        hm.put("王五", "广州");
        hm.put("赵六", "北京");
        boolean b1 = hm.containsKey("张三");                // 判断是否包含指定的键
        boolean b2 = hm.containsKey("xxx");
        System.out.println(b1);
        System.out.println(b2);
        boolean b3 = hm.containsValue("北京");            // 判断是否包含指定的值
        boolean b4 = hm.containsValue("深圳");
        System.out.println(b3);
        System.out.println(b4);
        boolean b5 = hm.isEmpty();                        // 判断集合是否为空
        hm.clear();
        boolean b6 = hm.isEmpty();
        System.out.println(b5);
        System.out.println(b6);
        System.out.println(hm);
    }

    public static void testGet() {
        System.out.println("testGet ----------");
        HashMap<String, String> hm = new HashMap<>();
        hm.put("张三", "北京");
        hm.put("李四", "上海");
        hm.put("王五", "广州");
        hm.put("赵六", "北京");
        String value = hm.get("xx");                    // 根据键获取值,如果没有指定的键返回null
        System.out.println(value);
        Collection<String> c = hm.values();                // 获取所有值
        System.out.println(c);

        System.out.println(hm.size());                    // 获取键值对的个数
    }


    /* 【Map集合概述和特点】

	• A:Map接口概述
		○ 查看API可以知道
		○ 将键映射到值的对象
		○ 一个映射不能包含重复的键
		○ 每个键最多只能映射到一个值

	• B:Map 接口和 Collection 接口的不同
		○ Map 是双列的,Collection 是单列的
		○ Map 的键唯一,Collection 的子体系 Set 是唯一的
		○ Map 集合的数据结构值针对键有效，跟值无关; Collection 集合的数据结构是针对元素有效
    */




    /* 【Map集合的功能概述】

	• A:Map集合的功能概述
		○ a:添加功能
			§ V put(K key,V value):添加元素。
				□ 如果键是第一次存储，就直接存储元素，返回null
				□ 如果键不是第一次存在，就用值把以前的值替换掉，返回以前的值

		○ b:删除功能
			§ void clear():移除所有的键值对元素
			§ V remove(Object key)：根据键删除键值对元素，并把值返回

		○ c:判断功能
			§ boolean containsKey(Object key)：判断集合是否包含指定的键
			§ boolean containsValue(Object value):判断集合是否包含指定的值
			§ boolean isEmpty()：判断集合是否为空

		○ copyFilesToOther:获取功能
			§ Set<Map.Entry<K,V>> entrySet():???
			§ V get(Object key):根据键获取值
			§ Set keySet():获取集合中所有键的集合
			§ Collection values():获取集合中所有值的集合

		○ e:长度功能
			§ int size()：返回集合中的键值对的个数
    */
}
