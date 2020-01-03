package com.gemini.threads.java9;

import java.util.Observable;

/**
 * @author xiaocuzi
 * @package com.gemini.threads.java9
 * @classname: ObServerDemo
 * @description: 事件监听者对系
 * @EventObject {@link java.util.EventObject}
 * @EventListener
 * @date 2019/2/27 17:31
 * @since 1.0.0
 */
public class ObServerDemo {

    public static void main(String[] args) {
        /**
         * 1、Vector作为底层存储每个方法都是线程安全的
         * 2、没有实现泛型
         * 3、同步 ->阻塞
         */
        MyObservable observable = new MyObservable();
        //观察者
        observable.addObserver((ob,value)->{
            System.out.printf("第一个观察者 %s \n",value);
        });

        observable.addObserver((ob,value)->{
            System.out.printf("第二个观察者 %s \n",value);
        });
        observable.setChanged();
        //通知、
        observable.notifyObservers(233434);
    }

    private static class MyObservable extends Observable{

        /**
         * Marks this {@code Observable} object as having been changed; the
         * {@code hasChanged} method will now return {@code true}.
         */
        @Override
        public void setChanged() {
            super.setChanged();
        }
    }
}
