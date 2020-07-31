package com.javaprimary.a3_method;

/**
 * break、continue、return应用场景
 */
public class A3_BreakReturnContinue {

    public static void main(String[] args) {
        testContinue();
        testReturnAndBreak();
    }

    // 【方法】测试 continue
    public static void testContinue() {
        for (int x = 1; x <= 10; x++) {
            if (x == 4) {
                continue;                //终止本次循环,继续下次循环
                //break;
            }

            System.out.println("x = " + x);
        }

        int x = 10;
        if (x > 4) {
            System.out.println("x = " + x);
            //break;
        }

		/*
		break和continue的应用场景
		break可以应用在switch语句还可以应用在循环里
		continue只能用在循环里
		*/
    }

    // 【方法】break 与 return 的区别
    public static void testReturnAndBreak() {
        for (int x = 1; x <= 5; x++) {
            if (x == 4) {
                return;              //return是将整个方法结束
                //break;			//break是将循环结束
            }

            System.out.println("x = " + x);
        }

        System.out.println("循环结束");
    }


    /*  【break、continue、return应用场景】

    • Break 可以应用在switch语句还可以应用中循环里
	• continue 只能用在循环里
	• Return 跳出整个方法，不仅仅是循环。void 方法也有 Return，省略了 ”return;"
     */
}
