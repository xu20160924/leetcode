package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: John
 * @date: 2020-03-16 08:25
 * @description: 78
 **/
public class SevenEight {
//    public List<List<Integer>> subsets(int[] nums) {
//        List<List<Integer>> list = new ArrayList<>();
//        Arrays.sort(nums);
//        backtrack(list, new ArrayList<>(), nums, 0);
//        return list;
//    }
//
//    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start) {
//        list.add(new ArrayList<>(tempList));
//        for (int i = start; i < nums.length; i++) {
//            tempList.add(nums[i]);
//            backtrack(list, tempList, nums, i + 1);
//            tempList.remove(tempList.size() - 1);
//        }
//    }

//    public List<List<Integer>> subsets(int[] nums) {
//        List<List<Integer>> output = new ArrayList<>();
//        output.add(new ArrayList<>());
//        for (int num : nums) {
//            List<List<Integer>> newSubsets = new ArrayList<>();
//            for (List<Integer> curr : output) {
//                newSubsets.add(new ArrayList<Integer>(curr) {{add(num);}});
//            }
//            for (List<Integer> curr : newSubsets) {
//                output.add(curr);
//            }
//        }
//        return output;
//    }

//    List<List<Integer>> output = new ArrayList<>();
//    int n, k;
//
//    public void backtrack(int first, ArrayList<Integer> curr, int[] nums) {
//        // if the combination is done
//        if (curr.size() == k) {
//            output.add(curr);
//        }
//        for (int i = first; i < n; ++i) {
//            // add i into the current combination
//            curr.add(nums[i]);
//            // use next integers to complete the combination
//            backtrack(i + 1, curr, nums);
//            // backtrack
//            curr.remove(curr.size() - 1);
//        }
//    }
//    public List<List<Integer>> subsets(int[] nums) {
//        n = nums.length;
//        for (k = 0; k < n + 1; ++k) {
//            backtrack(0, new ArrayList<>(), nums);
//        }
//        return output;
//    }

    /**
     * binary search solution
     *
     * @param nums
     * @return
     */
//    public List<List<Integer>> subsets(int[] nums) {
//        List<List<Integer>> output = new ArrayList<>();
//        int n = nums.length;
//        for (int i = (int)Math.pow(2, n); i < (int)Math.pow(2, n+1); ++i) {
//            System.out.println("2, n  " + (int)Math.pow(2, n));
//            System.out.println("2, n+1   " + (int)Math.pow(2, n+1));
//            // generate bitmask， from 0..00 to 1..11
//            String bitmask = Integer.toBinaryString(i).substring(1);
//            // append subset corresponding to that bitmask
//            List<Integer> curr = new ArrayList<>();
//            for (int j = 0; j < n; ++j) {
//               if (bitmask.charAt(j) == '1') {
//                   curr.add(nums[j]);
//               }
//            }
//            output.add(curr);
//        }
//        return output;
//    }


//    public List<List<Integer>> subsets(int[] nums) {
//        List<List<Integer>> results = new ArrayList<>();
//        if (nums == null || nums.length == 0) {
//            return results;
//        }
//    }
//
//    private void backtrack(int start, int[] nums, List<Integer> subset, List<List<Integer>> results) {
//        for (int i = start; i < nums.length; i++) {
//
//        }
//    }

//    public List<List<Integer>> subsets(int[] nums) {
//        List<List<Integer>> output = new ArrayList<>();
//        output.add(new ArrayList<>());
//
//        for (int num : nums) {
//           List<List<Integer>> newSubsets = new ArrayList<>();
//           for (List<Integer> curr : output) {
//               /**
//                * new ArrayList<Integer>(curr){{ add(num) }};</>
//                * equals List<Integer> list = new ArrayList<Integer>();
//                *   list.addAll(curr);
//                *   list.add(num);
//                */
//               newSubsets.add(new ArrayList<Integer>(curr){{ add(num); }});
//           }
//           for (List<Integer> curr : newSubsets) {
//               output.add(curr);
//           }
//        }
//        return output;
//    }


//    List<List<Integer>> output = new ArrayList<>();
//    int n, k;
//
//    public void backtrack(int first, ArrayList<Integer> curr, int[] nums) {
//        // if the Combination is done
//        if (curr.size() == k) {
//           output.add(new ArrayList<>(curr));
//        }
//
//        for (int i = first; i < n; i++) {
//            if (curr.size() == k ) {
//               return;
//            }
//            // add i into the current combination
//            curr.add(nums[i]);
//            // use next integers to complete the Combination
//            backtrack(i + 1, curr, nums);
//            // backtrack
//            curr.remove(curr.size() - 1);
//        }
//    }
//
//    public List<List<Integer>> subsets(int[] nums) {
//        n = nums.length;
//        for (k = 0; k < n + 1; ++k) {
//           backtrack(0, new ArrayList<>(), nums);
//        }
//        return output;
//    }
//    public List<List<Integer>> subsets(int[] nums) {
//        List<List<Integer>> output = new ArrayList<>();
//        int n = nums.length;
//        for (int i = (int) Math.pow(2, n); i < (int) Math.pow(2, n + 1); ++i) {
//            // generate bitmask, fromt 0..00 to 1.. 11
//            String bitmask = Integer.toBinaryString(i).substring(1);
//            // Append subset corresponding to that bitmask
//            List<Integer> curr = new ArrayList<>();
//            for (int j = 0; j < n; j++) {
//                if (bitmask.charAt(j) == '1') {
//                    curr.add(nums[j]);
//                }
//            }
//            output.add(curr);
//        }
//        return output;
//    }


//    public List<List<Integer>> subsets(int[] nums) {
//        List<List<Integer>> res = new ArrayList<>();
//        backtrack(0, nums, res, new ArrayList<>());
//        return res;
//    }
//
//    private void backtrack(int i, int[] nums, List<List<Integer>> res, ArrayList<Integer> tmp) {
//        res.add(new ArrayList<>(tmp));
//        for (int j = i; j < nums.length; j++) {
//            tmp.add(nums[j]);
//            backtrack(j + 1, nums, res, tmp);
//            tmp.remove(tmp.size() - 1);
//        }
//    }

//    public List<List<Integer>> binaryBit(int[] nums) {
//        List<List<Integer>> res = new ArrayList<>();
//        for (int i = 0; i < (1 << nums.length); i++) {
//            List<Integer> sub = new ArrayList<>();
//            for (int j = 0; j < nums.length; j++) {
//                if (((i >> j) & 1) == 1) {
//                    sub.add(nums[j]);
//                }
//            }
//            res.add(sub);
//        }
//        return res;
//    }


//    public List<List<Integer>> subsets(int[] nums) {
//        List<List<Integer>> res = new ArrayList<>();
//        backtrack(res, new ArrayList<>(), nums, 0);
//        return res;
//    }
//
//    private void backtrack(List<List<Integer>> res, List<Integer> temp, int[] nums, int start) {
//        res.add(new ArrayList<>(temp));
//        for (int i = start; i < nums.length; i++) {
//            temp.add(nums[i]);
//            backtrack(res, temp, nums, i + 1);
//            temp.remove(temp.size() - 1);
//        }
//    }

//    public List<List<Integer>> subsets(int[] nums) {
//        List<List<Integer>> output = new ArrayList<>();
//        output.add(new ArrayList<>());
//        for (int num : nums) {
//            List<List<Integer>> newSubsets = new ArrayList<>();
//            for (List<Integer> curr : output) {
//                newSubsets.add(new ArrayList<Integer>(curr) {{add(num);}});
//            }
//            for (List<Integer> curr : newSubsets) {
//                output.add(curr);
//            }
//        }
//        return output;
//    }


//    List<List<Integer>> res = new ArrayList<>();
//    int n, k;
//
//    public List<List<Integer>> subsets(int[] nums) {
//        n = nums.length;
//        for (k = 0; k < n + 1; ++k) {
//            backtrack(new ArrayList<>(), nums, 0);
//        }
//        return res;
//    }
//
//    private void backtrack(List<Integer> temp, int[] nums, int start) {
//        if (temp.size() == k) {
//            res.add(new ArrayList<>(temp));
//        }
//        for (int i = start; i < n; ++i) {
//            temp.add(nums[i]);
//            backtrack(temp, nums, i + 1);
//            temp.remove(temp.size() - 1);
//        }
//    }
//    public List<List<Integer>> subsets(int[] nums) {
//        List<List<Integer>> output = new ArrayList<>();
//        int n = nums.length;
//
//        for (int i = (int)Math.pow(2, n); i < (int)Math.pow(2, n + 1); ++i) {
////            System.out.println("sss:" + Integer.toBinaryString(i));
////            System.out.println("aaa:" + Integer.toBinaryString(i).substring(1));
//            String bitmask = Integer.toBinaryString(i).substring(1);
//            List<Integer> curr = new ArrayList<>();
//            for (int j = 0; j < n; j++) {
//                if (bitmask.charAt(j) == '1') {
//                    curr.add(nums[j]);
//                }
//                output.add(curr);
//            }
//        }
//        return output;
//    }


//    public List<List<Integer>> subsets(int[] nums) {
//        List<List<Integer>> output = new ArrayList<>();
//        output.add(new ArrayList<Integer>());
//
//        for (int num : nums) {
//            List<List<Integer>> newSubsets = new ArrayList<>();
//            for (List<Integer> curr : output) {
//                newSubsets.add(new ArrayList<Integer>(curr){{ add(num); }});
//            }
//            for (List<Integer> curr : newSubsets) {
//                output.add(curr);
//            }
//        }
//        return output;
//    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        int nthBit = 1 << n;
        for (int i = 0; i < (int)Math.pow(2, n); ++i) {
//        for (int i = (int)Math.pow(2, n); i < (int)Math.pow(2, n + 1); ++i) {
//            String bitmask =
//                    Integer.toBinaryString(i).substring(1);
            String bitmask =
                    Integer.toBinaryString(i | nthBit)
                            .substring(1);
            List<Integer> curr = new ArrayList<>();
            for (int j = 0; j < n; ++j) {
                if (bitmask.charAt(j) == '1') {
                    curr.add(nums[j]);
                }
            }
            ans.add(curr);
        }
        return ans;
    }

    public static void main(String[] args) {
        SevenEight sevenEight = new SevenEight();
        System.out.println(1 << 3);
//        List<List<Integer>> a = sevenEight.subsets(new int[]{1, 2, 3});
////        System.out.println(2 << 3);
//        for (List<Integer> list : a) {
//            for (Integer item : list) {
//                System.out.print(item);
//            }
//            System.out.println();
//        }
//        System.out.println(Integer.toBinaryString(1));
//        System.out.println("123".substring(1));
    }
}
