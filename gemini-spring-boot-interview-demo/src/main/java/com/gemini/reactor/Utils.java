package com.gemini.reactor;

/**
 * @author xiaocuzi
 * @package com.gemini.reactor
 * @classname: Utils
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/8/3 10:25
 * @since 1.0.0
 */
public class Utils {
    public static void println(Object msg){
        System.out.printf("[thread name %s] msg=%s \n",Thread.currentThread().getName(),String.valueOf(msg));
    }
}
