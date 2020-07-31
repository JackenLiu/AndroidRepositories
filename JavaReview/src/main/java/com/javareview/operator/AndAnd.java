package com.javareview.operator;

/**
 * 与运算
 */
public class AndAnd {

    public static void main(String[] args) {
        int x = 3;
        int y = 4;
        System.out.println((++x == 3) & (++y == 4));
        System.out.println(x);
        System.out.println(y);
        x = 3;
        y = 4;
        System.out.println("==================");
        System.out.println((++x == 3) && (++y == 4));
        System.out.println(x);
        System.out.println(y);
    }
}
