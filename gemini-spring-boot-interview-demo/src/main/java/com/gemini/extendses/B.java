package com.gemini.extendses;

/**
 * @author xiaocuzi
 * @package com.gemini.extendses
 * @classname: B
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/8/20 7:12
 * @since 1.0.0
 */
public class B {
    static {
        System.out.printf("b1\n");
    }

    {
        System.out.printf("b2\n");
    }

    public B() {
        System.out.printf("b3\n");
    }
}
