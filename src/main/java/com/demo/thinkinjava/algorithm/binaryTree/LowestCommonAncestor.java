package com.demo.thinkinjava.algorithm.binaryTree;

/**
 * 236. 二叉树的最近公共祖先
 * 中等
 * 2.1K
 * 相关企业
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * <p>
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出：3
 * 解释：节点 5 和节点 1 的最近公共祖先是节点 3 。
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * 输出：5
 * 解释：节点 5 和节点 4 的最近公共祖先是节点 5 。因为根据定义最近公共祖先节点可以为节点本身。
 * 示例 3：
 * <p>
 * 输入：root = [1,2], p = 1, q = 2
 * 输出：1
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中节点数目在范围 [2, 105] 内。
 * -109 <= Node.val <= 109
 * 所有 Node.val 互不相同 。
 * p != q
 * p 和 q 均存在于给定的二叉树中。
 */
public class LowestCommonAncestor {

    /**
     * 递归法 后序遍历是天然的回溯 回溯的过程传递 找到的p，q节点
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        //当前节点为p（q）则返回当前节点，为空则返回空
        if (root == null || root.val == p.val || root.val == q.val) {
            return root;
        }

        //左，获取左子树中找到的p(q)
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        //右
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        //如果当前节点的左节点有p(q)右节点有q(p)，则一定是公共节点
        if (left != null && right != null) return root;
            //左节点有，右节点没有，则p，q都在当前节点的右子树
        else if (left != null && right == null) return left;
        else if (left == null && right != null) return right;
        else return null; //左右节点都没有 则没有公共祖先


    }
}
