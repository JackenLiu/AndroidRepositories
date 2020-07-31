package com.javaprimary.a3_method;

/**
 * switch 语句
 */
public class A2_SwitchStatement {

    public static void main(String[] args) {
        int x = 2;
        int y = 3;
        switch (x) {
            default:
                y++;
                //break;
            case 3:
                y++;
            case 4:
                y++;
        }
        System.out.println("y=" + y);
    }



    /*  【switch语句】

	• Swith(表达式)的类型可以为？
		○ Byte、short、char、int，即可以提升为int的都可以
		○ 枚举 (jdk 1.5 +)
		○ string (jdk 1.7 +)
	• Default 不一定放在最后
    • 最后的 break 可以省略
     */




    /*  【选择结构if语句和switch语句的区别】

	• A:总结switch语句和if语句的各自使用场景 （效率选择）
		○ switch 建议判断固定值的时候用
        ○ if 建议判断区间或范围的时候用
     */
}
