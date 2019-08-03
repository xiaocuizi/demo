package com.gemini.algorithm;

/**
 * @author xiaocuzi
 * @package com.gemini.algorithm
 * @classname: Node
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/7/29 16:04
 * @since 1.0.0
 */
public class Node {
    private Node left;
    private Node right;
    private int val;

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }
}
