package com.javaprimary.b1_reflection;

public class A9_Enum {

    public static void main(String[] args) {
        // 自己实现
        Week mon = Week.MON;
        Week tue = Week.TUE;
        Week wed = Week.WED;
        System.out.println(mon.getName());
        System.out.println(tue.getName());
        System.out.println(wed.getName());

        Week2 week2 = Week2.TUE;
        week2.show();
        System.out.println(week2.getName());
        switch (week2) {    // 基本数据类型可以是byte,short,char,int

            // 引用数据类型,1.5是枚举,1.7是字符串
            case MON:
                System.out.println("Enum 星期一");
                break;
            case TUE:
                System.out.println("Enum 星期二");
                break;
        }
    }


    // 自己定义的枚举类
    static abstract class Week {
        public static final Week MON = new Week("星期一") {
            public void show() {
                System.out.println("星期一");
            }
        };
        public static final Week TUE = new Week("星期二") {
            public void show() {
                System.out.println("星期二");
            }
        };
        public static final Week WED = new Week("星期三") {
            public void show() {
                System.out.println("星期三");
            }
        };
        private String name;

        private Week(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public abstract void show();
    }


    // JDK 自带的枚举类
    enum Week2 {
        MON("星期一") {
            public void show() {
                System.out.println("name 星期一");
            }
        }, TUE("星期二") {
            public void show() {
                System.out.println("name 星期二");
            }
        }, WED("星期三") {
            public void show() {
                System.out.println("name 星期三");
            }
        };

        private String name;

        Week2(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public abstract void show();

	/*public String toString() {
		return name;
	}*/
    }


    public enum Week3 {
        MON,TUE
    }


    /* 【自己实现枚举类】

	• A:枚举概述
		○ 是指将变量的值一一列出来,变量的值只限于列举出来的值的范围内。举例：一周只有7天，一年只有12个月等。

	• B:回想单例设计模式：单例类是一个类只有一个实例
		○ 那么多例类就是一个类有多个实例，但不是无限个数的实例，而是有限个数的实例。这才能是枚举类。
    */





    /* 【枚举的注意事项】

		○ 定义枚举类要用关键字enum
		○ 所有枚举类都是Enum的子类
		○ 枚举类的第一行上必须是枚举项，最后一个枚举项后的分号是可以省略的，但是如果枚举类有其他的东西，这个分号就不能省
		  略。建议不要省略
		○ 枚举类可以有构造器，但必须是 private 的，它默认的也是 private 的。枚举项的用法比较特殊：枚举(“”);
		○ 枚举类也可以有抽象方法，但是枚举项必须重写该方法
		○ 枚举在 switch 语句中的使用
    */
}
