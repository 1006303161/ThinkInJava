package com.demo.thinkinjava.algorithm.linkList;
/*
 * Copyright (C) 1997-2020 康成投资（中国）有限公司
 *
 * http://www.rt-mart.com
 *
 * 版权归本公司所有，不得私自使用、拷贝、修改、删除，否则视为侵权
 */

/**
 * @author jiafeng.liu
 * 初始化工具类
 */

public class LinkListUtils {

    /**
     * 数组赋值
     *
     * @param arr
     * @return
     */
    public static ListNode insertHead(int[] arr) {

        if (arr.length == 0) {
            return new ListNode();
        }
        ListNode head = new ListNode();
        //头指针
        ListNode pre = head;
        for (int i = 0; i < arr.length; i++) {
            ListNode node = new ListNode();
            node.val = arr[i];
            pre.next = node;
            pre = pre.next;
        }
        return head.next;
    }

    public static ListNode removeNode(ListNode head, int val) {
        //头结点都是 删除的值
        while (head != null && head.val == val) {
            head = head.next;
        }

        if (head == null) {
            return head;
        }

        //头结点不为删除值
        //头指针
        ListNode pre = head;
        //遍历指针
        ListNode cur = head.next;

        while (cur != null) {
            //删除元素
            if (cur.val == val) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        return head;
    }


    public static void main(String[] args) {
        int p[] = new int[]{7, 7, 7};

        ListNode node = insertHead(p);
        ListNode node1 = removeNode(node, 7);
        System.out.println(node1);
    }
}
