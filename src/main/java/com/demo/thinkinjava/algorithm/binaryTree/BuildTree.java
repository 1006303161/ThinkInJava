package com.demo.thinkinjava.algorithm.binaryTree;

import java.util.Arrays;

/**
 * 106. 从中序与后序遍历序列构造二叉树
 *
 * @author FBI
 * 给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历， postorder 是同一棵树的后序遍历，请你构造并返回这颗 二叉树 。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * 输入：inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
 * 输出：[3,9,20,null,null,15,7]
 * 示例 2:
 * <p>
 * 输入：inorder = [-1], postorder = [-1]
 * 输出：[-1]
 * <p>
 * <p>
 * 提示:
 * <p>
 * 1 <= inorder.length <= 3000
 * postorder.length == inorder.length
 * -3000 <= inorder[i], postorder[i] <= 3000
 * inorder 和 postorder 都由 不同 的值组成
 * postorder 中每一个值都在 inorder 中
 * inorder 保证是树的中序遍历
 * postorder 保证是树的后序遍历
 */
public class BuildTree {

    private static TreeNode finalTree = new TreeNode();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        //1.数组大小为0，则是空节点
        if (inorder.length == 0) return null;

        //2.不为空 ，根据后序最后一个节点找中序根节点
        int rootVal = postorder[postorder.length - 1];
        TreeNode root = new TreeNode(rootVal, null, null);

        //叶子节点
        if (postorder.length == 1) return root;
        //3.找到后序数组的最后一个元素，作为中序数组的切割点
        int indexRoot = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootVal) {
                indexRoot = i;
                break;
            }
        }
        //4.切割中序数组，分为中序左子树和右子树数组
        int leftLength = indexRoot;
        int rightLength = inorder.length - indexRoot - 1;
        int[] leftInorder = new int[leftLength];
        int[] rightInorder = new int[rightLength];
        System.arraycopy(inorder, 0, leftInorder, 0, leftLength);
        System.arraycopy(inorder, indexRoot + 1, rightInorder, 0, rightLength);
        //5.根据中序切割后序，分后序左子树 后序右子树数组


        int[] leftPostorder = new int[leftLength];
        int[] rightPostorder = new int[rightLength];
        //后序遍历中 左子树节点树和中序一样，所以前leftLength个就是根节点的左子树，前leftLength+1-->postOrder.length就是右子树节点
        System.arraycopy(postorder, 0, leftPostorder, 0, leftLength);
        System.arraycopy(postorder, 0 + leftLength, rightPostorder, 0, rightLength);

        root.left = buildTree(leftInorder, leftPostorder);
        root.right = buildTree(rightInorder, rightPostorder);
        return root;
    }


    /**
     * 前序和中序构造二叉树
     *
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree2(int[] preorder, int[] inorder) {

        //1. 先判断根节点
        if (preorder.length == 0) return null;

        //2.根据前序遍历找出根
        int rootVal = preorder[0];
        TreeNode root = new TreeNode(rootVal, null, null);

        //终止条件1 如果是叶子节点 则返回
        if (preorder.length == 1) return root;

        //3.找中序遍历根节点 左边为左子树系节点 右边为右子树节点
        int rootIndex = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootVal) {
                rootIndex = i;
                break;
            }
        }
        //4.中序的左子树右子树整合
        int leftLength = rootIndex ;
        int rightLength = inorder.length - rootIndex-1;
        int[] leftInorder = new int[leftLength];
        int[] rightInorder = new int[rightLength];
        System.arraycopy(inorder, 0, leftInorder, 0, leftLength);
        System.arraycopy(inorder, rootIndex+1, rightInorder, 0, rightLength);
        //5. 前序遍历左子树右子树 根节点后面leftLength个是左子树节点 再往后rightLength是右子树节点
        //前序从第二个数开始 第一个数是根节点
        int[] leftPreorder = new int[leftLength];
        int[] rightPreorder = new int[rightLength];
        System.arraycopy(preorder,1,leftPreorder,0,leftLength);
        System.arraycopy(preorder,1+leftLength,rightPreorder,0,rightLength);

        root.left = buildTree2(leftPreorder, leftInorder);
        root.right = buildTree2(rightPreorder, rightInorder);
        return root;
    }

    public static void main(String[] args) {
        BuildTree buildTree = new BuildTree();
        TreeNode node = buildTree.buildTree2(new int[]{3,9,20,15,7}, new int[]{9,3,15,20,7});
        System.out.println(node);
    }
}
