package com.gemini.core;

/**
 * @author xiaocuzi
 * @version v1.0.0
 * @Package com.gemini.test.core
 * @classname: TestJoin
 * @Description: todo (用一句话描述该文件做什么)
 * @date 2019/3/11 15:16
 */
public class TestJoin {
    public volatile static  int i=0;
    public static class AddThread extends Thread{
        @Override
        public void run(){
            for (int j = 0; j <100 ; j++) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        AddThread addThread = new AddThread();
        addThread.start();
        System.out.println(">>>>>>>>>>>>>>>>>>");
        addThread.join();
        System.out.println(".............");
        ThreadGroup group =  new ThreadGroup("MY");
    }
}


