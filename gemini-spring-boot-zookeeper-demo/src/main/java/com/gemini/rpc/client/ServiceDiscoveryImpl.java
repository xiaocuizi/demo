package com.gemini.rpc.client;

import com.gemini.rpc.zk.ZkConfig;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.cache.PathChildrenCache;
import org.apache.curator.framework.recipes.cache.PathChildrenCacheEvent;
import org.apache.curator.framework.recipes.cache.PathChildrenCacheListener;
import org.apache.curator.retry.ExponentialBackoffRetry;

import java.util.List;

/**
 * @author xiaocuzi
 * @version v1.0.0
 * @Package com.gemini.rpc.client
 * @classname: ServiceDiscoveryImpl
 * @Description: todo (用一句话描述该文件做什么)
 * @date 2019/3/22 15:41
 */
public class ServiceDiscoveryImpl implements IServiceDiscovery {

    private CuratorFramework curatorFramework;
    private List<String> stringList;

    public ServiceDiscoveryImpl() {
        curatorFramework = CuratorFrameworkFactory
                .builder()
                .connectString("192.168.137.1:2181")
                .sessionTimeoutMs(5000)
                .retryPolicy(new ExponentialBackoffRetry(1000,10)).build();
        curatorFramework.start();
    }

    @Override
    public String discover(String serviceName) {

        String path = ZkConfig.root_path+"/"+serviceName;

        try {
            resigerWachter(path);
        } catch (Exception e) {
            e.printStackTrace();
        }

         //负载均衡
        return new RandomBalance().doSelete(stringList);
    }

    private void resigerWachter(String path){
        try {
            stringList = curatorFramework.getChildren().forPath(path);
            return;
        } catch (Exception e) {
            e.printStackTrace();
        }


        /**
         *
         * TODO 监听
         *
         */
        PathChildrenCache childrenCache = new PathChildrenCache(curatorFramework,path,true);

        PathChildrenCacheListener pathChildrenCacheListener = new PathChildrenCacheListener() {
            @Override
            public void childEvent(CuratorFramework client, PathChildrenCacheEvent event) throws Exception {
                stringList = curatorFramework.getChildren().forPath(path);
            }
        };

        childrenCache.getListenable().addListener(pathChildrenCacheListener);
        try {
            childrenCache.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


