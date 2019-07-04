package com.gemini.vertx;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author xiaocuzi
 * @package com.gemini.vertx
 * @classname: VertxDemo
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/2/27 14:40
 * @since 1.0.0
 */
public class VertxDemo {
    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();
        demoVerticle(vertx);
        //vertx.createHttpServer().listen(8080);
       /* vertx.setPeriodic(500,System.out::println);
        vertx.setPeriodic(500,System.out::println);
        Executors.newScheduledThreadPool(1)
                .schedule(()->
                    System.out.println("helloworld"),1000,TimeUnit.MILLISECONDS
                );*/

        vertx.close();
    }

    public static void demoVerticle(Vertx vertx){
        vertx.deployVerticle(new AbstractVerticle() {
            @Override
            public void start() throws Exception {
                System.out.println("start...................");
            }

            @Override
            public void stop() throws Exception {
                System.out.println("stoop...................");
            }
        });
    }
}
