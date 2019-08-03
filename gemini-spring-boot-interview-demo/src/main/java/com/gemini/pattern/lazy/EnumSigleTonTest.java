package com.gemini.pattern.lazy;

/**
 * @author xiaocuzi
 * @package com.gemini.pattern.lazy
 * @classname: EnumSigleTonTest
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/5/16 11:13
 * @since 1.0.0
 */
public class EnumSigleTonTest {

    public static void main(String[] args) {
        Object instance = EnumSigleTon.INSTANCE.getInstance();
        System.out.println(instance);
    }
}
