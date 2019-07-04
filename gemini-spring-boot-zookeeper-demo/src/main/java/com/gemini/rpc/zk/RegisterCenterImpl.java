package com.gemini.rpc.zk;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;

/**
 * @author xiaocuzi
 * @version v1.0.0
 * @Package com.gemini.rpc.zk
 * @classname: RegisterCenterImpl
 * @Description: todo (用一句话描述该文件做什么)
 * @date 2019/3/22 14:50
 */
public class RegisterCenterImpl implements IRegisterCenter {
    private  CuratorFramework curatorFramework;

    {
        curatorFramework =CuratorFrameworkFactory
                .builder()
                .connectString("192.168.137.1:2181")
                .sessionTimeoutMs(5000)
                .retryPolicy(new ExponentialBackoffRetry(1000,10)).build();
        curatorFramework.start();
    }
    @Override
    public void register(String serviceName, String serviceAddress) {
        String servicePath = ZkConfig.root_path+"/"+serviceName;

        try {
            if(curatorFramework.checkExists().forPath(servicePath)==null){
                curatorFramework.create().creatingParentsIfNeeded().withMode(CreateMode.PERSISTENT).forPath(servicePath,"0".getBytes());
            }
           String addressPath = servicePath +"/"+serviceAddress;

            String resNode = curatorFramework.create().creatingParentsIfNeeded().withMode(CreateMode.EPHEMERAL).forPath(addressPath, "0".getBytes());

            System.out.println("服务注册成功。。"+resNode);


        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}


