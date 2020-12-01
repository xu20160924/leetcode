package com.leetcode;

/**
 * @author: John
 * @date: 2020-02-29 11:49
 * @description: 287
 **/
public class TwoEightSeven {

    public int findDuplicate(int[] nums) {
        // Find the intersection point of the two runners
        int tortoise = nums[0];
        int hare = nums[0];

        do {
            tortoise = nums[tortoise];
            // 这里相当于跑了两步
            hare = nums[nums[hare]];
        } while (tortoise != hare);

        // Find the entrance to the cycle
        tortoise = nums[0];
        while (tortoise != hare) {
            tortoise = nums[tortoise];
            hare = nums[hare];
        }
        return hare;
    }

//    public int findDuplicate(int[] nums) {
//        Arrays.sort(nums);
//        for (int i = 1; i < nums.length; i++) {
//            if (nums[i] == nums[i - 1]) {
//                return nums[i];
//            }
//        }
//        return -1;
//    }

//    public int findDuplicate(int[] nums) {
//        int len = nums.length;
//        int left = 1;
//        int right = len - 1;
//        while (left < right) {
//            int mid = (left + right) >>> 1;
//            int cnt = 0;
//            for (int num : nums) {
//                if (num <= mid) {
//                    cnt += 1;
//                }
//            }
//            if (cnt > mid) {
//                right = mid;
//            } else {
//                left = mid + 1;
//            }
//        }
//        return left;
//    }



    // 这里通过将index 做为范围来进行二分查询 (抽屉原理)
    // 如果cnt小于等于mid 说明left 到 mid 之间没有重复的 反义亦然
//    public int findDuplicate(int[] nums) {
//       int low = 1, high = nums.length - 1;
//       while (low <= high) {
//           int mid = (int) (low + (high - low) * 0.5);
//           int cnt = 0;
//           for (int a : nums) {
//               if (a <= mid) {
//                   ++cnt;
//               }
//           }
//           if (cnt <= mid) {
//               low = mid + 1;
//           } else {
//               high = mid - 1;
//           }
//       }
//       return low;
//    }





    /**
     * binary search 抽屉原理
     * @param args
     */
//    public int findDuplicate(int[] nums) {
//        int len = nums.length;
//        int left = 1;
//        int right = len - 1;
//        while (left < right) {
//            // 在java里可以这么用，当left + right溢出的时候，无符号右移保证结果依然正确
//            int mid = (left + right) >>> 1;
//
//            int cnt = 0;
//            for (int num : nums) {
//                if (num <= mid) {
//                    cnt += 1;
//                }
//            }
//
//            // 根据抽屉原理，小于等于4的个数如果严格大于4个
//            // 此时重复元素一定出现在[1, 4]区间里
//            if (cnt > mid) {
//                // 重复元素位于区间 [left, mid]
//                right = mid;
//            } else {
//                // if 分析正确了以后 else 搜索的区间就是if的反面
//                // [mid + 1, right]
//                left = mid + 1;
//            }
//        }
//        return left;
//    }

    public static void main(String[] args) {
        TwoEightSeven twoEightSeven = new TwoEightSeven();
        twoEightSeven.findDuplicate(new int[]{1, 3, 4, 2, 2});
    }
}
