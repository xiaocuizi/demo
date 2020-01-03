package com.gemini.arithmetic;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author xiaocuzi
 * @package com.gemini.arithmetic
 * @classname: TreeList
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/12/13 15:47
 * @since 1.0.0
 */
public class TreeList {

    public List<Integer> loop(TreeNode root) {
        if (root == null) {
            return Lists.newArrayList();
        }
        List<Integer> integerList = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            integerList.add(node.val);
            if (node.left != null) {
                queue.offer(node);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }

        return integerList;
    }


    public static class TreeNode {
        int val;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
/*————————————————
    版权声明：本文为CSDN博主「NetlabCC」的原创文章，遵循 CC 4.0 BY-SA 版权协议，转载请附上原文出处链接及本声明。
    原文链接：https://blog.csdn.net/weixin_40808643/article/details/79734718*/
}
