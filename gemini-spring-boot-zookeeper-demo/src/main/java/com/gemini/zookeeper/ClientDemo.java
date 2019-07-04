package com.gemini.zookeeper;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @author xiaocuzi
 * @version v1.0.0
 * @Package com.gemini.zookeeper
 * @classname: ClientDemo
 * @Description: todo (用一句话描述该文件做什么)
 * @date 2019/3/21 8:54
 */
public class ClientDemo {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        try {
            ZooKeeper zooKeeper = new ZooKeeper("127.0.0.1:2181", 4000, new Watcher() {
                @Override
                public void process(WatchedEvent event) {
                    if(Event.KeeperState.SyncConnected==event.getState()) {
                        countDownLatch.countDown();
                    }
                }
            });
            countDownLatch.await();
            System.out.println(zooKeeper.getState());
            List<String> children = zooKeeper.getChildren("/locks", false);
            System.out.println("children--------------->"+children);
            /*zooKeeper.create("/zk-peson-xiaocuizi3","o".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
            Thread.sleep(10000);
            byte[] data = zooKeeper.getData("/zk-peson-xiaocuizi3", null, new Stat());
            System.out.println("data=>"+new String(data));*/
            zooKeeper.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }/* catch (KeeperException e) {
            e.printStackTrace();
        }*/ catch (KeeperException e) {
            e.printStackTrace();
        }
    }
}


