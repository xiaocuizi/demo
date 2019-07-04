package com.gemini.bio;

/**
 * @author xiaocuzi
 * @package com.gemini.bio
 * @classname: Node
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/6/18 20:34
 * @since 1.0.0
 */
public class Node {
    private Node left;
    private Node mid;
    private Node right;
    private int value;

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getMid() {
        return mid;
    }

    public void setMid(Node mid) {
        this.mid = mid;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
