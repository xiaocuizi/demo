package com.gemini.core;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author xiaocuzi
 * @version v1.0.0
 * @Package com.gemini.test.core
 * @classname: HashMapDemo
 * @Description: todo (用一句话描述该文件做什么)
 * @date 2019/3/15 10:18
 */
public class HashMapDemo {
    public static void main(String[] args) {
        Map<Object, Object> map = Collections.synchronizedMap(new HashMap<>());
    }
}


