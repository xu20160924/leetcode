package com.leetcode;

public class SixSeven {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;

        while (i >= 0 || j >= 0 || carry == 1) {
            if (i >= 0) {
                carry += a.charAt(i--) - '0';
            }
            if (j >= 0) {
                carry += b.charAt(j--) - '0';
            }

            sb.append(carry % 2);
            carry /= 2;
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        SixSeven sixSeven = new SixSeven();
        System.out.println(sixSeven.addBinary("100", "110010"));
    }
}
