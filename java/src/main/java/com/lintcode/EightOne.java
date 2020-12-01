package com.lintcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author: John
 * @date: 2020-04-26 10:31
 * @description: 81
 **/
public class EightOne {
    private PriorityQueue<Integer> maxHeap, minHeap;
    private int numOfElements = 0;

    /**
     * 用 maxheap 保存左半部分的数，用 minheap 保存右半部分的数。
     * 把所有的数一左一右的加入到每个部分。左边部分最大的数就一直都是 median。
     * 这个过程中，可能会出现左边部分并不完全都 <= 右边部分的情况。这种情况发生的时候，交换左边最大和右边最小的数即可。
     * @param nums
     * @return
     */
    public int[] median(int[] nums) {
        Comparator<Integer> revCmp = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        };
        int cnt = nums.length;
        maxHeap = new PriorityQueue<>(cnt, revCmp);
        minHeap = new PriorityQueue<>(cnt);

        int[] ans = new int[cnt];
        for (int i = 0; i < cnt; ++i) {
            addNumber(nums[i]);
            ans[i] = getMedian();
        }
        return ans;
    }

    public void addNumber(int value) {
        maxHeap.add(value);
        if (numOfElements % 2 == 0) {
            if (minHeap.isEmpty()) {
                numOfElements++;
                return;
            } else if (maxHeap.peek() > minHeap.peek()) {
                Integer maxHeapRoot = maxHeap.poll();
                Integer minHeapRoot = minHeap.poll();
                maxHeap.add(minHeapRoot);
                minHeap.add(maxHeapRoot);
            }
        } else {
            minHeap.add(maxHeap.poll());
        }
        numOfElements++;
    }

    public int getMedian() {
        return maxHeap.peek();
    }
}
