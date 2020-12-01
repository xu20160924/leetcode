//
// Created by John on 2020/2/14.
//

#include "NineSevenNine.h"
#include <vector>
#include <cmath>


using namespace std;

class Solution{
    int traverse(TreeNode * r, int & moves) {
        if (r == nullptr) {
            return 0;
        }
        int left = traverse(r->left, moves), right = traverse(r->right, moves);
        moves += abs(left) + abs(right);
        return r->val + left + right -1;
    }

    int distributeCoins(TreeNode * r, TreeNode * p = nullptr) {
        if (r == nullptr) {
            return 0;
        }
        int res = distributeCoins(r->left, r) + distributeCoins(r->right, r);
        if (p != nullptr) {
            p->val += r->val - 1;
        }
        return res + abs(r->val - 1);
    }
};