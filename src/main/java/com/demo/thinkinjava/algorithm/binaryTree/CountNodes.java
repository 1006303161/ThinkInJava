package com.demo.thinkinjava.algorithm.binaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 222. 完全二叉树的节点个数
 * 中等
 * 827
 * 相关企业
 * 给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。
 * <p>
 * 完全二叉树 的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层，则该层包含 1~ 2h 个节点。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [1,2,3,4,5,6]
 * 输出：6
 * 示例 2：
 * <p>
 * 输入：root = []
 * 输出：0
 * 示例 3：
 * <p>
 * 输入：root = [1]
 * 输出：1
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中节点的数目范围是[0, 5 * 104]
 * 0 <= Node.val <= 5 * 104
 * 题目数据保证输入的树是 完全二叉树
 * <p>
 * <p>
 * 进阶：遍历树来统计节点是一种时间复杂度为 O(n) 的简单解决方案。你可以设计一个更快的算法吗？
 *
 * @author FBI
 */
public class CountNodes {

    /**
     * 递归 后序遍历节点个数
     *
     * @param root
     * @return
     */
    public int countNodes(TreeNode root) {

        if (root == null) return 0;
        int leftNodes = countNodes(root.left);
        int rightNodes = countNodes(root.right);
        //左右中
        return leftNodes + rightNodes + 1;//+1记录当前中间节点
    }

    /**
     * 层序遍历 迭代法
     *
     * @param root
     * @return
     */
    public int countNodes2(TreeNode root) {
        Integer countNode=0;
        if (root == null) return countNode;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){

            //当前层上节点个数
            int size = queue.size();
            while (size-->0){
                TreeNode node = queue.peek();
                countNode++;
                queue.poll();
                //加入左右节点
                if(node.left!=null)queue.add(node.left);
                if(node.right!=null)queue.add(node.right);
            }
        }
        return countNode;
    }

}
