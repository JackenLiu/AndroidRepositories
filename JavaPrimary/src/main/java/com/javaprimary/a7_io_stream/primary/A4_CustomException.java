package com.javaprimary.a7_io_stream.primary;

/**
 * 自定义异常
 */
public class A4_CustomException {

    public static void main(String[] args) throws AgeOutOfBoundsException {
        Person p = new Person();
        p.setAge(-18);
        p.setName("张三");

        System.out.println(p.getName() + "," + p.getAge());
    }


    class Fu {
        public void print() {
            System.out.println("Fu");
        }
    }

    class Zi extends Fu {
        public void print() {

            System.out.println("Zi");
        }
    }


    public static class Person {
        private String name;
        private int age;

        public Person() {
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

        public void setAge(int age) throws AgeOutOfBoundsException {
            if (age > 0 && age < 200) {
                this.age = age;
            } else {
                //System.out.println("年龄错误");
                //throw new Exception("年龄错误");
                throw new AgeOutOfBoundsException("年龄非法");
            }
        }

        @Override
        public String toString() {
            return "Person [name=" + name + ", age=" + age + "]";
        }


    }

    public static class AgeOutOfBoundsException extends Exception {
        public AgeOutOfBoundsException() {
            super();
        }

        public AgeOutOfBoundsException(String message) {
            super(message);
        }
    }


    /* 【自定义异常概述和基本使用】

	• A:为什么需要自定义异常
		○ 举例：人的年龄

	• B:自定义异常概述
		○ 继承自Exception
		○ 继承自RuntimeException

	• C:案例演示
		○ 自定义异常的基本使用
		○ 继承 Exception 后重写构造方法，传入 message
    */
}
