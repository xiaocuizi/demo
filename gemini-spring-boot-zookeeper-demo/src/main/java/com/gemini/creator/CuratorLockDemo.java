package com.gemini.creator;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;

import java.util.concurrent.TimeUnit;

/**
 * @author xiaocuzi
 * @version v1.0.0
 * @Package com.gemini.creator
 * @classname: CuratorLockDemo
 * @Description: todo (用一句话描述该文件做什么)
 * @date 2019/3/21 19:40
 */
public class CuratorLockDemo {
    public static void main(String[] args) {
        CuratorFramework curatorFramework = CuratorFrameworkFactory.builder().connectString("192.168.137.1:2181").sessionTimeoutMs(15000).namespace("curators").build();
        InterProcessMutex mutex = new InterProcessMutex(curatorFramework,"/locks");
        try {
            boolean acquire = mutex.acquire(2, TimeUnit.SECONDS);
            System.out.println("acquire="+acquire);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


