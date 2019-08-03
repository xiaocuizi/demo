package com.gemini.arithmetic;

/**
 * @author xiaocuzi
 * @version v1.0.0
 * @Package com.gemini.arithmetic
 * @classname: MyList
 * @Description: todo (用一句话描述该文件做什么)
 * @date 2019/4/6 20:31
 */
public class MyList {

    /**
     * 头节点的插入
     * @param head
     * @param newHead
     */
    public static void headInsert(ListNode head,ListNode newHead){
        ListNode old = head;
        head = newHead;
        head.next = old;
    }
}


