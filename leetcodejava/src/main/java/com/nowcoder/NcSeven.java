package com.nowcoder;

/**
 * @author: John
 * @date: 2020-11-23 20:59
 * @description: Nc7
 **/
public class NcSeven {
    public int maxProfit (int[] prices) {
        // write code here
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int max = 0;
        int min = prices[0];
        for (int i = 0; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            max = Math.max(max, prices[i] - min);
        }
        return max;
    }
}
