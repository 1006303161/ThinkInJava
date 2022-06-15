package LinkListAlgorithm.reverseList;
/*
 * Copyright (C) 1997-2020 康成投资（中国）有限公司
 *
 * http://www.rt-mart.com
 *
 * 版权归本公司所有，不得私自使用、拷贝、修改、删除，否则视为侵权
 */

import LinkListAlgorithm.LinkListUtils;
import LinkListAlgorithm.ListNode;

/**
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 */
public class ReverseList {

    public static ListNode reverseList(ListNode head) {
        //一个元素或者 null 直接返回
        if (head == null || head.next == null) {
            return head;
        }

        //从第二个开始遍历
        //快指针
        ListNode pre = null;
        //循环
        ListNode cur = head;

        while (cur != null) {
            //记录下个节点的位置
            ListNode temp = cur.next;
            //指向上一个节点
            cur.next = pre;
            //更新上一节点的位置
            pre = cur;
            //将下一节点位置 给到循环遍量 继续遍历
            cur = temp;
        }
        return pre;
    }

    public static ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        return reverseList(null, head);
    }

    public static ListNode reverseList(ListNode pre, ListNode cur) {
        //最后一个节点得位置变为最开始得位置，所以返回pre
        if (cur == null) {
            return pre;
        }
        //记录当前节点得下一个节点
        ListNode tmp = cur.next;
        //下一节点指向上一届点
        cur.next = pre;
        //记录当前节点得位置
        pre = cur;
        //指针指到下一个节点
        cur = tmp;

        return reverseList(pre, cur);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3};
        ListNode node = LinkListUtils.insertHead(arr);
        ListNode node1 = reverseList2(node);
        System.out.println(node1);
    }
}
