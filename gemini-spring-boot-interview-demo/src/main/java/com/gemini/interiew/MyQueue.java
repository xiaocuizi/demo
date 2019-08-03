package com.gemini.interiew;

/**
 * @author xiaocuzi
 * @package com.gemini.interiew
 * @classname: MyQueue
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/6/10 15:02
 * @since 1.0.0
 */
public class MyQueue {
    int[] elements;

    public MyQueue() {
        this.elements = new int[0];
    }

    public void add(int e) {
        int[] newArr = new int[elements.length + 1];
        for (int i = 0; i < elements.length; i++) {
            newArr[i] = elements[i];
        }
        newArr[elements.length] = e;
        elements = newArr;
    }

    public int poll() {
        int element = elements[0];
        int newArr[] = new int[elements.length - 1];
        for (int i = 0; i < newArr.length; i++) {
            newArr[i] = elements[i + 1];
        }
        elements = newArr;
        return element;
    }
}
