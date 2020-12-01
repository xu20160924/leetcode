package com.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author: John
 * @date: 2020-03-02 11:47
 * @description: 22
 **/
public class TwoTwo {
//    public List<String> generateParenthesis(int n) {
//        List<String> ans = new ArrayList<>();
//        backtrack(ans, "", 0, 0, n);
//        return ans;
//    }
//
//    public void backtrack(List<String> ans, String cur, int open, int close, int max) {
//        if (cur.length() == max * 2) {
//            ans.add(cur);
//            return;
//        }
//        if (open < max) {
//            backtrack(ans, cur+"(", open + 1, close, max);
//        }
//         if (close < open) {
    //            backtrack(ans, cur+")", open, close + 1, max);

//         }
//
//    }

//    public List<String> generateParenthesis(int n) {
//        List<String> ans = new ArrayList();
//        if (n == 0) {
//            ans.add("");
//        } else {
//            for (int c = 0; c < n; ++c) {
//                for (String left : generateParenthesis(c)) {
//                    for (String right : generateParenthesis(n-1-c)) {
//                        ans.add("(" + left + ")" + right);
//                    }
//                }
//            }
//        }
//        return ans;
//    }
//    public List<String> generateParenthesis(int n) {
//        List<List<String>> lists = new ArrayList<>();
//        lists.add(Collections.singletonList(""));
//        for (int i = 1; i <= n; ++i) {
//            final List<String> list = new ArrayList<>();
//            for (int j = 0; j < i; ++j) {
//                for (final String first : lists.get(j)) {
//                    for (final String second : lists.get(i - 1 - j)) {
//                        list.add("(" + first + ")" + second);
//                    }
//                }
//            }
//            lists.add(list);
//        }
//        return lists.get(lists.size() - 1);
//    }


//    List<String> output = new ArrayList<>();
//    public List<String> generateParenthesis(int n) {
//        List<String> ans = new ArrayList<>();
//        backtrack(ans, "", 0, 0, n);
//        return ans;
//    }
//
//    private void backtrack(List<String> ans, String cur, int open, int close, int max) {
//        if (cur.length() == max * 2) {
//            ans.add(cur);
//            return;
//        }
//        if (open < max) {
//            backtrack(ans, cur + "(", open + 1, close, max);
//        }
//        if (close < open) {
//            backtrack(ans, cur + ")", open, close + 1, max);
//        }
//    }

//    public List<String> generateParenthesis(int n) {
//        List<String> ans = new ArrayList<>();
//        if (n == 0) {
//            ans.add("");
//        } else {
//            for (int c = 0; c < n; c++) {
//                for (String left : generateParenthesis(c)) {
//                    for (String right : generateParenthesis(n - c - 1)) {
//                        ans.add("(" + left + ")" + right);
//                    }
//                }
//            }
//        }
//        return ans;
//    }

    List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        if (n <= 0) {
            return res;
        }
        return res;
    }

    private void getParenthesis(String str, int left, int right) {
        if (left == 0 && right == 0) {
            res.add(str);
            return;
        }
        if (left == right) {
            getParenthesis(str + "(", left - 1, right);
        }
        if (left < right) {
            if (left > 0) {
                getParenthesis(str + "(", left - 1, right);
            }
            getParenthesis(str + ")", left, right - 1);
        }
    }


    /**
     *
     * List<String> res = new ArrayList<>();
     *         public List<String> generateParenthesis(int n) {
     *             if(n <= 0){
     *                 return res;
     *             }
     *             getParenthesis("",n,n);
     *             return res;
     *         }
     *
     *         private void getParenthesis(String str,int left, int right) {
     *             if(left == 0 && right == 0 ){
     *                 res.add(str);
     *                 return;
     *             }
     *             if(left == right){
     *                 //剩余左右括号数相等，下一个只能用左括号
     *                 getParenthesis(str+"(",left-1,right);
     *             }else if(left < right){
     *                 //剩余左括号小于右括号，下一个可以用左括号也可以用右括号
     *                 if(left > 0){
     *                     getParenthesis(str+"(",left-1,right);
     *                 }
     *                 getParenthesis(str+")",left,right-1);
     *             }
     *         }
     *
     * @param args
     */
    public static void main(String[] args) {
        TwoTwo twoTwo = new TwoTwo();
        List<String> res = twoTwo.generateParenthesis(3);
    }
}
