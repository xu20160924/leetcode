package com.entity;

/**
 * @author: John
 * @date: 2020-03-23 18:30
 * @description: FenwickTree
 **/
public class FenwickTree {
    int sums_[];
    public FenwickTree(int n) {
       sums_ = new int[n + 1];
    }
    public void update(int i, int delta) {
        while (i < sums_.length) {
            sums_[i] += delta;
            i += i & -i;
        }
    }

    public int query(int i) {
        int sum = 0;
        while (i > 0) {
           sum += sums_[i];
           i -= i & -i;
        }
        return sum;
    }

}
