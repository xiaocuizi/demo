package com.gemini.interiew.interiew2;

/**
 * @author xiaocuzi
 * @package com.gemini.interiew2
 * @classname: TestBinaryTree
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/6/18 21:15
 * @since 1.0.0
 */
public class TestBinaryTree {
    public static void main(String[] args) {
        BinaryTree binTree = new BinaryTree();
        TreeNode root = new TreeNode(1);
        // 根节点
        binTree.setRoot(root);
        TreeNode rootL = new TreeNode(2);
        TreeNode rootR = new TreeNode(3);
        // 左节点
        root.setLeftNode(rootL);
        // 右节点
        root.setRightNode(rootR);
        // 第二次做节点创建

        rootL.setLeftNode(new TreeNode(4));
        rootL.setRightNode(new TreeNode(5));

        rootR.setLeftNode(new TreeNode(6));
        rootR.setRightNode(new TreeNode(7));

        binTree.frontShow();
        System.out.println("========");
        binTree.midShow();
        System.out.println("========");
        binTree.afterShow();
        // TODO =========================================


    }

    public void mirror(TreeNode root) {

        if (root == null) {
            return;
        }

        if (root.leftNode == null && root.rightNode == null) {
            return;
        }
        TreeNode temp = null;
        temp = root.leftNode;
        root.leftNode = root.rightNode;
        root.rightNode = temp;

        if (root.leftNode != null) {
            mirror(root.leftNode);
        }
        if (root.rightNode != null) {
            mirror(root.rightNode);
        }

    }
}
