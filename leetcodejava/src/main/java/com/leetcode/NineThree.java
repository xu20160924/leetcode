package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: John
 * @date: 2020-11-20 18:09
 * @description: 93
 **/
public class NineThree {
//    public List<String> restoreIpAddresses(String s) {
//        List<String> res = new ArrayList<>();
//        backtrack(res, s, new StringBuilder(), new String[4], 0);
//        return res;
//    }

//    private void backtrack(List<String> res, String s, StringBuilder cur, String[] ip, int start) {
////        if (cur.length() - 4 == s.length()) {
////            res.add(ip);
////            return;
////        }
//        if () {
//
//        }
//
//        for (int i = start; i < s.length(); i++) {
//            if (!cur.toString().equals("") && Integer.valueOf(cur.toString()) > 255) {
//                continue;
//            }
//
//            if (!cur.toString().equals("") && cur.length() == Math.ceil((s.length() % 4.00))) {
//               ip[i / (int)Math.ceil((s.length() % 4.00))] = s;
//            }
//            cur.append(s.charAt(i));
//            backtrack(res, s, cur,  ip, i + 1);
//            cur.deleteCharAt(cur.length() - 1);
//        }
//    }

//    public static void main(String[] args) {
//        NineThree nineThree = new NineThree();
//        List<String> a = nineThree.restoreIpAddresses("25525511135");
////        System.out.println(Math.ceil(11 / 4.00));
//    }

//    public List<String> restoreIpAddress(String s) {
//        List<String> res = new ArrayList<>();
//        int len = s.length();
//        for (int i = 1; i < 4 && i < len - 2; i++) {
//            for (int j = i + 1; j < i + 4 && j < len - 1; j++) {
//                for (int k = j + 1; k < j + 4 && k < len; k++) {
//                    String s1 = s.substring(0, i),
//                            s2 = s.substring(i, j),
//                            s3 = s.substring(j, k),
//                            s4 = s.substring(k, len);
//                    if (isValid(s1) && isValid(s2) && isValid(s3) && isValid(s4)) {
//                        res.add(s1+"."+s2+"."+s3+"."+s4);
//                    }
//                }
//            }
//        }
//        return res;
//    }
//
//    private boolean isValid(String s) {
//        if (s.length() > 3 || s.length() == 0 ||
//                (s.charAt(0) == '0' && s.length() > 1) || Integer.parseInt(s) > 255) {
//            return false;
//        }
//        return true;
//    }

    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        doRestore(result, "", s, 0);
        return result;
    }

    private void doRestore(List<String> result, String path, String s, int k) {
        if (s.isEmpty() || k == 4) {
            if (s.isEmpty() && k == 4) {
                result.add(path.substring(1));
            }
            return;
        }
        for (int i = 1; i <= (s.charAt(0) == '0' ? 1 : 3) && i <= s.length(); i++) {

            String part = s.substring(0, i);
            System.out.println("path:" + path);
            System.out.println("part:" + part);
            if (Integer.valueOf(part) <= 255) {
                doRestore(result, path + "." + part, s.substring(i), k + 1);
            }
        }
    }

    public static void main(String[] args) {
        NineThree nineThree = new NineThree();
        nineThree.restoreIpAddresses("25525511135");
    }
}
