package com.leetcode;

import java.util.PriorityQueue;

/**
 * @author: John
 * @date: 2020-02-28 13:36
 * @description: 295
 **/
public class TwoNineFive {


    //my solution is wrong because dont consider order
//    private int index = 0;
//    private double median;
//    private List<Integer> nums = new ArrayList<>();
//    public void addNum(int num) {
//        nums.add(num);
//        if (nums.size() < 2) {
//           median = num;
//       } else {
//           if (nums.size() % 2 == 0) {
//               median = ((double)nums.get(index) + nums.get(index+1)) / (double)2 ;
//           } else {
//               median = nums.get(++index);
//           }
//       }
//    }
//
//    public double findMedian() {
//        return median;
//    }
//    private Queue<Long> small = new PriorityQueue<>(),
//                        large = new PriorityQueue<>();
//
//    public void addNum(int num) {
//       large.add((long) num);
//       small.add(-large.poll());
//       if (large.size() < small.size()) {
//           large.add(-small.poll());
//       }
//    }
//
//    public double findMedian() {
//        return large.size() > small.size() ? large.peek() : (large.peek() - small.peek()) / 2.0;
//    }

//    private PriorityQueue<Integer> small = new PriorityQueue<>(Collections.reverseOrder());
//    private PriorityQueue<Integer> large = new PriorityQueue<>();
//    private boolean even = true;
//
//    public double findMedian() {
//        if (even) {
//            return (small.peek() + large.peek()) / 2.0;
//        } else {
//            return small.peek();
//        }
//    }
//
//    public void addNum(int num) {
//        if (even) {
//            large.offer(num);
//            small.offer(large.poll());
//        } else {
//            small.offer(num);
//            large.offer(small.poll());
//        }
//        even = !even;
//    }

    /**
     * 当前大顶堆和小顶堆的元素个数之和
     */
    private int count;
    private PriorityQueue<Integer> maxHeap;
    private PriorityQueue<Integer> minHeap;

    public TwoNineFive() {
        count = 0;
        maxHeap = new PriorityQueue<>((x, y) -> y - x);
        minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        count += 1;
        maxHeap.offer(num);
        minHeap.add(maxHeap.poll());
        // 如果两个堆合起来的元素个数是奇数， 小顶堆要拿出堆顶元素给大顶堆
        if ((count & 1) != 0) {
           maxHeap.add(minHeap.poll());
        }
    }

    public double findMedian() {
        if ((count & 1) == 0) {
            // 如果两个堆合起来的元素个数是偶数，数据流的中位数就是各自堆顶元素的平均值
            return (double) (maxHeap.peek() + minHeap.peek()) / 2;
        } else {
            // 如果两个堆合起来的元素个数是奇数，数据流的中位数是大顶堆的堆顶元素
            return (double) maxHeap.peek();
        }
    }

    public static void main(String[] args) {
        TwoNineFive twoNineFive = new TwoNineFive();
        twoNineFive.addNum(1);
        twoNineFive.addNum(2);
        System.out.println(twoNineFive.findMedian());
        twoNineFive.addNum(3);
        System.out.println(twoNineFive.findMedian());
//        System.out.println((double)1/(double)2);
    }
}
