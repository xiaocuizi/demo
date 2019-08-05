package com.gemini.core;

/**
 * @author xiaocuzi
 * @version v1.0.0
 * @Package com.gemini.test.core
 * @classname: ThreadCountsDemo
 * @Description: todo (用一句话描述该文件做什么)
 * @date 2019/3/12 16:12
 */
public class ThreadCountsDemo {
    public static void main(String[] args) {
        int processors = Runtime.getRuntime().availableProcessors();
        long freeMemory = Runtime.getRuntime().freeMemory();
        System.out.println("processors="+processors);
        System.out.println("freeMemory="+freeMemory);
        double v = 8 * 0.75 * (1 + (500 / 200));
        System.out.println("v="+v);
    }

    /**
     *  NCPU = CUP数量
     *  Ucpu = 目标CPU的使用率  0<= Ucpu <=1
     *  W/C  等待时间/计算时间
     * N = NCPU * Ucpu* (1+w/c)
     * C = 4 * 0.6 * （1+500/200）
     *
     *
     */
}


