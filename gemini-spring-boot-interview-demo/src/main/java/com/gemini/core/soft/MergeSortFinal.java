package com.gemini.core.soft;

/**
 * @author xiaocuzi
 * @version v1.0.0
 * @Package com.gemini.test.core.soft
 * @classname: MergeSortFinal
 * @Description: todo (用一句话描述该文件做什么)
 * @date 2019/4/6 20:02
 */
public class MergeSortFinal {

    public static void main(String[] args) {
        String str = "abcdfghn";
        boolean a;
        if (str.contains("a")) a = true;
        else a = false;
    }
    static class ListNode {
        public static int value;
        public ListNode next;

        public ListNode(ListNode next) {
            this.next = next;
        }

        public static int getValue() {
            return value;
        }

        public static void setValue(int value) {
            ListNode.value = value;
        }

        public ListNode getNext() {
            return next;
        }

        public void setNext(ListNode next) {
            this.next = next;
        }
    }

    public ListNode merge(ListNode head1, ListNode head2) {
        //TODO 头节点比较小的节点作为基准点
        if (head1 == null || head2 == null) {
            return head1 != null ? head1 : head2;
        }
        int head = head1.value;
        return head1;
    }
}


