package com.leetcode;

/**
 * @author: John
 * @date: 2020-11-21 20:09
 * @description: 312
 **/
public class ThreeOneTwo {

    /**
     * myself thinking, everytime kill the smallest balloon in the center that exclude beginning balloon and ending ballon
     * but this didnt work
     *
     * @param nums
     * @return
     */
//    public int maxCoins(int[] nums) {
//        if (nums == null || nums.length == 0) {
//            return 0;
//        }
//        if (nums.length == 1) {
//            return nums[nums.length - 1];
//        }
//        Map<Integer, Integer> map = new HashMap<>();
//
//        for (int i = 0; i < nums.length; i++) {
//            map.put(nums[i], i);
//        }
//        int[] temp = Arrays.copyOf(nums, nums.length);
//        Arrays.sort(temp);
//
//        int result = 0;
//        for (int i = 0; i < temp.length; i++) {
//            if (temp[i] == nums[0] || temp[i] == nums[nums.length - 1]) {
//                continue;
//            }
//            int index = map.get(temp[i]);
//            int left = 1, right = 1, leftIdx = index, rightIdx = index;
//            while ((left = nums[--leftIdx]) > 0 && nums[leftIdx] == 101);
//            while (( right = nums[++rightIdx]) > 0 && nums[rightIdx] == 101);
//            System.out.println(left + "*" + nums[index] + "*" + right);
//            result += left * nums[index] * right;
//            nums[index] = 101;
//        }
//        result += nums[0] * nums[nums.length - 1] + Math.max(nums[0], nums[nums.length - 1]);
//        return result;
//    }
//    public int maxCoins(int[] nums) {
//        if (nums == null || nums.length == 0) {
//            return 0;
//        }
//        if (nums.length == 1) {
//            return nums[0];
//        }
//        int N = nums.length;
//        int[] help = new int[N + 2];
//        help[0] = 1;
//        help[N + 1] = 1;
//        for (int i = 0; i < N; i++) {
//            help[i + 1] = nums[i];
//        }
//        return process(help, 1, N);
//    }

//    public int maxCoins(int[] nums) {
//        if (nums == null || nums.length == 0) {
//            return 0;
//        }
//        if (nums.length == 1) {
//            return nums[0];
//        }
//        int N = nums.length;
//        int[] temp = new int[N + 2];
//        temp[0] = 1;
//        temp[N + 1] = 1;
//
//        for (int i = 0; i < N; i++) {
//            temp[i + 1] = nums[i];
//        }
//        int[][] dp = new int[N + 2][N + 2];
//        for (int i = 1; i <= N; i++) {
//            dp[i][i] = temp[i - 1] * temp[i] * temp[i + 1];
//            System.out.println(dp[i][i]);
//        }
//        for (int L = N; L >= 1; L--) {
//            for (int R = L + 1; R <= N; R++) {
//                // 求解dp[L][R] 表示temp[L..R] 上打爆所有气球的最大分数
//                // 最后打爆temp[L]的方案
//                int finalL = temp[L - 1] * temp[L] * temp[R + 1] + dp[L + 1][R];
//                // 最后打爆temp[R]的方案
//                int finalR = temp[L - 1] * temp[R] * temp[R + 1] + dp[L][R - 1];
//                dp[L][R] = Math.max(finalL, finalR);
//
//                // 尝试中间位置的气球最后被打爆的每一种方案
//                for (int i = L + 1; i < R; i++) {
//                    dp[L][R] = Math.max(dp[L][R],
//                            temp[L - 1] * temp[i] * temp[R + 1] + dp[L][i - 1] + dp[L + 1][R]
//                            );
//                }
//            }
//        }
//        return dp[1][N];
//    }
//
//
//    // 假设arr[L - 1]和arr[R + 1] 一定没有被打爆
//    private int process(int[] arr, int L, int R) {
//        if (L == R) {    // 如果arr[L..R] 范围只有一个气球， 直接打爆
//            return arr[L - 1] * arr[L] * arr[R + 1];
//        }
//        // 最后打爆arr[L] 的方案与最后打爆arr[R]的方案， 比较一下
//        int max = Math.max(arr[L - 1] * arr[L] * arr[R + 1] + process(arr, L + 1, R),
//                arr[L - 1] * arr[R] + arr[R + 1]) + process(arr, L, R - 1);
//
//        // 尝试中间位置的气球最后被打爆的每一种方案
//        for (int i = L + 1; i < R; i++) {
//            max = Math.max(max, arr[L - 1] * arr[i] * arr[R + 1] + process(arr, L, i - 1) + process(arr, i + 1, R));
//        }
//        return max;
//    }


//    public int maxCoins(int[] nums) {
//        int[] temp = new int[nums.length + 2];
//        int n = 1;
//        for (int num : nums) {
//            temp[n++] = num;
//        }
//        temp[0] = temp[n++] = 1;
//
//        int[][] memo = new int[n][n];
//        return burst(memo, nums, 0, n - 1);
//    }
//
//    private int burst(int[][] memo, int[] nums, int left, int right) {
//        if (left + 1 == right) {
//            return 0;
//        }
//        if (memo[left][right] > 0) {
//            return memo[left][right];
//        }
//        int ans = 0;
//        for (int i = left + 1; i < right; i++) {
//            ans = Math.max(
//                    ans,
//                    nums[left] * nums[i] * nums[right] +
//                            burst(memo, nums, left, i) +
//                            burst(memo, nums, i, right)
//            );
//            memo[left][right] = ans;
//        }
//        return ans;
//    }

    public int maxCoins(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int[] temp = new int[nums.length + 2];
        int n = 1;
        for (int num : nums) {
            temp[n++] = num;
        }
        temp[0] = temp[n++] = 1;
        int[][] dp = new int[n][n];

        for (int k = 2; k < n - 1; ++k) {
            for (int left = 0; left < n - k; left++) {
                int right = left + k;
                for (int i = left + 1; i < right; i++) {
                    dp[left][right] = Math.max(dp[left][right],
                            temp[left] * temp[i] * temp[right] + dp[left][i] + dp[i][right]
                            );

                    System.out.println(temp[left] + "*" + temp[i] + "*" + temp[right]);
                }
            }
        }
        return dp[0][n - 1];
    }

//    public int maxCoins(int[] nums) {
//        int[] temp = new int[nums.length + 2];
//        int n = 1;
//        for (int num : nums) {
//           temp[n++] = num;
//        }
//        temp[0] = temp[n++] = 1;
//        int[][] dp = new int[n][n];
//
//        for (int left = n - 1; left >= 0; left--) {
//            for (int right = left + 2; ) {
//                for () {
//
//                }
//            }
//        }
//
//    }

    public static void main(String[] args) {
        ThreeOneTwo threeOneTwo = new ThreeOneTwo();
        System.out.println(threeOneTwo.maxCoins(new int[]{3,1,5,8}));
//        System.out.println(threeOneTwo.maxCoins(new int[]{9, 76, 64, 21}));
    }
}
