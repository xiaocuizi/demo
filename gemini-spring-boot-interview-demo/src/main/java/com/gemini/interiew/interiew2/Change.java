package com.gemini.interiew.interiew2;

import java.util.Arrays;

/**
 * @author xiaocuzi
 * @package com.gemini.interiew2
 * @classname: Change
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/6/20 16:19
 * @since 1.0.0
 */
public class Change {
    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};
        int len = arr.length;
        int[] target = new int[len];
        for (int i = len - 1, j = 0; i > -1; i--, j++) {
            target[j] = arr[i];
        }
        System.out.println(Arrays.toString(target));
    }
}
