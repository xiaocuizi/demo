package com.gemini.arithmetic;

import java.util.Arrays;

/**
 * @author xiaocuzi
 * @package com.gemini.arithmetic
 * @classname: TestopArray
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/6/7 22:10
 * @since 1.0.0
 */
public class TestopArray {
    public static void main(String[] args) {
        int[] arr = new int[]{9, 8, 7};
        // arr[arr.length] = 6;
        int length = arr.length;
        int[] newArr = new int[4];
        for (int i = 0; i < length; i++) {
            newArr[i] = arr[i];
        }
        newArr[length] = 6;
        System.out.println(Arrays.toString(newArr));
    }
}
