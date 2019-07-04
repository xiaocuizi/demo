package com.gemini.spring.reacvtive;

import java.sql.SQLOutput;
import java.util.concurrent.CompletableFuture;

/**
 * @author xiaocuzi
 * @version v1.0.0
 * @package com.gemini.spring.reacvtive
 * @classname: CompletableFutureDemo
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/2/18 21:31
 */
public class CompletableFutureDemo {

    public static void main(String[] args) {
        CompletableFuture.supplyAsync(() -> {
            print("hello");
            return "hello";
        }).thenApply(result -> {
            print(result+",world");
            return result+",world";
        }).thenAccept(CompletableFutureDemo::print)
        .whenComplete((v,error)->{
            print("执行结束...");
        }).join();
    }

    public static void print(String msg){
        //
        System.out.printf("[线程]%s:msg=%s \n",Thread.currentThread().getName(),msg);

    }
}
