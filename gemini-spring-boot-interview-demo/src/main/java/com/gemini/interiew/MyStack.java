package com.gemini.interiew;

/**
 * @author xiaocuzi
 * @package com.gemini.interiew
 * @classname: MyStack
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/6/10 14:20
 * @since 1.0.0
 */
public class MyStack {
    // 数组
    int[] elements;

    public MyStack() {
        // 初始化栈
        elements = new int[0];
    }


    /**
     * 压入元素
     *
     * @param e
     */
    public void push(int e) {
        int[] newArr = new int[elements.length + 1];
        for (int i = 0; i < elements.length; i++) {
            newArr[i] = elements[i];
        }
        newArr[elements.length] = e;
        elements = newArr;
    }


    /**
     * 会删除元素
     *
     * @return
     */
    public int pop() {
        if (elements.length == 0) {
            throw new RuntimeException("栈是空的");
        }
        int element = elements[elements.length - 1];
        int[] newArr = new int[elements.length - 1];
        for (int i = 0; i < elements.length - 1; i++) {
            newArr[i] = elements[i];
        }
        elements = newArr;
        return element;
    }


    /**
     * 只是查询不删除元素
     *
     * @return
     */
    public int peek() {
        if (elements.length == 0) {
            throw new RuntimeException("栈是空的");
        }
        // 0 - elements.length - 1
        return elements[elements.length - 1];
    }
}
