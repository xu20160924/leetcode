package com.john;

import java.util.PriorityQueue;

public class FindUnsortedArrayMedianNum {
//    public static double findMedian(int[] nums) {
//        // 默认是小顶堆
//        PriorityQueue<Integer> minPQ = new PriorityQueue<>();
//        PriorityQueue<Integer> maxPQ = new PriorityQueue<>((o1, o2) -> o2 - o1);
//        int len = nums.length;
//        int k;
//        if (len % 2 == 0) { // 判断奇数偶数
//            k = len / 2;
//        } else {
//            k = len / 2 + 1;
//        }
//        for (int i = 0; i < len; i++) {
//            if (maxPQ.size() == 0 || nums[i] <= maxPQ.peek()) {
//                maxPQ.add(nums[i]);
//                if (maxPQ.size() > k) {
//                    minPQ.add(maxPQ.poll());
//                }
//            } else {
//                minPQ.add(nums[i]);
//                if (maxPQ.size() < k) {
//                    maxPQ.add(minPQ.poll());
//                }
//            }
//        }
//
//        if (k % 2 == 0) {
//            return (maxPQ.peek() + minPQ.peek()) / 2.0;
//        } else {
//            return maxPQ.peek();
//        }
//    }


    public static double findMedian(int[] nums) {
        PriorityQueue<Integer> minPQ = new PriorityQueue<>();
        int len = nums.length;
        int k = len / 2 + 1;

        for (int i = 0; i < k; i++) {
            minPQ.add(nums[i]);
        }

        for (int i = k; i < len; i++) {
            if (nums[i] > minPQ.peek()) {
                minPQ.poll();
                minPQ.add(nums[i]);
            }
        }

        if (len % 2 == 0) {
            return (minPQ.poll() + minPQ.peek()) / 2.0;
        } else {
            return minPQ.peek();
        }
    }

    public static void main(String[] args) {
//        System.out.println(FindUnsortedArrayMedianNum.findMedian(new int[]{1,23,5,2,23,3,4,142}));
        System.out.println(FindUnsortedArrayMedianNum.findMedian(new int[]{5,2,3,1}));
    }
}
