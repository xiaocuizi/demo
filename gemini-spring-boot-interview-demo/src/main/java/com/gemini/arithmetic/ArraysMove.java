package com.gemini.arithmetic;

import java.util.Arrays;

/**
 * @author xiaocuzi
 * @package com.gemini.arithmetic
 * @classname: ArraysMove
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/10/21 18:25
 * @since 1.0.0
 */
public class ArraysMove {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 5, 7};
        int n = 4;
        while (n > 0) {
            // 步长
            for (int i = 0; i < arr.length; i++) {
                int temp = arr[0];
                arr[0] = arr[i];
                arr[i] = temp;
            }
            n--;
        }
        System.out.println(Arrays.toString(arr));

    }
}
