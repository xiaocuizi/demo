package com.gemini.demo.core.list;

/**
 * @author xiaocuzi
 * @package com.gemini.demo.core.list
 * @classname: SingleLinkedList
 * @description: 单列表的反转
 * @date 2020/1/7 19:06
 * @since 1.0.0
 */
public class SingleLinkedList {

    private Node first;

    public SingleLinkedList() {
        this.first = null;
    }

    /**
     * 插入一个节点，在头结点之后进行插入
     */

    public void insert(int value){
        Node node = new Node(value);
        node.next = first.next;
        first = node;
    }
}
