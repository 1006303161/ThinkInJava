package com.demo.thinkinjava.algorithm.binaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 二叉搜索树中的搜索
 * 简单
 * 346
 * 相关企业
 * 给定二叉搜索树（BST）的根节点 root 和一个整数值 val。
 * <p>
 * 你需要在 BST 中找到节点值等于 val 的节点。 返回以该节点为根的子树。 如果节点不存在，则返回 null 。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * 输入：root = [4,2,7,1,3], val = 2
 * 输出：[2,1,3]
 * 示例 2:
 * <p>
 * <p>
 * 输入：root = [4,2,7,1,3], val = 5
 * 输出：[]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 数中节点数在 [1, 5000] 范围内
 * 1 <= Node.val <= 107
 * root 是二叉搜索树
 * 1 <= val <= 107
 *
 * @author FBI
 */
public class SearchBST {

    /**
     * 先序遍历寻找节点  题目根节点不为空！
     *
     * @param root
     * @param val
     * @return
     */
    public TreeNode searchBST(TreeNode root, int val) {

        //根节点
        if (root.val == val) {
            return root;
        }
        //左节点
        if (root.left != null) {
            TreeNode node = searchBST(root.left, val);
            if (node != null) return node;
        }
        //右节点
        if (root.right != null) {
            TreeNode node = searchBST(root.right, val);
            if (node != null) return node;
        }
        //查不到返回空
        return null;
    }

    /**
     * 二叉搜索树有序，可以根据值的大小判断递归
     *
     * @param root
     * @param val
     * @return
     */
    public TreeNode searchBST2(TreeNode root, int val) {

        //根节点
        if (root == null || root.val == val) {
            return root;
        }
        //左节点
        if (root.val > val) {
            return searchBST(root.left, val);
        }
        //右节点
        if (root.val < val) {
            return searchBST(root.right, val);
        }
        //查不到返回空
        return null;
    }

    /**
     * 二叉搜索树层序遍历 判断返回值
     *
     * @param root
     * @param val
     * @return
     */
    public TreeNode searchBST3(TreeNode root, int val) {

        //根节点
        if (root == null || root.val == val) {
            return root;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            while (size>0){
                TreeNode peek = queue.peek();
                if(peek.val==val){
                    return peek;
                }
                queue.poll();
                size--;
                //搜索值在左子树
                if(peek.val>val&&peek.left!=null){
                    queue.add(peek.left);
                    break;
                }
                if(peek.val<val&&peek.right!=null){
                    queue.add(peek.right);
                    break;
                }
            }
        }

        //查不到返回空
        return null;
    }

    /**
     * 迭代法遍历 简单
     * @param root
     * @param val
     * @return
     */
    public TreeNode searchBST4(TreeNode root, int val) {

        //根节点
        while (root!=null){
            if(root.val==val)return root;
            else if(root.val>val) root=root.left;
            else  root=root.right;
        }
        //查不到返回空
        return null;
    }

    public static void main(String[] args) {
        SearchBST searchBST = new SearchBST();
        TreeNode node = searchBST.searchBST(new TreeNode(4, new TreeNode(2, new TreeNode(1, null, null), new TreeNode(3, null, null)), new TreeNode(7, null, null)), 2);
        System.out.println(node);
    }
}
