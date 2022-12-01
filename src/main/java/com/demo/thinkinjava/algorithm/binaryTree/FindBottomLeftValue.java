package com.demo.thinkinjava.algorithm.binaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * 513. 找树左下角的值
 * 中等
 * 406
 * 相关企业
 * 给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。
 * <p>
 * 假设二叉树中至少有一个节点。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * <p>
 * 输入: root = [2,1,3]
 * 输出: 1
 * 示例 2:
 * <p>
 * <p>
 * <p>
 * 输入: [1,2,3,4,null,5,6,null,null,7]
 * 输出: 7
 * <p>
 * <p>
 * 提示:
 * <p>
 * 二叉树的节点个数的范围是 [1,104]
 * -231 <= Node.val <= 231 - 1
 *
 * @author FBI
 */
public class FindBottomLeftValue {

    private static int maxDepth = -1;
    private static int leftVal ;

    /**
     * 找左下角最深的节点的最左边的值
     *
     * @param root
     * @return
     */
    public int findBottomLeftValue(TreeNode root) {
        maxDepth = 0;
        leftVal = root.val;
        getDeptLastVal(root, 0);
        return leftVal;
    }

    public void getDeptLastVal(TreeNode node, int depth) {
        if (node.left == null && node.right == null) {
            //当前最左节点 是否最深
            if (depth > maxDepth) {
                leftVal = node.val;
                maxDepth=depth;
            }
            return;
        }
        if(node.left!=null){
            depth++;
            getDeptLastVal(node.left, depth);
            depth--; //回溯
        }
        if(node.right!=null){
            //省略回溯 depth+1 是改变下一次递归深度 不改变当前递归深度，右递归结束返回后 还是depth
            getDeptLastVal(node.right, depth+1);
        }
        return;
    }


    public static int sum(int a){
        return a;
    }
    public static void main(String[] args) {
        int i =2;
        System.out.println(sum(i++));
    }
}
