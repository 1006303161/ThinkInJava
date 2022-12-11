package com.demo.thinkinjava.algorithm.binaryTree;

/**
 * 617. 合并二叉树
 * 简单
 * 1.1K
 * 相关企业
 * 给你两棵二叉树： root1 和 root2 。
 * <p>
 * 想象一下，当你将其中一棵覆盖到另一棵之上时，两棵树上的一些节点将会重叠（而另一些不会）。你需要将这两棵树合并成一棵新二叉树。合并的规则是：如果两个节点重叠，那么将这两个节点的值相加作为合并后节点的新值；否则，不为 null 的节点将直接作为新二叉树的节点。
 * <p>
 * 返回合并后的二叉树。
 * <p>
 * 注意: 合并过程必须从两个树的根节点开始。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root1 = [1,3,2,5], root2 = [2,1,3,null,4,null,7]
 * 输出：[3,4,5,5,4,null,7]
 * 示例 2：
 * <p>
 * 输入：root1 = [1], root2 = [1,2]
 * 输出：[2,2]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 两棵树中的节点数目在范围 [0, 2000] 内
 * -104 <= Node.val <= 104
 *
 * @author FBI
 */
public class MergeTrees {

    /**
     * 前序遍历 合并二叉树
     *
     * @param root1
     * @param root2
     * @return
     */
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        //终止条件 1树==null返回2树，2树亦然
        if (root1 == null) return root2;
        if (root2 == null) return root1;
        //根节点
        TreeNode node = new TreeNode();
        node.val = root1.val + root2.val;
        //左节点
        node.left=mergeTrees(root1.left,root2.left);
        //右节点
        node.right=mergeTrees(root1.right,root2.right);
        return node;
    }

    public static void main(String[] args) {

        MergeTrees mergeTrees= new MergeTrees();
        TreeNode node = mergeTrees.mergeTrees(new TreeNode(1, new TreeNode(3, new TreeNode(5, null, null), null), new TreeNode(2, null, null)),
                new TreeNode(2, new TreeNode(1, null, new TreeNode(4, null, null)), new TreeNode(3, null, new TreeNode(7, null, null)))
        );
        System.out.println(node);
    }
}
