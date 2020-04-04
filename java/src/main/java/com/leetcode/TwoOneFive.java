package com.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author: John
 * @date: 2020-03-03 16:52
 * @description: 215
 **/
public class TwoOneFive {
//    public int findKthLarget(int[] nums, int k) {
//        PriorityQueue<Integer> heap = new PriorityQueue<>((n1, n2) -> n1 - n2);
//        for (int n : nums) {
//            heap.add(n);
//            if (heap.size() > k) {
//               heap.poll();
//            }
//        }
//        return heap.poll();
//    }
//    int [] nums;
//
//    public void swap(int a, int b) {
//        int tmep = nums[a];
//        nums[a] = nums[b];
//        nums[b] = tmep;
//    }
//
//    public int partition(int left, int right, int pivot_index) {
//        int pivot = nums[pivot_index];
//        // move pivot to end
//        swap(pivot_index, right);
//        int store_index = left;
//
//        // move all smaller elements to the left
//        for (int i = left; i <= right; i++) {
//            if (nums[i] < pivot) {
//                swap(store_index, i);
//                store_index++;
//            }
//        }
//
//        // move pivot to its final place
//        swap(store_index, right);
//        return store_index;
//    }
//
//    public int quickselect(int left, int right, int k_smallest) {
//        // Returns the k-th smallest element of list within left.. right.
//        if (left == right) {  // If the list contains only one element.
//            return nums[left];  //return that element
//        }
//        // select a random pivot_index
//        Random random = new Random();
//        int pivot_index = left + random.nextInt(right - left);
//        pivot_index = partition(left, right, pivot_index);
//        // the pivot is on(N -k) th smallest position
//        if (k_smallest == pivot_index) {
//            return nums[k_smallest];
//            // go left side
//        } else if (k_smallest < pivot_index) {
//            return quickselect(left, pivot_index - 1, k_smallest);
//        }
//        // go right side
//        return quickselect(pivot_index + 1, right, k_smallest);
//    }
//
//    public int findKthLargest(int[] nums, int k) {
//        this.nums = nums;
//        int size = nums.length;
//        return quickselect(0, size -1, size - k);
//    }

//    public int findKthLargest(int[] nums, int k) {
//        int N = nums.length;
//        Arrays.sort(nums);
//        return nums[N - k];
//    }

//    public int findKthLargest(int[] nums, int k) {
//        PriorityQueue<Integer> pq = new PriorityQueue<>();
//        for (int val : nums) {
//           pq.offer(val);
//           if (pq.size() > k) {
//               pq.poll();
//           }
//        }
//        return pq.peek();
//    }

    public int findKthLargest(int[] nums, int k) {
        k = nums.length - k;
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            int j = partition(nums, lo, hi);
            if (j < k) {
               lo = j + 1;
            } else if (j > k) {
                hi = j - 1;
            } else {
                break;
            }
        }
        return nums[k];
    }

    private int partition(int[] a, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        while (true) {
            while (i < hi && less(a[++i], a[lo])) {};
            while (i > lo && less(a[lo], a[--j])) {};
            if (i >= j) {
               break;
            }
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
    }

    private void exch(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    private boolean less(int v, int w) {
        return v < w;
    }


    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        TwoOneFive twoOneFive = new TwoOneFive();
        twoOneFive.findKthLargest(nums, 2);
    }
}
