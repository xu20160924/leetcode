package com.lintcode;

import java.util.*;

/**
 * @author: John
 * @date: 2020-04-23 11:25
 * @description: 545
 **/
public class FiveFourFive {

    private int maxSize;
    private Queue<Integer> minheap;


    public FiveFourFive(int k) {
        minheap = new PriorityQueue<>();
        maxSize = k;
    }

    public void add(int num) {
        if (minheap.size() < maxSize) {
            minheap.offer(num);
            return;
        }

        if (num > minheap.peek()) {
            minheap.poll();
            minheap.offer(num);
        }
    }

    public List<Integer> topk() {
        Iterator it = minheap.iterator();
        List<Integer> result = new ArrayList<>();
        while (it.hasNext()) {
            result.add((Integer) it.next());
        }
        Collections.sort(result, Collections.reverseOrder());
        return result;
    }


    public static void main(String[] args) {
        FiveFourFive fiveFourFive = new FiveFourFive(3);
        fiveFourFive.add(3);
        fiveFourFive.add(3);
        fiveFourFive.add(10);
        fiveFourFive.topk();
        fiveFourFive.add(1000);
        fiveFourFive.add(-99);
        fiveFourFive.topk();
        fiveFourFive.add(4);
        fiveFourFive.topk();
        fiveFourFive.add(100);
        fiveFourFive.topk();
    }
}
