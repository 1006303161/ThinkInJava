package LinkListAlgorithm.getIntersectionNode;
/*
 * Copyright (C) 1997-2020 康成投资（中国）有限公司
 *
 * http://www.rt-mart.com
 *
 * 版权归本公司所有，不得私自使用、拷贝、修改、删除，否则视为侵权
 */

import LinkListAlgorithm.LinkListUtils;
import LinkListAlgorithm.ListNode;
import org.omg.PortableInterceptor.INACTIVE;

/**
 * @author jiafeng.liu
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null 。
 * <p>
 * 图示两个链表在节点 c1 开始相交：
 */
public class GetIntersectionNode {

    public static ListNode GetIntersectionNode(ListNode headA, ListNode headB) {

        ListNode nodeA = headA;
        ListNode nodeB = headB;
        while (nodeA != null) {
            while (nodeB != null) {
                if (nodeA.val == nodeB.val && nodeA == nodeB) {
                    return nodeA;
                }
                nodeB = nodeB.next;
            }
            //比较完成后 B 重新指向初始值
            nodeB = headB;
            nodeA = nodeA.next;
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode headA = LinkListUtils.insertHead(new int[]{4, 1, 8, 4, 5});
        ListNode headB = LinkListUtils.insertHead(new int[]{5, 0, 1, 8, 4, 5});
        ListNode val = GetIntersectionNode(headA, headB);
        System.out.println(val);
    }
}
