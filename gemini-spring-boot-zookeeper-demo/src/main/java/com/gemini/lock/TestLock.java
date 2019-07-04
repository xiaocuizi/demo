package com.gemini.lock;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * @author xiaocuzi
 * @version v1.0.0
 * @Package com.gemini.lock
 * @classname: TestLock
 * @Description: todo (用一句话描述该文件做什么)
 * @date 2019/3/21 17:09
 */
public class TestLock {
    static CountDownLatch countDownLatch = new CountDownLatch(10);


    /**
     *
     */
    public static class Task implements Runnable{
        @Override
        public void run() {
            try {
                countDownLatch.await();
                LockDemo lockDemo = new LockDemo();
                lockDemo.lock();
                Thread.sleep(5000);
                lockDemo.unlock();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        for (int i = 0; i <10 ; i++) {
            Thread thread = new Thread(new Task());
            thread.setName("Thread->"+i);
            thread.start();
            countDownLatch.countDown();
        }
        System.in.read();
    }
}


