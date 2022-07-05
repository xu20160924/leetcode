package com.entity;

import java.util.PriorityQueue;

/**
 * @author: John
 * @date: 2019-12-31 11:53
 * @description 703 from leetcode
 * the k max item in datastream
 **/
public class KthLargest {
    private PriorityQueue<Integer> queue;
    private int limit;

    public KthLargest(int k, int[] nums) {
        limit = k;
        queue = new PriorityQueue<>(k);
        for (int num : nums) {
            queue.add(num);
        }
    }

    public int add(int val) {
        if (queue.size() < limit) {
            queue.add(val);
        } else if (val > queue.peek()) {
            queue.poll();
            queue.add(val);
        }
        return queue.peek();
    }

    public static void main(String[] args) {
        int k = 3;
        int[] arr = new int[]{4, 5, 8, 2};
        KthLargest kthLargest = new KthLargest(k, arr);
//        assertEquals(4, kthLargest.add(3));
//        assertEquals(5, kthLargest.add(5));
//        assertEquals(5, kthLargest.add(10));
//        assertEquals(8, kthLargest.add(9));
//        assertEquals(8, kthLargest.add(4));
    }
//    public static void main(String[] args) {
//        PriorityQueue<Integer> queue = new PriorityQueue<>(10);
//        for (int i = 10; i >= 5; i--) {
//            queue.offer(i);
//        }
//        for (Integer i : queue) {
//            System.out.println(i + " ");
//        }
//    }
//    public static void main(String[] args) {
//        PriorityQueue<Integer> queue = new PriorityQueue<>(10, new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o1.compareTo(o2);
//            }
//        });
//        for (int i = 10; i >= 5 ; i--) {
//            queue.offer(i);
//        }
//        for (Integer i : queue) {
//            System.out.println(i + "");
//        }
////        while (queue.peek() != null) {
////            System.out.println(queue.poll() + " ");
////        }
//    }
//    public static void main(String[] args) {
//        PriorityQueue<Integer> queue = new PriorityQueue<>(10);
//        for (int i = 10; i >= 5 ; i--) {
//            queue.offer(i);
//        }
//        while (queue.peek() != null) {
//            System.out.println(queue.poll() + " ");
//        }
//    }


}


