package com.leetcode;

import java.util.HashMap;

/**
 * @author: John
 * @date: 2020-04-13 11:09
 * @description: 560
 **/
public class FiveSixZero {

    /**
     * hashmap
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {
        int count = 0, sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
//        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum == k) {
               count++;
            }
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }


    /**
     * cumulative sum
     * @param nums
     * @param k
     * @return
     */
//    public int subarraySum(int[] nums, int k) {
//        int count = 0;
//        int[] sum = new int[nums.length + 1];
//        sum[0] = 0;
//        // 这里提前算好当前下标所对应的sum值
//        for (int i = 1; i <= nums.length; i++) {
//            sum[i] = sum[i - 1] + nums[i - 1];
//        }
//        for (int start = 0; start < nums.length; start++) {
//            for (int end = start +1; end <= nums.length; end++) {
//                // 在判断时通过结尾下标的sum值减去start 下标的sum值 即为当前这段距离的sum值
//                if (sum[end] - sum[start] == k) {
//                   count++;
//                }
//            }
//        }
//        return count;
//    }

//    public int subarraySum(int[] nums, int k) {
//       int count = 0;
//       for (int start = 0; start < nums.length; start++) {
//           int sum = 0;
//           for (int end = start; end < nums.length; end++) {
//               sum += nums[end];
//               if (sum == k) {
//                    count++;
//               }
//           }
//       }
//       return count;
//    }


    /**
     * brute force
     * @param nums
     * @param k
     * @return
     */
//    public int subarraySum(int[] nums, int k) {
//        int count = 0;
//        for (int start = 0; start < nums.length; start++) {
//            for (int end = start + 1; end <= nums.length; end++) {
//                int sum = 0;
//                for (int i = start; i < end; i++) {
//                    sum += nums[i];
//                }
//                if (sum == k) {
//                   count++;
//                }
//            }
//        }
//        return count;
//    }



//    public int subarraySum(int[] nums, int k) {
//        int len = nums.length;
//        ArrayList<Integer> ans = new ArrayList<>();
//        HashMap<Integer, Integer> map = new HashMap<>();
//
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

//    public int subarraySum(int[] nums, int k) {
//        int len = nums.length;
//
//        ArrayList<Integer> ans = new ArrayList<>();
//        HashMap<Integer, Integer> map = new HashMap<>();
//        // 这里put -1 是为了配合后续取下标时需要加1的操作；加1是为了右边有0的情况
//        map.put(0, k);
//
//        int result = 1;
//        int sum = 0;
//        for (int i = 0; i < len; i++) {
//            sum += nums[i];
//            if (map.containsKey(sum)) {
//                ans.add(map.get(sum) + 1);
//                ans.add(i);
//                result++;
//                return result;
////                return ans;
//            }
//            map.put(sum, i);
//        }
//        return result;
//    }



    public static void main(String[] args) {
        FiveSixZero fiveSixZero = new FiveSixZero();
//        System.out.println(fiveSixZero.subarraySum(new int[]{1, 1, 1}, 2));
        System.out.println(fiveSixZero.subarraySum(new int[]{3,4,7,2,-3,1,4,2}, 7));
    }
}
