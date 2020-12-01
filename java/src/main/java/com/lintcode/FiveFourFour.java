package com.lintcode;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * @author: John
 * @date: 2020-04-23 11:45
 * @description: 544
 **/
public class FiveFourFour {
    public int[] topk(int[] nums, int k) {
        if (nums == null || nums.length <= 1) {
            return nums;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(k, Collections.reverseOrder());
        for (int num : nums) {
            pq.offer(num);
        }
        int[] maxk = new int[k];
        for (int i = 0; i < k; i++) {
            maxk[i] = pq.poll();
        }
        return maxk;
    }
}
