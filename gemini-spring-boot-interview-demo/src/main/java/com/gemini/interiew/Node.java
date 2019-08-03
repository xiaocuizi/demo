package com.gemini.interiew;

/**
 * @author xiaocuzi
 * @package com.gemini.interiew
 * @classname: Node
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/6/10 15:51
 * @since 1.0.0
 */
public class Node {

    int data;

    Node next;

    public Node(int data) {
        this.data = data;
    }


    /**
     * 追加
     *
     * @param node
     * @return
     */
    public Node append(Node node) {
        // this.next = node;
        Node currentNode = this;
        /**
         *  1 -> 2 -> 3 -> null
         */
        while (true) {
            Node nextNode = currentNode.next;
            if (nextNode == null) {
                break;
            }
            currentNode = nextNode;
        }
        currentNode.next = node;
        return this;
    }

    public void removeNext() {
        Node newNext = this.next.next;
        this.next = newNext;
    }

    public Node getNext() {
        return this.next;
    }

    public int getData() {
        return this.data;
    }

    public boolean isLast() {
        return this.next == null ? true : false;
    }

    /**
     * 当前节点的下一个节点
     *
     * @param node
     */
    public void after(Node node) {
        // 当前节点的下一个节点
        Node next = this.next;
        this.next = node;
        node.next = next;
    }

    public void show() {
        Node current = this;
        while (true) {
            System.out.println(current.getData());
            current = current.next;
            if (current == null) {
                break;
            }
        }
    }
}
