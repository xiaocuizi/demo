package com.gemini.lambda;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author xiaocuzi
 * @package com.gemini.lambda
 * @classname: Test3
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/7/28 11:54
 * @since 1.0.0
 */
public class Test3 {

    public static void main(String[] args) {
        distinct();
    }

    /**
     * list 去重
     * @return
     */
    public static List<Integer> distinct() {
        ArrayList<Integer> integerList = Lists.newArrayList(1, 9, 4, 5, 5, 3, 6, 7, 8, 6, 7, 34, 23, 12, 89);
        List<Integer> result = integerList.stream().distinct().collect(Collectors.toList());
        System.out.printf("%s", result.toString());
        return result;
    }
}
