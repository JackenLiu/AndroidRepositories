package com.javaprimary.a2_data.array;

import java.util.Arrays;

/**
 * 二分法查找
 */
public class A4_ArrayHalfSearch {

    public static void main(String[] args) {
        int[] arr = {11, 22, 33, 44, 55, 66, 77};
        System.out.println(halfSearch(arr, 22));
        System.out.println(halfSearch(arr, 00));

        // Arrays 自带二分法
        System.out.println(Arrays.binarySearch(arr, 77));
        System.out.println(Arrays.binarySearch(arr, 88)); // 负数：-（插入点）-1，因为可能是0所以减一
    }



    /*
     * 二分查找法
     * 1,返回值类型int
     * 2,参数列表int[] arr,int key
     */

    public static int halfSearch(int[] arr, int key) {
        int min = 0;                        // 记录最小索引的值
        int max = arr.length - 1;            // 记录最大索引的值
        int mid = (min + max) >> 1;            // 等效于(min + max) / 2
        while (arr[mid] != key) {
            if (key < arr[mid]) {            // 如果要找的数小于了中间索引对应的值
                max = mid - 1;                // 最大值变
            } else if (key > arr[mid]) {        // 如果要找的数大于了中间索引对应的值
                min = mid + 1;                // 最小值变
            }

            if (min > max) {
                return -1;
            }

            mid = (min + max) >> 1;            // 无论最大值变还是最小值变,中间的索引都要重新求值
        }
        return mid;
    }
}
