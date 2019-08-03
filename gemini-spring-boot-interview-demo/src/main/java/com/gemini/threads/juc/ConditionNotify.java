package com.gemini.threads.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @author xiaocuzi
 * @package com.gemini.threads.juc
 * @classname: ConditionNotify
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/5/20 20:19
 * @since 1.0.0
 */
public class ConditionNotify implements Runnable{

    private Lock lock;
    private Condition condition;

    public ConditionNotify(Lock lock, Condition condition) {
        this.lock = lock;
        this.condition = condition;
    }

    @Override
    public void run() {
        try {
            lock.lock();
            System.out.println("begin -signal");
            condition.signal();
            System.out.println("end -signal");

        } finally {
            lock.unlock();
        }
    }
}
