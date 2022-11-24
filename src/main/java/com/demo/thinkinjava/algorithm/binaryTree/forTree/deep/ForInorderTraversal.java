package com.demo.thinkinjava.algorithm.binaryTree.forTree.deep;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author FBI
 * 中序遍历
 */
public class ForInorderTraversal {

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

    public static List<Integer> inOrderTraversal(TreeNode root) {

        List<Integer> inorderTree = new ArrayList<>();
        //放入元素顺序的栈
        Stack<TreeNode> stack = new Stack<>();
        //遍历元素的指针
        TreeNode cur;
        if(root==null){
            return inorderTree;
        }
        //指针开始指向头节点
        cur=root;
        ///如果指针遍历结束 并且 栈内元素为空 则遍历结束
        while (!(cur==null&&stack.empty())){
            //判断当前元素（可能是右节点元素）,是否为空
            if(cur!=null){
                //中序左中右 先深度遍历 一直找左节点
                stack.push(cur);
                cur=cur.left;
            }else {
                //一直找到左节点为空时，弹出站内元素
                cur=stack.pop();
                //放入顺序元素  （中）元素
                inorderTree.add(cur.val);
                //再找右节点看是否有元素
                cur=cur.right;
            }
        }
        return inorderTree;
    }


    public static void main(String[] args) {
        ForInorderTraversal.TreeNode treeNode = new ForInorderTraversal.TreeNode(1, null, new ForInorderTraversal.TreeNode(2, new ForInorderTraversal.TreeNode(3, null, null), null));
        System.out.println(ForInorderTraversal.inOrderTraversal(treeNode));

    }
}
