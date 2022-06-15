package LinkListAlgorithm.swapPairs;
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
 * @author jiafeng.liu
 */
public class SwapPairs {

    public static ListNode swapPairs(ListNode head) {
        //头节点单独处理
        if (head == null || head.next == null) {
            return head;
        }
        //设置虚拟头节点
        ListNode vmHead = new ListNode();
        vmHead.next = head;
        ListNode cur = vmHead;
        //遍历  有两个可以交换的节点才进行交换
        while (cur.next != null && cur.next.next != null) {
            //保存B的下一个
            ListNode nextTmpNode = head.next.next;
            //A->B 互换
            //头结点指向B
            cur.next = head.next;
            //B->A
            cur.next.next = head;
            //A->B的下一个
            head.next = nextTmpNode;
            //指针移动到下个交换位置
            cur = head;
            head = head.next;
        }
        return vmHead.next;
    }

    public static ListNode swapPairs2(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode res = head.next;
        head.next = swapPairs2(res.next);
        res.next = head;
        return res;
    }


    public static void main(String[] args) {
        int[] head = new int[]{1, 2, 3, 4};
        ListNode node = LinkListUtils.insertHead(head);
//        ListNode result = swapPairs(node);
//        System.out.println(result);

        ListNode node1 = swapPairs2(node);
        System.out.println(node1);
    }
}
