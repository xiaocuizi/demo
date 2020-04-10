package com.agent;

/**
 * todo (用一句话描述该文件做什么)
 *
 * @author xiaocuizi
 * @since 0.0.1 2020/4/10 11:32
 */
public class SayHelloService2 {
    public void sayHello(){
        System.out.println("hello ,good name..................");
    }

    public void sayHello2(){
        System.out.println("hello ,good name");
    }

    public static void main(String[] args) throws InterruptedException {
        new SayHelloService2().sayHello();
        new SayHelloService2().sayHello2();
        Thread.sleep(1000);
    }
}
