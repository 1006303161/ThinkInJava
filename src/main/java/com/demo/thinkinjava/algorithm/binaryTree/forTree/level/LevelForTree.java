package com.demo.thinkinjava.algorithm.binaryTree.forTree.level;

import java.util.*;

/**
 * 层序遍历 广度遍历
 *
 * @author FBI
 */
public class LevelForTree {


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        ;

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.left = left;
            this.right = right;
            this.val = val;
        }
    }


    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levelList = new ArrayList<>();
        if (root == null) {
            return levelList;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {

            List<Integer> queList = new ArrayList<>();
            int len = queue.size();
            //每次相对于上一个节点 循环的次数都变化了
            while (len > 0) {
                TreeNode poll = queue.poll();
                queList.add(poll.val);
                if (poll.left != null) {
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                }
                len--;
            }
            levelList.add(queList);
        }
        return levelList;
    }

    /**
     * 递归
     * @param root
     * @return
     */
    public static List<List<Integer>> levelOrderII(TreeNode root) {
        if(root==null){
            return new ArrayList<>();
        }
        List<List<Integer>> levelList = new ArrayList<>();
        getChildTreeNodeVal(root,1,levelList);
        return levelList;
    }

    //DFS
    public static void getChildTreeNodeVal(TreeNode root,Integer deep,List<List<Integer>> levelList){

        //如果创建的集合<当前深度，第一次遍历当前深度节点 创建一个存放的List
        if(levelList.size()<deep){
            levelList.add(new ArrayList<>());
        }
        //将当前深度元素放入集合
        levelList.get(deep-1).add(root.val);

        //递归遍历左节点和右节点
        if(root.left!=null){
            getChildTreeNodeVal(root.left,deep+1,levelList);
        }
        if(root.right!=null){
            getChildTreeNodeVal(root.right,deep+1,levelList);
        }
        //如果左右节点为空 当前递归结束

    }


    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3, new TreeNode(9, null, null),
                new TreeNode(20, new TreeNode(15, null, null), new TreeNode(7, null, null)));
//        System.out.println(LevelForTree.levelOrder(treeNode));
        System.out.println(LevelForTree.levelOrderII(treeNode));

    }

}
