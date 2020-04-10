package com.gemini;

/**
 * todo (用一句话描述该文件做什么)
 *
 * @author xiaocuizi
 * @since 0.0.1 2020/4/10 11:32
 */
public class SayHelloService {
    public void sayHello(){
        System.out.println("hello ,good name");
    }

    public static void main(String[] args) {
        new SayHelloService().sayHello();
    }
}
