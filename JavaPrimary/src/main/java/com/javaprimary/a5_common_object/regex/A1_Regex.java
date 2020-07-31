package com.javaprimary.a5_common_object.regex;

/**
 * 正则表达式
 */
public class A1_Regex {

    public static void main(String[] args) {

        // 一般判断
        System.out.println(qq("1083447322"));

        // 正则表达式
        String regex = "[1-9][\\d]{4,14}";
        System.out.println("abcdef".matches(regex));
        System.out.println("2553868".matches(regex));
        System.out.println("012345".matches(regex));
        System.out.println("012345abcdef".matches(regex));
        System.out.println("1234567890987654".matches(regex));
    }

    /**
     * * 需求：校验qq号码.
     * 1:要求必须是5-15位数字
     * 2:0不能开头
     * 3:必须都是数字
     */
    public static boolean qq(String qq) {
        boolean flag = true;                        // 标记,不符合标准就改为false
        if (qq.length() >= 5 && qq.length() <= 15) {
            if (!qq.startsWith("0")) {
                char[] arr = qq.toCharArray();        // 将字符串转换成字符数组
                for (int i = 0; i < arr.length; i++) {
                    char temp = arr[i];
					/*if(temp >= '0' && temp <= '9') {

					}else {
						flag = false;
						break;
					}*/
                    if (!Character.isDigit(temp)) {    // 判断该字符是否是数字
                        flag = false;
                        break;
                    }
                }
            } else {
                flag = false;
            }
        } else {
            flag = false;
        }
        return flag;
    }





    /*  【正则表达式 】

    是指一个用来描述或者匹配一系列符合某个语法规则的字符串的单个字符串。其实就是一种规则。有自己特殊的应用。
     */
}
