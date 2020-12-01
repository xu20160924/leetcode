//
// Created by John on 2020/2/20.
//

#include "FiveZeroOne.h"
#include "TreeNode.h"
#include <vector>

using namespace std;

class Solution {
public:
    void inOrder(TreeNode * root, TreeNode *& pre, int & curTimes, int & maxTimes, vector<int> & res) {
        if (!root) {
            return;
        }
        inOrder(root->left, pre, curTimes, maxTimes, res);
        if (pre) {
            curTimes = (root->val == pre->val) ? curTimes + 1 : 1;
        }
        if (curTimes == maxTimes) {
            res.push_back(root->val);
        } else if (curTimes > maxTimes) {
            res.clear();
            res.push_back(root->val);
            maxTimes = curTimes;
        }
        pre = root;
        inOrder(root->right, pre, curTimes, maxTimes, res);
    }
    vector<int> findMode(TreeNode * root) {
        vector<int> res;
        if (!root) {
            return res;
        }
        TreeNode* pre = NULL;
        int curTimes = 1, maxTimes = 0;
        inOrder(root,pre, curTimes, maxTimes, res);
        return res;
    }
};
