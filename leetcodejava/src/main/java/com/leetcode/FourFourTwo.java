package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: John
 * @date: 2020-11-15 07:57
 * @description: 442
 **/
public class FourFourTwo {

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0) {
                res.add(Math.abs(index + 1));
            } else {
                nums[index] = -nums[index];
            }
        }
        return res;
    }



//    public List<Integer> findDuplicates(int[] nums) {
//        List<Integer> res = new ArrayList<>();
//        for (int i = 0; i < nums.length; i++) {
//            int index = Math.abs(nums[i]);
//            if (nums[index] < 0) {
//                res.add(Math.abs(index));
//            } else {
//                nums[index] = -nums[index];
//            }
//        }
//        return res;
//    }


    public static void main(String[] args) {
//        List<Integer> list = new ArrayList<>();
        FourFourTwo fourFourTwo = new FourFourTwo();
        List<Integer> a  = fourFourTwo.findDuplicates(new int[]{4,3,2,7,8,2,3,1});
    }
}
