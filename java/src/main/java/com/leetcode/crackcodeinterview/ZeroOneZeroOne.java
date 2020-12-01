package com.leetcode.crackcodeinterview;

/**
 * @author: John
 * @date: 2020-09-14 15:30
 * @description: 0101
 **/
public class ZeroOneZeroOne {
//    public boolean isUnique(String astr) {
//        for (int i = 0; i < astr.length(); i++) {
//            if (astr.lastIndexOf(astr.charAt(i)) != i) {
//                return false;
//            }
//        }
//        return true;
//    }

    public boolean isUnique(String astr) {
       long mark = 0;
       for (int i = 0; i < astr.length(); i++) {
           int num = 1 << (astr.charAt(i) - 'a');
           if ((mark & num) != 0) {
               return false;
           } else {
               mark |= num;
           }
       }
       return true;
    }


}
