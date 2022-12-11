package com.demo.thinkinjava.algorithm.binaryTree;

import java.util.HashMap;

/**
 * 最大二叉树
 * 给定一个不重复的整数数组 nums 。 最大二叉树 可以用下面的算法从 nums 递归地构建:
 *
 * 创建一个根节点，其值为 nums 中的最大值。
 * 递归地在最大值 左边 的 子数组前缀上 构建左子树。
 * 递归地在最大值 右边 的 子数组后缀上 构建右子树。
 * 返回 nums 构建的 最大二叉树 。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：nums = [3,2,1,6,0,5]
 * 输出：[6,3,5,null,2,0,null,null,1]
 * 解释：递归调用如下所示：
 * - [3,2,1,6,0,5] 中的最大值是 6 ，左边部分是 [3,2,1] ，右边部分是 [0,5] 。
 *     - [3,2,1] 中的最大值是 3 ，左边部分是 [] ，右边部分是 [2,1] 。
 *         - 空数组，无子节点。
 *         - [2,1] 中的最大值是 2 ，左边部分是 [] ，右边部分是 [1] 。
 *             - 空数组，无子节点。
 *             - 只有一个元素，所以子节点是一个值为 1 的节点。
 *     - [0,5] 中的最大值是 5 ，左边部分是 [0] ，右边部分是 [] 。
 *         - 只有一个元素，所以子节点是一个值为 0 的节点。
 *         - 空数组，无子节点。
 * 示例 2：
 *
 *
 * 输入：nums = [3,2,1]
 * 输出：[3,null,2,null,1]
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 1000
 * 0 <= nums[i] <= 1000
 * nums 中的所有整数 互不相同
 * @author FBI
 */
public class ConstructMaximumBinaryTree {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if(nums.length==0)return null;
        if(nums.length==1)return new TreeNode(nums[0],null,null);

        //找出数组最大值 和 数组下标
        int maxVal =Integer.MIN_VALUE;
        int maxIndex =-1;
        for (int i = 0; i < nums.length; i++) {
             if(nums[i]>maxVal){
                 maxVal=nums[i];
                 maxIndex=i;
             }
        }
        TreeNode root = new TreeNode(maxVal,null,null);

        int leftLength = maxIndex+1-1;//去除根节点
        int rightLength = nums.length-leftLength-1;//去除左边和根节点
        int[] leftNum = new int[leftLength];
        int[] rightNum = new int[rightLength];
        //copy数组
        System.arraycopy(nums,0,leftNum,0,leftLength);
        System.arraycopy(nums,maxIndex+1,rightNum,0,rightLength);//根节点右边第一个开始复制

        //判断左右子树是否为空
        if(leftNum.length!=0){
            root.left = constructMaximumBinaryTree(leftNum);
        }else {
            root.left=null;
        }
        if(rightNum.length!=0){
            root.right = constructMaximumBinaryTree(rightNum);
        }else {
            root.right=null;
        }
        return root;
    }

    public static void main(String[] args) {
        int[] nums=new int[]{3,2,1,6,0,5};
        ConstructMaximumBinaryTree constructMaximumBinaryTree = new ConstructMaximumBinaryTree();
        TreeNode node = constructMaximumBinaryTree.constructMaximumBinaryTree(nums);
        System.out.println(node);
    }
}
