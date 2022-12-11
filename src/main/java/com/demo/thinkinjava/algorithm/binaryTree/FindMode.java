package com.demo.thinkinjava.algorithm.binaryTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 501. 二叉搜索树中的众数
 * 简单
 * 556
 * 相关企业
 * 给你一个含重复值的二叉搜索树（BST）的根节点 root ，找出并返回 BST 中的所有 众数（即，出现频率最高的元素）。
 * <p>
 * 如果树中有不止一个众数，可以按 任意顺序 返回。
 * <p>
 * 假定 BST 满足如下定义：
 * <p>
 * 结点左子树中所含节点的值 小于等于 当前节点的值
 * 结点右子树中所含节点的值 大于等于 当前节点的值
 * 左子树和右子树都是二叉搜索树
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [1,null,2,2]
 * 输出：[2]
 * 示例 2：
 * <p>
 * 输入：root = [0]
 * 输出：[0]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中节点的数目在范围 [1, 104] 内
 * -105 <= Node.val <= 105
 * <p>
 * <p>
 * 进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内）
 *
 * @author FBI
 */
public class FindMode {

    private List<Integer> result;
    //最多众数
    private int maxCount;
    //当前值众数
    private int count;
    //上一个节点
    private TreeNode pre;

    /**
     * 二叉搜索树的众数 依旧是中序遍历二叉搜索树
     *
     * @param root
     * @return
     */
    public int[] findMode(TreeNode root) {
        result = new ArrayList<>();
        maxCount = 0;
        count = 0;
        if (root.left == null && root.right == null) return new int[]{root.val};
        inorderTravel(root);
        int[] num = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            num[i] = result.get(i);
        }
        return num;
    }

    /**
     * 中序遍历
     *
     * @param node
     */
    void inorderTravel(TreeNode node) {
        if (node == null) return;
        //左
        inorderTravel(node.left);

        if (pre == null) {
            //第一次进入
            count = 1;
        } else if (pre.val == node.val) {
            //当前节点和上一个节点相同 count++
            count++;
        } else {
            //与前一个节点值不同
            count = 1;
        }

        pre = node;

        if (count == maxCount) {
            //等于 追加众数II
            result.add(node.val);
        }

        //1.大于 清空数组 更新
        if (count > maxCount) {
            maxCount = count;
            result.clear();
            result.add(pre.val);
        }

        inorderTravel(node.right);

        return;
    }

    public static void main(String[] args) {
        FindMode findMode = new FindMode();
        int[] mode = findMode.findMode(new TreeNode(1, null, new TreeNode(2, new TreeNode(2, null, null), null)));
        System.out.println(mode);
    }

}
