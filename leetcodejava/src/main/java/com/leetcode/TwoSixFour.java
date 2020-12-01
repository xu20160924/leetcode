package com.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author: John
 * @date: 2020-04-22 16:25
 * @description: 264
 **/
public class TwoSixFour {
//    public int nthUglyNumber(int n) {
//        int res = 0;
//        for (int i = 2; i < 6 && i > 0; i++) {
//            while (n % i == 0) {
//                n /= i;
//                res++;
////                System.out.println(n /= i);
//            }
//        }
//        return res;
//    }

//    public int[] nums = new int[1690];
//
//    public TwoSixFour() {
//        HashSet<Long> seen = new HashSet<>();
//        PriorityQueue<Long> heap = new PriorityQueue<>();
//        seen.add(1L);
//        heap.add(1L);
//
//        long currUgly, newUgly;
//        int[] primes = new int[]{2, 3, 5};
//        for (int i = 0; i < 1690; ++i) {
//            currUgly = heap.poll();
//            nums[i] = (int) currUgly;
//            for (int j : primes) {
//                newUgly = currUgly * j;
//                if (!seen.contains(newUgly)) {
//                    seen.add(newUgly);
//                    heap.add(newUgly);
//                }
//            }
//        }
//    }

    public int nthUglyNumber(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int t2 = 0, t3 = 0, t5 = 0;

        List<Integer> list = new ArrayList<>();
        list.add(1);

        for (int i = 1; i < n; i++) {
            list.add(i, Math.min(list.get(t2) * 2, Math.min(list.get(t3) * 3, list.get(t5) * 5)));
            if (list.get(i) == list.get(t2) * 2) {
                t2++;
            }
            if (list.get(i) == list.get(t3) * 3) {
                t3++;
            }
            if (list.get(i) == list.get(t5) * 5) {
                t5++;
            }
        }
        return list.get(n - 1);
    }

    public static void main(String[] args) {
//        TwoSixFour twoSixFour = new TwoSixFour();
//        System.out.println(twoSixFour.nthUglyNumber(10));
    }
}
