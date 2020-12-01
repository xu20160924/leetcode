package com.lintcode;

/**
 * @author: John
 * @date: 2020-04-06 20:43
 * @description: 41
 **/
public class FourOne {
    // greedy
//    public int maxSubArray(int[] A) {
//       if (A == null || A.length == 0) {
//           return 0;
//       }
//       // max记录全局最大值， sum记录区间和，如果当前sum > 0,
//        // 那么可以继续和后面的数求和，否则就从0开始
//        int max = Integer.MIN_VALUE, sum = 0;
//        for (int i = 0; i < A.length; i++) {
//            sum += A[i];
//            max = Math.max(max, sum);
//            sum = Math.max(sum, 0);
//        }
//        return max;
//    }

    // prefix sum
//    public int maxSubArray(int[] nums) {
//        if (nums == null || nums.length == 0) {
//            return 0;
//        }
//        // max 记录全局最大值, sum记录前i个数的和，minSum记录前i个树中0-k的最小值
//        int max = Integer.MIN_VALUE, sum = 0, minSum = 0;
//        for (int i = 0; i < nums.length; i++) {
//            sum += nums[i];
//            max = Math.max(max, sum - minSum);
//            minSum = Math.min(minSum, sum);
//        }
//        return max;
//    }

    // dp
//    public int maxSubArray(int[] nums) {
//       if (nums.length == 0) {
//           return 0;
//       }
//       int n = nums.length;
//       int[] global = new int[2];
//       int[] local = new int[2];
//       global[0] = nums[0];
//       local[0] = nums[0];
//       for (int i = 1; i < n; i++) {
//           local[i % 2] = Math.max(nums[i], local[(i - 1) % 2] + nums[i]);
//           global[i % 2] = Math.max(local[i % 2], global[(i - 1) % 2]);
//       }
//       return global[(n-1) % 2];
//    }

    // dp
//    public int maxSubArray(int[] nums) {
//        int n = nums.length;
//        int[] dp = new int[n];  //dp[i] means the maximum subarray ending with nums[i]
//        dp[0] = nums[0];
//        int max = dp[0];
//
//        for (int i = 1; i < n; i++) {
//            dp[i] = nums[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);
//            max = Math.max(max, dp[i]);
//        }
//        return max;
//    }

    // greedy
//    public int maxSubArray(int[] A) {
//        if (A == null || A.length == 0) {
//            return 0;
//        }
//        // max 记录全局最大值, sum 记录区间和， 如果当前sum > 0,
//        // 那么可以继续和后面的数求和， 否则就从0开始
//        int max = Integer.MIN_VALUE, sum = 0;
//        for (int i = 0; i < A.length; i++) {
//           sum += A[i];
//           max = Math.max(max, sum);
//           sum = Math.max(sum, 0);
//        }
//        return max;
//    }

//    public int maxSubArray(int[] nums) {
//        if (nums == null || nums.length == 0) {
//            return 0;
//        }
//        // max 记录全局最大值，sum记录前i个数的和，minSum记录前i个树中0-k的最小值
//        int max = Integer.MIN_VALUE, sum = 0, minSum = 0;
//        for (int i = 0; i < nums.length; i++) {
//            sum += nums[i];
//            max = Math.max(max, sum - minSum);
//            minSum = Math.min(minSum, sum);
//        }
//        return max;
//    }

//    public int maxSubArray(int[] nums) {
//        if (nums.length == 0) {
//            return 0;
//        }
//        int n = nums.length;
//        int[] global = new int[2];
//        int[] local = new int[2];
//        global[0] = nums[0];
//        local[0] = nums[0];
//        for (int i = 1; i < n; i++) {
//            local[i % 2] = Math.max(nums[i], local[(i - 1 % 2)] + nums[i]);
//            global[i % 2] = Math.max(local[i % 2], global[(i - 1) % 2]);
//        }
//        return global[(n - 1) % 2];
//    }

    public int maxSubArray(int[] A) {
       int n = A.length;
       int[] dp = new int[n];
       dp[0] = A[0];
       int max = dp[0];

       for (int i = 1; i < n; i++) {
          dp[i] = A[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);
          max = Math.max(max, dp[i]);
       }
       return max;
    }

    public static void main(String[] args) {
        FourOne fourOne = new FourOne();
        fourOne.maxSubArray(new int[]{-2, 2, -3, 4, -1, 2, 1, -5, 3});
    }
}
