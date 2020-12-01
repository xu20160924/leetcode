package com.leetcode;

/**
 * @author: John
 * @date: 2020-05-11 09:00
 * @description: 69
 **/
public class SixNine {
//    public int mySqrt(int x) {
//        if (x == 0) {
//            return 0;
//        }
//        int left = 1, right = Integer.MAX_VALUE;
//        while (true) {
//            int mid = left + (right - left) / 2;
//            if (mid > x / mid) {
//                right = mid - 1;
//            } else {
//                if (mid + 1 > x / (mid + 1)) {
//                    return mid;
//                }
//                left = mid + 1;
//            }
//        }
//    }

    public int mySqrt(int x) {
        int l = 0, r = x, ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if ((long) mid * mid <= x) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }
}
