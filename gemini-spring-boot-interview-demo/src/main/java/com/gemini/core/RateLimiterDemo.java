package com.gemini.core;

import com.google.common.util.concurrent.RateLimiter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author xiaocuzi
 * @version v1.0.0
 * @Package com.gemini.test.core
 * @classname: RateLimiterDemo
 * @Description: todo (用一句话描述该文件做什么)
 * @date 2019/3/12 12:28
 */
public class RateLimiterDemo {
    static RateLimiter rateLimiter = RateLimiter.create(2);
    public static class Task implements Runnable{
        public void run(){
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("当前时间："+System.currentTimeMillis());
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        for (int i = 0; i < 50;i++) {
            //System.out.println("i="+i+"--->>>>");
            rateLimiter.acquire();
            executorService.submit(new Task());
        }
        executorService.shutdown();
    }

}


