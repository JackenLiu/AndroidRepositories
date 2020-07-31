package com.javaprimary.a5_common_object.string;

/**
 * String 获取功能
 */
public class A4_StringAcquire {

    public static void main(String[] args) {
        demo1();
        demo2();
        demo3();
        demo4();
        demo5();
    }

    public static void demo1() {
        System.out.println("testDate --------");
        String s1 = "abc";
        String s2 = "我是中国人";

        System.out.println(s1.length());            // 获取字符串中字符的个数
        System.out.println(s2.length());

        char c1 = s1.charAt(1);                        // 通过索引获取字符
        System.out.println(c1);
        char c2 = s2.charAt(3);
        System.out.println(c2);

        for (int i = 0; i < s2.length(); i++) {        // 字符串的遍历方式
            System.out.println(s2.charAt(i));
        }
    }

    public static void demo2() {
        System.out.println("testDateFormat --------");
        String s1 = "abcdefc";
        int index1 = s1.indexOf('c');    // 返回指定字符在此字符串中第一次出现处的索引。
        System.out.println(index1);

        int index2 = s1.indexOf("ce");    // 如果查找的字符串没有,返回-1
        System.out.println(index2);
    }

    public static void demo3() {
        System.out.println("testEquals --------");
        String s1 = "abcabcitcast";
        int index1 = s1.indexOf('c', 3);// 返回指定字符在此字符串中从指定位置后第一次出现处的索引。
        System.out.println(index1);

        int index2 = s1.indexOf("ca", 4);
        System.out.println(index2);
    }

    public static void demo4() {
        System.out.println("testIsEmpty --------");
        String s1 = "abcitcastabc";
        int index1 = s1.lastIndexOf('a');// 从后向前找,将字符对应的索引返回
        System.out.println(index1);

        int index2 = s1.lastIndexOf("ab");
        System.out.println(index2);

        int index3 = s1.lastIndexOf('a', 8);    // 从指定的位置向前找,第一次字符出现的索引
        System.out.println(index3);
    }

    public static void demo5() {
        System.out.println("testRemove --------");
        String s1 = "abcitcastabc";
        String s2 = s1.substring(3);        // 从指定位置开始截取字符串,默认到末尾。产生新的字符串
        System.out.println(s2);
        String s3 = s1.substring(3);// 包含头,不包含尾(左闭右开)
        System.out.println(s3);
    }


    /*  【String类的获取功能】

	• int length():
		○ 获取字符串的长度。

	• char charAt(int index):
		○ 获取指定索引位置的字符

	• int indexOf(int ch):
		○ 返回指定字符在此字符串中第一次出现处的索引。

	• int indexOf(String str):
		○ 返回指定字符串在此字符串中第一次出现处的索引。

	• int indexOf(int ch,int fromIndex):
		○ 返回指定字符在此字符串中从指定位置后第一次出现处的索引。

	• int indexOf(String str,int fromIndex):
		○ 返回指定字符串在此字符串中从指定位置后第一次出现处的索引。

	• lastIndexOf

	• String substring(int start):

		○ 从指定位置开始截取字符串,默认到末尾。

	• String substring(int start,int end):

		○ 从指定位置开始到指定位置结束截取字符串。
     */
}
