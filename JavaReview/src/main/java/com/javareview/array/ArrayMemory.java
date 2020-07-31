package com.javareview.array;

/**
 * 数组内存图 Java 参数传递
 */
public class ArrayMemory {
    public static void main(String[] args) {
        /*
             栈内存
         ____________
        |           |
        |           |
        |  change() |
        |-----------|
        | int a = 2 |   ----> change 方法的参数在方法调用完成后会回收，独立于 main 方法的存在
        | int b = 1 |
        |-----------|
        |           |
        |   main()  |
        |-----------|
        | int a = 1 |   ----> main 方法的参数在 change 方法调用时不受影响
        | int b = 2 |
         ------------
         */
        int a = 1;
        int b = 2;
        change(a, b);
        System.out.println(a);
        System.out.println(b);

        /*
             栈内存                                堆内存
         ____________               _________________________________
        |           |               |          数组                  |
        |           |               |       _________               |
        |changeArr()|               |      |    1   |               |
        |-----------|               |      |________|               |
        | int[] arr ---------------------->|    2   |               |
        |-----------|        |------------>|________|               |
        |           |        |      |                               |
        |   main()  |        |      |                               |
        |-----------|        |      |                               |
        | int[] arr ---------|      |                               |
        |-----------|               ---------------------------------

        · changeArr 方法的数组引用参数改变的值是堆内存中同一个对象，所以即使出栈了，main 方法的数组的值也会被改变
         */
        int[] arr = {1, 2};
        changeArr(arr);
        System.out.println("arr[0]=" + arr[0] + "," + "arr[1]=" + arr[1]);
    }

    private static void changeArr(int[] arr) {
        arr[0] = 3;
    }

    private static void change(int a, int b) {
        a = 2;
        b = 1;
    }
}
