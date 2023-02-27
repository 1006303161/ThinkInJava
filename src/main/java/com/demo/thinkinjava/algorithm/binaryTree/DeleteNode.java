package com.demo.thinkinjava.algorithm.binaryTree;

/**
 * 删除二叉搜索树中的节点
 * 中等
 * 1K
 * 相关企业
 * 给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。
 * <p>
 * 一般来说，删除节点可分为两个步骤：
 * <p>
 * 首先找到需要删除的节点；
 * 如果找到了，删除它。
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * <p>
 * 输入：root = [5,3,6,2,4,null,7], key = 3
 * 输出：[5,4,6,2,null,null,7]
 * 解释：给定需要删除的节点值是 3，所以我们首先找到 3 这个节点，然后删除它。
 * 一个正确的答案是 [5,4,6,2,null,null,7], 如下图所示。
 * 另一个正确答案是 [5,2,6,null,4,null,7]。
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * 输入: root = [5,3,6,2,4,null,7], key = 0
 * 输出: [5,3,6,2,4,null,7]
 * 解释: 二叉树不包含值为 0 的节点
 * 示例 3:
 * <p>
 * 输入: root = [], key = 0
 * 输出: []
 * <p>
 * <p>
 * 提示:
 * <p>
 * 节点数的范围 [0, 104].
 * -105 <= Node.val <= 105
 * 节点值唯一
 * root 是合法的二叉搜索树
 * -105 <= key <= 105
 * <p>
 * <p>
 * 进阶： 要求算法时间复杂度为 O(h)，h 为树的高度。
 *
 * @author FBI
 */
public class DeleteNode {

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return root;

        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else {
            //值相等 右子树为空
            if (root.right == null) {
                return root.left;
            }
            //值相等 左子树为空
            if (root.left == null) {
                return root.right;
            }
            //左右子树都不为空 将左子树的节点移动到右子树最左侧的左节点的孩子上
            else {
                TreeNode cur = root.right;
                while (cur.left != null) {
                    cur = cur.left;
                }
                cur.left = root.left;
                //删除当前节点
                return root.right;
            }
        }

        return root;
    }



    public static void main(String[] args) {
        DeleteNode deleteNode = new DeleteNode();
        TreeNode node = deleteNode.deleteNode(new TreeNode(5, new TreeNode(3, new TreeNode(2, null, null), new TreeNode(4, null, null)), new TreeNode(6, null, new TreeNode(7, null, null))), 3);
        System.out.println(node);
    }

}
