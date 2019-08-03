package com.gemini.arithmetic.singlelist;

import com.gemini.arithmetic.ListDemo;

/**
 * @author xiaocuzi
 * @package com.gemini.arithmetic.singlelist
 * @classname: Test
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/3/30 16:18
 * @since 1.0.0
 */
public class Test {
    /**
     * 反转链表
     */
    public static ListDemo.Node reverseList(ListDemo.Node head) {
        ListDemo.Node pre = null;
        ListDemo.Node next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
     return pre;
    }
}
