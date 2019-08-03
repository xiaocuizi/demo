package com.gemini.threads.morethread.juc.aqs;

/**
 * @author xiaocuzi
 * @version v1.0.0
 * @Package com.gemini.threads.morethread.juc.aqs
 * @classname: TestInterrupted
 * @Description: todo (用一句话描述该文件做什么)
 * @date 2019/4/24 17:19
 */
public class TestInterrupted {

    public static class MyThread extends Thread{

        @Override
        public void run() {
            System.out.println("hello ,worlds;");
        }
    }
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new MyThread();
        thread.setName("TEST-1");
        thread.start();
        Thread.sleep(200);
        thread.interrupt();// 打断
        Thread.sleep(500);
        System.out.println("interrupted=" + Thread.currentThread().getName());
        System.out.println("interrupted=" + Thread.currentThread().isInterrupted());
        //thread.isInterrupted(true);
       /* Thread.interrupted();
        System.out.println("alive2=" + thread.isAlive());*/

    }
}


