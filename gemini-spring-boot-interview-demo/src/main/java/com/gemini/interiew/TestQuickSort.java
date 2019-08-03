package com.gemini.interiew;

import java.util.Arrays;

/**
 * @author xiaocuzi
 * @package com.gemini.interiew
 * @classname: TestQuickSort
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/6/22 20:55
 * @since 1.0.0
 */
public class TestQuickSort {

    public static void main(String[] args) {
        int a[] = {49, 38, 65, 97, 76, 13, 27, 49};
       // sorta(a, 0, a.length);
        System.out.println(Arrays.toString(a));
        System.out.println(1 % 5);
    }

    private static void sorta(int[] a, int start, int end) {
        if (start > end) {
            return;
        }
        // 基准值
        int base = a[start];
        while (start < end) {

            while (base < a[end - 1]) {
                start++;
            }

        }
    }
}
