package com.gemini.core;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author xiaocuzi
 * @package com.gemini.test.core
 * @classname: SempleDemo
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/3/11 18:55
 * @since 1.0.0
 */
public class SempleDemo{
    private ReentrantLock lock = new ReentrantLock();
    private static ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
    private static Lock readLock = reentrantReadWriteLock.readLock();
    private static Lock writeLock = reentrantReadWriteLock.writeLock();
    private static int index;
    public static int handRead(Lock lock){
        lock.lock();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
        return index;
    }
    public static int handlerWrite(Lock lock,int i){
        lock.lock();
        try {
            Thread.sleep(1000);
            index = i;
            return index;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
        return 0;
    }


    public static void main(String[] args) {
        Runnable readRannable = new Runnable() {
            @Override
            public void run() {
                int handRead = handRead(readLock);
                System.out.println("handRead="+handRead);
            }
        };

        Runnable writeRunnable = new Runnable() {
            @Override
            public void run() {
                int handlerWrite = handlerWrite(writeLock, new Random().nextInt());
                System.out.println("handlerWrite="+handlerWrite);
            }
        };
        for (int i = 0; i < 16; i++) {
            Thread thread =  new Thread(readRannable);
            thread.start();
        }
        for (int i = 10; i <20 ; i++) {
            Thread thread1 = new Thread(writeRunnable);
            thread1.start();
        }
    }

}
