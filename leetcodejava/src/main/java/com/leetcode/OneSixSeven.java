package com.leetcode;

/**
 * @author: John
 * @date: 2020-04-14 17:52
 * @description: 167
 **/
public class OneSixSeven {
    public int[] twoSum(int[] numbers, int target) {

        int[] res = new int[2];
        int i = 0, j = numbers.length - 1;
        while (i < j) {
            if ((numbers[i] + numbers[j]) > target) {
                j--;
            } else if ((numbers[i] + numbers[j]) < target) {
                i++;
            } else {
                res[0] = i + 1;
                res[1] = j + 1;
                return res;
            }
        }
        return res;
    }
}
