package com.gemini.reactor;

import reactor.core.publisher.Flux;

import java.util.Random;

/**
 * @author xiaocuzi
 * @package com.gemini.reactor
 * @classname: FluxAPIDemo
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/8/3 10:48
 * @since 1.0.0
 */
public class FluxAPIDemo {

    public static void main(String[] args) {

        Random random = new Random();
        Flux.generate(() -> 0, (value, sink) -> {

            if (value == 3) {
                sink.complete();
            } else {
                sink.next("value" + value);
            }

            return value + 1;
        }).subscribe(
                Utils::println, // onNext
                Utils::println, // onEoror
                ()->{
                    Utils.println("subscription is completed!");
                }
        );
    }
}
