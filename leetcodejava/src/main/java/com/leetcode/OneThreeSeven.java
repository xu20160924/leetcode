package com.leetcode;

import java.util.HashMap;

/**
 * @author: John
 * @date: 2020-03-18 14:37
 * @description: 137
 **/
public class OneThreeSeven {
//    public int singleNumber(int[] nums) {
//        HashMap<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            if (map.containsKey(nums[i])) {
//               map.put(nums[i], map.get(nums[i] + 1));
//            } else {
//                map.put(nums[i], 1);
//            }
//        }
//
//        for (Integer key : map.keySet()) {
//            if (map.get(key) == 1) {
//                return key;
//            }
//        }
//        return -1;
//    }

    public int singleNumber(int[] nums) {
        int ans = 0;
        // 考虑每一位
        for (int i = 0; i < 32; i++) {
            int count = 0;
            // 考虑每一个数
            for (int j = 0; j < nums.length; j++) {
               if ((nums[j] >>> i & 1) == 1) {
                   count++;
               }
            }
            // 1的个数是否是3的倍数
            if (count % 3 != 0) {
                ans = ans | 1 << i;
            }
        }
        return ans;
    }
}
