package com.interview;

public class PrimeNumber {

    private static boolean isPrime(int n) {
        boolean flag = true;
        if (n == 1) {
            flag = false;
        } else {
            for (int i = 2; i <= Math.sqrt(n); i++) {
                if ((n % i) == 0 || n == 1) {
                    flag = false;
                    break;
                }
            }
        }
        return flag;
    }

    public static void main(String[] args) {
//        int m = 1;
//        int n = 1000;
//        int count = 0;
//        for (int i = m; i < n; i++) {
//            if (isPrime(i)) {
//                count++;
//            }
//        }
        System.out.println(Math.sqrt(12));
    }
}
