package com.gemini.util;

/**
 * @author xiaocuzi
 * @version v1.0.0
 * @package com.gemini.util
 * @classname: Utils
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/2/26 16:53
 */
public class Utils {
    public static void printf(Object msg){
        System.out.printf("[Thread :%s] %s\n",Thread.currentThread().getName(),String.valueOf(msg));
    }
}
