package com.demo.thinkinjava.algorithm.binaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * 404. 左叶子之和
 * 简单
 * 526
 * 相关企业
 * 给定二叉树的根节点 root ，返回所有左叶子之和。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入: root = [3,9,20,null,null,15,7]
 * 输出: 24
 * 解释: 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
 * 示例 2:
 * <p>
 * 输入: root = [1]
 * 输出: 0
 * <p>
 * <p>
 * 提示:
 * <p>
 * 节点数在 [1, 1000] 范围内
 * -1000 <= Node.val <= 1000
 *
 * @author FBI
 */
public class SumOfLeftLeaves {

    /**
     * 中序遍历找左节点之和
     *
     * @param root
     * @return
     */
    public int sumOfLeftLeaves(TreeNode root) {
        //叶子节点无法判断是否是左节点，但是也是终止条件，遍历空树回归
        if (root==null) return 0;
        //当前节点有左节点 并且左节点的左右节点为空，则当前节点的左节点为左叶子节点
        if(root.left==null&&root.right==null)return 0;
        int leftNodeSum = sumOfLeftLeaves(root.left);
        if (root.left!=null&&root.left.left == null&&root.left.right == null) {
            leftNodeSum+=root.left.val;
        }
        int rightNodeSum= sumOfLeftLeaves(root.right);

        return leftNodeSum+rightNodeSum;
    }

}
