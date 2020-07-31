package com.javaprimary.a6_collection.map;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Objects;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Map 集合练习
 */
//@RequiresApi(api = Build.VERSION_CODES.KITKAT)
public class A3_MapPractice {

    public static void main(String[] args) {
        testHashMapKey();
        testCheckEachCharNum();
        testPlayPoker();
    }

    // 模拟玩牌
    public static void testPlayPoker() {
        // 买一副牌
        String[] num = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"};
        String[] color = {"方片", "梅花", "红桃", "黑桃"};
        HashMap<Integer, String> hm = new HashMap<>();            // 存储索引和扑克牌
        ArrayList<Integer> list = new ArrayList<>();            // 存储索引
        int index = 0;                                            // 索引的开始值
        for (String s1 : num) {
            for (String s2 : color) {
                hm.put(index, s2.concat(s1));                    //将索引和扑克牌添加到HashMap中
                list.add(index);                                //将索引添加到ArrayList集合中
                index++;
            }
        }
        hm.put(index, "小王");
        list.add(index);
        index++;
        hm.put(index, "大王");
        list.add(index);
        //洗 牌
        Collections.shuffle(list);
        // 发牌
        TreeSet<Integer> gaojin = new TreeSet<>();
        TreeSet<Integer> longwu = new TreeSet<>();
        TreeSet<Integer> me = new TreeSet<>();
        TreeSet<Integer> dipai = new TreeSet<>();

        for (int i = 0; i < list.size(); i++) {
            if (i >= list.size() - 3) {
                dipai.add(list.get(i));                        // 将list集合中的索引添加到TreeSet集合中会自动排序
            } else if (i % 3 == 0) {
                gaojin.add(list.get(i));
            } else if (i % 3 == 1) {
                longwu.add(list.get(i));
            } else {
                me.add(list.get(i));
            }
        }

        // 看牌
        lookPoker("高进", gaojin, hm);
        lookPoker("龙五", longwu, hm);
        lookPoker("冯佳", me, hm);
        lookPoker("底牌", dipai, hm);
    }

    // HashMap 想保证键的唯一依赖于 hashCode() 和 equals 方法
    public static void testHashMapKey() {
        HashMap<Person, String> hm = new HashMap<>();
        hm.put(new Person("张三", 23), "北京");
        hm.put(new Person("张三", 23), "北京");
        hm.put(new Person("李四", 24), "上海");
        System.out.println(hm);
    }

    // 统计字符串中每个字符出现的次数
    public static void testCheckEachCharNum() {
        String str = "zzzzzzaawnaabbbcccsssfjjhkccccccjhc";
        char[] arr = str.toCharArray();                        // 将字符串转换成字符数组
        TreeMap<Character, Integer> hm = new TreeMap<>();    // 创建双列集合存储键和值

        for (char c : arr) {                                    // 遍历字符数组
			/*if(!hm.containsKey(c)) {						// 如果不包含这个键
				hm.put(c, 1);								// 就将键和值为1添加
			}else {											// 如果包含这个键
				hm.put(c, hm.get(c) + 1);					// 就将键和值再加1添加进来
			}*/

            hm.put(c, !hm.containsKey(c) ? 1 : hm.get(c) + 1);
        }

        for (Character key : hm.keySet()) {                    // 遍历双列集合
            System.out.println(key + "=" + hm.get(key));
        }
    }


    private static class Person {
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Person person = (Person) o;
            return age == person.age &&
                    Objects.equals(name, person.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, age);
        }
    }

    public static void lookPoker(String name, TreeSet<Integer> ts, HashMap<Integer, String> hm) {
        System.out.print(name + "的牌是:");
        for (Integer index : ts) {
            System.out.print(hm.get(index) + " ");
        }

        System.out.println();
    }
}
