package com.lintcode;

import org.omg.CORBA.INTERNAL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeMap;

/**
 * @author: John
 * @date: 2020-04-07 10:26
 * @description: 139
 **/
public class OneThreeNine {

    class Pair {
        int sum;
        int index;
        public Pair(int s, int i) {
            sum = s;
            index = i;
        }
    }

    public int[] subarraySumClosest(int[] nums) {
        int[] res = new int[2];
        if (nums == null || nums.length == 0) {
            return res;
        }
        int len = nums.length;
        if (len == 1) {
           res[0] = res[1] = 0;
           return res;
        }
        Pair[] sums = new Pair[len + 1];
        int prev = 0;
        sums[0] = new Pair(0, 0);
        for (int i = 1; i <= len; i++) {
           sums[i] = new Pair(prev + nums[i - 1], i);
           prev = sums[i].sum;
        }
        Arrays.sort(sums, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
               return (o1.sum - o2.sum) < 0 ? 1 : (o1.sum - o2.sum);
            }
        });

        int ans = Integer.MAX_VALUE;
        for (int i = 1; i <= len; i++) {
            if (ans > sums[i].sum - sums[i - 1].sum) {
                ans = sums[i].sum - sums[i - 1].sum;
                int[] temp = new int[] {sums[i].index - 1, sums[i - 1].index - 1};
                Arrays.sort(temp);
                res[0] = temp[0] + 1;
                res[1] = temp[1];
            }
        }
        return res;
    }

//    public int[] subarraySumClosest(int[] nums) {
//        int[] res = new int[2];
//        if (nums.length == 0) {
//           return res;
//        }
//        int closet = Integer.MAX_VALUE, sum = 0;
//        TreeMap<Integer, Integer> map = new TreeMap<>();
//        map.put(0, 0);
//        for (int i = 1; i <= nums.length; i++) {
//            sum += nums[i - 1];
//            if (map.containsKey(sum)) {
//               res[0] = map.get(sum);
//               res[1] = i - 1;
//               return res;
//            }
//
//            Integer greater = map.higherKey(sum);
//            if (greater != null && Math.abs(sum - greater) < closet) {
//                closet = Math.abs(sum - greater);
//                res[0] = map.get(greater);
//                res[1] = i - 1;
//            }
//            Integer lower = map.lowerKey(sum);
//            if (lower != null && Math.abs(sum - lower) < closet) {
//                closet = Math.abs(sum - lower);
//                res[0] = map.get(lower);
//                res[1] = i - 1;
//            }
//            map.put(sum, i);
//        }
//        return res;
//    }

    public static void main(String[] args) {
        OneThreeNine oneThreeNine = new OneThreeNine();
//        int[] res = oneThreeNine.subarraySumClosest(new int[]{-3,1,1,-3,5});
        int[] res = oneThreeNine.subarraySumClosest(new int[]{-2, 2, 1, -1, -1});
//        int[] res = oneThreeNine.subarraySumClosest(new int[]{-2, 2, 1, -1, -1});
//        int[] res = oneThreeNine.subarraySumClosest(new int[]{6, -4, -8, 3, 1, 7});
        System.out.println("asdf");
    }
}
