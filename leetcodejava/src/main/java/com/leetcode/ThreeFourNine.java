package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: John
 * @date: 2020-04-11 10:11
 * @description: 349
 **/
public class ThreeFourNine {
    /**
     * Two Sets
     */
//    public int[] set_intersection(HashSet<Integer> set1, HashSet<Integer> set2) {
//        int[] output = new int[set1.size()];
//        int idx = 0;
//        for (Integer s : set1) {
//            if (set2.contains(s)) {
//                output[idx++] = s;
//            }
//        }
//        return Arrays.copyOf(output, idx);
//    }
//
//    public int[] intersection(int[] nums1, int[] nums2) {
//        HashSet<Integer> set1 = new HashSet<>();
//        for (Integer n : nums1) {
//            set1.add(n);
//        }
//        HashSet<Integer> set2 = new HashSet<>();
//        for (Integer n : nums2) {
//            set2.add(n);
//        }
//        if (set1.size() < set2.size()) {
//            return set_intersection(set1, set2);
//        } else {
//            return set_intersection(set2, set1);
//        }
//    }

//    public int[] intersection(int[] nums1, int[] nums2) {
//        HashSet<Integer> set1 = new HashSet<>();
//        for (Integer n : nums1) {
//            set1.add(n);
//        }
//        HashSet<Integer> set2 = new HashSet<>();
//        for (Integer n :nums2) {
//            set2.add(n);
//        }
//
//        set1.retainAll(set2);
//
//        int[] output = new int[set1.size()];
//        int idx = 0;
//        for (int s : set1) {
//            output[idx++] = s;
//        }
//
//        return output;
//    }

    /**
     * sort both arrays use two pointers
     * @return
     */
//    public int[] intersection(int[] nums1, int[] nums2) {
//        Set<Integer> set = new HashSet<>();
//        Arrays.sort(nums1);
//        Arrays.sort(nums2);
//        int i = 0;
//        int j = 0;
//        while (i < nums1.length && j < nums2.length) {
//            if (nums1[i] < nums2[j]) {
//               i++;
//            } else if (nums1[i] > nums2[j]) {
//               j++;
//            } else {
//                set.add(nums1[i]);
//                i++;
//                j++;
//            }
//        }
//        int[] result = new int[set.size()];
//        int k = 0;
//        for (Integer num : set) {
//           result[k++] = num;
//        }
//        return result;
//    }

    /**
     * binary search solution
     *
     * @param nums1
     * @param nums2
     * @return
     */
//    public int[] intersection(int[] nums1, int[] nums2) {
//        Set<Integer> set = new HashSet<>();
//        // 先排序其中一个数组， 然后再迭代另一个数组中的每一个数去已排序的数组中进行二分
//        Arrays.sort(nums2);
//        for (Integer num : nums1) {
//            if (binarySearch(nums2, num)) {
//                set.add(num);
//            }
//        }
//        int i = 0;
//        int[] result = new int[set.size()];
//        for (Integer num : set) {
//           result[i++] = num;
//        }
//        return result;
//    }
//
//    public boolean binarySearch(int[] nums, int target) {
//        int low = 0;
//        int high = nums.length - 1;
//        while (low <= high) {
//           int mid = low + (high - low) / 2;
//           if (nums[mid] == target) {
//               return true;
//           }
//           if (nums[mid] > target) {
//               high = mid - 1;
//           } else {
//               low = mid + 1;
//           }
//        }
//        return false;
//    }


//    public int[] intersection(int[] nums1, int[] nums2) {
//        int[] result = new int[nums1.length + nums2.length];
////        List<Integer> result = new ArrayList<Integer>();
//        Arrays.sort(nums1);
//        Arrays.sort(nums2);
//        int i = 0;
//        int j = 0;
//        int index = 0;
//        while (i < nums1.length && j < nums2.length) {
//            if (nums1[i] < nums2[j]) {
//               i++;
//            } else if (nums1[i] > nums2[j]) {
//               j++;
//            } else {
//                if (index == 0 || nums1[i] != result[index - 1]) {
//                    result[index++] = nums1[i];
////                    resultd(nums1[i]);
//                }
//                i++;
//                j++;
//            }
//        }
        // 最后通过Arrays.copyOf 进行截取
//        return Arrays.copyOf(result, index);
//    }


    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0;
        int j = 0;
        int index = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                if (i > j) {
                    if (index == 0 || nums2[j] != nums1[index - 1]) {
                        nums1[index++] = nums1[i];
                    }
                } else {
                    if (index == 0 || nums1[i] != nums2[index - 1]) {
                        nums2[index++] = nums2[j];
                    }
                }
                i++;
                j++;
            }
        }
        if (i > j) {
            return Arrays.copyOf(nums1, index);
        }
        return Arrays.copyOf(nums2, index);
    }


//    public List intersections(int[] l1, int[] l2) {
//        Arrays.sort(l1);
//        Arrays.sort(l2);
//        List<Integer> result = new ArrayList<>();
//
//        int l = 0;
//        int r = 0;
//        while (r < l1.length && l < l2.length) {
//            int left = l1[r], right = l2[l];
//            if (left == right) {
//                result.add(left);
//                while (left == l1[r]) {
//                    r++;
//                }
//                while (right == l2[l]) {
//                    l++;
//                }
//            }
//            if (right > left) {
//                while (left == l1[r]) {
//                   r++;
//                }
//            } else {
//                while (right == l2[l]) {
//                    l++;
//                }
//            }
//        }
//        return result;
//    }
//    public int[] intersection(int[] A, int[] B) {
//        A.
//    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        ThreeFourNine threeFourNine = new ThreeFourNine();
        int[] result = threeFourNine.intersection(nums1, nums2);
        System.out.println("");
    }
}
