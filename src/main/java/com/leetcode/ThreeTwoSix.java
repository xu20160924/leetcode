package com.leetcode;

/**
 * @author: John
 * @date: 2020-03-18 11:08
 * @description: 326
 **/
public class ThreeTwoSix {
//    public boolean isPowerOfThree(int n) {
//       String baseChange = Integer.toString(n, 3);
//       boolean powerOfThree = baseChange.matches("^10*$");
//       return powerOfThree;
//    }

//    public boolean isPowerOfThree(int n) {
//       return (Math.log(n) / Math.log(3) + )
//    }

    public boolean isPowerOfThree(int n) {
        return n > 0 && 1162261467 % n == 0;
    }

    public static void main(String[] args) {
        ThreeTwoSix threeTwoSix = new ThreeTwoSix();
        threeTwoSix.isPowerOfThree(45);
    }
}
