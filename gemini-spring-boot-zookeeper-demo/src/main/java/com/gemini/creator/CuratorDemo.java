package com.gemini.creator;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.data.Stat;

/**
 * @author xiaocuzi
 * @version v1.0.0
 * @Package com.gemini.creator
 * @classname: CuratorDemo
 * @Description: todo (用一句话描述该文件做什么)
 * @date 2019/3/21 15:44
 */
public class CuratorDemo {

    public static void main(String[] args) throws Exception {
        CuratorFramework curatorFramework =
                CuratorFrameworkFactory.builder()
                        .connectString("127.0.0.1:2181")
                        .sessionTimeoutMs(4000).retryPolicy(
                new ExponentialBackoffRetry(1000, 3)
        ).namespace("curator").build();
        curatorFramework.start();

        /*curatorFramework.create()
                .creatingParentsIfNeeded()
                .withMode(CreateMode.PERSISTENT).forPath("/mic/model","1".getBytes());*/
        Stat stat = new Stat();
        curatorFramework.getData().storingStatIn(stat).forPath("/mic/model");
        curatorFramework.setData().withVersion(stat.getVersion()).forPath("/mic/model","hello".getBytes());
    }
}


