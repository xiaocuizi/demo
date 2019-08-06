package com.gemini.algorithm;

import java.util.Arrays;

/**
 * @author xiaocuzi
 * @package com.gemini.algorithm
 * @classname: StrRerview
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/8/5 15:40
 * @since 1.0.0
 */
public class StrRerview {

    public static void main(String[] args) {
        String str = "fedcba";
        char[] chars = str.toCharArray();
        int i = 0;
        int j = 0;
        int size = chars.length;
        char[] taget = new char[size];
        for (i = 0, j = size - 1; j > -1; j--, i++) {
            taget[j] = chars[i];
        }
        System.out.printf("chars=%s", Arrays.toString(taget));
    }
}
