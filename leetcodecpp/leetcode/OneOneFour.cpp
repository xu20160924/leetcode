//
// Created by John on 2020/3/21.
//

#include "TreeNode.h"

class Solution{
public:
    void flatten(TreeNode * root) {
        TreeNode * now = root;
        while (now) {
            if (now->left) {
                // Find current node's prenode that links to current node's right subtree
                TreeNode* pre = now->left;
                while (pre->right) {
                    pre = pre->right;
                }
                pre->right = now->right;
                // Use current node's left subtree to replace its right subtree
                // (originally right subtree is already linked by current node's prenode)
                now->right = now->left;
                now->left = NULL;
            }
            now = now->right;
        }
    }
};
//int main() {
//    TreeNode * root = new TreeNode(1);
//    TreeNode * two = new TreeNode(2);
//    TreeNode * three = new TreeNode(3);
//    TreeNode * four = new TreeNode(4);
//    TreeNode * five = new TreeNode(5);
//    TreeNode * six = new TreeNode(6);
//
//    two->left = three;
//    two->right = four;
//    five->right = six;
//    root->left = two;
//    root->right = five;
//
//
//    Solution * solution = new Solution();
//    solution->flatten(root);
//}