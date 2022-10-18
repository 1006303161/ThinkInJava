package com.demo.thinkinjava.algorithm.linkList.RemoveElement;
/*
 * Copyright (C) 1997-2020 康成投资（中国）有限公司
 *
 * http://www.rt-mart.com
 *
 * 版权归本公司所有，不得私自使用、拷贝、修改、删除，否则视为侵权
 */

import com.demo.thinkinjava.algorithm.linkList.LinkListUtils;
import com.demo.thinkinjava.algorithm.linkList.ListNode;

/**
 * 删除元素
 * 题意：删除链表中等于给定值 val 的所有节点。
 * <p>
 * 示例 1：
 * 输入：head = [1,2,6,3,4,5,6], val = 6
 * 输出：[1,2,3,4,5]
 * <p>
 * 示例 2：
 * 输入：head = [], val = 1
 * 输出：[]
 * <p>
 * 示例 3：
 * 输入：head = [7,7,7,7], val = 7
 * 输出：[]
 *
 * @author jiafeng.liu
 */
public class RemoveElement {

    public static ListNode removeElement(ListNode head, int val) {

        if (head == null) {
            return head;
        }
        //设置一个虚拟头指针
        ListNode vmHead = new ListNode(-1, head);
        //记录虚拟节点头指针
        ListNode pre = vmHead;
        //记录头指针
        ListNode cur = head;
        //循环链表
        while (cur != null) {
            //找到删除元素
            if (cur.val == val) {
                //删除当前节点
                pre.next = cur.next;
            } else {
                //指针下移
                pre = cur;
            }
            cur = cur.next;
        }
        return vmHead.next;
    }

    public static void main(String[] args) {
        ListNode node = LinkListUtils.insertHead(new int[]{});
        ListNode node1 = removeElement(node, 6);
        System.out.println(node1.toString());
    }
}
