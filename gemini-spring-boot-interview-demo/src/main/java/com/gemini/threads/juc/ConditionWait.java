package com.gemini.threads.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @author xiaocuzi
 * @package com.gemini.threads.juc
 * @classname: ConditionWait
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/5/20 20:19
 * @since 1.0.0
 */
public class ConditionWait implements Runnable {
    private Lock lock;
    private Condition condition;

    public ConditionWait(Lock lock, Condition condition) {
        this.lock = lock;
        this.condition = condition;
    }

    @Override
    public void run() {
        try {
            lock.lock();
            try {
                System.out.println("begin -await");
                condition.await();
                System.out.println("end -await");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } finally {
            lock.unlock();
        }


    }
}
