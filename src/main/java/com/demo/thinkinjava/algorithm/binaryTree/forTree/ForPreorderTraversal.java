package com.demo.thinkinjava.algorithm.binaryTree.forTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 144. 二叉树的前序遍历 迭代
 * 简单
 * 943
 * 相关企业
 * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [1,null,2,3]
 * 输出：[1,2,3]
 * 示例 2：
 * <p>
 * 输入：root = []
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：root = [1]
 * 输出：[1]
 * 示例 4：
 * <p>
 * <p>
 * 输入：root = [1,2]
 * 输出：[1,2]
 * 示例 5：
 * <p>
 * <p>
 * 输入：root = [1,null,2]
 * 输出：[1,2]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中节点数目在范围 [0, 100] 内
 * -100 <= Node.val <= 100
 *
 * @author FBI
 */
public class ForPreorderTraversal {

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
     * 前序遍历  中左右  入栈顺序 中右左 迭代法
     *
     * @param root
     * @return
     */
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> arr = new ArrayList<>();
        if(root==null){
            return arr;
        }
        Stack<TreeNode> arrStack = new Stack<>();
        arrStack.add(root);
        while (!arrStack.empty()) {
            TreeNode pop = arrStack.pop();
            arr.add(pop.val);
            //入栈先右后左  出栈才是中左右
            if(pop.right!=null){
                arrStack.push(pop.right);
            }
            if(pop.left!=null){
                arrStack.push(pop.left);
            }
        }
        return arr;
    }




    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3, new TreeNode(1, null, null), new TreeNode(2, null, null));
        System.out.println(ForPreorderTraversal.preorderTraversal(treeNode));
    }

}
