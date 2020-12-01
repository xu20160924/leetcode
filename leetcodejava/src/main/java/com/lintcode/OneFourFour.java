package com.lintcode;

/**
 * @author: John
 * @date: 2020-04-16 20:42
 * @description: 144
 **/
public class OneFourFour {

    public int[] rerange(int[] A) {
       if (A == null || A.length < 3) {
           return A;
       }
       int n = A.length;
        // count the number of positive numbers
       int countPositive = 0;

       // store the positive numbers index.
        int positiveIndex = 0;
        int pos = 1;
        int neg = 0;
        for (int i = 0; i < n; i++) {
            if (A[i] > 0) {
               // Put all the positive numbers at in the left part.
               swap(A, positiveIndex++, i);
               countPositive++;
            }
        }

        if (countPositive > n / 2) {
            // if positive numbers are more than negative numbers.
            // put the positive numbers at first.
            pos = 0;
            neg = 1;
            // reverse the array.
            int left = 0;
            int right = n - 1;
            while (left < right) {
               swap(A, left,right);
               left++;
               right--;
            }
        }

        while (pos < n && neg < n) {
            while (pos < n && A[pos] > 0) {
               pos += 2;
            }
            while (neg < n && A[neg] < 0) {
               neg += 2;
            }
            if (neg >= n || pos >= n) {
               break;
            }
            swap(A, pos, neg);
        }
        return A;
    }

    private void swap(int[] A, int l, int r) {
        int temp = A[l];
        A[l] = A[r];
        A[r] = temp;
    }

    public static void main(String[] args) {
        OneFourFour oneFourFour = new OneFourFour();
//        oneFourFour.rerange(new int[]{-1, - 2, -3, 4, 5, 6});
        oneFourFour.rerange(new int[]{28,2,-22,-27,2,9,-33,-4,-18,26,25,34,-35,-17,2,-2,32,35,-8});
    }
}
