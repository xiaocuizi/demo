package com.gemini.core;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author xiaocuzi
 * @version v1.0.0
 * @Package com.gemini.test.core
 * @classname: ReentrantLockDemo
 * @Description: todo (用一句话描述该文件做什么)
 * @date 2019/3/11 16:10
 */
public class ReentrantLockDemo  implements Runnable{
    ReentrantLock lock1 = new ReentrantLock();
    ReentrantLock lock2 = new ReentrantLock();
    int order;

    public ReentrantLockDemo(int order) {
        this.order = order;
    }

    @Override
    public void run() {
        try {
            if (order == 1) {
                lock1.lockInterruptibly();
                Thread.sleep(2000);
                lock2.lockInterruptibly();
            }else {
                lock2.lockInterruptibly();
                Thread.sleep(2000);
                lock1.lockInterruptibly();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if(lock1.isHeldByCurrentThread()){
                lock1.unlock();
            }
            if(lock2.isHeldByCurrentThread()){
                lock2.unlock();
            }
            System.out.println(Thread.currentThread().getName()+"：线程退出");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new ReentrantLockDemo(1));
        Thread thread2 = new Thread(new ReentrantLockDemo(2));
        thread.setName("A");
        thread2.setName("B");
        thread.start();
        thread2.start();
        Thread.sleep(5000);
    }
}


