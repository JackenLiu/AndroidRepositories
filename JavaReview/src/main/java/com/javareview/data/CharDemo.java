package com.javareview.data;

public class CharDemo {

    public static void main(String[] args) {
        System.out.println(' ');
        System.out.println('a');
        System.out.println('a' + '\'');
        System.out.println("" + 'a' + '\'');
        System.out.println('\n'); // 这里是换两行
        System.out.println('a' + 0);
        System.out.println('a' + 'b');
        System.out.println('a' + "b");

        System.out.println("==========================");

        char a = 43;
        char b = 54;
        char c = (char) (a + b);
        System.out.println(c);
    }
}
