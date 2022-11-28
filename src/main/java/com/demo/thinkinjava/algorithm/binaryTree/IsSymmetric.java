package com.demo.thinkinjava.algorithm.binaryTree;


import java.util.LinkedList;
import java.util.Queue;

/**
 * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [1,2,2,3,4,4,3]
 * 输出：true
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [1,2,2,null,3,null,3]
 * 输出：false
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中节点数目在范围 [1, 1000] 内
 * -100 <= Node.val <= 100
 * <p>
 * <p>
 * 进阶：你可以运用递归和迭代两种方法解决这个问题吗？
 *
 * @author FBI
 */
public class IsSymmetric {

    /**
     * 递归法
     *
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return compareVal(root.left, root.right);
    }


    public boolean compareVal(TreeNode left, TreeNode right) {
        //几种左右节点为空的情况比较
        if (left != null && right == null) return false;
        if (left == null && right != null) return false;
        if (left == null && right == null) return true;
        if (left.val != right.val) return false;
        //左右节点不为空 的情况如下： 遍历顺序类似于后序
        boolean outside = compareVal(left.left, right.right);//左子树左节点和右子树右节点
        boolean inside = compareVal(left.right, right.left);//左子树右节点和右子树左节点
        boolean isSame = outside && inside;
        return isSame;
    }

    /**
     * 迭代法 用队列或者栈来判断
     *
     * @param root
     * @return
     */
    public boolean isSymmetric2(TreeNode root) {
        if (root == null) return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);
        while (!queue.isEmpty()) {
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();

            if (left == null && right == null) continue;
            //为空情况判断
            if (left != null && right == null) return false;
            if (left == null && right != null) return false;
            if (left.val != right.val) return false;

            //相等时候遍历子元素
            queue.add(left.left);
            queue.add(right.right);
            queue.add(left.right);
            queue.add(right.left);
        }
        return true;


    }

}
