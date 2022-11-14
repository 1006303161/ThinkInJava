package com.demo.thinkinjava.algorithm.QueueAndStack;

import java.util.*;

/**
 * @author FBI
 * 347. 前 K 个高频元素
 * 中等
 * 1.4K
 * 相关企业
 * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 示例 2:
 * <p>
 * 输入: nums = [1], k = 1
 * 输出: [1]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * k 的取值范围是 [1, 数组中不相同的元素的个数]
 * 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的
 * <p>
 * <p>
 * 进阶：你所设计算法的时间复杂度 必须 优于 O(n log n) ，其中 n 是数组大小。
 */
public class TopKFrequent {

    public static int[] topKFrequent(int[] nums, int k) {
        //java小顶堆
        PriorityQueue<int[]> topFre = new PriorityQueue<int[]>((a,b)->(a[1]-b[1]));
        //key 元素值 ，value 出现的次数
        HashMap<Integer, Integer> topMap = new HashMap<>(nums.length);
        //计算个元素出现的频次
        for (int i = 0; i < nums.length; i++) {
            Integer topItemCount = topMap.get(nums[i]);
            if (Objects.isNull(topItemCount)) {
                topMap.put(nums[i], 1);
            } else {
                topMap.put(nums[i], topItemCount + 1);
            }
        }

        //放入小顶堆 堆频次排序
        topMap.entrySet().forEach(entry -> {
            if(topFre.size()<=k){
                topFre.add(new int[]{entry.getKey(),entry.getValue()});
            }else {
                //站内存放最大k个频次数据 ，所以超过k的小数量出栈
                //如果栈顶最小元素<当前元素出现的次数，则出栈
                if(topFre.peek()[1]<entry.getValue()){
                    topFre.poll();
                    topFre.add(new int[]{entry.getKey(),entry.getValue()});
                }
            }
        });
        for (int i =topFre.size()-k ; i >0 ; i--) {
            topFre.poll();
        }
        int[] finalTopKArr =new int[k];
        for (int i = 0; i < k; i++) {
            finalTopKArr[i]=topFre.poll()[0];
        }
        return finalTopKArr;
    }

    public static void main(String[] args) {
        int nums[] = new int[]{ 5,2,5,3,5,3,1,1,3};
        int[] ints = TopKFrequent.topKFrequent(nums, 2);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }
}
