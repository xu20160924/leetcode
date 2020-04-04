package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: John
 * @date: 2020-03-08 21:46
 * @description: 169
 **/
public class OneSixNine {
    private Map<Integer, Integer> countNums(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int num : nums) {
            if (!counts.containsKey(num)) {
                counts.put(num, 1);
            } else {
                counts.put(num, counts.get(num) + 1);
            }
        }
        return counts;
    }

    public int majorityElement(int[] nums) {
        Map<Integer, Integer> counts = countNums(nums);

        Map.Entry<Integer, Integer> majorityEntry = null;
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            if (majorityEntry == null || entry.getValue() > majorityEntry.getValue()) {
                majorityEntry = entry;
            }
        }
        return majorityEntry.getKey();
    }

    public static void main(String[] args) {
        int[] nums = {3,2,3};
        OneSixNine oneSixNine = new OneSixNine();
        oneSixNine.majorityElement(nums);
    }
}
