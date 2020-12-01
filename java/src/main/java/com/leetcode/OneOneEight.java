package com.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: John
 * @date: 2020-09-20 19:20
 * @description: 118
 **/
public class OneOneEight {
//    public List<List<Integer>> generate(int numRows) {
//        List<List<Integer>> res = new LinkedList<>();


//        for (int i = 0; i < numRows; i++) {
//            List<Integer> list = new LinkedList<Integer>();
//            list.add(0, 1);
//            for (int j = 1; j < i; j++) {
//                list.add(res.get(i).get(j - 1) + res.get(i).get(j - 1));
//            }
//            list.add(1);
//            res.add(list);
//        }
//        return res;
//    }

//    public List<List<Integer>> generate(int numRows) {
//        List<List<Integer>> triangle = new ArrayList<>();
//        if (numRows == 0) {
//            return triangle;
//        }
//        triangle.add(new ArrayList<Integer>(){{ add(1); }});
//        for (int rowNum = 1; rowNum < numRows; rowNum++) {
//            List<Integer> row = new ArrayList<>();
//            List<Integer> prevRow = triangle.get(rowNum - 1);
//            row.add(1);
//
//            for (int j = 1; j < rowNum; j++) {
//                row.add(prevRow.get(j - 1) + prevRow.get(j));
//            }
//            row.add(1);
//            triangle.add(row);
//        }
//        return triangle;
//    }

//    public List<List<Integer>> generate(int numRows) {
//        List<List<Integer>> triangle = new ArrayList<>();
//
//        if (numRows == 0) {
//            return triangle;
//        }
//
//        triangle.add(new ArrayList<Integer>(){{ add(1); }});
//
//        List<Integer> row = new ArrayList<>();
//        for (int i = 1; i < numRows; i++) {
//            // List<Integer> row = new ArrayList<>();
////            List<Integer> row = new ArrayList<>(triangle.get(i - 1));
//
//            row.add(0, 1);
//            for (int j = 1; j < i; j++) {
//                row.set(j, row.get(j - 1) + row.get(j));
//            }
//            row.add(row.size(), 1);
//            triangle.add(row);
//        }
//        return triangle;
//    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> row = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            row.add(0, 1);
            for (int j = 1; j < row.size() -1; j++) {
                row.set(j, row.get(j) + row.get(j + 1));
            }
            res.add(new ArrayList<>(row));
        }
        return res;
    }


    public static void main(String[] args) {
        OneOneEight oneOneEight = new OneOneEight();
        oneOneEight.generate(5);
    }
}
