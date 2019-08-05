package com.gemini.core;

import com.google.common.collect.Lists;
import com.google.common.util.concurrent.MoreExecutors;

import java.util.List;

/**
 * @author xiaocuzi
 * @version v1.0.0
 * @Package com.gemini.test.core
 * @classname: MoreExecutorDemo
 * @Description: todo (用一句话描述该文件做什么)
 * @date 2019/3/13 22:21
 */
public class MoreExecutorDemo {
    private static class User{
        private String name;

        public User(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
    public static void main(String[] args) {
       /* Executor executor = MoreExecutors.directExecutor();
        executor.execute(()->{
            System.out.println("I am find IN ,"+Thread.currentThread().getName());
        });*/
        final List<User> transitionStates = Lists.newArrayList();
        transitionStates.add(new MoreExecutorDemo.User("XXXXXXXXXXXX"));
        MoreExecutors.directExecutor();
    }
}


