package com.gemini.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author xiaocuzi
 * @package com.gemini.threads
 * @classname: ThreadOrder
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/6/7 16:53
 * @since 1.0.0
 */
public class ThreadOrder {

    static Thread thread1 = new Thread(new Runnable() {
        @Override
        public void run() {
            System.out.println("thread1");
        }
    });

    static Thread thread2 = new Thread(new Runnable() {
        @Override
        public void run() {
            System.out.println("thread2");
        }
    });

    static Thread thread3 = new Thread(new Runnable() {
        @Override
        public void run() {
            System.out.println("thread3");
        }
    });

    static ExecutorService executorService = Executors.newSingleThreadExecutor();
    public static void main(String[] args) throws InterruptedException {
        executorService.submit(thread1); // 1、执行thread1
        executorService.submit(thread2); // 2、执行thread2
        executorService.submit(thread3); // 3、执行thread3
        executorService.shutdown();
    }
}
