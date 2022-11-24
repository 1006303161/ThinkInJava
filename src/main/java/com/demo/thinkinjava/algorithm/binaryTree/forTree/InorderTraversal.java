package com.demo.thinkinjava.algorithm.binaryTree.forTree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author FBI
 * 中序遍历
 */
public class InorderTraversal {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        ;

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.left = left;
            this.right = right;
            this.val = val;
        }
    }

    public static List<Integer> inOrderTraversal(TreeNode root) {

        List<Integer> inorderTree = new ArrayList<>();
        return inorder(root, inorderTree);
    }

    /**
     * 中序递归遍历 左 中（节点） 右
     *
     * @param root
     * @return
     */
    public static List<Integer> inorder(TreeNode root, List<Integer> inorderTree) {


        if (root == null) {
            return inorderTree;
        }
        inorder(root.left, inorderTree);
        inorderTree.add(root.val);
        inorder(root.right, inorderTree);

        return inorderTree;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1, null, new TreeNode(2, new TreeNode(3, null, null), null));
        System.out.println(InorderTraversal.inOrderTraversal(treeNode));

    }
}
