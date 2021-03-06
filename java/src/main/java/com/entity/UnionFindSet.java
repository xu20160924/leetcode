package com.entity;

/**
 * @author: John
 * @date: 2020-03-28 21:02
 * @description: UnionFind
 **/
public class UnionFindSet {
    private int[] parents_;
    private int[] ranks_;

    public UnionFindSet(int n) {
        parents_ = new int[n + 1];
        ranks_ = new int[n + 1];
        for (int i = 0; i < parents_.length; ++i) {
           parents_[i] = i;
           ranks_[i] = 1;
        }
    }

    public boolean Union(int u, int v) {
        int pu = Find(u);
        int pv = Find(v);
        if (pu == pv) {
            return false;
        }
        if (ranks_[pv] > ranks_[pu]) {
            parents_[pu] = pv;
        } else if (ranks_[pu] > ranks_[pv]) {
           parents_[pv] = pu;
        } else {
            parents_[pv] = pu;
            ranks_[pu] += 1;
        }
        return true;
    }

    public int Find(int u) {
        while (parents_[u] != u) {
           parents_[u] = parents_[parents_[u]];
           u = parents_[u];
        }
        return u;
    }
}
