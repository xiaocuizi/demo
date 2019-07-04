package com.gemini.bio.tree;

/**
 * @author xiaocuzi
 * @package com.gemini.bio.tree
 * @classname: TestArrayBinaryTree
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/6/24 21:49
 * @since 1.0.0
 */
public class TestArrayBinaryTree {
    public static void main(String[] args) {
        int[] a = new int[]{1,2,3,4,5,6,7};
        ArrayBinaryTree arrayBinaryTree = new ArrayBinaryTree(a);
        arrayBinaryTree.frontShow();
    }
}

