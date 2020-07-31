package com.javaprimary.a6_collection.map;

import java.util.HashMap;
import java.util.Map;

/**
 * Map 遍历
 */
public class A2_MapTraversal {

    public static void main(String[] args) {

        traversalKey();
        testEntry();

    }

    // Map集合的遍历之键找值
    public static void traversalKey() {
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("张三", 23);
        hm.put("李四", 24);
        hm.put("王五", 25);
        hm.put("赵六", 26);

		/*Set<String> keySet = hm.keySet();			// 获取集合中所有的键
		Iterator<String> it = keySet.iterator();	// 获取迭代器
		while(it.hasNext()) {						// 判断单列集合中是否有元素
			String key = it.next();					// 获取集合中的每一个元素,其实就是双列集合中的键
			Integer value = hm.get(key);			// 根据键获取值
			System.out.println(key + "=" + value);	// 打印键值对
		}*/

        for (String key : hm.keySet()) {                // 增强for循环迭代双列集合第一种方式
            System.out.println(key + "=" + hm.get(key));
        }
    }

    // Map集合的遍历之键值对对象找键和值
    public static void testEntry() {
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("张三", 23);
        hm.put("李四", 24);
        hm.put("王五", 25);
        hm.put("赵六", 26);
		/*Set<Map.Entry<String, Integer>> entrySet = hm.entrySet();	// 获取所有的键值对象的集合
		Iterator<Entry<String, Integer>> it = entrySet.iterator();// 获取迭代器
		while(it.hasNext()) {
			Entry<String, Integer> en = it.next();				// 获取键值对对象
			String key = en.getKey();								// 根据键值对对象获取键
			Integer value = en.getValue();							// 根据键值对对象获取值
			System.out.println(key + "=" + value);
		}*/

        for (Map.Entry<String, Integer> en : hm.entrySet()) {
            System.out.println(en.getKey() + "=" + en.getValue());
        }
    }



    /* 【Map集合的遍历之键找值】

	• A:键找值思路：
		○ 获取所有键的集合
		○ 遍历键的集合，获取到每一个键
		○ 根据键找值
    */




    /* 【Map集合的遍历之键值对对象找键和值】

	• A:键值对对象找键和值思路：
		○ 获取所有键值对对象的集合
		○ 遍历键值对对象的集合，获取到每一个键值对对象
		○ 根据键值对对象找键和值
    */
}
