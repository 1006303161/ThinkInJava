package com.demo.thinkinjava.algorithm.binaryTree.forTree.deep.forSameCodeDeepTree;

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
public class ForSamePreorderTraversal {

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
            //中左右 栈内先进右 右后出
            if (cur != null) {
                //栈内元素先出栈
                stack.pop();
                //右元素不为空 放入右元素
                if (cur.right != null) {
                    stack.push(cur.right);
                }
                //左元素不为空 放入左元素
                if (cur.left != null) {
                    stack.push(cur.left);
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
        return inorderTree;
    }




    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1, new TreeNode(2, null, null), new TreeNode(3, null, null));
        System.out.println(ForSamePreorderTraversal.preorderTraversal(treeNode));
    }

}
