package com.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: John
 * @date: 2020-03-18 14:42
 * @description: 136
 **/
public class OneThreeSix {

    /**
     * 2∗(a+b+c)−(a+a+b+b+c)=c
     */
//    public int singleNumber(int[] nums) {
//        int sumOfSet = 0, sumOfNums = 0;
//        Set<Integer> set = new HashSet<>();
//        for (int num : nums) {
//           if (!set.contains(num)) {
//               set.add(num);
//               sumOfSet += num;
//           }
//           sumOfNums += num;
//        }
//        return 2 * sumOfSet - sumOfNums;
//    }

    /**
     * a⊕b⊕a=(a⊕a)⊕b=0⊕b=b
     */
//    public int singleNumber(int[] nums) {
//        int a = 0;
//        for (int i : nums) {
//            a ^= i;
//        }
//        return a;
//    }

}
