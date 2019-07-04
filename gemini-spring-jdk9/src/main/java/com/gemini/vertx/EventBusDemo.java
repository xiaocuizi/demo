package com.gemini.vertx;

import io.vertx.core.Vertx;

/**
 * @author xiaocuzi
 * @package com.gemini.vertx
 * @classname: EventBusDemo
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/2/27 15:19
 * @since 1.0.0
 */
public class EventBusDemo {
    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();
        vertx.eventBus().consumer("localhost",message->{
            Object payLoad = message.body();
            System.out.println("ADD resss->"+payLoad);
        }).completionHandler(hadnler->{
            System.out.println("消费已经结束");
        });
          //发布
        vertx.eventBus().publish("localhost","helloWorld");
        vertx.close();
    }
}
