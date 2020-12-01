package com.interview;


import java.util.ArrayList;
import java.util.List;

/**
 * @author: John
 * @date: 2020-11-19 15:17
 * @description: Tencent
 *
 *
 *  给定m个无重复的个位数，0<m<10，能组成哪些互不相同且无重复的n位数（n<=m）？
 *
 * 如 m=3，则可选的个位数的范围是1，2，3
 * 如 m=5，则可选的个位数的范围是1，2，3，4，5
 * 如 m=8，则可选的个位数的范围是1，2，3，4，5，6，7，8
 *
 * 如m=3，n=2，则输出：12，13，23，21，23，31
 *
 **/
public class Permutation {
    public List<String> permutation(int m, int n) {
       List<String> res = new ArrayList<>();
       backtrack(res, new StringBuilder(), m, n);
       return res;
    }

    private void backtrack(List<String> res, StringBuilder str, int m, int n) {
        if (str.length() == n) {
            res.add(str.toString());
            return;
        }
        for (int i = 1; i <= m; i++) {
            if (str.indexOf(String.valueOf(i)) >= 0) {
                continue;
            }
            str.append(i);
            backtrack(res, str, m, n);
            str.deleteCharAt(str.length() - 1);
        }
    }

    public static void main(String[] args) {
        Permutation permutation = new Permutation();
        List<String> a = permutation.permutation(3, 2);
        a.forEach(p -> {
            System.out.println(p);
        });
//        System.out.println("123".indexOf(String.valueOf(2)));
    }
}
