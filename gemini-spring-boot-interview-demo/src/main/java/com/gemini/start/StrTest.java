package com.gemini.start;

import com.google.common.base.Splitter;

import java.util.Stack;

/**
 * @author xiaocuzi
 * @package com.gemini.start
 * @classname: StrTest
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/5/9 11:37
 * @since 1.0.0
 */
public class StrTest {

    public static void main(String[] args) {
        String str = "abcde"; // 实现反转
        // 1、利用数组切分
        // 2 、利用二进制排序
        Stack<String> stringStack =  new Stack<String>();
        String[] strs = str.split(",",str.length());
        System.out.println(strs.length);

        String stringBuffer = new StringBuffer(str).reverse().toString();
        System.out.println(stringBuffer);

        System.out.print(Character.MIN_LOW_SURROGATE);
       /* for (int i = 0; i <split.length ; i++) {
            System.out.println("="+split[i]);
            stringStack.push(split[i]);
        }

        for (int i = 0; i <str.length() ; i++) {
            System.out.println(stringStack.pop());
        }*/
    }
}
