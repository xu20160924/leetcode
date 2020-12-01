//
// Created by John on 2020/3/23.
//

#ifndef UNTITLED_FENWICKTREE_H
#define UNTITLED_FENWICKTREE_H

#include "vector"

using namespace std;

class FenwickTree {
public:
    FenwickTree(int n): sums_(n + 1, 0) {}

    void update(int i, int delta) {
        while (i < sums_.size()) {
            sums_[i] += delta;
            i += lowbit(i);
        }
    }

    int query(int i) const {
        int sum = 0;
        while (i > 0) {
            sum += sums_[i];
            i -= lowbit(i);
        }
        return sum;
    }

private:
    static inline int lowbit(int x) {
        return x & (-x);
    }
    vector<int> sums_;
};

#endif //UNTITLED_FENWICKTREE_H
