package com.lintcode;

import com.leetcode.Three;

import java.util.Arrays;

/**
 * @author: John
 * @date: 2020-04-16 08:36
 * @description: 382
 **/
public class ThreeEightTwo {
    public int triangleCount(int S[]) {
        Arrays.sort(S);
        int ans = 0;
        for (int i = 0; i < S.length; ++i) {
            int left = 0, right = i - 1;
            while (left < right) {
                if (S[left] + S[right] > S[i]) {
                    // 如果left + right 大于 i 直接统计right 到 left 的个数；因为left 往后一直到right 都是满足条件的
                    ans += right - left;
                    right -= 1;
                } else {
                    left += 1;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        ThreeEightTwo threeEightTwo = new ThreeEightTwo();
        threeEightTwo.triangleCount(new int[]{3,4,6,7});
    }
}
