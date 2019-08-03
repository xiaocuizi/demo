package com.gemini.interiew;

/**
 * @author xiaocuzi
 * @package com.gemini.interiew
 * @classname: Node
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/6/10 15:51
 * @since 1.0.0
 */
public class LoopNode {

    int data;
    // 如果只有一个节点的话，下一个节点就是自己本身
    LoopNode next = this;

    public LoopNode(int data) {
        this.data = data;
    }



    public void removeNext() {
        LoopNode newNext = this.next.next;
        this.next = newNext;
    }

    public LoopNode getNext() {
        return this.next;
    }

    public int getData() {
        return this.data;
    }


    /**
     * 当前节点的下一个节点
     *
     * @param node
     */
    public void after(LoopNode node) {
        // 当前节点的下一个节点
        LoopNode next = this.next;
        this.next = node;
        node.next = next;
    }
}
