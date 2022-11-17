package com.demo.thinkinjava.algorithm.binaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 *145. 二叉树的后序遍历
 * 简单
 * 945
 * 相关企业
 * 给你一棵二叉树的根节点 root ，返回其节点值的 后序遍历 。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：root = [1,null,2,3]
 * 输出：[3,2,1]
 * 示例 2：
 *
 * 输入：root = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：root = [1]
 * 输出：[1]
 *
 * @author FBI
 */
public class PostorderTraversal {

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
        List<Integer> arr = new ArrayList<>();
        return postOrderList(root, arr);
    }

    /**
     * 后序遍历 左右中
     * @param root
     * @param preOrderArr
     * @return
     */
    public static List<Integer> postOrderList(TreeNode root, List<Integer> preOrderArr) {

        //终止条件
        if (root == null) {
            return preOrderArr;
        }
        postOrderList(root.left, preOrderArr);
        postOrderList(root.right, preOrderArr);
        preOrderArr.add(root.val);

        return preOrderArr;
    }



    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1, null, new TreeNode(2, new TreeNode(3, null, null), null));
        System.out.println(PostorderTraversal.postorderTraversal(treeNode));
    }

}
