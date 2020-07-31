package com.javaprimary.a6_collection.set;


import java.util.HashSet;
import java.util.Objects;

/**
 * HashSet 类的使用
 */
//@RequiresApi(api = Build.VERSION_CODES.KITKAT)
public class A1_HashSet {

    public static void main(String[] args) {
        demo1();
        demo2();

        HashSet<Person> hs = new HashSet<>();
        hs.add(new Person("张三", 23));
        hs.add(new Person("张三", 23));
        hs.add(new Person("李四", 23));
        hs.add(new Person("赵六", 23));
        System.out.println(hs);
    }

    public static void demo2() {
        HashSet<String> hs = new HashSet<>();
        hs.add("a");
        hs.add("b");
        hs.add("c");
        hs.add("copyFilesToOther");
        System.out.println(hs);
    }

    public static void demo1() {
        HashSet<String> hs = new HashSet<>();
        boolean b1 = hs.add("a");
        boolean b2 = hs.add("a");            // 当存储不成功的时候,返回false
        System.out.println(b1);
        System.out.println(b2);
        System.out.println(hs);
    }


    static class Person {
        private String name;
        private int age;

        public Person() {
            super();

        }

        public Person(String name, int age) {
            super();
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
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

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }





    /* 【HashSet如何保证元素唯一性的原理】

    	• 1.HashSet原理
		    ○ 我们使用 Set 集合都是需要去掉重复元素的, 如果在存储的时候逐个 equals() 比较, 效率较低,哈希算法提高了
		      去重复的效率, 降低了使用equals()方法的次数
		    ○ 当 HashSet 调用 add() 方法存储对象的时候, 先调用对象的 hashCode() 方法得到一个哈希值, 然后在集合中
		      查找是否有哈希值相同的对象
			§ 如果没有哈希值相同的对象就直接存入集合
			§ 如果有哈希值相同的对象, 就和哈希值相同的对象逐个进行 equals() 比较,比较结果为 false 就存入, true则不
			  存

	    • 2.将自定义类的对象存入 HashSet 去重复
		    ○ 类中必须重写 hashCode() 和 equals() 方法
		    ○ hashCode(): 属性相同的对象返回值必须相同, 属性不同的返回值尽量不同(提高效率，编译工具提供自动生成)
		    ○ equals(): 属性相同返回true, 属性不同返回false,返回false的时候存储
    */
}
