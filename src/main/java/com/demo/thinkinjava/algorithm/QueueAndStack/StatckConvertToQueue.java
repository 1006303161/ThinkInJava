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
import java.util.Stack;

/**
 * 队列和栈转化
 *
 * @author jiafeng.liu
 */
public class StatckConvertToQueue {

    Stack<Integer> stack1;
    Stack<Integer> stack2;

    StatckConvertToQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    /**
     * p
     *
     * @param x
     */
    void push(int x) {
        if (this.empty()) {
            stack1.push(x);
            return;
        }
        //栈1拿出到 栈2
        while (!this.empty()){
            stack2.push(stack1.pop());
        }
        //放栈2 顶部
        stack2.push(x);

        //栈2放回到 栈1
        while (!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
    }

    int pop() {
        return stack1.pop();
    }

    int peek() {
        return stack1.peek();
    }

    boolean empty() {
        return stack1.empty();
    }

    public static void main(String[] args) {
        StatckConvertToQueue myQueue = new StatckConvertToQueue();
        myQueue.push(1); // queue is: [1]
        myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
        System.out.println(myQueue.peek()); // return 1
        System.out.println( myQueue.pop()); // return 1, queue is [2]
        System.out.println( myQueue.empty()); // return fa
    }
}
