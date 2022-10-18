package com.demo.thinkinjava.algorithm.linkList.removeNthFromEnd;
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
 * @author jiafeng.liu
 * 删除倒数第n个元素
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * <p>
 * 进阶：你能尝试使用一趟扫描实现吗？
 */
public class RemoveNthFromEnd {

    /**
     * 一遍循环删除倒数第n个元素返回头节点
     *
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        //双指针应用 快指针移动n步骤，慢指针和快指针同时移动（平移），快指针到达终点 慢指针所指向得就是实际需要删除得元素
        if (head == null) {
            return head;
        }
        ListNode vmHead = new ListNode(0);
        vmHead.next = head;
        //使用虚拟头节点可以避免 去掉头部单独处理得麻烦
        ListNode fast = vmHead;
        ListNode slow = vmHead;
        //指定元素得前一个位置
        ListNode preSlow = null;
        while (fast != null) {
            if (n > 0) {
                //快指针先移动
                fast = fast.next;
                n--;
            } else {
                //移动到指定位置时，快慢指针 同时移动
                fast = fast.next;
                slow = slow.next;
            }
            //此处建议移动到指定位置得前一个位置，以便于删除元素
            if (fast.next == null) {
                //删除得元素个数大于链表长度
                if (n > 0) {
                    return head;
                }

                preSlow = slow;
                break;
            }
        }
        //删除元素
        //如果当前节点以为空{1} 删除倒数第二个
        preSlow.next = preSlow.next.next;
        return vmHead.next;
    }

    public static void main(String[] args) {

        int[] head = new int[]{1};
        ListNode node = LinkListUtils.insertHead(head);
        ListNode headNode = removeNthFromEnd(node, 2);
        System.out.println(headNode);
    }
}
