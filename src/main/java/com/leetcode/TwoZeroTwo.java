package com.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: John
 * @date: 2020-03-02 17:25
 * @description: 202
 **/
public class TwoZeroTwo {
    public boolean isHappy(int n) {
        Set<Integer> inLoop = new HashSet<>();
        int squareSum, remain;
        while (inLoop.add(n)) {
           squareSum = 0;
           while (n > 0) {
               remain = n % 10;
               squareSum += remain * remain;
               n /= 10;
           }
           if (squareSum == 1) {
               return true;
           } else {
               n = squareSum;
           }
        }
        return false;
    }
}
