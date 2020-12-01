//
// Created by John on 2020/2/22.
//

#include "OneZeroZero.h"
#include "TreeNode.h"

class Solution {
public:
    bool isSameTree(TreeNode * p, TreeNode * q) {
        return traverse(p, q);
    }

private:
    bool traverse(TreeNode * p, TreeNode * q) {
        if (p == NULL && q == NULL) {
            return true;
        }
        if (p == NULL || q == NULL) {
            return false;
        }
        return p->val == q->val && traverse(p->left, q->left) && traverse(p->right, q->right);
    }
};