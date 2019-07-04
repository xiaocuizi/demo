package com.gemini.spring.reactive;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

/**
 * @author xiaocuzi
 * @version v1.0.0
 * @package com.gemini.spring.reactive
 * @classname: ReactorDemo
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/2/19 14:57
 */
public class ReactorDemo {

    public static void main(String[] args) throws InterruptedException {
        Flux.just(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
                //.subscribe(ReactorDemo::print)
                .filter(v -> v % 2 == 1) //判断数值 -->获取奇数
                .map(v -> v - 1) //奇数变偶数
                .reduce(Integer::sum)//集合操作;
                //.subscribeOn(Schedulers.elastic())
                .subscribeOn(Schedulers.parallel())
                //.block();
                .subscribe(ReactorDemo::print);
        Thread.sleep(1000);
    }

    public static void print(Object msg){
        System.out.printf("【线程%s】:%s \n",Thread.currentThread().getName(),msg);
    }
}
