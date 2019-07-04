package com.gemini.creator;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.cache.NodeCache;
import org.apache.curator.framework.recipes.cache.NodeCacheListener;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.data.Stat;

import java.util.prefs.NodeChangeListener;

/**
 * @author xiaocuzi
 * @version v1.0.0
 * @Package com.gemini.creator
 * @classname: CuratorDemo
 * @Description: todo (用一句话描述该文件做什么)
 * @date 2019/3/21 15:44
 */
public class CuratorListenerDemo {

    public static void main(String[] args) throws Exception {
        CuratorFramework curatorFramework =
                CuratorFrameworkFactory.builder()
                        .connectString("127.0.0.1:2181")
                        .sessionTimeoutMs(4000).retryPolicy(
                new ExponentialBackoffRetry(1000, 3)
        ).namespace("curator").build();
        curatorFramework.start();
        addWithNodeCache(curatorFramework,"/mic");
        System.in.read();
    }

    public static void addWithNodeCache(CuratorFramework curatorFramework,String path) throws Exception {
        NodeCache nodeCache = new NodeCache(curatorFramework,path,false);
        NodeCacheListener nodeCacheListener =new NodeCacheListener() {
            @Override
            public void nodeChanged() throws Exception {
                System.out.println("eveent"+nodeCache.getCurrentData().getPath());
            }
        };
        nodeCache.getListenable().addListener(nodeCacheListener);
        nodeCache.start();

    }
}


