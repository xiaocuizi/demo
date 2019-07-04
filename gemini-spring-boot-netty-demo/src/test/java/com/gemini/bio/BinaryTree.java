package com.gemini.bio;

/**
 * @author xiaocuzi
 * @package com.gemini.bio
 * @classname: BinaryTree
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/6/18 21:14
 * @since 1.0.0
 */
public class BinaryTree {
    TreeNode root;

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    public void frontShow() {
        root.frontShow();
    }
    public void midShow() {
        root.midShow();
    }

    public void afterShow() {
        root.afterShow();
    }

}
