package com.leetcode.jianzhioffer;

/**
 * @author: John
 * @date: 2020-05-18 09:35
 * @description: 14
 **/
public class OneFour {

    /**
     * 14:2  割绳子扩展
     * @param n
     * @return
     */
    public int cuttingRope(int n) {
       if (n <= 3) {
           return n - 1;
       }
       int b = n % 3, p = 1000000007;
       long rem = 1, x = 3;
       for (int a = n / 3 - 1; a > 0; a /= 2) {
           if (a % 2 == 1) {
               rem = (rem * x) % p;
           }
           x = (x * x) % p;
       }
       if (b == 0) {
           return (int) (rem * 3 % p);
       }
       if (b == 1) {
           return (int) (rem * 4 % p);
       }
       return (int) (rem * 6 % p);
    }


    /**
     * 贪心算法
     * @param n
     * @return
     */
    int maxProductAfterCutting_solution2(int n) {
        if (n < 2) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 3;
        }

        // 尽可能多地剪去长度为3的绳子段
        int timesOf3 = n / 3;
        // 当绳子最后剩下的长度为4的时候，不能再剪去长度为3的绳子段
        // 此时更好的方法是把绳子剪成长度为2的两段 因为 2 * 2 > 3 * 1
        if (n - timesOf3 * 3 == 1) {
            timesOf3 -= 1;
        }
        int timesOf2 = (n - timesOf3 * 3) / 2;
        return (int)(Math.pow(3, timesOf3)) * (int)(Math.pow(2, timesOf2));
    }

    /**
     * dp
     *
     * @param n
     * @return
     */
//    public int cuttingRope(int n) {
//       if (n <= 3) {
//           return n - 1;
//       }
//       int a = n / 3, b = n % 3;
//       if (b == 0) {
//           return (int) Math.pow(3, a);
//       }
//       if (b == 1) {
//           return (int) (Math.pow(3, a - 1) * 4);
//       }
//       return (int) (Math.pow(3, a) * 2);
//    }
    public static void main(String[] args) {
        System.out.println(Math.pow(3, 3));
    }
}
