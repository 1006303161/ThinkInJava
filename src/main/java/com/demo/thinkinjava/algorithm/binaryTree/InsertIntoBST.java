package com.demo.thinkinjava.algorithm.binaryTree;

/**
 * 701. 二叉搜索树中的插入操作
 * 中等
 * 410
 * 相关企业
 * 给定二叉搜索树（BST）的根节点 root 和要插入树中的值 value ，将值插入二叉搜索树。 返回插入后二叉搜索树的根节点。 输入数据 保证 ，新值和原始二叉搜索树中的任意节点值都不同。
 * <p>
 * 注意，可能存在多种有效的插入方式，只要树在插入后仍保持为二叉搜索树即可。 你可以返回 任意有效的结果 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [4,2,7,1,3], val = 5
 * 输出：[4,2,7,1,3,5]
 * 解释：另一个满足题目要求可以通过的树是：
 * <p>
 * 示例 2：
 * <p>
 * 输入：root = [40,20,60,10,30,50,70], val = 25
 * 输出：[40,20,60,10,30,50,70,null,null,25]
 * 示例 3：
 * <p>
 * 输入：root = [4,2,7,1,3,null,null,null,null,null,null], val = 5
 * 输出：[4,2,7,1,3,5]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中的节点数将在 [0, 104]的范围内。
 * -108 <= Node.val <= 108
 * 所有值 Node.val 是 独一无二 的。
 * -108 <= val <= 108
 * 保证 val 在原始BST中不存在。
 *
 * @author FBI
 */
public class InsertIntoBST {


    public TreeNode insertIntoBST(TreeNode root, int val) {

        if (root == null) {
            return new TreeNode(val, null, null);
        }
        getTravel(root, val);
        return root;
    }

    private TreeNode pre;

    void getTravel(TreeNode root, int val) {

        if (root == null) {
            if (pre.val < val) {
                pre.right = new TreeNode(val, null, null);
                return;
            } else {
                pre.left = new TreeNode(val, null, null);
                return;
            }
        }

        pre = root;
        //在搜索树左边 左
        if (root.val > val) {
            getTravel(root.left, val);
        }
        // 右
        if (root.val < val) {
            getTravel(root.right, val);
        }
        return;
    }

    /**
     * 采用递归的返回值赋值
     *
     * @param root
     * @param val
     * @return
     */
    public TreeNode insertIntoBST2(TreeNode root, int val) {
        if (root == null) return new TreeNode(val, null, null);

        //左    找到节点对应位置并赋值为父节点的左孩子
        if (root.val > val) root.left = insertIntoBST(root.left, val);
        //右
        if (root.val < val) root.right = insertIntoBST(root.right, val);
        return root;
    }

}
