package com.gemini.interiew;

/**
 * @author xiaocuzi
 * @package com.gemini.interiew
 * @classname: TestLoopNodeDemo
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/6/10 17:11
 * @since 1.0.0
 */
public class TestLoopNodeDemo {


    public static void main(String[] args) {
        LoopNode n1 = new LoopNode(1);
        LoopNode n2 = new LoopNode(2);
        LoopNode n3 = new LoopNode(3);
        LoopNode n4 = new LoopNode(4);
        n1.after(n2);
        n2.after(n3);
        n3.after(n4);
        System.out.println(n1.getNext().getData());
        System.out.println(n2.getNext().getData());
        System.out.println(n3.getNext().getData());
        System.out.println(n4.getNext().getData());
    }
}
