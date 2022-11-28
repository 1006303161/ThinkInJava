package com.demo.thinkinjava.algorithm.binaryTree.forTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 104. 二叉树的最大深度
 * 简单
 * 1.4K
 * 相关企业
 * 给定一个二叉树，找出其最大深度。
 * <p>
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回它的最大深度 3 。
 *
 * @author FBI
 */
public class MaxDepth {
    /**
     * 递归法
     *
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        //递归根节点到叶子节点的深度； 后序遍历
        return getDepth(root);
    }


    public int getDepth(TreeNode node) {
        if (node == null) return 0;
        //左子树节点
        int leftDepth = getDepth(node.left);
       //右子树节点长度
        int rightDept = getDepth(node.right);
        return Math.max(leftDepth,rightDept)+1;
    }


    public int maxDepth2(TreeNode root) {
        int deep=0;
        if (root == null) {
            return deep;
        }
        Queue<TreeNode> levelQue = new LinkedList<>();
        levelQue.add(root);
        //队列为空，则遍历完最后的叶子节点
        while (!levelQue.isEmpty()) {
            deep++;
            //记录当前层节点个数，当前层的队列全部出栈，则当前层遍历结束
            int size = levelQue.size();
            while (size > 0) {
                size--;
                TreeNode peek = levelQue.peek();
                levelQue.poll();
                if (peek.left != null) {
                    levelQue.add(peek.left);
                }
                if (peek.right != null) {
                    levelQue.add(peek.right);
                }
            }
        }
        return deep;
    }
}
