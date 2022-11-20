package com.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author: John
 * @date: 2020-03-25 16:37
 * @description: 384
 **/
public class ThreeEightFour {
//    private int[] array;
//    private int[] original;
//    Random rand = new Random();
//
//    private int randRange(int min, int max) {
//        return rand.nextInt(max - min) + min;
//    }
//    private void swapAt(int i, int j) {
//        int temp = array[i];
//        array[i] = array[j];
//        array[j] = temp;
//    }
//
//    public ThreeEightFour(int[] nums) {
//       array = nums;
//       original = nums.clone();
//    }
//
//    public int[] reset() {
//        array = original;
//        original = original.clone();
//        return original;
//    }
//
//    public int[] shuffle() {
//        for (int i = 0; i < array.length; i++) {
//            swapAt(i, randRange(i, array.length));
//        }
//        return array;
//    }

    private int[] array;
    private int[] original;

    private Random rand = new Random();

    private List<Integer> getArrayCopy() {
        List<Integer> asList = new ArrayList<Integer>();
        for (int i = 0; i < array.length; i++) {
            asList.add(array[i]);
        }
        return asList;
    }

    public ThreeEightFour(int[] nums) {
        array = nums;
        original = nums.clone();
    }

    public int[] reset() {
        array = original;
        original = original.clone();
        return array;
    }

    public int[] shuffle() {
        List<Integer> aux = getArrayCopy();

        for (int i = 0; i < array.length; i++) {
            int removeIdx = rand.nextInt(aux.size());
            array[i] = aux.get(removeIdx);
            aux.remove(removeIdx);
        }

        return array;
    }

}
