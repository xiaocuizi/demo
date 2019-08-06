package com.gemini.interiew.interiew2;

/**
 * @author xiaocuzi
 * @package com.gemini.interiew2
 * @classname: NodeTest
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/6/18 20:36
 * @since 1.0.0
 */
public class NodeTest {
    private void change(Node root) {
        Node temp = root;
        while (temp.getLeft() != null) {
            Node left = temp.getLeft();
            temp.setLeft(temp.getRight());
            temp.setRight(left);
        }
    }
}
