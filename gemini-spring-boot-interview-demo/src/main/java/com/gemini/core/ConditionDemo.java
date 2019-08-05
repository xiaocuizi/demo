package com.gemini.core;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author xiaocuzi
 * @version v1.0.0
 * @Package com.gemini.test.core
 * @classname: ConditionDemo
 * @Description: todo (用一句话描述该文件做什么)
 * @date 2019/3/11 16:49
 */
public class ConditionDemo implements Runnable{

    public static ReentrantLock lock = new ReentrantLock();
    public static Condition condition = lock.newCondition();


    @Override
    public void run() {
        try {
            lock.lock();
            condition.await();
            System.out.println("go on ............");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {

        ConditionDemo conditionDemo = new ConditionDemo();
        Thread thread = new Thread(conditionDemo);
        thread.start();
        Thread.sleep(2000);
        lock.lock();
        condition.signal();
        lock.unlock();
    }
}


