package com.gemini.core;

import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xiaocuzi
 * @version v1.0.0
 * @Package com.gemini.test.core
 * @classname: LockSupportDemo
 * @Description: todo (用一句话描述该文件做什么)
 * @date 2019/3/14 12:09
 */
public class LockSupportDemo {
    static Object u = new Object();

    @org.openjdk.jmh.annotations.Benchmark
    public void measureName() {
       // System.out.println("hello,world!");
        Map<String, String> map = new HashMap<>();
        map.put("a", "b");
    }
    /** main method */
    public static void main(String[] args) {
        Options opt = new OptionsBuilder()
                ////benchmark 所在的类的名字，注意这里是使用正则表达式对所有类进行匹配的
                .include(LockSupportDemo.class.getSimpleName())
                .forks(1)////进行 fork 的次数。如果 fork 数是2的话，则 JMH 会 fork 出两个进程来进行测试
                .warmupIterations(5) //预热的迭代次数
                .measurementIterations(5) //实际测量的迭代次数
                .build();

        try {
            new Runner(opt).run();
        } catch (RunnerException e) {
            e.printStackTrace();
        }
    }
    /*public static class ChangeObject extends Thread{
        public ChangeObject(String name) {
            super(name);
        }

        public void run(){
          //synchronized (u){
              System.out.println("in "+getName());
              LockSupport.park();
          //}
        }
    }

    static ChangeObject t1 = new ChangeObject("T1");
    static ChangeObject t2 = new ChangeObject("T2");
    public static void main(String[] args) throws InterruptedException {
        t1.start();
        Thread.sleep(100);
        t2.start();
       LockSupport.unpark(t1);
        *//* LockSupport.unpark(t2);
        t1.join();
        t2.join();*//*
    }*/
}


