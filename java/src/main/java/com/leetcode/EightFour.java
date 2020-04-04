package com.leetcode;

import java.util.Stack;

/**
 * @author: John
 * @date: 2020-03-04 20:19
 * @description: 84
 **/
public class EightFour {
//    public int largestRectangleArea(int[] heights) {
//        int max = 0, width = 1, min = heights[0];
//        for (int i = 0; i < heights.length; i++) {
//
//            if (heights[i] < min) {
//                min = heights[i];
//            }
//            if (width * min <= heights[i]) {
//                width = 1;
//                min = heights[i];
//            }
//            max = Math.max(max, width * min);
//            width++;
//        }
//        return max;
//    }

    // brute
//    public int largestRectangleArea(int[] heights) {
//        int maxarea = 0;
//        for (int i = 0; i < heights.length; i++) {
//            for (int j = i; j < heights.length; j++) {
//                int minheight = Integer.MAX_VALUE;
//                for (int k = i; k <= k; k++) {
//                    minheight = Math.min(minheight, heights[k]);
//                }
//                maxarea = Math.max(maxarea, minheight * (j - i + 1));
//            }
//        }
//        return maxarea;
//    }

//    brute optimization
//    public int largestRectangleArea(int[] heights) {
//        int maxarea = 0;
//        for (int i = 0; i < heights.length; i++) {
//            int minheight = Integer.MAX_VALUE;
//            for (int j = i; j < heights.length; j++) {
//                minheight = Math.min(minheight, heights[j]);
//                maxarea = Math.max(maxarea, minheight * (j - i + 1));
//            }
//        }
//        return maxarea;
//    }

//    public int calculateArea(int[] heights, int start, int end) {
//        if (start > end) {
//            return 0;
//        }
//        int minindex = start;
//        for (int i = start; i <= end; i++) {
//            if (heights[minindex] > heights[i]) {
//                minindex = i;
//            }
//        }
//        return Math.max(heights[minindex] * (end - start + 1), Math.max(calculateArea(heights, start, minindex - 1), calculateArea(heights, minindex + 1, end)));
//    }
//    public int largestRectangleArea(int[] heights) {
//        return calculateArea(heights, 0, heights.length - 1);
//    }

//    public int largestRectangleArea(int[] heights) {
//        Stack<Integer> stack = new Stack<>();
//        stack.push(-1);
//        int maxarea = 0;
//        for (int i = 0; i < heights.length; i++) {
//            while (stack.peek() != -1 && heights[stack.peek()] >= heights[i]) {
//                maxarea = Math.max(maxarea, heights[stack.pop()] * (i - stack.peek() - 1));
//            }
//            stack.push(i);
//        }
//        while (stack.peek() != -1) {
//            maxarea = Math.max(maxarea, heights[stack.pop()] * (heights.length - stack.peek() - 1));
//        }
//        return maxarea;
//    }

    public int largestRectangleArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int[] lessFromLeft = new int[height.length]; // idx of the first bar the left that is lower than current
        int[] lessFromRight = new int[height.length]; // idx of the first bar the right that is lower than current
        lessFromRight[height.length - 1] = height.length;
        lessFromLeft[0] = -1;
        for (int i = 1; i < height.length; i++) {
            int p = i - 1;
            while (p >= 0 && height[p] >= height[i]) {
               p = lessFromLeft[p];
            }
            lessFromLeft[i] = p;
        }
        for (int i = height.length - 2; i >= 0; i--) {
            int p = i + 1;
            while (p < height.length && height[p] >= height[i]) {
               p = lessFromRight[p];
            }
            lessFromRight[i] = p;
        }
        int maxArea = 0;
        for (int i = 0; i < height.length; i++) {
            maxArea = Math.max(maxArea, height[i] * (lessFromRight[i] - lessFromLeft[i] - 1));
        }
        return maxArea;
    }



    public static void main(String[] args) {
//        int[] nums = {2,1,5,6,2,3};
//        int[] nums = {1,2,2};
//        int[] nums = {1,2,3,4,5};
//        int[] nums = {1,2,2};
//        int[] nums = {4,2};
        int[] nums = {2,1,5,6,2,3};
        EightFour eightFour = new EightFour();
        System.out.println(eightFour.largestRectangleArea(nums));
    }
}
