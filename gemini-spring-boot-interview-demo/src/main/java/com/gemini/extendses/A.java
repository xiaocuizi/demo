package com.gemini.extendses;

/**
 * @author xiaocuzi
 * @package com.gemini.extendses
 * @classname: A
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/8/20 7:12
 * @since 1.0.0
 */
public class A extends B {
    static {
        System.out.printf("a1\n");
    }

    {
        System.out.printf("a2\n");
    }

    public A() {

        System.out.printf("a3\n");
    }


    public static void main(String[] args) {
        A a = new A();
        B b = new B();
    }
}
