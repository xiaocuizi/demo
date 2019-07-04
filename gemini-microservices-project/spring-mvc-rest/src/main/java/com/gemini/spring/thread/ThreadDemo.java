package com.gemini.spring.thread;

/**
 * @author xiaocuzi
 * @version v1.0.0
 * @package com.gemini.spring.thread
 * @classname: ThreadDemo
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/2/19 10:36
 */
public class ThreadDemo {

    public static void main(String[] args) throws InterruptedException {
        print("hello world 1");
        Thread thread = new Thread(()->{
            print("hello world 2018");
        });
        //thread.start();
        thread.join();
        print("hello world 2");

    }

    public static void print(String msg){
        System.out.printf("【线程%s】:%s \n",Thread.currentThread().getName(),msg);
    }
}
