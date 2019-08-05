package com.gemini.core;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author xiaocuzi
 * @version v1.0.0
 * @Package com.gemini.test.core
 * @classname: ReentrantLockDemo
 * @Description: todo (用一句话描述该文件做什么)
 * @date 2019/3/11 16:10
 */
public class TryLockDemo implements Runnable{
    private static ReentrantLock lock1 = new ReentrantLock();
    int order;

    public TryLockDemo(int order) {
        this.order = order;
    }

    @Override
    public void run() {
        try {
            if (lock1.tryLock(5, TimeUnit.SECONDS)) {
                System.out.println("tryLock=");
                Thread.sleep(10000);
            }else {
                System.out.println("get lock failed......");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if(lock1.isHeldByCurrentThread()){
                lock1.unlock();
            }
            System.out.println(Thread.currentThread().getName()+"：线程退出");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new TryLockDemo(1));
        Thread thread2 = new Thread(new TryLockDemo(2));
        thread.setName("A");
        thread2.setName("B");
        thread.start();
        thread2.start();
    }
}


