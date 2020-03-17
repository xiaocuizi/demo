package com.gemini.demo.core.list;

/**
 * @author xiaocuzi
 * @package com.gemini.demo.core
 * @classname: Node
 * @description: todo (用一句话描述该文件做什么)
 * @date 2020/1/7 16:54
 * @since 1.0.0
 */
public  class Node {
    public long data;
    public Node next;


    public Node(Node next) {
        this.next = next;
    }

    public void  display(){
        System.out.println("data=>"+this.data
        );
    }
}
