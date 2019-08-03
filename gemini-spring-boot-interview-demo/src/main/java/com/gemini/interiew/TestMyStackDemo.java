package com.gemini.interiew;

/**
 * @author xiaocuzi
 * @package com.gemini.interiew
 * @classname: TestMyStackDemo
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/6/10 14:40
 * @since 1.0.0
 */
public class TestMyStackDemo {

    public static void main(String[] args) throws InterruptedException {
        MyStack myStack = new MyStack();
        myStack.push(9);
        myStack.push(8);
        myStack.push(7);
        System.out.println(myStack.pop());
        Thread.sleep(100);
        System.out.println(myStack.peek());
    }
}
