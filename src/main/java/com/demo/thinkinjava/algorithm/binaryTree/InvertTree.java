package com.demo.thinkinjava.algorithm.binaryTree;

import com.demo.thinkinjava.algorithm.binaryTree.forTree.deep.ForInorderTraversal;

import java.util.List;
import java.util.Stack;

/**
 * 226. 翻转二叉树
 * 简单
 * 1.5K
 * 相关企业
 * 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
 *
 * @author FBI
 */
public class InvertTree {

    public TreeNode invertTree(TreeNode root) {
        //前序遍历 中左右

        if (root == null) {
            return null;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.right);
        invertTree(root.left);
        return root;
    }

    //中序遍历 反转
    public static TreeNode invertInOrderTraversal(TreeNode root) {
        if (root == null) {
            return root;
        }

        //用栈 记录需要处理的元素
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            TreeNode pop = stack.peek();
            if (pop != null) {
                //左中右
                stack.pop();
                //入栈 右 中 左
                if (pop.right != null) {
                    stack.push(pop.right);
                }
                stack.push(pop);
                stack.push(null);
                if (pop.left != null) {
                    stack.push(pop.left);
                }
            } else {
                stack.pop();
                TreeNode peek = stack.peek();
                stack.pop();
                TreeNode tempNode = peek.left;
                peek.left = peek.right;
                peek.right = tempNode;
            }
        }
        return root;
    }

}
