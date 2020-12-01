package com.leetcode;

/**
 * @author: John
 * @date: 2020-01-22 13:57
 * @description: 75  sort colors
 **/
public class SevenFive {

//    public void sortColors(int[] nums) {
//        // for all  idx < i : nums[idx < i] = 0
//        // j is current index
//        int p0 = 0, curr = 0;
//        // for all idex > k : nums[idx > k] = 2
//        int p2 = nums.length - 1;
//
//        int tmp;
//        while (curr <= p2) {
//            if (nums[curr] == 0) {
//                // swap p0 and curr item
//                //i++ j++
//                tmp = nums[p0];
//                nums[p0++] = nums[curr];
//                nums[curr++] = tmp;
//            } else if (nums[curr] == 2) {
//                //swap k and curr item
//                // p2--
//                tmp = nums[curr];
//                nums[curr] = nums[p2];
//                nums[p2--] = tmp;
//            } else {
//                curr++;
//            }
//        }
//    }

    /**
     * 用三个变量记录red,white,blue的下标位置。起始下标都为-1
     * <p>
     * 如果A[i] == 0 ，插入red对white blue有影响，blue先整体向后移动一位，white再整体向后移动一位，如果不移动，前面插入的数据就会覆盖已有的。
     * <p>
     * 如果A[i] == 1，插入white对blue有影响，blue整体向后移动一位。
     * <p>
     * A[i] == 2，直接插入blue
     */
//    public static int[] sortColors(int[] nums) {
//        int red = -1, white = -1, blue = -1;
//        for (int i = 0; i < nums.length; ++i) {
//            if (nums[i] == 0) {
//                nums[++blue] = 2;
//                nums[++white] = 1;
//                nums[++red] = 0;
//            } else if (nums[i] == 1){
//                nums[++blue] = 2;
//                nums[++white] = 1;
//            } else {
//                nums[++blue] = 2;
//            }
//        }
//        return nums;
//    }

    // I want to some trick operation but i failed
//    public static int[] sortColors(int[] nums) {
//        int n = nums.length;
//        int c = n / 3;
//        if (n < 3) {
//            Arrays.sort(nums);
//            return nums;
//        }
//        for (int i = 0; i < n; i++) {
////            if (nums[0] == 0) {
////                nums[0] = 0;
////                continue;
////            }
//            nums[i] = i / c;
//        }
//        return nums;
//    }

//    public void sortColors(int[] nums) {
//        if (nums == null || nums.length < 2) {
//            return;
//        }
//
//        int low = 0;
//        int high = nums.length - 1;
//        for (int i = low; i <= high;) {
//            if (nums[i] == 0) {
//                int tmp = nums[i];
//                nums[i] = nums[low];
//                nums[low] = tmp;
//                i++; low++;
//            } else if (nums[i] == 2) {
//                int tmp = nums[i];
//                nums[i] = nums[high];
//                nums[high] = tmp;
//                high--;
//            } else {
//                i++;
//            }
//        }
//    }


//    void sortColors(int nums[]) {
//        int num0 = 0, num1 = 0, num2 = 0;
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] == 0) {
//                ++num0;
//            } else if (nums[i] == 1) {
//                ++num1;
//            } else if (nums[i] == 2) {
//                ++num2;
//            }
//        }
//
//        for (int i = 0; i < num0; ++i) {
//            nums[i] = 0;
//        }
//        for (int i = 0; i < num1; ++i) {
//            nums[num0 + i] = 1;
//        }
//        for (int i = 0; i < num2; ++i) {
//            nums[num0 + num1 + i] = 2;
//        }
//    }

    // one pass in place solution
//    void sortColors(int nums[]) {
//        int n0 = -1, n1 = -1, n2 = -1;
//        for (int i = 0; i < nums.length; ++i) {
//            // 不断的将 0  1 向后推
//            if (nums[i] == 0) {
//                nums[++n2] = 2;
//                nums[++n1] = 1;
//                nums[++n0] = 0;
//            } else if (nums[i] == 1) {
//                nums[++n2] = 2;
//                nums[++n1] = 1;
//            } else if (nums[i] == 2) {
//                nums[++n2] = 2;
//            }
//        }
//    }

    void sortColors(int nums[]) {
        int j = 0, k = nums.length - 1;
        for (int i = 0; i <= k; ++i) {
            if (nums[i] == 0 && i != j) {
                swap(nums, i--, j++);
            } else if (nums[i] == 2 && i != k) {
                swap(nums, i--, k--);
            }
        }
    }

//    void sortColors(int nums[]) {
//       int j = 0, k = nums.length - 1;
//       for (int i = 0; i <= k; i++) {
//           if (nums[i] == 0) {
//               swap(nums, i, j++);
//           } else if (nums[i] == 2) {
//               swap(nums, i--, k--);
//           }
//       }
//    }


    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
//        int[] input = {2,0,2,1,1,0};
        int[] input = {1};
//        Arrays.stream(SevenFive.sortColors(input)).forEach(x -> System.out.println(x));
//        System.out.println(5 / 2);
        SevenFive sevenFive = new SevenFive();
        sevenFive.sortColors(new int[]{2, 0, 2, 1, 1, 0});
    }


}
