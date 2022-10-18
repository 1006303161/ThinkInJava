package com.demo.thinkinjava.algorithm.QueueAndStack;
/*
 * Copyright (C) 1997-2020 康成投资（中国）有限公司
 *
 * http://www.rt-mart.com
 *
 * 版权归本公司所有，不得私自使用、拷贝、修改、删除，否则视为侵权
 */

import java.util.LinkedList;
import java.util.Queue;

/**
 * 队列和栈转化
 *
 * @author jiafeng.liu
 */
public class QueueConvertToStatck {

    Queue<Integer> queue1;
    Queue<Integer> queue2;

    QueueConvertToStatck() {
        queue1 = new LinkedList();
        queue2 = new LinkedList();
    }

    /**
     * push 将queue1 改为F i L o
     *
     * @param x
     */
    void push(int x) {
        if (this.empty()) {
            queue1.add(x);
            return;
        }

        queue2.add(x);
        //1中全部出队列放在2中
        while (!queue1.isEmpty()) {
            queue2.add(queue1.poll());
        }
        //2中为栈顺序 两者互换
        Queue queueTemp = queue2;
        queue2 = queue1;
        queue1 = queueTemp;

    }

    int pop() {
        return this.queue1.poll();
    }

    int top() {
        return this.queue1.peek();
    }

    boolean empty() {
        return queue1.isEmpty();
    }

    public static void main(String[] args) {
        QueueConvertToStatck myStack = new QueueConvertToStatck();
        myStack.push(1);
        myStack.push(2);
        System.out.println(myStack.top()); // 返回 2
        System.out.println(myStack.pop()); // 返回 2
        System.out.println(myStack.empty()); // 返回 False
    }
}
