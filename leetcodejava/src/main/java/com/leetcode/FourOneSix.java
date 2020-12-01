package com.leetcode;

import java.util.Arrays;

/**
 * @author: John
 * @date: 2020-10-07 08:19
 * @description: 416
 **/
public class FourOneSix {
//    public boolean canPartition(int[] nums) {
//        Arrays.sort(nums);
//        int max = nums[nums.length - 1];
//        int len = nums.length - 1;
//        for (int i = 0; i < len; i++) {
//            max -= nums[i];
//            if (max < 0 && (len - 1) != i) {
//                max += nums[len - 1];
//                len -= 1;
//            }
//        }
//        if (max == 0) {
//            return true;
//        }
//        return false;
//    }

//    public boolean canPartition(int[] nums) {
//        int totalSum = 0;
//
//        for (int sum : nums) {
//            totalSum += sum;
//        }
//
//        // if totalSum is odd, it cannot be partitioned into equal sum subset
//        if (totalSum % 2 != 0) {
//            return false;
//        }
//        int subSetSum = totalSum / 2;
//        int n = nums.length;
//        return dfs(nums, n - 1, subSetSum);
//    }
//
//    private boolean dfs(int[] nums, int n, int subSetSum) {
//        if (subSetSum == 0) {
//            return true;
//        }
//        if (n == 0 || subSetSum < 0) {
//            return false;
//        }
//        return dfs(nums, n - 1, subSetSum - nums[n - 1]) ||
//                dfs(nums, n - 1, subSetSum);
//    }

//    public boolean canPartition(int[] nums) {
//        int totalSum = 0;
//        Arrays.sort(nums);
//        for (int num : nums) {
//            totalSum += num;
//        }
//        if (totalSum % 2 != 0) {
//            return false;
//        }
//
//        int start = 0, end = nums.length - 1, target = (totalSum /= 2);
//        do {
//            if (target == 0) {
////                target = totalSum;
//                target = target ^ totalSum;
//                totalSum = target ^ totalSum;
//                target = target ^ totalSum;
//            }
//            if (target < 0 || target < nums[end]) {
//                target += nums[end++];
//                target -= nums[start++];
//            }
//            target -= nums[end--];
//        } while(end - start != 0);
//        return target == 0;
//    }


//    public boolean canPartition(int[] nums) {
//        int totalSum = 0;
//        for (int num : nums) {
//            totalSum += num;
//        }
//        if (totalSum % 2 != 0) {
//            return false;
//        }
//        int subSetSum = totalSum / 2;
//        int n = nums.length;
//        return dfs(nums, n, subSetSum);
//    }
//
//    private boolean dfs(int[] nums, int n, int subSetSum) {
//        if (subSetSum == 0) {
//            return true;
//        }
//        if (n == 0 || subSetSum < 0) {
//            return false;
//        }
//        return dfs(nums, n - 1, subSetSum - nums[n - 1]) ||
//                dfs(nums, n - 1, subSetSum);
//    }

//    public boolean canPartition(int[] nums) {
//        int totalSum = 0;
//        // find sum of all array elements
//        for (int num : nums) {
//            totalSum += num;
//        }
//        // if totalSum is odd, it cannot be partitioned into equal sumsubset
//        if (totalSum % 2 != 0) {
//            return false;
//        }
//        int subSetSum = totalSum / 2;
//        int n = nums.length;
//        Boolean[][] memo = new Boolean[n + 1][subSetSum + 1];
//        return dfs();
//    }
//
//    private boolean dfs(int[] nums, int n, int subSetSum, Boolean[][] memo) {
//        if (subSetSum == 0) {
//            return true;
//        }
//        if (n == 0 || subSetSum < 0) {
//            return false;
//        }
//        if (memo[n][subSetSum] != null) {
//            return memo[n][subSetSum];
//        }
////        memo[n][subSetSum] = dfs(nums, n - 1, subSetSum - nums[n - 1], memo);
////        memo[n][subSetSum] = dfs(nums, n - 1, subSetSum, memo);
//        boolean result =
//                dfs(nums, n - 1, subSetSum - nums[n - 1], memo) ||
//                        dfs(nums, n - 1, subSetSum, memo);
//        memo[n][subSetSum] = result;
//        return result;
//    }

//    public boolean canPartition(int[] nums) {
//        int totalSum = 0;
//        for (int num : nums) {
//            totalSum += num;
//        }
//        if (totalSum % 2 != 0) {
//            return false;
//        }
//        int subSetSum = totalSum / 2;
//        int n = nums.length;
//        boolean dp[][] = new boolean[n + 1][subSetSum + 1];
//        dp[0][0] = true;
//        for (int i = 1; i <= n; i++) {
//            int curr = nums[i - 1];
//            for (int j = 0; j <= subSetSum; j++) {
//                if (j < curr) {
//                    dp[i][j] = dp[i - 1][j];
//                } else {
//                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - curr];
//                }
//            }
//        }
//        return dp[n][subSetSum];
//    }

    public boolean canPartition(int[] nums) {
        if (nums.length == 0) {
            return false;
        }
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        if (totalSum % 2 != 0) {
            return false;
        }
        int subSetSum = totalSum / 2;
        int n = nums.length;
        boolean[] dp = new boolean[subSetSum + 1];
        dp[0] = true;
        for (int curr : nums) {
            for (int j = subSetSum; j >= curr; j--) {
                dp[j] |= dp[j - curr];
            }
        }
        return dp[subSetSum];
    }

    public static void main(String[] args) {
//        int[] num = {1,2,3,4,5,6,7};
//        int[] num = {1,5,11,5};
//        int[] num = {1,2,3,5};
//        int[] num = {23,13,11,7,6,5,5};
        int[] num = {1,3,4,4};
        FourOneSix fourOneSix = new FourOneSix();
        System.out.println(fourOneSix.canPartition(num));
    }
}
