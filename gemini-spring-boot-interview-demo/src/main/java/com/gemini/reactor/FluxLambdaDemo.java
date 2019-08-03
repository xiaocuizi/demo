package com.gemini.reactor;

import reactor.core.publisher.Flux;

/**
 * @author xiaocuzi
 * @package com.gemini.reactor
 * @classname: FluxLambdaDemo
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/8/3 10:18
 * @since 1.0.0
 */
public class FluxLambdaDemo {

    public static void main(String[] args) {
        Flux.just(1, 2, 3).map(value -> {

            return value + 1;

        }).subscribe(
                Utils::println, // doNext
                Utils::println,// doError
                () -> {
                    Utils.println ("订阅已完成。。");
                }
        );
    }

}
