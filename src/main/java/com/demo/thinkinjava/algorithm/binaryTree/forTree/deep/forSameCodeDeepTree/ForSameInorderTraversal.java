package com.demo.thinkinjava.algorithm.binaryTree.forTree.deep.forSameCodeDeepTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author FBI
 * 中序遍历
 */
public class ForSameInorderTraversal {

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
            //左中右 栈内先进右 右后出
            if (cur != null) {
                //栈内元素先出栈
                stack.pop();
                //右元素不为空 放入右元素
                if (cur.right != null) {
                    stack.push(cur.right);
                }
                //放入中间元素 但元素还未处理 需要添加null标记
                stack.push(cur);
                stack.push(null);
                //左元素不为空 放入左元素
                if (cur.left != null) {
                    stack.push(cur.left);
                }
            } else {
                //如果栈顶有标记 则出栈 入集合
                stack.pop();
                inorderTree.add(stack.pop().val);
            }
        }
        return inorderTree;
    }


    public static void main(String[] args) {
        ForSameInorderTraversal.TreeNode treeNode = new ForSameInorderTraversal.TreeNode(1, null, new ForSameInorderTraversal.TreeNode(2, new ForSameInorderTraversal.TreeNode(3, null, null), null));
        System.out.println(ForSameInorderTraversal.inOrderTraversal(treeNode));

    }
}
