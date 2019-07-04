package com.gemini.bio.tree;

/**
 * @author xiaocuzi
 * @package com.gemini.bio.tree
 * @classname: ArrayBinaryTree
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/6/24 21:45
 * @since 1.0.0
 */
public class ArrayBinaryTree {
    int[] data;

    public ArrayBinaryTree(int[] data) {
        this.data = data;
    }

    public void frontShow() {
        frontShow(0);
    }

    public void frontShow(int index) {
        if (data == null || data.length == 0) {
            return;
        }
        System.out.println(data[index]);

        if (2 * index + 1 < data.length) {
            frontShow(2 * index + 1);
        }

        if (2 * index + 2 < data.length) {
            frontShow(2 * index + 2);
        }

    }
}
