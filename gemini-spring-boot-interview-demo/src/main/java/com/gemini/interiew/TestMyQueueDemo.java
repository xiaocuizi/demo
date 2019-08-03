package com.gemini.interiew;

/**
 * @author xiaocuzi
 * @package com.gemini.interiew
 * @classname: TestMyQueueDemo
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/6/10 15:10
 * @since 1.0.0
 */
public class TestMyQueueDemo {
    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.add(9);
        myQueue.add(8);
        myQueue.add(7);
        System.out.println(myQueue.poll());;
        myQueue.add(10);
        System.out.println(myQueue.poll());;
    }
}
