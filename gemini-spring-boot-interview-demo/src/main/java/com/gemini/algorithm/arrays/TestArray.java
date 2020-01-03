package com.gemini.algorithm.arrays;

import java.util.Arrays;

/**
 * @author xiaocuzi
 * @version v1.0.0
 * @Package com.gemini.algorithm.arrays
 * @classname: TestArray
 * @Description: todo (用一句话描述该文件做什么)
 * @date 2019/12/21 10:48
 */
public class TestArray {
    public static void main(String[] args) {
        int[] arr = new int[]{3, 2, 3, 5, 9, 1, 3, 6, 3, 3};
        int i = find(arr);
        System.out.println(i);
    }

    private static int find(int[] arr) {
        Arrays.sort(arr);
        int count = 0;
        int totalCount = 0;
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            if (count > totalCount) {
                totalCount = count;
                if (totalCount >= (length / 2)) {
                    return arr[i];
                }
            }
            int temp = arr[i];
            for (int j = i + 1; j < length; j++) {
                if (temp == arr[j]) {
                    count++;
                }
            }
        }

        return -1;

    }


}




