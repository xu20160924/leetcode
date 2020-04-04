package com.leetcode;

/**
 * @author: John
 * @date: 2020-03-03 14:15
 * @description: 55
 **/
enum Index{
    GOOD, BAD, UNKNOWN
}
public class FiveFive {

    /**
     * backTracking
     * @return
     */
//    public boolean canJumpFromPosition(int position, int[] nums) {
//       if (position == nums.length - 1) {
//           return true;
//       }
//       int furthestJump = Math.min(position + nums[position], nums.length - 1);
//       // old
////       for (int nextPosition = position + 1; nextPosition <= furthestJump; nextPosition++) {
//       //new
//       for (int nextPosition = furthestJump; nextPosition > position; nextPosition--) {
//           System.out.print(nextPosition + "->");
//           if (canJumpFromPosition(nextPosition, nums)) {
//                return true;
//           }
//       }
//       return false;
//    }
//
//    public boolean canJump(int[] nums) {
//        return canJumpFromPosition(0, nums);
//    }

    // Top-down dynamic programming
    Index[] memo;
    public boolean canJumpFromPosition(int position, int[] nums) {
        if (memo[position] != Index.UNKNOWN) {
            return memo[position] == Index.GOOD ? true : false;
        }
        int furthestJump = Math.min(position + nums[position], nums.length - 1);
        for (int nextPosition = position + 1; nextPosition <= furthestJump; nextPosition++) {
            if (canJumpFromPosition(nextPosition, nums)) {
                memo[position] = Index.GOOD;
                return true;
            }
        }
        memo[position] = Index.BAD;
        return false;
    }

    public boolean canJump(int[] nums) {
        memo = new Index[nums.length];
        for (int i = 0; i < memo.length; i++) {
            memo[i] = Index.UNKNOWN;
        }
        memo[memo.length - 1] = Index.GOOD;
        return canJumpFromPosition(0, nums);
    }

//    public boolean canJump(int[] nums) {
//        Index[] memo = new Index[nums.length];
//        for (int i = 0; i < memo.length; i++) {
//            memo[i] = Index.UNKNOWN;
//        }
//        memo[memo.length - 1] = Index.GOOD;
//
//        for (int i = nums.length - 2; i >= 0; i--) {
//            int furthestJump = Math.min(i + nums[i], nums.length - 1);
//            for (int j = i + 1; j <= furthestJump; j++) {
//                if (memo[j] == Index.GOOD) {
//                    memo[i] = Index.GOOD;
//                    break;
//                }
//            }
//        }
//        return memo[0] == Index.GOOD;
//    }


    // greedy
//    public boolean canJump(int[] nums) {
//        int lastPos = nums.length - 1;
//        for (int i = nums.length - 1; i >= 0; i--) {
//            if (i + nums[i] >= lastPos) {
//                lastPos = i;
//            }
//        }
//        return lastPos == 0;
//    }

    public static void main(String[] args) {
        int[] nums = {5, 4, 3, 2, 1, 0, 0};
        FiveFive fiveFive = new FiveFive();
        fiveFive.canJump(nums);
    }
}
