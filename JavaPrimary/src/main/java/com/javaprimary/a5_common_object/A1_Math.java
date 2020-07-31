package com.javaprimary.a5_common_object;

/**
 * math 类
 */
public class A1_Math {

    public static void main(String[] args) {
        testGenerateRandomNum();

        System.out.println(Math.PI);
        System.out.println(Math.abs(-10));                // 取绝对值
        System.out.println(Math.abs(10));
        System.out.println(Math.ceil(12.33));                // 天花板(向上取整,但是是一个double数)
        System.out.println(Math.ceil(12.77));
        System.out.println(Math.floor(12.33));            // 地板(向下取整,但是是一个double数)
        System.out.println(Math.floor(12.77));
        System.out.println(Math.max(10, 100));
        System.out.println(Math.pow(2, 3));                // 2.0 ^ 3.0次方
        System.out.println(Math.random());                // 随机数(0.0 - 1.0之间,不包括1.0)
        System.out.println(Math.round(12.33));
        System.out.println(Math.round(12.53));            // 四舍五入
        System.out.println(Math.sqrt(9));                    // 开平方
    }

    // 【方法】 参数随机数
    public static void testGenerateRandomNum() {
        // 生成随机数大于等于0.0小于1.0
        double d = Math.random();
        System.out.println(d);

        // 在1 到100 生成随机整数
        for (int x = 1; x <= 100; x++) {
            int num = (int) (Math.random() * 100) + 1;
            System.out.println(num);
        }
    }
}
