package com.gemini.threads.morethread.juc.aqs;

/**
 * @author xiaocuzi
 * @version v1.0.0
 * @Package com.gemini.threads.morethread.juc.aqs
 * @classname: Interrupt
 * @Description: todo (用一句话描述该文件做什么)
 * @date 2019/4/24 17:49
 */
public class Interrupt {
    public static void main(String[] args) throws Exception {
        Thread t = new Thread(new Worker());
        t.start();

        Thread.sleep(200);
        t.interrupt();

        System.out.println("Main thread stopped.");
    }

    public static class Worker implements Runnable {
        @Override
        public void run() {
            System.out.println("Worker started.");

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread curr = Thread.currentThread();
                //再次调用interrupt方法中断自己，将中断状态设置为“中断”
                curr.interrupt();
                System.out.println("Worker IsInterrupted: " + curr.isInterrupted());
                System.out.println("Worker IsInterrupted: " + curr.isInterrupted());
                System.out.println("Static Call: " + Thread.interrupted());//clear status 清除中断状态，恢复线程
                System.out.println("---------After Interrupt Status Cleared----------");
                System.out.println("Static Call: " + Thread.interrupted());
                System.out.println("Worker IsInterrupted: " + curr.isInterrupted());
                System.out.println("Worker IsInterrupted: " + curr.isInterrupted());
            }

            System.out.println("Worker stopped.");
        }
    }
}


