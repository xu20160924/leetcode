package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author: John
 * @date: 2020-03-04 11:54
 * @description: 373
 **/
public class ThreeSevenThree {

//    public List<int[]> kSmallestPaires(int[] nums1, int[] nums2, int k) {
//        PriorityQueue<int[]> que = new PriorityQueue<>((a,b) ->a[0] + a[1] - b[0] - b[1]);
//        List<int[]> res = new ArrayList<>();
//        if (nums1.length == 0 || nums2.length == 0 || k == 0) {
//           return res;
//        }
//        for (int i = 0; i < nums1.length && i < k; i++) {
//            que.offer(new int[]{nums1[i], nums2[0], 0});
//        }
//        while(k-- > 0 && !que.isEmpty()) {
//            int[] cur = que.poll();
//            res.add(new int[]{cur[0], cur[1]});
//            if (cur[2] == nums2.length - 1) {
//                continue;
//            }
//            que.offer(new int[]{cur[0], nums2[cur[2] + 1], cur[2] + 1});
//        }
//        return res;
//    }


    public List<List<Integer>> kSmallestPaires(int[] nums1, int[] nums2, int k) {
        PriorityQueue<List<Integer>> que = new PriorityQueue<>((a,b) -> a.get(0) + a.get(1) - b.get(0) - b.get(1));
        List<List<Integer>> res = new ArrayList<>();
        if (nums1.length == 0 || nums2.length == 0 || k == 0) {
            return res;
        }
        for (int i = 0; i < nums1.length && i < k; i++) {
            que.offer(Arrays.asList(nums1[i], nums2[0], 0));
        }
        while (k-- > 0 && !que.isEmpty()) {
            List<Integer> cur = que.poll();
            res.add(Arrays.asList(cur.get(0), cur.get(1)));
            if (cur.get(2) == nums2.length - 1) {
                continue;
            }
            que.offer(Arrays.asList(cur.get(0), nums2[cur.get(2) + 1], cur.get(2) + 1));
        }
        return res;
    }

//
//    public List<int[]> kSmallestPaires(int[] nums1, int[] nums2, int k) {
//        List<int[]> list = new ArrayList<>();
//        int m = nums1.length;
//        int n = nums2.length;
//        if (m == 0 || n == 0 || k == 0) {
//            return list;
//        }
//        PriorityQueue<Data> heap = new PriorityQueue<>((a,b) -> (a.val - b.val));
//        heap.offer(new Data(0,0, nums1[0] + nums2[0]));
//        while (!heap.isEmpty() && k > 0) {
//            Data d = heap.poll();
//            int[] pair = {nums1[d.i], nums2[d.j]};
//            list.add(pair);
//            k--;
//            // add the next column item
//            if (d.j < n -1) {
//                heap.offer(new Data(d.i, d.j + 1, nums1[d.i] + nums2[d.j]));
//            }
//            // always store the next row(smallest)
//            if (d.j == 0 && d.i < m - 1) {
//                heap.offer(new Data(d.i + 1, 0, nums1[d.i + 1] + nums2[0]));
//            }
//        }
//        return list;
//    }

    class Data {
        int i;
        int j;
        int val;

        public Data(int i, int j, int val) {
            this.i = i;
            this.j = j;
            this.val = val;
        }
    }



    public static void main(String[] args) {
        int[] nums1 = {1, 7, 11};
        int[] nums2 = {2, 4, 6};
        ThreeSevenThree threeSevenThree = new ThreeSevenThree();
        threeSevenThree.kSmallestPaires(nums1, nums2, 3);
    }
}
