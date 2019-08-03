package com.gemini.threads.morethread.juc.aqs;

import java.io.IOException;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author xiaocuzi
 * @version v1.0.0
 * @Package com.gemini.threads.morethread.juc.aqs
 * @classname: AbstractQueuedSynchronizerDemo
 * @Description: todo (用一句话描述该文件做什么)
 * @date 2019/4/24 10:03
 */
public class AbstractQueuedSynchronizerDemo {

    static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        /*ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(AbstractQueuedSynchronizerDemo::action);
        executorService.submit(AbstractQueuedSynchronizerDemo::action);
        executorService.awaitTermination(200, TimeUnit.SECONDS);
        executorService.shutdown();*/
        new Thread(() -> {
            action();
        }, "线程1").start();
        new Thread(() -> {
            action();
        }, "线程2").start();
    }

    public static void action() {
        // System.out.printf("当前线程【%s】 正在执行，等待您的输入\n ", Thread.currentThread().getName());
        try {
            int holdCount = lock.getHoldCount();
            System.out.println("holdCount=" + holdCount);
            lock.lock();
            System.out.println("当前线程【" + Thread.currentThread().getName() + "】 正在执行，等待您的输入......");
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}


