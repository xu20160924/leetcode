package com.lintcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: John
 * @date: 2020-04-22 14:20
 * @description: 124
 **/
public class OneTwoFour {


    private boolean arrayContains(int[] arr, int num) {
       for (int i = 0; i < arr.length; i++) {
           if (arr[i] == num) {
              return true;
           }
       }
       return false;
    }

    public int longestConsecutive(int[] nums) {
       int longestStreak = 0;
       for (int num : nums) {
          int currentNum = num;
          int currentStreak = 1;

          while (arrayContains(nums, currentNum + 1)) {
              currentNum += 1;
              currentStreak += 1;
          }
          longestStreak = Math.max(longestStreak, currentStreak);
       }
       return longestStreak;
    }

    /**
     * hashset
     * @param args
     */
//    public int longestConsecutive(int[] num) {
//        HashSet<Integer> set = new HashSet<>();
//        for (int i = 0; i < num.length; i++) {
//            set.add(num[i]);
//        }
//
//        int longest = 0;
//        for (int i = 0; i < num.length; i++) {
//            int down = num[i] - 1;
//            while (set.contains(down)) {
//                set.remove(down);
//                down--;
//            }
//
//            int up = num[i] + 1;
//            while (set.contains(up)) {
//                set.remove(up);
//                up++;
//            }
//            // 这里由于是向两边扩张 只要中间不断就能连上， 所以不用考虑起点是哪个
//            longest = Math.max(longest, up - down - 1);
//        }
//        return longest;
//    }

//    public int longestConsecutive(int[] num) {
//        Set<Integer> set = new HashSet<>();
//        for (int item : num) {
//            set.add(item);
//        }
//
//        int ans = 0;
//        for (int item : num) {
//            if (set.contains(item)) {
//                set.remove(item);
//
//                int l = item - 1;
//                int r = item + 1;
//                while (set.contains(l)) {
//                    set.remove(l);
//                    l--;
//                }
//                while (set.contains(r)) {
//                    set.remove(r);
//                    r++;
//                }
//                ans = Math.max(ans, r - l - 1);
//            }
//        }
//        return ans;
//    }

    public static void main(String[] args) {
        OneTwoFour oneTwoFour = new OneTwoFour();
//        oneTwoFour.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2});
        oneTwoFour.longestConsecutive(new int[]{1,5,6,2,3,4});
    }
}
