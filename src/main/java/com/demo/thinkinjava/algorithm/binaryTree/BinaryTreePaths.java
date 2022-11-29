package com.demo.thinkinjava.algorithm.binaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * 257. 二叉树的所有路径
 * 简单
 * 850
 * 相关企业
 * 给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。
 * <p>
 * 叶子节点 是指没有子节点的节点。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [1,2,3,null,5]
 * 输出：["1->2->5","1->3"]
 * 示例 2：
 * <p>
 * 输入：root = [1]
 * 输出：["1"]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中节点的数目在范围 [1, 100] 内
 * -100 <= Node.val <= 100
 *
 * @author FBI
 */

public class BinaryTreePaths {

    /**
     * 前序遍历 寻找所有路径 递归回溯
     *
     * @param root
     * @return
     */
    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) return new ArrayList<>();
        ArrayList<String> pathList = new ArrayList<>();
        getTravelPath(root, new ArrayList<>(), pathList);
        return pathList;
    }

    void getTravelPath(TreeNode node, List<Integer> travelVal, List<String> pathList) {

        //中,记录当前路径最后叶子节点的值
        travelVal.add(node.val);
        //叶子节点操作
        if (node.left == null && node.right == null) {
            String path = "";
            for (int i = 0; i < travelVal.size() - 1; i++) {
                path += travelVal.get(i) + "->";
            }
            path += travelVal.get(travelVal.size() - 1);
            //加入路径记录
            pathList.add(path);
            return;
        }

        //左
        if (node.left != null) {
            getTravelPath(node.left, travelVal, pathList);
            //回溯到上一节点路径
            travelVal.remove(travelVal.size()-1); //5个元素为a{1,2,3,4,5}a.get(4)
        }
        if (node.right != null) {
            getTravelPath(node.right, travelVal, pathList);
            travelVal.remove(travelVal.size()-1);
        }
    }
}
