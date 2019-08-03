package com.gemini.pattern.lazy;

/**
 * @author xiaocuzi
 * @package com.gemini.pattern.lazy
 * @classname: TestVolatile
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/5/11 11:07
 * @since 1.0.0
 */
public class TestVolatile {
    public static volatile int i = 1;
    public static void main(String[] args) {
        i++;
        System.out.println(i);
    }
}
