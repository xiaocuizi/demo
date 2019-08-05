package com.gemini.core;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author xiaocuzi
 * @version v1.0.0
 * @Package com.gemini.test.core
 * @classname: ThreadPoolDemo
 * @Description: todo (用一句话描述该文件做什么)
 * @date 2019/3/14 15:04
 */
public class ThreadPoolDemo {


    public static class MyTask implements Runnable{
        private String name;

        public MyTask(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getId()+",正在执行。。。");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {

        /**
         * int corePoolSize,
         *                               int maximumPoolSize,
         *                               long keepAliveTime,
         *                               TimeUnit unit,
         *                               BlockingQueue<Runnable> workQueue,
         *                               RejectedExecutionHandler handler
         */
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                5, 10,0L, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>()){

            @Override
            public void terminated() {
                System.out.println("线程已退出。。。。。。");
            }

            @Override
            protected void beforeExecute(Thread t, Runnable r) {
                System.out.println("准备执行。。。。。。");
            }
            @Override
            protected void afterExecute(Runnable r, Throwable t) {
                System.out.println("执行完成。。。。。。");
            }
        };

        for (int i = 0; i <6 ; i++) {
            MyTask myTask = new MyTask("TASK-" + i);
            threadPoolExecutor.execute(myTask);
            Thread.sleep(100);
        }

        threadPoolExecutor.shutdown();

    }
}


