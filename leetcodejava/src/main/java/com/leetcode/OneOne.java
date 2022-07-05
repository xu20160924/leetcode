package com.leetcode;

/**
 * @author: John
 * @date: 2020-11-16 11:02
 * @description: 11
 **/
public class OneOne {
    /**
     * brute force
     *
     * @param args
     */
//    public int maxArea(int[] height) {
//        int maxarea = 0;
//        for (int i = 0; i < height.length; i++) {
//            for (int j = i + 1; j < height.length;  ) {
//                maxarea = Math.max(maxarea, Math.min(height[i], height[j]) * (j - i));
//            }
//        }
//        return maxarea;
//    }
    public int maxArea(int[] height) {
        int maxarea = 0, l = 0, r = height.length - 1;
        while (l < r) {
            maxarea = Math.max(maxarea, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }

        return maxarea;
    }


    public static void main(String[] args) {
//        int[] a =  new int[]{2,3,4,1,5,56};
//        Arrays.sort(a);
//        System.out.println(a);
    }
}
