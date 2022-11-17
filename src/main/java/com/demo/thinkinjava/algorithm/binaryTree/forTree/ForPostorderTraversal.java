package com.demo.thinkinjava.algorithm.binaryTree.forTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * 145. 二叉树的后序遍历 迭代法
 * 简单
 * 945
 * 相关企业
 * 给你一棵二叉树的根节点 root ，返回其节点值的 后序遍历 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [1,null,2,3]
 * 输出：[3,2,1]
 * 示例 2：
 * <p>
 * 输入：root = []
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：root = [1]
 * 输出：[1]
 *
 * @author FBI
 */
public class ForPostorderTraversal {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        ;

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * 后序遍历  左右中
     *
     * @param root
     * @return
     */
    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> addTreeNoList = new ArrayList<>();
        if (root == null) {
            return addTreeNoList;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.empty()) {

            TreeNode pop = stack.pop();
            addTreeNoList.add(pop.val);
            //todo 后序 左右中 相当于 前序 中左右---右左节点颠倒顺序--->中右左---倒叙处理---->左右中

            if (pop.left != null) {
                stack.add(pop.left);
            }
            if (pop.right != null) {
                stack.add(pop.right);
            }
        }
        Collections.reverse(addTreeNoList);
        return addTreeNoList;
    }


    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1, null, new TreeNode(2, new TreeNode(3, null, null), null));
        System.out.println(ForPostorderTraversal.postorderTraversal(treeNode));
    }

}
