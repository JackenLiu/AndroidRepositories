package com.javaprimary.a6_collection.set;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * Set 集合练习
 */
public class A4_SetPractice {

    public static void main(String[] args) {
        sortStudentByScore();
    }


    // 5个学生信息(姓名,语文成绩,数学成绩,英语成绩),按照总分从高到低输出
    public static void sortStudentByScore() {
        TreeSet<Student> ts = new TreeSet<>(new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                int num = s2.getSum() - s1.getSum();            //根据学生的总成绩降序排列
                return num == 0 ? 1 : num;
            }
        });

        ts.add(new Student("看来是", 35, 67, 43));
        ts.add(new Student("顺丰大概", 100, 57, 24));
        ts.add(new Student("风格和", 70, 90, 22));
        ts.add(new Student("单个", 100, 100, 13));
        ts.add(new Student("的光和热", 54, 53, 43));

        System.out.println("排序后的学生成绩是:");
        for (Student s : ts) {
            System.out.println(s);
        }
    }


    public static class Student {
        private String name;
        private int chinese;
        private int math;
        private int english;
        private int sum;

        public Student() {
            super();

        }

        public Student(String name, int chinese, int math, int english) {
            super();
            this.name = name;
            this.chinese = chinese;
            this.math = math;
            this.english = english;
            this.sum = this.chinese + this.math + this.english;
        }

        public int getSum() {
            return sum;
        }

        //姓名,语文成绩,数学成绩,英语成绩
        @Override
        public String toString() {
            return name + ", " + chinese + ", " + math + ", " + english + ", " + sum;
        }


    }

}
