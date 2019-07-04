package com.gemini.controller;

import java.util.Random;
import java.util.concurrent.*;

/**
 * @author xiaocuzi
 * @version v1.0.0
 * @package com.gemini.controller
 * @classname: FutureDemo
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/2/25 10:54
 */
public class FutureDemo {
    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
        Random random = new Random();
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Future<String> future = executorService.submit(() -> {
            int value = random.nextInt(200);
            try {
                Thread.sleep(value);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Hello Worlds";
        });
        String s = future.get(100, TimeUnit.MILLISECONDS);
    }
}
