package com.javaprimary.a5_common_object.stringBuffer;

/**
 * StringBuffer 各种功能
 */
public class A2_StringBufferFunction {

    public static void main(String[] args) {

        testAppend();
        testInsert();
        testDelete();
        testReplace();
        testSubstring();
    }

    // 测试 append 添加
    public static void testAppend() {                    // 添加,在尾部追加
        System.out.println("testAppend --------");
        StringBuffer sb = new StringBuffer();
        StringBuffer sb2 = sb.append(true);
        StringBuffer sb3 = sb.append(123);
        StringBuffer sb4 = sb.append("大家好");    // 四个引用指向的是同一个对象

        System.out.println(sb);                    // 调用了 StringBuffer 的 toString 方法
        System.out.println(sb2);
        System.out.println(sb3);
        System.out.println(sb4);
    }

    // 测试 insert 添加
    public static void testInsert() {                    // 添加
        System.out.println("testInsert --------");
        StringBuffer sb = new StringBuffer("itcast");
        sb.insert(1, true);                            // 在指定位置添加
        System.out.println(sb);
    }

    // 测试删除
    public static void testDelete() {
        System.out.println("testDelete --------");
        StringBuffer sb = new StringBuffer("itcast");
        sb.deleteCharAt(1);                        // 删除指定索引位置的字符
        System.out.println(sb);

        sb.delete(1, 3);                            // 删除,包含头不包含尾
        System.out.println(sb);
        sb.delete(0, sb.length());                // 清空缓冲区
        System.out.println(sb);
        sb = new StringBuffer();                    // 重新创建对象
        System.out.println(sb);
    }

    // 测试替换和反转
    public static void testReplace() {
        System.out.println("testReplace --------");// 替换和反转
        StringBuffer sb = new StringBuffer("画上荷花花和尚画");
        sb.replace(2, 4, "oo");                    // 替换
        System.out.println(sb);
        sb.reverse();                                // 反转,将缓冲区的字符反转
        System.out.println(sb);
    }

    // 测试 Substring
    public static void testSubstring() {
        System.out.println("testSubstring --------");
        StringBuffer sb = new StringBuffer("itcast");
        String s = sb.substring(1);
        System.out.println(s);
        // 截取字符串,包含头,不包含尾 ctrl + 1 可以根据右边的方法或变量生成左边的返回值类型和对象名
        String s1 = sb.substring(2, 4);
        System.out.println(s1);
        System.out.println(sb);
    }




    /*  【StringBuffer 的添加功能】

	• A:StringBuffer 的添加功能
		○ public StringBuffer append(String str):
			§ 可以把任意类型数据添加到字符串缓冲区里面,并返回字符串缓冲区本身

		○ public StringBuffer insert(int offset,String str):
			§ 在指定位置把任意类型的数据插入到字符串缓冲区里面,并返回字符串缓冲区本身
     */





    /*  【StringBuffer的删除功能】

	• A:StringBuffer 的删除功能
		○ public StringBuffer deleteCharAt(int index):
			§ 删除指定位置的字符，并返回本身

		○ public StringBuffer delete(int start,int end):
			§ 删除从指定位置开始指定位置结束的内容，并返回本身
     */





    /*  【StringBuffer 的替换和反转功能】

	• A:StringBuffer的替换功能
		○ public StringBuffer replace(int start,int end,String str):
			§ 从start开始到end用str替换

	• B:StringBuffer的反转功能
		○ public StringBuffer reverse():
			§ 字符串反转
     */






    /*  【StringBuffer 的截取功能及注意事项】

	• A:StringBuffer的截取功能
		○ public String substring(int start):
			§ 从指定位置截取到末尾
		○ public String substring(int start,int end):
			§ 截取从指定位置开始到结束位置，包括开始位置，不包括结束位置

	• B:注意事项
		○ 注意:返回值类型不再是StringBuffer本身
     */






    /*  【StringBuffer 和String 的相互转换】

	• A:String -- StringBuffer
		○ a:通过构造方法
		○ b:通过append()方法

	• B:StringBuffer -- String
		○ a:通过构造方法
		○ b:通过toString()方法
		○ c:通过subString(0,length);
     */
}
