package com.gemini.lock;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @author xiaocuzi
 * @version v1.0.0
 * @Package com.gemini.lock
 * @classname: LockDemo
 * @Description: todo (用一句话描述该文件做什么)
 * @date 2019/3/21 16:40
 */
public class LockDemo implements Lock, Watcher {
    private ZooKeeper zooKeeper;

    private volatile String root_lock ="/locks";
    private volatile String wait_lock;
    private volatile String current_lock;

    private volatile CountDownLatch countDownLatch;

    public LockDemo() {
        try {
            zooKeeper =  new ZooKeeper("192.168.137.1:2181",5000,this);
            Stat stat =zooKeeper.exists(root_lock,false);
            if (stat == null) {
                zooKeeper.create(root_lock, "0".getBytes(),ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (KeeperException e) {
            e.printStackTrace();
        }
    }

    @Override
    public  void lock() {
        //如果获得锁成功
      if(this.tryLock()){
          System.out.println(Thread.currentThread().getName()+"->"+current_lock+"->获得锁成功。");
         return;
      }
      if(wait_lock ==null || "".equals(wait_lock)){
          System.out.println(Thread.currentThread().getName()+" wait_lock->"+wait_lock);
          return;
      }
      waitForLock(wait_lock);
    }

    /**
     *
     * @param pre 上一个节点
     */
    private boolean waitForLock(String pre) {
        try {
            Stat stat = zooKeeper.exists(pre, true);
            if(stat !=null){
                System.out.println(Thread.currentThread().getName()+"->等待锁"+root_lock+"/"+pre
                +" 释放。。");
                countDownLatch = new CountDownLatch(1);
                countDownLatch.await();
                System.out.println(Thread.currentThread().getName()+"获得锁成功。。");
                return true;
            }
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        try {
            //TODO 创建临时节点
            current_lock = zooKeeper.create(root_lock + "/", "0".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
            System.out.println(Thread.currentThread().getName()+"->"+current_lock+",尝试竞争锁");
            Thread.sleep(1000);
            List<String> childrens = zooKeeper.getChildren(root_lock, false);
            if(childrens ==null || childrens.size()==0){
                System.out.println(Thread.currentThread().getName()+"->子节点为空。。。");
                return false;
            }
            SortedSet<String> sortedSet = new TreeSet<>();
            for (String child:childrens) {
                sortedSet.add(child);
            }
            //获得当前所有节点序号最小的节点
            String firstNode = root_lock + "/"+sortedSet.first();
            SortedSet<String> lessThenMe = ((TreeSet<String>) sortedSet).headSet(current_lock);
            //TODO 通过当前节点和子节点中最小的节点进比较，如果相等，表示获得锁成功
            if (current_lock.equals(firstNode)){
                return true;
            }
            if(!lessThenMe.isEmpty()){
                //TODO 获得比当前节点序列号 更小的 最后一个节点，设置给wait_lock
                wait_lock = lessThenMe.last();
            }
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {
        System.out.println(Thread.currentThread().getName() + "->释放锁" + current_lock);
        try {
            zooKeeper.delete(current_lock, -1);
            current_lock = null;
            zooKeeper.close();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (KeeperException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Condition newCondition() {
        return null;
    }

    @Override
    public void process(WatchedEvent event) {
          if(this.countDownLatch !=null){
              this.countDownLatch.countDown();
              System.out.println("getType->"+event.getType());
          }
    }
}


