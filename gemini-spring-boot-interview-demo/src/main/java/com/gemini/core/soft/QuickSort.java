package com.gemini.core.soft;

import java.util.Arrays;

/**
 * @author xiaocuzi
 * @package com.gemini.core.soft
 * @classname: QuickSort
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/12/11 11:12
 * @since 1.0.0
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = new int[]{3, 4, 6, 7, 2, 2, 8, 0};
        sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr, int start, int end) {
        if (start < end) {
            int stand = arr[start];
            int low = start;
            int high = end;
            // 循环找出比标准大的数和小的数
            while (low < high) {
                while (low < high && stand <= arr[high]) {
                    high--;
                }
                arr[low] = arr[high];
                while (low < high && arr[low] <= stand) {
                    low++;
                }
                arr[high] = arr[low];
            }
            arr[low] = stand;
            // 处理所有小的数据
            sort(arr, start, low);
            // 处理所有大的数据
            sort(arr, low + 1, end);
        }
    }
}
