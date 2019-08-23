package com.gemini.interiew;

/**
 * @author xiaocuzi
 * @package com.gemini.interiew
 * @classname: TestStatic
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/8/14 12:58
 * @since 1.0.0
 */
public class TestStatic {

    static {
        System.out.printf("hhaa=%s\n","bbbbbb");
    }

    {
        System.out.printf("hhaa=%s\n","cccccccc");
    }
    public TestStatic() {
        System.out.printf("hhaa=%s\n","aaaaaaaaaaa");
    }

    public static void main(String[] args) {
      new TestStatic();
    }
}
