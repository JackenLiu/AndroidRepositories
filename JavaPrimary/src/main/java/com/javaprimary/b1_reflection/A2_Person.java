package com.javaprimary.b1_reflection;

/**
 * 测试反射 demo 的 A2_Person 类
 */
public class A2_Person {
    private String name;
    private int age;

    public A2_Person() {
        super();

    }

    public A2_Person(String name, int age) {
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
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + age;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        A2_Person other = (A2_Person) obj;
        if (age != other.age)
            return false;
        if (name == null) {
            return other.name == null;
        } else return name.equals(other.name);
    }

    @Override
    public String toString() {
        return "A2_Person [name=" + name + ", age=" + age + "]";
    }


    public void eat() {
        System.out.println("今天吃了一顿全聚德");
    }

    public void eat(int num) {
        System.out.println("今天吃了" + num + "顿金钱豹");
    }
}
