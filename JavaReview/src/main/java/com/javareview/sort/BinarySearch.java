package com.javareview.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 二分法查找无序字符数组
 */
public class BinarySearch {
    public static void main(String[] arg) {

        char[] chars = {'a', '@', '5', 'b', '1', '9', ')', '%', '*', '^'};

        System.out.println(findRandomChar(chars, '*'));
    }


    /**
     * 对已排序的数组进行二分法查找，返回找到的索引
     *
     * @param chars
     * @param target
     * @return 找到的索引
     */
    private static int findByTwoHalf(char[] chars, char target) {
        int min = 0;
        int max = chars.length - 1;
        int mid = max / 2;

        // 如果超出首尾边界
        if (target > chars[chars.length - 1] || target < chars[0]) {
            return -1;
        }

        while (true) {
            // 最小的区间也没找到
            if (max - mid <= 1 && chars[mid] != target && chars[max] != target) {
                return -1;
            }

            if (chars[mid] == target) {
                break;
            } else if (chars[mid] > target) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
            mid = (min + max) / 2;
        }
        return mid;
    }

    /**
     * 查找随机字符数组里的字符
     *
     * @param chars
     * @param target
     * @return
     */
    private static int findRandomChar(char[] chars, char target) {
/*
        记录每个字符的索引
         */
        List<Map<Character, Integer>> charsIndex = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            Map map = new HashMap();
            map.put(chars[i], i);
            charsIndex.add(map);
        }
        Arrays.sort(chars);

        System.out.println(Arrays.toString(chars));
        // 排序后找到的 index
        int sortIndex = findByTwoHalf(chars, target);
        if (sortIndex == -1) {
            return -1;
        }
        char sortChar = chars[sortIndex];
        int targetIndex = -1;
        for (Map<Character, Integer> item : charsIndex) {

            if (item.containsKey(sortChar)) {
                targetIndex = item.get(sortChar);
            }
        }
        return targetIndex;
    }
}
