package com.leetcode;

/**
 * @author: John
 * @date: 2020-05-04 08:34
 * @description: 509
 **/
public class FiveZeroNine {

//    private Integer[] cache = new Integer[31];
//
//    public int fib(int N) {
//        if (N <= 1) {
//            return N;
//        }
//        cache[0] = 0;
//        cache[1] = 1;
//        return memozie(N);
//    }
//
//    private int memozie(int N) {
//        if (cache[N] != null) {
//            return cache[N];
//        }
//
//        cache[N] = memozie(N - 1) + memozie(N - 2);
//        return memozie(N);
//    }


    public int fib(int N) {
        if (N <= 1) {
            return N;
        }

        int first = 0;
        int second = 1;
        for (int i = 2; i <= N; i++) {
            if ((i & 1) == 1) {
                second = first + second;
            } else {
                first = first + second;
            }
        }
        return Math.max(first, second);
    }


    public static void main(String[] args) {
        FiveZeroNine fiveZeroNine = new FiveZeroNine();
        System.out.println(fiveZeroNine.fib(4));
    }

    /**
     * bottom-up Approach using Memoization
     * @param N
     * @return
     */
//    public int fib(int N) {
//        if (N <= 1) {
//            return N;
//        }
//        return memoize(N);
//    }
//
//    public int memoize(int N) {
//        int[] cache = new int[N + 1];
//        cache[1] = 1;
//
//        for (int i = 2; i <= N; i++) {
//            cache[i] = cache[i - 1] + cache[i - 2];
//        }
//        return cache[N];
//    }

    /**
     * recursion
     *
     * @param N
     * @return
     */
//    public int fib(int N) {
////       if (N == 1) {
////           return 1;
////       }
//        if (N <= 1) {
//            return N;
//        }
//        return fib(N - 1) + fib(N - 2);
//    }


}
