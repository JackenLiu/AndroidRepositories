package com.javaprimary.a3_method;

/**
 * while 循环
 */
public class A1_WhileStatement {

    public static void main(String[] args) {
        testDoWhileStatement();
        testWhileStatement();
    }

    // 【方法】测试 while 循环
    public static void testWhileStatement() {
        //求1-100之和
        int x = 1;
        int sum = 0;
        while (x <= 100) {
            sum = sum + x;
            x++;
        }
        System.out.println(sum);


        //求水仙花数的个数
        int count = 0;
        int x1 = 100;
        while (x1 < 1000) {
            int ge = x1 % 10;
            int shi = x1 / 10 % 10;
            int bai = x1 / 100;

            if (ge * ge * ge + shi * shi * shi + bai * bai * bai == x1) {
                count++;
            }

            x1++;
        }
        System.out.println(count);
    }

    // 【方法】测试 do while 循环
    public static void testDoWhileStatement() {
        /*
		建议:
		当循环增量,只为了循环而定义的,建议for
		当循环增量,不只为了循环,循环结束之后,继续使用,建议while
		*/

        int x = 1;
        do {
            System.out.println(x);
            x++;
        }
        while (x < 0);

		/*
		while和do while的区别
		while如果条件不满足,不执行循环体
		do while 无论条件是否满足,至少会执行一次循环体
		*/
    }


    /*  【循环结构while语句的格式】

	• 完整格式：

		初始化语句;
		while(判断条件语句) {
		     循环体语句;
		     控制条件语句;
        }
     */



    /*  【循环结构do...while语句的格式】

	• 完整格式；
		初始化语句;
		do {
                   循环体语句;
                   控制条件语句;
               }while(判断条件语句);
     */




    /*  【循环结构三种循环语句的区别】
	• A:案例演示
		○ 三种循环语句的区别:
			§ do...while循环至少执行一次循环体。
			§ 而for,while循环必须先判断条件是否成立，然后决定是否执行循环体语句。

	• B:案例演示
		○ for循环和while循环的区别：
			§ A:如果你想在循环结束后，继续使用控制条件的那个变量，用while 循环，否则用for 循环。不知道用for 循环。因
			    为变量及早的从内存中消失，可以提高内存的使用效率。
			§ B:建议:
				□ 如果是一个范围的，用for循环非常明确。
                □ 如果是不明确要做多少次，用while循环较为合适。
     */
}
