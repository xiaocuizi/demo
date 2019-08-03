package com.gemini.threads.morethread.juc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author xiaocuzi
 * @version v1.0.0
 * @Package com.gemini.threads.morethread.juc
 * @classname: CountDownLanch2Demo
 * @Description: todo (用一句话描述该文件做什么)
 * @date 2019/4/20 15:21
 */
public class CountDownLanch3Demo {


    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();

        //ThreadPoolExcetor  beforeExecute  & afterEexecute

        for (int i = 0; i <10 ; i++) {
            executorService.submit(()->{

            });
        }

    }

}


