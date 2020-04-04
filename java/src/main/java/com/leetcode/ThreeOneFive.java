package com.leetcode;

import java.util.Arrays;
import java.util.List;

/**
 * @author: John
 * @date: 2020-02-24 17:37
 * @description: 315
 **/
public class ThreeOneFive {
//    private int[] temp;
//    private int[] counter;
//    private int[] indexes;
//
//    public List<Integer> countSmaller(int[] nums) {
//        List<Integer> res = new ArrayList<>();
//        int len = nums.length;
//        if (len == 0) {
//            return res;
//        }
//        temp = new int[len];
//        counter = new int[len];
//        indexes = new int[len];
//        for (int i = 0; i < len; i++) {
//            indexes[i] = i;
//        }
//        mergeAndCountSmaller(nums, 0, len - 1);
//        for (int i = 0; i < len; i++) {
//            res.add(counter[i]);
//        }
//        return res;
//    }
//
//    private void mergeAndCountSmaller(int[] nums, int l, int r) {
//        if (l == r) {
//            return;
//        }
//        int mid = l + (r - l) / 2;
//        mergeAndCountSmaller(nums, l, mid);
//        mergeAndCountSmaller(nums, mid + 1, r);
//        if (nums[indexes[mid]] > nums[indexes[mid + 1]]) {
////            mergeAndCountSmaller(nums, l, mid, r);
//            mergeOfTwoSortedArrAndCountSmaller(nums, l, mid, r);
//        }
//    }
//
//    private void mergeOfTwoSortedArrAndCountSmaller(int[] nums, int l, int mid, int r) {
//        for (int i = l; i <= r; i++) {
//            temp[i] = indexes[i];
//        }
//        int i = l;
//        int j = mid + 1;
//        for (int k = l; k <= r; k++) {
//            if (i > mid) {
//                indexes[k] = temp[j];
//                j++;
//            } else if (j > r) {
//                indexes[k] = temp[i];
//                i++;
//                counter[indexes[k]] += (r - mid);
//            } else if (nums[temp[i]] <= nums[temp[j]]) {
//                indexes[k] = temp[i];
//                i++;
//                counter[indexes[k]] += (j - mid - 1);
//            } else {
//                indexes[k] = temp[j];
//                j++;
//            }
//        }
//    }
//
//    public static void main(String[] args) {
//        int[] nums = {5, 2, 6, 1};
//        ThreeOneFive threeOneFive = new ThreeOneFive();
//        List<Integer> countSmaller = threeOneFive.countSmaller(nums);
//
//    }


//    class Pair {
//        int index;
//        int val;
//        public Pair(int index, int val) {
//            this.index = index;
//            this.val = val;
//        }
//    }
//
//    public List<Integer> countSmaller(int[] nums) {
//        List<Integer> res = new ArrayList<>();
//        if (nums == null || nums.length == 0) {
//            return res;
//        }
//        Pair[] arr = new Pair[nums.length];
//        Integer[] smaller = new Integer[nums.length];
//        Arrays.fill(smaller, 0);
//        for (int i = 0; i < nums.length; i++) {
//            arr[i] = new Pair(i, nums[i]);
//        }
//        mergeSort(arr, smaller);
//        res.addAll(Arrays.asList(smaller));
//        return res;
//    }
//
//    private Pair[] mergeSort(Pair[] arr, Integer[] smaller) {
//        if (arr.length <= 1) {
//            return arr;
//        }
//        int mid = arr.length / 2;
//        Pair[] left = mergeSort(Arrays.copyOfRange(arr, 0, mid), smaller);
//        Pair[] right = mergeSort(Arrays.copyOfRange(arr, mid, smaller.length), smaller);
//        for (int i = 0, j = 0; i < left.length || j < right.length;) {
//            if (j == right.length || i < left.length && left[i].val <= right[j].val) {
//               arr[i + j] = left[i];
//               smaller[left[i].index] += j;
//               i++;
//            } else {
//                arr[i + j] = right[j];
//                j++;
//            }
//        }
//        return arr;
//    }

    class Node {
        Node left, right;
        int val, sum, dup = 1;

        public Node(int v, int s) {
            val = v;
            sum = s;
        }
    }

    public List<Integer> countSmaller(int[] nums) {
        Integer[] ans = new Integer[nums.length];
        Node root = null;
        for (int i = nums.length - 1; i >= 0; i--) {
            root = insert(nums[i], root, ans, i, 0);
        }
        return Arrays.asList(ans);
    }

    private Node insert(int num, Node node, Integer[] ans, int i, int preSum) {
        if (node == null) {
            node = new Node(num, 0);
            ans[i] = preSum;
        } else if (node.val == num) {
            node.dup++;
            ans[i] = preSum + node.sum;
        } else if (node.val > num) {
            node.sum++;
            node.left = insert(num, node.left, ans, i, preSum);
        } else {
            node.right = insert(num, node.right, ans, i, preSum + node.dup + node.sum);
        }
        return node;
    }

    public static void main(String[] args) {
        ThreeOneFive threeOneFive = new ThreeOneFive();
        threeOneFive.countSmaller(new int[]{5, 2, 6, 1});
    }
}
