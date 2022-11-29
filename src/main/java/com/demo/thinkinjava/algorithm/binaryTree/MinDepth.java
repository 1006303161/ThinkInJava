package com.demo.thinkinjava.algorithm.binaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 111. 二叉树的最小深度
 * 简单
 * 882
 * 相关企业
 * 给定一个二叉树，找出其最小深度。
 * <p>
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * <p>
 * 说明：叶子节点是指没有子节点的节点。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：2
 * 示例 2：
 * <p>
 * 输入：root = [2,null,3,null,4,null,5,null,6]
 * 输出：5
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中节点数的范围在 [0, 105] 内
 * -1000 <= Node.val <= 1000
 *
 * @author FBI
 */
public class MinDepth {

    /**
     * 递归后序遍历 求该节点到叶子节点的最短路径  高度
     *
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        return getMinDepTree(root);
    }

    public int getMinDepTree(TreeNode node) {
        if(node==null)return 0;

        int leftDept = getMinDepTree(node.left);
        int rightDept = getMinDepTree(node.right);

        //左子树为空，右子树不为空 则返回右子树上最短路径
        if(node.left==null&&node.right!=null){
           return rightDept+1;
        }
        //同上
        if(node.left!=null&&node.right==null){
           return leftDept+1;
        }
        //左右都有则返回两棵树上较短的那一个
        return Math.min(leftDept,rightDept)+1;
    }

    /**
     * 层序遍历
     *
     * @param root
     * @return
     */
    public int minDepth2(TreeNode root) {
        int deep = 0;
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
                if (peek.left == null && peek.right == null) {
                    levelQue.clear();
                    break;
                }
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
