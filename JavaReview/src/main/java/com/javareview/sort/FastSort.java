package com.javareview.sort;

import java.util.Arrays;

/**
 * 快速排序
 */
public class FastSort {
    public static void main(String[] args) {

        int[] arr = {72, 6, 57, 88, 60, 42, 83, 73, 48, 85};
        System.out.println(Arrays.toString(arr));

        toSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void toSort(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        toSort(arr, low, high);
    }

    private static void toSort(int[] arr, int low, int high) {
        if (low < high) {
            // 分区操作，将一个数组分成两个分区，返回分区界限索引
            int index = partition(arr, low, high);
            // 对左边分区进行快排序
            toSort(arr, low, index - 1);
            // 对右边分区进行快排序
            toSort(arr, index + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        // 指定左指针i和右指针j
        int i = low;
        int j = high;

        // 将第一个数作为基准值，挖坑
        int x = arr[low];

        // 使用循环实现分区操作
        while (i < j) {
            // 1.从右向左移动 j ,找到第一个小于基准值的值
            while (arr[j] >= x && i < j) {
                j--;
            }
            // 2.将右侧找到小于基准值的值加到左边的（坑）的位置，左指针向之间移动一个位置 （i++）
            if (i < j) {
                arr[i] = arr[j];
                i++;
            }


            // 3.从左向右移动 i ，找到第一个大于等于基准值的值 arr[i]
            while (arr[i] < x && i < j) {
                i++;
            }
            // 4.将左侧找到大于基准值的值加到右边的（坑）的位置，右指针向之间移动一个位置 （j--）
            if (i < j) {
                arr[j] = arr[i];
                j--;
            }
        }

        // 使用基准值填坑，这就是基准值的最终位置
        arr[i] = x;

        // 返回基准值的位置索引
        return i;
    }
}
