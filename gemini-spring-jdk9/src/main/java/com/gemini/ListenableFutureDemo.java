package com.gemini;

import com.gemini.util.Utils;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

/**
 * {@link ListenableFuture}
 * @author xiaocuzi
 * @version v1.0.0
 * @package com.gemini
 * @classname: ListenableFutureDemo
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/2/26 16:50
 */
public class ListenableFutureDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        SimpleAsyncTaskExecutor simpleAsyncTaskExecutor = new SimpleAsyncTaskExecutor("SimpleAsyncTaskExecutor-1");
        ListenableFuture<Integer> future = simpleAsyncTaskExecutor
                .submitListenable(new Callable<Integer>() {
                    @Override
                    public Integer call() throws Exception {
                        return 100;
                    }
                });

        //添加事件
        future.addCallback(new ListenableFutureCallback<Integer>() {
            public void onSuccess(Integer result) {
              Utils.printf(result);
            }

            public void onFailure(Throwable ex) {
                Utils.printf(ex);
            }
        });
        future.get();

        //-------------------------------------------------------------------

        ListenableFuture<Integer> future1 = simpleAsyncTaskExecutor.submitListenable(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return 300;
            }
        });
        //添加事件
        future1.addCallback(new ListenableFutureCallback<Integer>() {
            public void onSuccess(Integer result) {
                Utils.printf(result);
            }

            public void onFailure(Throwable ex) {
                Utils.printf(ex);
            }
        });
        future1.get();
    }
}
