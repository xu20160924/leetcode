//
// Created by John on 2020/2/22.
//

#include "OneZeroOne.h"
#include "NineSevenNine.h"
#include <queue>

using namespace std;

class Solution {
public:
//    bool isSymmetric(TreeNode * root) {
//        if (root == NULL) {
//            return true;
//        }
//        return traverse(root, root);
//    }
    bool isSymmetric(TreeNode * root) {
        queue<TreeNode *> q;
        q.push(root);
        q.push(root);
        while (!q.empty()) {
            TreeNode * t1 = q.front();
            TreeNode * t2 = q.front();
            if (t1 == NULL && t2 == NULL) {
                continue;
            }
            if (t1 == NULL || t2 == NULL) {
                return false;
            }
            if (t1->val != t2->val) {
                return false;
            }
            q.push(t1->left);
            q.push(t2->right);
            q.push(t1->right);
            q.push(t2->left);
        }
        return true;
    }
private:
    bool traverse(TreeNode * left, TreeNode * right) {
        if (left == NULL && right == NULL) {
            return true;
        }
        if (left == NULL || right == NULL) {
            return false;
        }
        return left->val == right->val && traverse(left->left, right->right) && traverse(left->right, right->left);
    }
};
//int main() {
//    TreeNode * lefttwo = new TreeNode(2);
//    TreeNode * leftthree = new TreeNode(3);
//    TreeNode * righttwo = new TreeNode(2);
//    TreeNode * rightthree = new TreeNode(3);
//    righttwo->right = rightthree;
//    lefttwo->right = leftthree;
//    TreeNode * one = new TreeNode(1);
//    one->left = lefttwo;
//    one->right = righttwo;
//
//    Solution * solution = new Solution();
//    solution->isSymmetric(one);
//
//}
