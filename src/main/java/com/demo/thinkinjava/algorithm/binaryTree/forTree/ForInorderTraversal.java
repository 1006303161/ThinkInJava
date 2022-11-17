package com.demo.thinkinjava.algorithm.binaryTree.forTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author FBI
 * 中序遍历
 */
public class ForInorderTraversal {

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
        if (root == null) {
            return inorderTree;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {

            //左节点不为空 就一直找
            if(cur!=null){
                stack.push(cur);
                cur=cur.left;
            }else {
                //先添加中 节点 再 寻找右节点
                cur = stack.pop();
                inorderTree.add(cur.val);
                cur=cur.right;
            }
        }

        return inorderTree;
    }


    public static void main(String[] args) {
        ForInorderTraversal.TreeNode treeNode = new ForInorderTraversal.TreeNode(1, null, new ForInorderTraversal.TreeNode(2, new ForInorderTraversal.TreeNode(3, null, null), null));
        System.out.println(ForInorderTraversal.inOrderTraversal(treeNode));

    }
}
