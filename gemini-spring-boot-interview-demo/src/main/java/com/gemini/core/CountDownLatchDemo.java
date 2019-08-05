package com.gemini.core;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author xiaocuzi
 * @version v1.0.0
 * @Package com.gemini.test.core
 * @classname: CountDownLatchDemo
 * @Description: todo (用一句话描述该文件做什么)
 * @date 2019/3/11 21:27
 */
public class CountDownLatchDemo implements Runnable {
    private static final CountDownLatch end = new CountDownLatch(10);
    static final CountDownLatchDemo demo = new CountDownLatchDemo();
    @Override
    public void run() {
        try {
            Thread.sleep(new Random().nextInt(10)*1000);
            System.out.println("check complete...");
            end.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(20);
        for (int i = 0; i <10 ; i++) {
            executorService.submit(demo);
        }
        end.await();
        System.out.println("Fire");
        executorService.shutdown();
    }
}


