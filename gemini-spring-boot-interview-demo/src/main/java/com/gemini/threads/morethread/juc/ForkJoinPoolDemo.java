package com.gemini.threads.morethread.juc;

import java.util.concurrent.ForkJoinPool;

/**
 * @author xiaocuzi
 * @version v1.0.0
 * @Package com.gemini.threads.morethread.juc
 * @classname: ForkJoinPoolDemo
 * @Description: todo (用一句话描述该文件做什么)
 * @date 2019/4/20 16:45
 */
public class ForkJoinPoolDemo {

    public static void main(String[] args) throws InterruptedException {
        ForkJoinPool pool = ForkJoinPool.commonPool();
        for (int i = 0; i < 10; i++) {
            pool.execute(new MyThread());
            Thread.sleep(3000);
        }

    }

    /**
     *
     */
    public static class MyThread implements Runnable {
        @Override
        public void run() {
            System.out.println("thid=" + Thread.currentThread().getName());
        }
    }

}


