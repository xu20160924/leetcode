package com.lintcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author: John
 * @date: 2020-04-06 21:53
 * @description: 138
 **/
public class OneThreeEight {
//    public List<Integer> subarraySum(int[] nums) {
//        int len = nums.length;
//
//        ArrayList<Integer> ans = new ArrayList<>();
//        HashMap<Integer, Integer> map = new HashMap<>();
//        // 这里put -1 是为了配合后续取下标时需要加1的操作；加1是为了右边有0的情况
//        map.put(0, -1);
//
//        int sum = 0;
//        for (int i = 0; i < len; i++) {
//            sum += nums[i];
//            if (map.containsKey(sum)) {
//                ans.add(map.get(sum) + 1);
//                ans.add(i);
//                return ans;
//            }
//            map.put(sum, i);
//        }
//        return ans;
//    }

    public List<Integer> subarraySum(int[] nums) {
       int count = 0, sum = 0;

       List<Integer> result = new ArrayList<>();
       HashMap<Integer, Integer> map = new HashMap<>();
       map.put(0, 1);
       for (int i = 0; i < nums.length; i++) {
           sum += nums[i];
           if (map.containsKey(sum)) {
               result.add(map.get(sum) + 1);
               result.add(i);
               return result;
           }
           map.put(sum, i);
       }
       return result;
    }

    public static void main(String[] args) {
        OneThreeEight oneThreeEight = new OneThreeEight();
       List<Integer> result = oneThreeEight.subarraySum(new int[]{-3, 1, 2, -3, 4});
        System.out.println("");
//        oneThreeEight.subarraySum(new int[]{1,0,1});
//        oneThreeEight.subarraySum(new int[]{1,-1});
    }
}
