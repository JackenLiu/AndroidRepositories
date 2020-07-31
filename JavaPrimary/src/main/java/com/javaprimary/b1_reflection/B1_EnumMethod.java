package com.javaprimary.b1_reflection;

/**
 * 枚举常见方法
 */
public class B1_EnumMethod {

    public static void main(String[] args) {

        // 获取枚举的编号
        Week2 mon1 = Week2.MON;
        Week2 tue1 = Week2.TUE;
        Week2 wed1 = Week2.WED;
        System.out.println(mon1.ordinal());
        System.out.println(tue1.ordinal());
        System.out.println(wed1.ordinal());

        Week2 mon = Week2.MON;
        Week2 tue = Week2.TUE;
        Week2 wed = Week2.WED;

        // 比的是编号
        int x = mon.compareTo(tue);
        System.out.println(x);

        // 名称
        System.out.println(mon.name());
        System.out.println(mon.toString());

        // 获取枚举项的值
        mon = Week2.valueOf(Week2.class, "MON");
        System.out.println(mon);

        Week2[] arr = Week2.values();                        // 获取所有的枚举值
        for (Week2 w : arr) {                                // 遍历打印
            System.out.println(w);
            System.out.println(w.getName());
        }
    }

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



    /* 【枚举类的常见方法】

		○ int ordinal()
			§ 枚举序号
		○ int compareTo(E o)
			§ 比的是编号
		○ String name()
			§ 枚举项名
		○ String toString()
			§ 默认返回枚举项名
		○ T valueOf(Class type,String name)
			§ 枚举项的值
		○ values()
			§ 此方法虽然在JDK文档中查找不到，但每个枚举类都具有该方法，它遍历枚举类的所有枚举值非常方便
    */
}
