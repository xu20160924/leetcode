package com.leetcode;

/**
 * @author: John
 * @date: 2020-02-24 16:19
 * @description: 204
 **/
public class TwoZeroFour {
    public int countPrimes(int n) {
        boolean[] notPrime = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (notPrime[i] == false) {
                count++;
            }
            for (int j = 2; i * j < n; j++) {
                notPrime[i*j] = true;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        TwoZeroFour twoZeroFour = new TwoZeroFour();
        twoZeroFour.countPrimes(10);
    }
}
