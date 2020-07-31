package com.javaprimary.a5_common_object.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则表达式 各种功能
 */
public class A5_RegexFunction {

    public static void main(String[] args) {
        testSplit();
        testReplace();
        testGroup();
        testPattern();
    }


    // 测试分割
    public static void testSplit() {
        System.out.println("testSplit ----------");
        String s = "我..爱....java";
        String regex = "\\.+";                    // .是代表任意字符,不能直接用点切割,需要转义
        String[] arr = s.split(regex);            // 切割后返回的是字符串数组
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    // 测试替换
    public static void testReplace() {
        System.out.println("testReplace ----------");
        String s = "itcast";
        String regex = "[abc]";
        String s2 = s.replaceAll(regex, "oo");
        System.out.println(s2);
    }

    // 测试分组
    public static void testGroup() {
        System.out.println("testGroup ----------");
        //判断是否是叠词高高兴兴,快快乐乐
        String regex = "(.)\\1(.)\\2";  // （.）代表任何字符，\\1代表（.）这组再出现一次，\\2代表第二组
        System.out.println("不高兴兴".matches(regex)); // false
        System.out.println("快快乐乐".matches(regex)); // true

        //判断是否是叠词高兴高兴,快乐快乐,死啦死啦
        String regex1 = "(..)\\1";
        System.out.println("死啦死啦".matches(regex1)); // true
        System.out.println("1234".matches(regex1)); // false
        //出现四个一模一样的字符哈哈哈哈
        String regex2 = "(.)\\1{3}";
        System.out.println("1234".matches(regex2)); // false
        System.out.println("哈哈哈哈".matches(regex2)); // true
    }

    // 测试功能，Pattern 和 Matcher 的结合使用
    public static void testPattern() {
        System.out.println("testPattern ----------");
        Pattern p = Pattern.compile("a*b");            // 获取正则对象，a 出现多次，b 出现一次
        Matcher m = p.matcher("aaaaab");            // 获取匹配器
        boolean b = m.matches();
        System.out.println(b);

        // 获取电话号码
        String str = "我的电话号码是18511866260,曾经用过13887654321,还用过18912345678";
        String regex = "1[34578]\\d{9}";            // 第一个数字是1，第二个是34578任意一个，其余9个纯数字
        Pattern p1 = Pattern.compile(regex);            // 获取正则对象
        Matcher m1 = p1.matcher(str);                    // 获取匹配器

        boolean b1 = m1.find();
        System.out.println(b1);
        String s = m1.group();
        System.out.println(s);
        while (m1.find())                                // 调用 find 方法一次再调用，则查找下一个
            System.out.println(m1.group());
    }



    /*  【正则表达式的分割功能】

    String类的功能：public String[] split(String regex)
     */




    /*  【正则表达式的替换功能】

    String类的功能：public String replaceAll(String regex,String replacement)
     */




    /*  【分组功能】

		○ 捕获组可以通过从左到右计算其开括号来编号。例如，在表达式 ((A)(B(C))) 中，存在四个这样的组：
		    ○ 1     ((A)(B(C)))
            ○ 2     (A
            ○ 3     (B(C))
            ○ 4     (C)
        ○ 组零始终代表整个表达式。
     */





    /*  【获取功能】

    Pattern 和 Matcher 的结合使用
     */
}
