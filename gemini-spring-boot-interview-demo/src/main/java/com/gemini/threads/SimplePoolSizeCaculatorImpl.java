package com.gemini.threads;

import java.lang.management.ManagementFactory;
import java.math.BigDecimal;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author xiaocuzi
 * @package com.gemini.threads
 * @classname: SimplePoolSizeCaculatorImpl
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/8/23 10:47
 * @since 1.0.0
 */
public class SimplePoolSizeCaculatorImpl extends PoolSizeCalculator {

    @Override
    protected Runnable creatTask() {
        return new AsyncIOTask();
    }

    @Override
    protected BlockingQueue createWorkQueue() {
        return new LinkedBlockingQueue(1000);
    }

    @Override
    protected long getCurrentThreadCPUTime() {
        return ManagementFactory.getThreadMXBean().getCurrentThreadCpuTime();
    }

    public static void main(String[] args) {
        PoolSizeCalculator poolSizeCalculator = new SimplePoolSizeCaculatorImpl();
        poolSizeCalculator.calculateBoundaries(new BigDecimal(1.0), new BigDecimal(100000));
    }

}
