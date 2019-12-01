package com.gemini.interiew;

import com.gemini.extendses.A;

import java.util.Arrays;

/**
 * @author xiaocuzi
 * @package com.gemini.interiew
 * @classname: QuickSort
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/10/14 16:31
 * @since 1.0.0
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 1,7, 9, 5, 8};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void quickSort(int[] arr, int start, int end) {
        if (start <end) {
            // 基準數據
            int base = arr[start];
            // 低位
            int low = start;
            // 高位
            int high = end;
            while (low < high) {
                while (low < high && base <= arr[high]) {
                    high--;
                }
                arr[low] = arr[high];
                while (low < high && arr[low] <= base) {
                    low++;
                }
                arr[high] = arr[low];
            }
            arr[low] = base;
            quickSort(arr,start,low);
            quickSort(arr,low+1,end);
        }


    }
}
