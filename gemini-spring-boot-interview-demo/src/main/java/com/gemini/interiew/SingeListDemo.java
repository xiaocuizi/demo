package com.gemini.interiew;

/**
 * @author xiaocuzi
 * @package com.gemini.interiew
 * @classname: SingeListDemo
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/6/10 15:52
 * @since 1.0.0
 */
public class SingeListDemo {
    public static void main(String[] args) {
        // 创建节点
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        // 追加节点
        n1.append(n2);
        n2.append(n3);
        // System.out.println(n1.next.getData());
        n1.show();
        System.out.println("xxxxxxxxxxxx");
        Node node5 = new Node(5);
        n1.getNext().after(node5);
        n1.show();
    }
}
