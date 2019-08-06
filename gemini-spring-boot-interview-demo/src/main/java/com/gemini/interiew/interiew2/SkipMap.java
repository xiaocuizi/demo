package com.gemini.interiew.interiew2;

import java.util.Map;
import java.util.concurrent.ConcurrentSkipListMap;

/**
 * @author xiaocuzi
 * @package com.gemini.interiew2
 * @classname: SkipMap
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/6/17 19:15
 * @since 1.0.0
 */
public class SkipMap {

    public static void main(String[] args) {
        Map map = new ConcurrentSkipListMap();
        map.put("1", 1);
    }
}
