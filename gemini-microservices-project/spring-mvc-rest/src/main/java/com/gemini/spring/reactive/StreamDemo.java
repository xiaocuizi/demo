package com.gemini.spring.reactive;

import java.util.stream.Stream;

/**
 * @author xiaocuzi
 * @version v1.0.0
 * @package com.gemini.spring.reactive
 * @classname: StreamDemo
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/2/19 11:14
 */
public class StreamDemo {

    public static void main(String[] args) {
        Stream.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)//0-1集合
                .filter(v -> v % 2 == 1) //判断数值 -->获取奇数
                .map(v -> v - 1) //奇数变偶数
                .reduce(Integer::sum)//集合操作
                .ifPresent(System.out::println);//输出偶数相加
    }
}
