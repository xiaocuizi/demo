package com.gemini.arithmetic;

/**
 * @author xiaocuzi
 * @package com.gemini.arithmetic
 * @classname: ListDemo
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/3/30 16:02
 * @since 1.0.0
 */
public class ListDemo {

    /**
     * 节点
     */
    public static class Node {
        public static int value;
        public Node next;

        public Node(Node next) {
            this.next = next;
        }
    }

    /**
     * 头节点的插入
     */
    public static void headInsert(Node head, Node node) {
        Node old = head;
        head = node;
        head.next = old;
    }

    public static void tailInsert(Node tail,Node newTail){
        Node old = tail;
        tail =  newTail;
        newTail.next = null;
        old.next = tail;
    }

}
