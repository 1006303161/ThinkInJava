package com.demo.thinkinjava.algorithm.binaryTree;

/**
 * 110. 平衡二叉树
 * 简单
 * 1.2K
 * 相关企业
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 *
 * 本题中，一棵高度平衡二叉树定义为：
 *
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：true
 * 示例 2：
 *
 *
 * 输入：root = [1,2,2,3,3,null,null,4,4]
 * 输出：false
 * 示例 3：
 *
 * 输入：root = []
 * 输出：true
 *
 *
 * 提示：
 *
 * 树中的节点数在范围 [0, 5000] 内
 * -104 <= Node.val <= 104
 * @author FBI
 */
public class IsBalanced {
    public boolean isBalanced(TreeNode root) {
        if(root==null)return true;
        return getTreeDept(root)!=-1;
    }

    public int getTreeDept(TreeNode node){
        if(node==null)return 0;
        int leftHeight = getTreeDept(node.left);
        if(leftHeight==-1)return -1;
        int rightHeight = getTreeDept(node.right);
        if(rightHeight==-1)return -1;
        int height = Math.abs(rightHeight - leftHeight);
        //如果左右不平衡返回-1，否则返回当前节点为根节点的树的最大高度
        return height>1?-1:Math.max(rightHeight,leftHeight)+1;
    }
}
