package com.leetcode;

public class Six {
    public String convert(String s, int numRows) {
        if(numRows == 1 || numRows >= s.length()) return s;
        StringBuilder sb = new StringBuilder();
        int t = 2 * numRows - 2;
        for(int i = 0;i < numRows;i ++){
            int pos = i;
            while(pos < s.length()){
                sb.append(s.charAt(pos));
                if(i != 0 && i != numRows - 1 && (pos + t - 2 * i) < s.length()){
                        sb.append(s.charAt(pos + t - 2*i));
                }
                pos += t;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Six six = new Six();
        six.convert("PAYPALISHIRING", 4);
        // PINALSIGYAHRPI
    }
}
