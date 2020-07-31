package com.javareview.data;

public class FloatAndDouble {

    public static void main(String[] args) {

        /*
        浮点型使用
         */
        double v = 1 / 3; // ?
        double v0 = 1. / 3; // 1. 代表浮点型 double
        double v1 = 1d / 3;
        double vv = 1f / 3; // 强转丢失精度
        System.out.println(v);
        System.out.println(v0);
        System.out.println(v1);
        System.out.println(vv);
        System.out.println("---------------");

        /*
        单精度 双精度
         */
        double v2 = 1f / 3;
        double v3 = 1d / 3;
        float v4 = 1f / 3;
        float v5 = (float) (1d / 3);
        System.out.println(v2);
        System.out.println(v3);
        System.out.println(v4);
        System.out.println(v5);
        System.out.println("---------------");

        /*
        浮点数不能用于比较 不精确 会使用科学计数法
         */
        float v6 = 23444333f;
        float v7 = v6 + 1;
        System.out.println(v6);
        System.out.println(v7);

    }
}
