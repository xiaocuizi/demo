package com.gemini.controller;

import com.sun.org.apache.bcel.internal.generic.NEW;
import rx.Observer;
import rx.Scheduler;
import rx.Single;
import rx.schedulers.Schedulers;

import java.util.Random;

/**
 * @author xiaocuzi
 * @version v1.0.0
 * @package com.gemini.controller
 * @classname: RxJavaDemo
 * @description: Reactive X java
 * @date 2019/2/24 18:46
 */

public class RxJavaDemo {

    public static void main(String[] args) {
        Random random = new Random();
        Single.just("helloworls").subscribeOn(Schedulers.immediate())//Schedulers.io()是多线程
                .subscribe(new Observer<String>() {
                    @Override
                    public void onCompleted() {
                        System.out.println("成功。。。。。。。。。");
                    }

                    @Override
                    public void onError(Throwable e) {
                        System.out.println("熔断保护~");
                    }

                    @Override
                    public void onNext(String s) {
                        int value = random.nextInt(200);
                        System.out.println("cost time="+value);
                        /*try {
                            System.out.println("cost time="+value);
                            Thread.sleep(value);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }*/
                        if(value >100){
                            throw  new RuntimeException("超时了 。。。");
                        }
                    }
                });
    }
}
