package com.gemini.threads.morethread.juc;

/**
 * @author xiaocuzi
 * @version v1.0.0
 * @Package com.gemini.threads.morethread.juc
 * @classname: CountDownLanch2Demo
 * @Description: todo (用一句话描述该文件做什么)
 * @date 2019/4/20 15:21
 */
public class CountDownLanch2Demo {

    private int count;

    public CountDownLanch2Demo(int count) {
        this.count = count;
    }

    public void await() throws InterruptedException {

        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        synchronized (this) {
            while (count > 0) {
                wait();
            }
        }
    }

    public void countDown() {
        synchronized (this) {
            if (count < 1) {
                return;
            }
            count--;
            if (count == 0) {
                notifyAll();
            }
        }

    }

}


