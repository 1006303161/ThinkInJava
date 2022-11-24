package com.demo.thinkinjava.algorithm.binaryTree.forTree.deep.forSameCodeDeepTree;

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
public class ForSamePostorderTraversal {

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

        List<Integer> inorderTree = new ArrayList<>();

        //存元素顺序的栈
        Stack<TreeNode> stack = new Stack<>();
        if (root != null) {
            //根节点先入栈
            stack.add(root);
        }
        //栈内 需要处理的元素进行空标记，栈内元素全部出栈则结束
        while (!stack.isEmpty()) {
            //获取头节点
            TreeNode cur = stack.peek();
            //左右中 右左中 对称 中左右倒叙
            if (cur != null) {
                //栈内元素先出栈
                stack.pop();

                //左元素不为空 放入左元素
                if (cur.left != null) {
                    stack.push(cur.left);
                }
                //右元素不为空 放入右元素
                if (cur.right != null) {
                    stack.push(cur.right);
                }

                //放入中间元素 但元素还未处理 需要添加null标记
                stack.push(cur);
                stack.push(null);

            } else {
                //如果栈顶有标记 则出栈 入集合
                stack.pop();
                inorderTree.add(stack.pop().val);
            }
        }
        Collections.reverse(inorderTree);
        return inorderTree;
    }


    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1, null, new TreeNode(2, new TreeNode(3, null, null), null));
        System.out.println(ForSamePostorderTraversal.postorderTraversal(treeNode));
    }

}
