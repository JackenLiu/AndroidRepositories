package com.javaprimary.a5_common_object.string;

/**
 * String 其他功能
 */
public class A6_StringOther {

    public static void main(String[] args) {
        demo1();
        demo2();
        demo3();
        demo4();
    }

    public static void demo1() {
        System.out.println("testDate --------");
        String s = "itcast";
        // 替换,将已有字符替换,如果没有被替换的字符,打印原字符串
        String s2 = s.replace('z', 'o');
        System.out.println(s2);

        String s3 = s.replace("cas", "ooo");
        System.out.println(s3);
    }

    public static void demo2() {
        System.out.println("testDateFormat --------");
        String s = "    itcast    ";
        String s2 = s.trim();                    // 去除前后空格
        System.out.println(s2);
    }

    public static void demo3() {
        System.out.println("testEquals --------");
        String s1 = "a";
        String s2 = "aaaa";
        // 按照码表值比较两个字符串的大小
        // 如果两个字符串中的字符一样,个数不一样比较长度，长度 1 - 4 = -3
        int x = s1.compareTo(s2);
        System.out.println(x);
        // a 是97，c 是99，所以是 97 - 99 = -2
        System.out.println("a".compareTo("c"));
    }

    public static void demo4() {
        System.out.println("testIsEmpty --------");
        String s1 = "A";
        String s2 = "a";
        System.out.println(s1.compareToIgnoreCase(s2));    // 比较的时候不区分大小写
    }




    /*  【String类的其他功能】

	• A:String的替换功能及案例演示
		○ String replace(char old,char new)
		○ String replace(String old,String new)

	• B:String的去除字符串头尾空格
		○ String trim()

	• C:String的按字典顺序比较两个字符串及案例演示
		○ int compareTo(String str)(暂时不用掌握)
			§ 按照码表值比较两个字符串的大小
			§ 如果两个字符串中的字符一样,个数不一样比较长度

		○ int compareToIgnoreCase(String str)
     */
}
