package com.gemini.threads.juc;

import java.util.concurrent.*;

/**
 * @author xiaocuzi
 * @package com.gemini.threads.juc
 * @classname: ThreadPoolDemo
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/5/27 10:37
 * @since 1.0.0
 */
public class ThreadPoolDemo {
    static class App implements Runnable {
        @Override
        public void run() {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName());
        }
    }

    static ExecutorService service = Executors.newFixedThreadPool(3);

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            service.execute(new App());
            Future<?> submit = service.submit(new App());
            try {
                Object o = submit.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

        ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor)service;
        threadPoolExecutor.prestartAllCoreThreads();
        service.shutdown();
    }
}
