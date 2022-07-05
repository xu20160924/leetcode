package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Denial.AO
 * @date: 2020-12-03 17:49
 * @description: 842
 **/
public class EightFourTwo {
//    public List<Integer> splitIntoFibonacci(String S) {
//        List<Integer> list = new ArrayList<>();
//        backtrack(list, S, 0);
//        return list;
//    }
//
//    private boolean backtrack(List<Integer> list, String s, int pos) {
//        if (pos == s.length() && list.size() >= 3) {
//            return true;
//        }
//        for (int i = pos; i < s.length(); i++) {
//            if (s.charAt(pos) == '0' && i > pos) {
//                break;
//            }
//            long num = Long.parseLong(s.substring(pos, i + 1));
//            if (num > Integer.MAX_VALUE) {
//                break;
//            }
//            int size = list.size();
//            if (size >= 2 && num > list.get(size - 1) + list.get(size - 2)) {
//                break;
//            }
//            if (size <= 1 || num == list.get(size - 1) + list.get(size - 2)) {
//                list.add((int) num);
//                if (backtrack(list, s, i + 1)) {
//                    return true;
//                }
//                list.remove(list.size() - 1);
//            }
//        }
//        return false;
//    }








//    public List<Integer> splitIntoFibonacci(String S) {
//        List<Integer> ans = new ArrayList<>();
//        helper(S, ans, 0);
//        return ans;
//    }
//
//    public boolean helper(String s, List<Integer> ans, int idx) {
//        if (idx == s.length() && ans.size() >= 3) {
//            return true;
//        }
//        for (int i=idx; i<s.length(); i++) {
//            if (s.charAt(idx) == '0' && i > idx) {
//                break;
//            }
//            long num = Long.parseLong(s.substring(idx, i+1));
//            if (num > Integer.MAX_VALUE) {
//                break;
//            }
//            int size = ans.size();
//            // early termination
//            if (size >= 2 && num > ans.get(size-1)+ans.get(size-2)) {
//                break;
//            }
//            if (size <= 1 || num == ans.get(size-1)+ans.get(size-2)) {
//                ans.add((int)num);
//                // branch pruning. if one branch has found fib seq, return true to upper call
//                if (helper(s, ans, i+1)) {
//                    return true;
//                }
//                ans.remove(ans.size()-1);
//            }
//        }
//        return false;
//    }
//



//    public static void main(String[] args) {
//        EightFourTwo eightFourTwo = new EightFourTwo();
//        List<Integer> a = eightFourTwo.splitIntoFibonacci("0123");
//
//    }
}
