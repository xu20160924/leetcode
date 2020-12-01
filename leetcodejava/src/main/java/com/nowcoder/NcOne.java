package com.nowcoder;

/**
 * @author: John
 * @date: 2020-11-01 20:23
 * @description: NC1
 **/
public class NcOne {
//    public String solve (String s, String t) {
//        // write code here
//        if (s == null || s.equals("")) {
//            return t;
//        }
//        if (t == null || t.equals("")) {
//            return s;
//        }
//
//        int num = Math.max(s.length(), t.length());
//        int carry = 0;
//        for (int i = 0; i < num; i++) {
//            char sc = i > s.length() ? '0' : s.charAt(i);
//            char st = i > t.length() ? '0' : t.charAt(i);
//
//        }
//    }

    public String solve(String s, String t) {
        StringBuilder ans = new StringBuilder();
        int tmp = 0;
        int ls = s.length() - 1, lt = t.length() - 1;
        while (ls >= 0 || lt >= 0 || tmp == 1) {
            int l = ls >= 0 ? (s.charAt(ls--) - '0') : 0;
            int r = lt >= 0 ? (t.charAt(lt--) - '0') : 0;
            int plus = l + r + tmp;
            tmp = plus / 10;
            char a = (char)(plus % 10 + '0');
            ans.append(a);
        }
        return ans.reverse().toString();
    }

    public static void main(String[] args) {
        NcOne ncOne = new NcOne();
        ncOne.solve("1", "99");
    }
}
