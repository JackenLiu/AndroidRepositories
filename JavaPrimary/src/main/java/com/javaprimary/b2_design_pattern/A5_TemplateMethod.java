package com.javaprimary.b2_design_pattern;

/**
 * 模板设计模式
 */
public class A5_TemplateMethod {

    public static void main(String[] args) {
        /*
        普通实现
         */
        long start = System.currentTimeMillis();                // 记录开始时间
        for (int i = 0; i < 10000; i++) {
            System.out.print("x");
            if (i == 9999) {
                System.out.println();
            }
        }
        long end = System.currentTimeMillis();                  // 记录结束时间

        System.out.println(end - start);

        /*
        模板设计模式
         */
        Demo d = new Demo();
        System.out.println(d.getTime());
    }


    // 获取代码执行时间
    static abstract class GetTime {
        public final long getTime() {
            long start = System.currentTimeMillis();                // 记录开始时间
            code();
            long end = System.currentTimeMillis();                  // 记录结束时间

            return end - start;
        }

        public abstract void code();

    }

    static class Demo extends GetTime {

        @Override
        public void code() {
            int i = 0;
            while (i < 10000) {
                System.out.print("x");
                i++;
                if (i == 9999) {
                    System.out.println();
                }
            }
        }
    }



    /* 【模版设计模式概述和使用】

	• A:模版设计模式概述
		○ 模版方法模式就是定义一个算法的骨架，而将具体的算法延迟到子类中来实现

	• B:优点和缺点
		○ a:优点
			§ 使用模版方法模式，在定义算法骨架的同时，可以很灵活的实现具体的算法，满足用户灵活多变的需求
		○ b:缺点
            § 如果算法骨架有修改的话，则需要修改抽象类
    */
}
