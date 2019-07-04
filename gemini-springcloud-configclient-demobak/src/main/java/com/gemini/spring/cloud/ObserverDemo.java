package com.gemini.spring.cloud;

import java.util.Arrays;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * @author xiaocuzi
 * @version v1.0.0
 * @package com.gemini.spring.cloud
 * @classname: ObserverDemo
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/2/22 17:24
 */
public class ObserverDemo {
    public static void main(String[] args) {
        MyObservable observable  = new MyObservable();
        observable.addObserver(new Observer() {
            @Override
            public void update(Observable o, Object arg) {
                System.out.println("hello,worlds") ;
            }
        });
        observable.setChanged();
        observable.notifyObservers("hello");
    }


    /**
     *
     */
    public static class MyObservable extends Observable{

        @Override
        protected synchronized void setChanged() {
            super.setChanged();
        }
    }

    /*private static void echoIterator(){
        List<Integer>  list = Arrays.asList(1,2,4);

        Iterable  iterable = T
    }*/
}
