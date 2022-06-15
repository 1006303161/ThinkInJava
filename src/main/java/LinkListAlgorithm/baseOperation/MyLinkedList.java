package LinkListAlgorithm.baseOperation;
/*
 * Copyright (C) 1997-2020 康成投资（中国）有限公司
 *
 * http://www.rt-mart.com
 *
 * 版权归本公司所有，不得私自使用、拷贝、修改、删除，否则视为侵权
 */

import LinkListAlgorithm.ListNode;

/**
 * @author jiafeng.liu
 * 链表基础操作
 * <p>
 * 设计链表的实现。您可以选择使用单链表或双链表。单链表中的节点应该具有两个属性：val 和 next。val 是当前节点的值，next 是指向下一个节点的指针/引用。如果要使用双向链表，则还需要一个属性 prev 以指示链表中的上一个节点。假设链表中的所有节点都是 0-index 的。
 * <p>
 * 在链表类中实现这些功能：
 * <p>
 * get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。
 * addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
 * addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。
 * addAtIndex(index,val)：在链表中的第 index 个节点之前添加值为 val  的节点。如果 index 等于链表的长度，则该节点将附加到链表的末尾。如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。
 * deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。
 */
public class MyLinkedList {

    private ListNode head;

    private int size;

    //初始化链表  自动添加一个虚拟节点
    public MyLinkedList() {
        size = 0;
        head = new ListNode(0);
    }

    /**
     * get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。
     *
     * @param index
     * @return
     */
    public int get(int index) {
        if (index < 0 || index > size) {
            return -1;
        }

        //头指针遍历
        ListNode pre = head;
        for (int i = 0; i <= index; i++) {
            pre = pre.next;
        }
        return pre.val;
    }

    /**
     * 在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
     *
     * @param val
     */
    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    /**
     * 将值为 val 的节点追加到链表的最后一个元素。
     *
     * @param val
     */
    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    /**
     * 在链表中的第 index 个节点之前添加值为 val  的节点。
     * 如果 index 等于链表的长度，则该节点将附加到链表的末尾。
     * 如果 index 大于链表长度，则不会插入节点。
     * 如果index小于0，则在头部插入节点。
     *
     * @param index
     * @param val
     */
    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }
        //指针
        ListNode pre = head;
        //找到前一个指针
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }

        ListNode newNode = new ListNode(val);
        //新指针指向原来位置的节点
        newNode.next = pre.next;
        //当前位置替换为新指针
        pre.next = newNode;
        size++;
    }

    /**
     * 如果索引 index 有效，则删除链表中的第 index 个节点。
     *
     * @param index
     */
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }

        ListNode pre = head;
        //遍历到当前节点的前一个节点
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        //将删除元素的节点替换为删除元素的下一个节点
        pre.next = pre.next.next;
        size--;
    }

    @Override
    public String toString() {
        return "MyLinkedList{" +
                "head=" + head +
                ", length=" + size +
                '}';
    }

    public static void main(String[] args) {
        MyLinkedList mylist = new MyLinkedList();
        mylist.addAtHead(1);
        System.out.println("addAtHead:" + mylist.get(0));


        mylist.addAtTail(3);
        System.out.println("addAtTail:" + mylist.get(1));

        mylist.addAtIndex(1, 2);
        System.out.println("addAtIndex:" + mylist);
        int param_1 = mylist.get(1);
        System.out.println("mylist:" + param_1);

        mylist.deleteAtIndex(2);
        System.out.println("mylist:" + mylist);

        int param_2 = mylist.get(1);
        System.out.println("mylist:" + param_2);
    }
}
