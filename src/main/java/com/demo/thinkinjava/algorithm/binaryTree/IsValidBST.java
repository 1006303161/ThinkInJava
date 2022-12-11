package com.demo.thinkinjava.algorithm.binaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * 验证二叉搜索树
 * 中等
 * 1.8K
 * 相关企业
 * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 * <p>
 * 有效 二叉搜索树定义如下：
 * <p>
 * 节点的左子树只包含 小于 当前节点的数。
 * 节点的右子树只包含 大于 当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [2,1,3]
 * 输出：true
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [5,1,4,null,null,3,6]
 * 输出：false
 * 解释：根节点的值是 5 ，但是右子节点的值是 4 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中节点数目范围在[1, 104] 内
 * -231 <= Node.val <= 231 - 1
 *
 * @author FBI
 */
public class IsValidBST {

    /**
     * 中序遍历 左中右就是有序遍历，二叉搜索树的中序遍历一定是递增数列
     *
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;

        ArrayList<Integer> inOrderBST = new ArrayList<>();
        getInOrderBST(root, inOrderBST);
        for (int i = 1; i < inOrderBST.size(); i++) {
            if (inOrderBST.get(i) < inOrderBST.get(i - 1)) {
                return false;
            }
        }
        return true;

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

    public static void main(String[] args) {
        IsValidBST validBST = new IsValidBST();
        boolean validBST1 = validBST.isValidBST(new TreeNode(2, new TreeNode(1, null, null), new TreeNode(3, null, null)));
        System.out.println(validBST1);
    }
}
