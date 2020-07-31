package com.javaprimary.a2_data.array;

/**
 * 数组冒泡排序
 */
public class A2_ArrayBubbleSort {

    public static void main(String[] args) {
        int[] arr = {33, 11, 44, 22, 55, 66}; // 11,22,33,44,55
        bubbleSort(arr);
        System.out.println(arr2String(arr));

        char[] chars = {'z', 'a', '*', '!', 'c', 's', '1', '3', '8'};
        bubbleSortString(chars);
        System.out.println(new String(chars));
    }


    /*
     * 冒泡排序
     * 返回值类型void
     * 参数列表int[] arr
     */

    public static void bubbleSort(int[] arr) {            // arr.length = 6
        for (int i = 0; i < arr.length - 1;     i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {// -1 防止索引越界
                if (arr[j] > arr[j + 1]) {                    // -i 是为了提高效率
					/*int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;*/
                    swap(arr, j, j + 1);                    // 交换两个索引对应的元素值
                }
            }
        }
    }


    /**
     * char 数组冒泡排序
     *
     * @param arr
     */
    public static void bubbleSortString(char[] arr) {            // arr.length = 6
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {// -1 防止索引越界
                if (arr[j] > arr[j + 1]) {                    // -i 是为了提高效率
                    char temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }


    /*
     * 打印数组
     * 1,返回值类型String
     * 2,参数列表int[] arr
     */
    public static String arr2String(int[] arr) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1) {
                sb.append(arr[i]).append("]");
            } else {
                sb.append(arr[i]).append(", ");
            }
        }

        return sb.toString();
    }
    /*
     * 交互数组中的位置
     * 1,返回值类型void
     * 2,参数列表int[] arr,int i,int j
     */

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
