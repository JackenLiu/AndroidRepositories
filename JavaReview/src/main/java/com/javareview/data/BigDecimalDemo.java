package com.javareview.data;

import java.math.BigDecimal;

/**
 * 精确表示浮点数
 */
public class BigDecimalDemo {

    public static void main(String[] args) {

        BigDecimal bd = BigDecimal.valueOf(1.0);
        bd = bd.subtract(BigDecimal.valueOf(0.1));
        System.out.println(bd);

        double v = 1.0 - 0.1;
        BigDecimal bd1 = BigDecimal.valueOf(v);
        System.out.println(v);
        System.out.println(bd1);

        System.out.println(bd.equals(v));
        System.out.println(bd.equals(bd1)); // 可以作精确的比较
        System.out.println(bd.equals(1.0 - 0.1));
        System.out.println(bd1.equals(1.0 - 0.1));

        System.out.println("============");

        double d = 5d / 3;
        float f = 5f / 3;
        byte b = 5 / 3;
        int i = 5 / 3;
        System.out.println(d == f);
        System.out.println(b == i);
    }
}
