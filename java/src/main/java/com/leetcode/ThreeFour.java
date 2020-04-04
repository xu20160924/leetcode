package com.leetcode;

/**
 * @author: John
 * @date: 2020-01-30 15:59
 * @description: 34
 **/
public class ThreeFour {
//    public static int[] searchRange(int[] nums, int target) {
//        int[] targetRange = {-1, -1};
//        for (int i = 0; i < nums.length; i++) {
//            if (nums.length == 1 && nums[i] == target) {
//                targetRange[0] = i;
//                targetRange[1] = i;
//                break;
//            }
//            if (targetRange[0] >= 0 && nums[i] == target) {
//                targetRange[1] = i;
//            }
//            if (targetRange[0] < 0 && nums[i] == target) {
//                targetRange[0] = i;
//                targetRange[1] = i;
//            }
//
//        }
//        return targetRange;
//    }

//    public int[] searchRange(int[] nums, int target) {
//        int[] targetRange = {-1, - 1};
//        int leftIdx = extremeInsertionIndex(nums, target, true);
//        // assert that 'leftIdx' is within the array bounds and that 'target'
//        // is actually in 'nums'
//        if (leftIdx == nums.length || nums[leftIdx] != target) {
//            return targetRange;
//        }
//        targetRange[0] = leftIdx;
//        targetRange[1] = extremeInsertionIndex(nums, target, false) - 1;
//        return targetRange;
//    }
//
//    // return leftmost (or rightmost) index at which 'target' should be
//    // inserted in sorted array 'nums' via binary search
//    private int extremeInsertionIndex(int[] nums, int target, boolean left) {
//        int lo = 0;
//        int hi = nums.length;
//        while (lo < hi) {
//            int mid = lo + (hi - lo) / 2;
//            if (nums[mid] > target || (left && target == nums[mid])) {
//                hi = mid;
//            } else {
//                lo = mid + 1;
//            }
//        }
//        return lo;
//    }


    // wrong  answer
//    public int[] searchRange(int[] nums, int target) {
//        int[] res = new int[]{-1, -1};
//        int start = 0, end = nums.length;
//        while (start < end) {
//            int mid = start + (end - start) / 2;
//            if (nums[mid] == target) {
//                if (mid > 0 && nums[mid - 1] == target) {
//                    res[1] = mid;
//                    res[0] = mid - 1;
//                } else if ((mid + 1) < nums.length && nums[mid + 1] == target) {
//                    res[0] = mid;
//                    res[1] = mid + 1;
//                } else {
//                    res[0] = mid;
//                    res[1] = mid;
//                }
//                break;
//            } else if (nums[mid] < target) {
//                start = mid + 1;
//            } else {
//                end = mid;
//            }
//        }
//        return res;
//    }

    public int[] searchRange(int[] nums, int target) {
        int start = firstGreaterEqual(nums, target);
        if (start == nums.length || nums[start] != target) {
            return new int[]{-1,-1};
        }
        return new int[]{start, firstGreaterEqual(nums, target + 1)};
    }
    // find the first number that is greater than or equal to target.
    // could return nums.length if target is greater than nums[nums.length - 1]
    // actually this is the same as lower_bound in c++ stl.
    private static int firstGreaterEqual(int[] nums, int target) {
        int low = 0, high = nums.length;
        while (low < high) {
            int mid = low + ((high - low) >> 1);
            // low <= mid < high
            if (nums[mid] < target) {
                low = mid + 1;
            } else {
                // should not be mid - 1 when nums[mid] == target.
                // could be mid even if nums[mid] > target because mid < high.
                high = mid;
            }
        }
        return low;
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{5, 7, 7, 8, 8, 10};
//        int[] nums = new int[]{2};
        int[] nums = new int[]{3,3,3};
        ThreeFour threeFour = new ThreeFour();
        threeFour.searchRange(nums, 3);
//        int[] input = {1, 3};
//        ThreeFour.searchRange(input, 1);
    }
}
