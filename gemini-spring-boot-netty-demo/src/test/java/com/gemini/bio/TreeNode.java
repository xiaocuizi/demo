package com.gemini.bio;

/**
 * @author xiaocuzi
 * @package com.gemini.bio
 * @classname: TreeNode
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/6/18 21:16
 * @since 1.0.0
 */
public class TreeNode {
    TreeNode leftNode;
    TreeNode rightNode;
    int value;

    public TreeNode(int value) {
        this.value = value;
    }

    public TreeNode getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(TreeNode leftNode) {
        this.leftNode = leftNode;
    }

    public TreeNode getRightNode() {
        return rightNode;
    }

    public void setRightNode(TreeNode rightNode) {
        this.rightNode = rightNode;
    }

    // 前序遍历
    public void frontShow() {
        // 本身
        System.out.print(value+" ");
        // 左节点
        if (leftNode != null) {
            leftNode.frontShow();
        }

        // 右节点
        if (rightNode != null) {
            rightNode.frontShow();
        }
    }

    // 前序遍历
    public void midShow() {

        // 左节点
        if (leftNode != null) {
            leftNode.midShow();
        }
        // 本身
        System.out.print(value+" ");
        // 右节点
        if (rightNode != null) {
            rightNode.midShow();
        }
    }

    // 后序遍历
    public void afterShow() {

        // 左节点
        if (leftNode != null) {
            leftNode.afterShow();
        }

        // 右节点
        if (rightNode != null) {
            rightNode.afterShow();
        }

        // 本身
        System.out.print(value+" ");
    }


}
