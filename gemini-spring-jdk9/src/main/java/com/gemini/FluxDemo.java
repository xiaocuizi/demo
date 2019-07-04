package com.gemini;

import com.gemini.util.Utils;
import reactor.core.publisher.Flux;

import java.util.Random;

/**
 * @author xiaocuzi
 * @version v1.0.0
 * @package com.gemini
 * @classname: FluxDemo
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/2/26 17:14
 */
public class FluxDemo {
    public static void main(String[] args) {
       /* Random random = new Random(4);
        Flux.just(1,2,3,8).map(value->{
            int nextInt = random.nextInt();
            if (nextInt < value) {
                throw new RuntimeException("出错了~ the value must be less then 3@!@!");
            }
            return value+2;
        }).subscribe(
                Utils::printf,//onNext
                Utils::printf,//onError
                ()->{
                    Utils.printf("PROCESS SUCCESS!");
                }
        );*/

        Random random = new Random();

        Flux.generate(() -> 0, (value, sink) -> {
            if (value == 3) {
                sink.complete();
            } else {
                sink.next("value=" + value);
            }
            return value + 1;
        }).subscribe(Utils::printf);
    }
}
