package com.gemini.demo.core.stack;

/**
 * @author xiaocuzi
 * @package com.gemini.demo.core.stack
 * @classname: Mystatic
 * @description: todo (用一句话描述该文件做什么)
 * @date 2020/1/10 10:39
 * @since 1.0.0
 */
public class Mystatck {
    private long[] arr;
    private int top;

    public Mystatck() {
        this.arr = new long[10];
        this.top = -1;
    }

    public Mystatck(int maxSize) {
        this.arr = new long[maxSize];
        this.top = -1;
    }

    public void push(int value) {
        arr[++top] = value;
    }

    public long pop() {
        return arr[top--];
    }

    public long peek() {
        return arr[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == arr.length - 1;
    }


    public static void main(String[] args) {
        Mystatck mystatck = new Mystatck(3);
        mystatck.push(1);
        mystatck.push(2);
        mystatck.push(3);

        System.out.println(mystatck.isFull());
        System.out.println(mystatck.isEmpty());
    }
}
