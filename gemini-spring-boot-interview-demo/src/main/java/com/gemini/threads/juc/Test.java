package com.gemini.threads.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author xiaocuzi
 * @package com.gemini.threads.juc
 * @classname: Test
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/5/20 20:24
 * @since 1.0.0
 */
public class Test {

    public static void main(String[] args) {
        Lock lock = new  ReentrantLock();
        Condition condition = lock.newCondition();

        new Thread(new ConditionWait(lock,condition)).start();
        new Thread(new ConditionNotify(lock,condition)).start();
    }
}
