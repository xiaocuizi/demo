package com.gemini;

import com.gemini.util.Utils;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

/**
 * @author xiaocuzi
 * @version v1.0.0
 * @package com.gemini
 * @classname: FluxAsyncDemo
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/2/26 18:15
 */
public class FluxAsyncDemo {
    public static void main(String[] args) {

        /**
         * Schedulers.immediate() 当前线程
         * Schedulers.elatic()  弹性
         */
        Flux.range(0, 10).publishOn(Schedulers.immediate()).subscribe(Utils::printf);
    }
}
