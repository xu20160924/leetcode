//
// Created by John on 2020/10/12.
//
#include "vector"
#include "TreeNode.h"
#include "queue"


using namespace std;

//vector<int> rightSideView(TreeNode* root) {
//    vector<int> res;
//    if (!root) {
//        return res;
//    }
//    queue<TreeNode *> queue;
//    queue.push(root);
//    while (!queue.empty()) {
//        int size = queue.size();
//        res.push_back(queue.front()->val);
//        while (size--) {
//            TreeNode* temp = queue.front();
//            queue.pop();
//            if (temp->right) {
//                queue.push(temp->right);
//            }
//            if (temp->left) {
//                queue.push(temp->left);
//            }
//        }
//    }
//    return res;
//}

class Solution {
public:
    void recursion(TreeNode *root, int level, vector<int> &res) {
        if (root == NULL) {
            return;
        }
        if (res.size() < level) {
            res.push_back(root->val);
        }
        recursion(root->right, level + 1, res);
        recursion(root->left, level + 1, res);
    }

    vector<int> rightSideView(TreeNode *root) {
        vector<int> res;
        recursion(root, 1, res);
        return res;
    }
};

