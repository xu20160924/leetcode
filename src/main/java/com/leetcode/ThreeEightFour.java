package com.leetcode;

import java.util.Random;

/**
 * @author: John
 * @date: 2020-03-25 16:37
 * @description: 384
 **/
public class ThreeEightFour {
    private int[] array;
    private int[] original;
    Random rand = new Random();

    private int randRange(int min, int max) {
        return rand.nextInt(max - min) + min;
    }
    private void swapAt(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public ThreeEightFour(int[] nums) {
       array = nums;
       original = nums.clone();
    }

    public int[] reset() {
        array = original;
        original = original.clone();
        return original;
    }

    public int[] shuffle() {
        for (int i = 0; i < array.length; i++) {
            swapAt(i, randRange(i, array.length));
        }
        return array;
    }

}
