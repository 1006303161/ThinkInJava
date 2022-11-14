package com.demo.thinkinjava.algorithm.QueueAndStack;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 滑动窗口最大值
 *
 * @author FBI
 * <p>
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * <p>
 * 返回 滑动窗口中的最大值 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
 * 输出：[3,3,5,5,6,7]
 * 解释：
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 * 示例 2：
 * <p>
 * 输入：nums = [1], k = 1
 * 输出：[1]
 */
public class MaxSlidingWindow {



    /**
     * 单调队列
     */
    static class SingQueClass {

        Deque<Integer> slidQue = new LinkedList<>();
        /**
         * 当前值等于出口队列元素，弹出 出口元素（滑动窗口用）
         *
         * @param value
         */
        public void pop(int value) {
            if (!slidQue.isEmpty() && slidQue.peek() == value) {
                slidQue.poll();
            }
        }

        /**
         * 当前元素大于入口元素 弹出入口元素，直到没有该元素为止
         *
         * @param value
         */
        public void push(int value) {

            while (!slidQue.isEmpty() && value > slidQue.getLast()) {
                slidQue.removeLast();
            }
            slidQue.add(value);
        }

        public int front() {
            return slidQue.peek();
        }

    }

    /**
     * 滑动窗口最大值
     *
     * @param nums 数据
     * @param k    窗口大小
     * @return
     */
    public static int[] maxSlidingWindow(int[] nums, int k) {
        SingQueClass singQueClass = new SingQueClass();
        int[] maxWindowInt = new int[nums.length-k+1];
        int j=0;
        if (k == 1) {
            return nums;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i < k) {
                singQueClass.push(nums[i]);
                if (i == k - 1) {
                    maxWindowInt[j++]=singQueClass.front();
                }
                continue;
            }
            if (i >= k) {
                singQueClass.pop(nums[i - k]);
                singQueClass.push(nums[i]);
                maxWindowInt[j++]=(singQueClass.front());
            }

        }
        return maxWindowInt;
    }

    public static void main(String[] args) {
        int[] a = new int[]{4,-2};
        int[] ints = MaxSlidingWindow.maxSlidingWindow(a, 2);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }

    }
}
