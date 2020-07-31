package com.javaprimary.a5_common_object.regex;

/**
 * 正则表达式 面试题
 */
public class A6_RegexInterviewTitle {

    public static void main(String[] args) {

        // 需求：请按照叠词切割： "sdqqfgkkkhjppppkl";
        String regex = "(.)\\1+"; // 代表叠词出现一次以上
        String s = "sdqqfgkkkhjppppkl";
        String[] arr = s.split(regex);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }


        /*
        需求：我我....我...我.要...要要...要学....学学..学.编..编编.编.程.程.程..程
		将字符串还原成:“我要学编程”。
         */
        String s1 = "我我....我...我.要...要要...要学....学学..学.编..编编.编.程.程.程..程";
        String s2 = s1.replaceAll("\\.+", "");             // \\.代表点，+ 代表一次或多次
        String s3 = s2.replaceAll("(.)\\1+", "$1");        //$是获取对应组中的字符
        System.out.println(s3);
    }
}
