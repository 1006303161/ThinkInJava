package com.demo.thinkinjava.algorithm.binaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * 530. 二叉搜索树的最小绝对差
 * 简单
 * 404
 * 相关企业
 * 给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
 *
 * 差值是一个正数，其数值等于两值之差的绝对值。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：root = [4,2,6,1,3]
 * 输出：1
 * 示例 2：
 *
 *
 * 输入：root = [1,0,48,null,null,12,49]
 * 输出：1
 *
 *
 * 提示：
 *
 * 树中节点的数目范围是 [2, 104]
 * 0 <= Node.val <= 105
 * @author FBI
 */
public class GetMinimumDifference {

    /**
     * 二叉搜索树是有序的 可以通过中序遍历获得有序数组 并解决递增数组的问题
     * @param root
     * @return
     */
    public int getMinimumDifference(TreeNode root) {
        List<Integer> nums = new ArrayList<>();
        getInOrderBST(root,nums);

        int minVal=Integer.MAX_VALUE;
        for (int i = 1; i < nums.size(); i++) {
            minVal= Math.min(minVal,Math.abs(nums.get(i)-nums.get(i-1)));
        }
        return minVal;
    }
    public void getInOrderBST(TreeNode root, List<Integer> nums) {
        if (root == null) return;

        //左
        if (root.left != null) {
            getInOrderBST(root.left, nums);
        }
        //中
        nums.add(root.val);
        //右
        if (root.right != null) {
            getInOrderBST(root.right, nums);
        }
    }

    //保存上一个节点
    private TreeNode pre;
    //最小值
     Integer result =Integer.MAX_VALUE;
    public int getMinimumDifference2(TreeNode root) {
        if(root==null)return 0;
        traversal(root);
        return result;
    }

    /**
     * 简单遍历
     * @param node
     */
    public void traversal(TreeNode node){
        if(node==null)return;

        //左
        if(node.left!=null){
            traversal(node.left);
        }
        //中 第一个根节点不比较
        if(pre!=null){
            result=Math.min(result,Math.abs(pre.val-node.val));
        }

        pre=node;
        //右
        if(node.right!=null){
            traversal(node.right);
        }
    }

}
