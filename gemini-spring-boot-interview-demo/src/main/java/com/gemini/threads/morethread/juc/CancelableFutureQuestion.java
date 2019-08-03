package com.gemini.threads.morethread.juc;

import java.util.concurrent.*;

/**
 * @author xiaocuzi
 * @version v1.0.0
 * @Package com.gemini.threads.morethread.juc
 * @classname: CancelableFutureQuestion
 * @Description: todo (用一句话描述该文件做什么)
 * @date 2019/4/20 17:03
 */
public class CancelableFutureQuestion {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<?> future = executorService.submit(() -> {
            action(4);
        });

        try {
            future.get(3, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        } catch (ExecutionException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } catch (TimeoutException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt(); //中断
            //超时，优雅关闭
            future.cancel(true);//尝试取消
        }finally {
            executorService.shutdown();
        }
    }


    /**
     *
     * @param sencods
     */
    public static void action(int sencods){
        try {
            Thread.sleep(TimeUnit.SECONDS.toMillis(sencods));
            System.out.println("Thread ->"+Thread.currentThread().getName());
            if(Thread.interrupted()){ //使得下一次不会进入InterruptedException
                //判断并且清除中断状态
                return;

            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


