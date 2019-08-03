package com.gemini.reactor;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

/**
 * @author xiaocuzi
 * @package com.gemini.reactor
 * @classname: FluxAsyncDemo
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/8/3 11:04
 * @since 1.0.0
 */
public class FluxAsyncDemo {

    public static void main(String[] args) throws InterruptedException {
        // Flux.range(0,10).publishOn(Schedulers.immediate()).subscribe(Utils::println);

       // 单线程异步执行
//        Flux.range(0, 10)
//                .publishOn(Schedulers.single())
//                .subscribe(Utils::println);


        // 弹性线程池异步执行
//        Flux.range(0, 10)
//                .publishOn(Schedulers.elastic())
//                .subscribe(Utils::println);


        // 并行线程池异步执行
        Flux.range(0, 10)
                .publishOn(Schedulers.parallel())
                .subscribe(Utils::println);

        Thread.currentThread().join(1 * 1000L);
    }
}
