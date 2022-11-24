package com.demo.thinkinjava.algorithm.binaryTree.forTree.level;

import java.util.*;

/**
 * 107. 二叉树的层序遍历 II
 * 中等
 * 632
 * 相关企业
 * 给你二叉树的根节点 root ，返回其节点值 自底向上的层序遍历 。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 *
 * @author FBI
 */
public class LevelForTreeII {


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

  /*  public static class Node {
        int val;
        Node left;
        Node right;
        Node next;

        Node() {

        }

        public Node(int val, Node left, Node right, Node next) {
            this.val = val;
            this.left = left;
            this.right = right;
            this.next = next;
        }
    }*/
    /*public static class Node {
        int val;
        List<Node> children;

        Node() {
            this.children = null;
            this.val = 0;
        }

        Node(int val, List<Node> children) {
            this.children = children;
            this.val = val;
        }
    }*/


    /*  public static List<List<Integer>> levelOrder(Node root) {
          List<List<Integer>> levelList = new ArrayList<>();

          if (root == null) {
              return levelList;
          }
          Queue<Node> levelQue = new LinkedList<>();
          levelQue.add(root);
          //队列为空，则遍历完最后的叶子节点
          while (!levelQue.isEmpty()) {
              //记录当前层节点个数，当前层的队列全部出栈，则当前层遍历结束
              List<Integer> queList = new ArrayList<>();
              int size = levelQue.size();
              while (size > 0) {
                  size--;
                  Node peek = levelQue.peek();
                  queList.add(peek.val);
                  levelQue.poll();
                  if (peek.children != null) {
                      levelQue.addAll(peek.children);
                  }
              }
              levelList.add(levelQue);
          }
          return levelList;
      }*/
    public static TreeNode levelOrder(TreeNode root) {
        if (root == null) {
            return root;
        }
        Queue<TreeNode> levelQue = new LinkedList<>();
        levelQue.add(root);
        //队列为空，则遍历完最后的叶子节点
        while (!levelQue.isEmpty()) {
            //记录当前层节点个数，当前层的队列全部出栈，则当前层遍历结束
            int size = levelQue.size();
            while (size > 0) {
                size--;
                TreeNode peek = levelQue.peek();

                TreeNode tempTree=peek.left;
                peek.left=peek.right;
                peek.right=tempTree;
                levelQue.poll();
                if (peek.left != null) {
                    levelQue.add(peek.left);
                }
                if (peek.right != null) {
                    levelQue.add(peek.right);
                }
            }
        }
        return root;
    }

    public static void main(String[] args) {
       /* List<Node> nodes = new ArrayList<>();
        List<Node> nodeChild = new ArrayList<>();
        nodeChild.add(new Node(5,null));
        nodeChild.add(new Node(6,null));
        nodes.add(new Node(3,nodeChild));
        nodes.add(new Node(2,null));
        nodes.add(new Node(4,null));
        Node treeNode = new Node(1,nodes);*/
        TreeNode treeNode = new TreeNode(0, new TreeNode(-1, null,null),null);
        System.out.println(LevelForTreeII.levelOrder(treeNode));

    }

}
