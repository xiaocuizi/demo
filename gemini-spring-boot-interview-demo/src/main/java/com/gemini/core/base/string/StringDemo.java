package com.gemini.core.base.string;

import org.apache.commons.lang3.StringUtils;

import java.util.stream.Stream;

/**
 * @author xiaocuzi
 * @version v1.0.0
 * @Package com.gemini.test.core.base.string
 * @classname: StringDemo
 * @Description: todo (用一句话描述该文件做什么)
 * @date 2019/4/8 15:41
 */
public class StringDemo {

    public static void main(String[] args) {
        Stream.of("AB","DEF","10","2O")
                .filter(StringUtils::isNumeric)
                .forEach(System.out::println);
    }
}


