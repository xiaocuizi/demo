package com.gemini.arithmetic;

import com.gemini.threads.Thread1;

/**
 * @author xiaocuzi
 * @package com.gemini.arithmetic
 * @classname: ConcurrentClass
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/12/17 10:00
 * @since 1.0.0
 */
public class ConcurrentClass {

    private synchronized static void a() {
        System.out.println("method a was invoked....");
        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private synchronized void b() {
        System.out.println("method b was invoked....");
        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private synchronized void c() {
        System.out.println("method c was invoked....");
        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private synchronized void d() {
        System.out.println("method d was invoked....");
        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        ConcurrentClass concurrentClass = new ConcurrentClass();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                //concurrentClass.c();
                ConcurrentClass.a();
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                //concurrentClass.d();
                concurrentClass.b();
            }
        });

        thread1.start();
        thread2.start();
    }
}
