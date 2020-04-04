package com.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: John
 * @date: 2020-02-23 12:05
 * @description: 15
 **/
public class OneFive {

//    public List<List<Integer>> threeSum(int[] num) {
//        Arrays.sort(num);
//        List<List<Integer>> res = new LinkedList<>();
//        for (int i = 0; i < num.length - 2; i++) {
//            if (i == 0 || (i > 0 && num[i] != num[i-1])) {
//                int lo = i + 1, hi = num.length - 1, sum = 0 - num[i];
//                while (lo < hi) {
//                    if (num[lo] + num[hi] == sum) {
//                       res.add(Arrays.asList(num[i], num[lo], num[hi]));
//                       while (lo < hi && num[lo] == num[lo + 1]) {
//                           lo++;
//                       }
//                       while (lo < hi && num[hi] == num[hi - 1]) {
//                           hi--;
//                       }
//                       lo++; hi--;
//                    } else if (num[lo] + num[hi] < sum) {
//                       lo++;
//                    } else {
//                        hi--;
//                    }
//                }
//            }
//        }
//        return res;
//    }

    public List<List<Integer>> threeSum(int[] num) {
        Arrays.sort(num);
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < num.length - 2; i++) {
            if (i == 0 || (i > 0 && num[i] != num[i-1])) {
                int lo = i+1, hi = num.length -1, sum = 0 -num[i];
                while (lo < hi) {
                    if (num[lo] + num[hi] == sum) {
                       res.add(Arrays.asList(num[i], num[lo], num[hi]));
                       while (lo < hi && num[lo] == num[lo+1]) {
                           lo++;
                       }
                       while (lo < hi && num[hi] == num[hi-1]) {
                           hi--;
                       }
                       lo++; hi--;
                    } else if (num[lo] + num[hi] < sum) {
                        while (lo < hi & num[lo] == num[lo + 1]) {
                            lo++;
                        }
                        lo++;
                    } else {
                        while (lo < hi && num[hi] == num[hi - 1]) {
                            hi--;
                        }
                        hi--;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] array = {-1, 0, 1, 2, -1, -4};
        OneFive oneFive = new OneFive();
        oneFive.threeSum(array);
    }
}
