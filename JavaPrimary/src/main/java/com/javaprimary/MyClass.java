package com.javaprimary;

import java.util.Arrays;

public class MyClass {

    public static void main(String[] args) {
        int[] arr = {1, 44, 2, 34, 22, 12, 0, 32, 23};
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        System.out.println(Arrays.toString(arr));
    }

}