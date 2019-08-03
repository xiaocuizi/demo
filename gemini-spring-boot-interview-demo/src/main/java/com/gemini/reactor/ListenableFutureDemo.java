package com.gemini.reactor;

import org.springframework.core.task.AsyncListenableTaskExecutor;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.util.concurrent.Callable;

/**
 * @author xiaocuzi
 * @package com.gemini.reactor
 * @classname: ListenableFutureDemo
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/8/3 11:28
 * @since 1.0.0
 */
public class ListenableFutureDemo {

    public static void main(String[] args) {
        AsyncListenableTaskExecutor executor = new SimpleAsyncTaskExecutor("ListenableFutureDemo-");
        ((SimpleAsyncTaskExecutor) executor).setConcurrencyLimit(1);
        ListenableFuture<Integer> future = executor.submitListenable(new Callable<Integer>() {

            @Override
            public Integer call() throws Exception {
                // onSuccess 方法接收
                return 1;
            }
        });

        future.addCallback(new ListenableFutureCallback<Integer>() {
            @Override
            public void onFailure(Throwable ex) {
                Utils.println(ex);
            }

            @Override
            public void onSuccess(Integer result) {
                Utils.println("------------------");
                Utils.println(result);
                Utils.println("------------------");
            }
        });
    }
}
