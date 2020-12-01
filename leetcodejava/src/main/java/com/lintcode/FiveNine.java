package com.lintcode;

import java.util.Arrays;

/**
 * @author: John
 * @date: 2020-04-16 09:37
 * @description: 59
 **/
public class FiveNine {
    public int threeSumClosest(int[] numbers, int target) {
        if (numbers == null || numbers.length < 3) {
            return -1;
        }

        Arrays.sort(numbers);
        int bestSum = numbers[0] + numbers[1] + numbers[2];
        // for 最小那个数
        for (int i = 0; i < numbers.length - 2; i++) {
            int start = i + 1, end = numbers.length - 1;
            while (start < end) {
               int sum = numbers[i] + numbers[start] + numbers[end];
               if (Math.abs(target - sum) < Math.abs(target - bestSum)) {
                   bestSum = sum;
               }
                if (sum < target) {
                    start++;
                } else {
                    end--;
                }
            }
        }
        return bestSum;
    }
}
