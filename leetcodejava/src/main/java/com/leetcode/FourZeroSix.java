package com.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: John
 * @date: 2020-10-06 18:29
 * @description: 406
 **/
public class FourZeroSix {
    public int[][] reconstructQueue(int[][] people) {
        // pick up the tallest guy first
        // when insert the next tall guy, jsut need to insert him into kth position
        // repeat until all people are inserted into list
        Arrays.sort(people, new Comparator<int[]>() {

            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] != o2[0] ? -o1[0]+o2[0] : o1[1]-o2[1];
            }
        });
        List<int[]> res = new LinkedList<>();
        for (int[] cur: people) {
            res.add(cur[1], cur);
        }
        return res.toArray(new int[people.length][]);
    }

    public static void main(String[] args) {
        int[][] nums = {{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
        FourZeroSix fourZeroSix = new FourZeroSix();
        fourZeroSix.reconstructQueue(nums);
    }
}
