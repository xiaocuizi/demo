package com.gemini.core;

import java.util.Deque;
import java.util.Random;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author xiaocuzi
 * @version v1.0.0
 * @Package com.gemini.test.core
 * @classname: MiaoShaDemo
 * @Description: todo (用一句话描述该文件做什么)
 * @date 2019/3/13 20:44
 */
public class MiaoShaDemo {
    private static Deque<User> queue =  new ConcurrentLinkedDeque<User>();

    private static volatile int queueSize;

    private final static AtomicInteger index_genertator = new AtomicInteger();




    /**
     *
     *  public boolean offerLast(E e) {
     *         linkLast(e);
     *         return true;
     *     }
     *
     *      public boolean offer(E e) {
     *         return offerLast(e);
     *     }
     *
     *
     * @return
     */
    public static String acceptReq() {
        if(queueSize >=10){
            System.out.println("acceptReq:queueSize="+ queueSize+"| 达到上限");
            return "失败";
        }
        Random random = new Random();
        //int index = random.nextInt(100);
        int index = index_genertator.getAndIncrement();
        String name = "张三" + index;
        User userBefore = new User(index, name);

        boolean add = queue.add(userBefore);
        queueSize = queue.size();
        System.out.println("acceptReq:queueSize="+ queueSize+",name="+name+",Thread name"+Thread.currentThread().getName());
        return add ? "成功" : "失败";
    }

    public static void takeReq() {
        User userAfter = (User)queue.poll();
        System.out.println("userAfter="+userAfter.toString()+",size="+ queue.size());
    }

    public static void main(String[] args) {
        for (int j = 0; j<1000 ; j++) {
            Thread thread =  new Thread(new Runnable() {
                @Override
                public void run() {
                    String acceptReq = acceptReq();
                }
            });
            thread.setName("A-->"+j);
            thread.start();
        }

        /**========================================*/
        User user =null;
         while ((user =queue.pollFirst()) !=null){
             System.out.println("user"+user.toString());
         }
        /*for (int j = 0; j<100 ; j++) {
            Thread threadB =  new Thread(new Runnable() {
                @Override
                public void run() {
                    synchronized (this) {
                        takeReq();
                    }
                }
            });
            threadB.setName("B");
            threadB.start();
        }*/
    }
}


