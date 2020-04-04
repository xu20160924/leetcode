package com.leetcode;

/**
 * @author: John
 * @date: 2020-02-20 17:45
 * @description: 96
 **/
public class NineSix {
    public int numTrees(int n) {
        int[] G = new int[n+1];
        G[0] = G[1] = 1;
        for (int i = 2; i <= n; ++i) {
           for (int j = 1; j <= i; ++j) {
              G[i] += G[j-1] * G[i-j];
           }
        }
        return G[n];
    }

    public static void main(String[] args) {
        NineSix nineSix = new NineSix();
        System.out.println(nineSix.numTrees(4));
    }
}
