package com.javaprimary.a2_data.array;


import static com.javaprimary.a2_data.array.A2_ArrayBubbleSort.arr2String;
import static com.javaprimary.a2_data.array.A2_ArrayBubbleSort.swap;

/**
 * 数组选择排序
 */
public class A3_ArraySelectSort {

    public static void main(String[] args) {
        int[] arr = {66, 55, 44, 33, 22, 11};
        selectSort(arr);                                        // 升序排列
        System.out.println(arr2String(arr));    // 将数组转换成字符串并打印
    }


    /*
	 * 选择排序
	 * 1,void
	 * 2,int[] arr
	 * 	第一次:arr[0]分别与arr[1-5]比较5次
		第二次:arr[1]分别与arr[2-5]比较4次
		第三次:arr[2]分别与arr[3-5]比较3次
		第四次:arr[3]分别与arr[4-5]比较2次
		第五次:arr[4]与arr[5]比较1次
	 */
    public static void selectSort(int[] arr) {                // arr.length = 6
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
					/*int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;*/
                    swap(arr, i, j);        // 调用 A2_ArrayBubbleSort 类静态的换位方法
                }
            }
        }
    }
}
