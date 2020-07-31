package com.javaprimary.a6_collection.set;


import java.util.Comparator;
import java.util.Objects;
import java.util.TreeSet;

/**
 * TreeSet 类
 */
//@RequiresApi(api = Build.VERSION_CODES.KITKAT)
public class A3_TreeSet {

    public static void main(String[] args) {
        // 测试 TreeSet 基本用法
        demo1();
        demo2();
        demo3();

        /*
        测试 Comparable 自然顺序
         */
        TreeSet<Person> ts = new TreeSet<>();
        ts.add(new Person("Tom", 23));
        ts.add(new Person("john", 28));
        ts.add(new Person("black", 13));
        ts.add(new Person("xxxxxx", 33));
        ts.add(new Person("xxxxxx", 33));
        ts.add(new Person("zzzzzz", 33));
        ts.add(new Person("wc", 53));
        ts.add(new Person("wc", 53));
        ts.add(new Person("ccav", 50));

        System.out.println(ts);

        /*
        测试 Comparator 比较器
         */
        TreeSet<String> strings = new TreeSet<>(new CompareByLen());
        strings.add("nba");
        strings.add("cba");
        strings.add("wnba");
        strings.add("czbk");
        strings.add("heima");
        strings.add("z");
        strings.add("aaaaaaaaaaaaaaaa");
        System.out.println(strings);
    }

    public static void demo1() {
        TreeSet<Integer> ts = new TreeSet<>();
        ts.add(5);
        ts.add(1);
        ts.add(3);
        ts.add(2);
        ts.add(2);
        ts.add(4);
        ts.add(4);
        System.out.println(ts);
    }

    public static void demo2() {
        TreeSet<String> ts = new TreeSet<>();
        ts.add("b");
        ts.add("c");
        ts.add("a");
        ts.add("copyFilesToOther");
        ts.add("e");
        System.out.println(ts);
    }

    public static void demo3() {
        TreeSet<Person> ts = new TreeSet<>();
        ts.add(new Person("张三", 23));
        ts.add(new Person("王五", 25));
        ts.add(new Person("李四", 24));
        ts.add(new Person("马哥", 24));
        ts.add(new Person("赵六", 26));

        System.out.println('张' + 0);                // 根据码表值排序
        System.out.println('李' + 0);
        System.out.println('王' + 0);
        System.out.println('赵' + 0);
        System.out.println('马' + 0);
        System.out.println(ts);
    }

    static class CompareByLen implements Comparator<String> {

        @Override
        public int compare(String s1, String s2) {            // 比较字符串的长度
            int num = s1.length() - s2.length();            // 长度作为主要条件
            return num == 0 ? s1.compareTo(s2) : num;        // 内容作为次要条件
        }

    }

    static class Person implements Comparable<Person> {
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


        @Override
        public int compareTo(Person o) {
            int num = this.name.length() - o.name.length();    // 长度作为主要条件
            int num2 = num == 0 ? this.name.compareTo(o.name) : num;// 姓名的内容作为次要条件
            return num2 == 0 ? this.age - o.age : num2;        // 年龄作为次要条件
        }
    }


    /* 【TreeSet 原理】

	• 1.特点
		○ TreeSet 是用来排序的, 可以指定一个顺序, 对象存入之后会按照指定的顺序排列

	• 2.使用方式
		○ a.自然顺序(Comparable)
			§ TreeSet类的 add() 方法中会把存入的对象提升为Comparable类型
			§ 调用对象的 compareTo() 方法和集合中的对象比较
			§ 根据 compareTo() 方法返回的结果进行存储

		○ b.比较器顺序(Comparator)
			§ 创建 TreeSet 的时候可以制定一个 Comparator
			§ 如果传入了 Comparator 的子类对象, 那么 TreeSet 就会按照比较器中的顺序排序
			§ add() 方法内部会自动调用 Comparator 接口中 compare() 方法排序

		○ c.两种方式的区别
			§ TreeSet 构造函数什么都不传, 默认按照类中 Comparable 的顺序(没有就报错ClassCastException)
			§ TreeSet 如果传入Comparator, 就优先按照 Comparator
    */
}
