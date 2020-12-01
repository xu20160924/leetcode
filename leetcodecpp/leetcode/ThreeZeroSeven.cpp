//
// Created by John on 2020/3/23.
//

#include "vector"
#include "../algorithm/FenwickTree.h"
using namespace std;

class NumArray{
public:
    NumArray(vector<int> & nums): nums_(move(nums)), tree_(nums_.size()) {
        for (int i = 0; i < nums_.size(); ++i)  {
            tree_.update(i + 1, nums_[i]);
        }
    }

    void update(int i, int val) {
        tree_.update(i + 1, val - nums_[i]);
        nums_[i] = val;
    }
    int sumRange(int i, int j) {
        return tree_.query(j + 1) - tree_.query(i);
    }

private:
    vector<int> nums_;
    FenwickTree tree_;
};