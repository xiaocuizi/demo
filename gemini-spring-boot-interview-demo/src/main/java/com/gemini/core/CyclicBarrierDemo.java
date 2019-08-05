package com.gemini.core;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author xiaocuzi
 * @version v1.0.0
 * @Package com.gemini.test.core
 * @classname: CyclicBarrierDemo
 * @Description: todo (用一句话描述该文件做什么)
 * @date 2019/3/14 10:48
 */
public class CyclicBarrierDemo {


    /**
     * 士兵
     */
    public static class Soldider implements Runnable{
        private String solder;
        private final CyclicBarrier cyclicBarrier;

        public Soldider(String solder, CyclicBarrier cyclicBarrier) {
            this.solder = solder;
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run(){
            try {
                cyclicBarrier.await();
                doWork();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }

        private void doWork() throws InterruptedException {
            Thread.sleep(Math.abs(new Random().nextInt()%10000));
            System.out.println("任务完成了 。。。。");
        }
    }


    /**
     * 士兵集合的处理类
     */
    public static class BarrierRun implements Runnable{
        int N;
        boolean flag;

        public BarrierRun(int n, boolean flag) {
            N = n;
            this.flag = flag;
        }

        @Override
        public void run() {
              if(flag){
                  System.out.println("司令：第"+N+"个士兵任务完成");
              }else {
                  System.out.println("司令：第"+N+"个士兵，集合完毕");
                  flag = true;
              }
        }
    }


    public static void main(String[] args) {
        final int N=10;
        boolean flag = false;
        Thread[] threads = new Thread[N];
        CyclicBarrier cyclicBarrier = new CyclicBarrier(N,new BarrierRun(N,flag));
        for (int i = 0; i <N ; i++) {
            System.out.println("-->第"+i+"个士兵报道");
            Thread threads1 = threads[i];
            threads1 = new Thread(new Soldider("士兵"+i,cyclicBarrier));
            threads1.start();
        }
    }
}


