
//
// Created by John on 2020/3/19.
//

#include "Tree.h"

class Solution{

public:
    void connect(PrefectBinaryTree *root) {
        if (root == NULL) {
            return;
        }
        PrefectBinaryTree * pre = root;
        PrefectBinaryTree * cur = NULL;
        while (pre->left) {
            cur = pre;
            while (cur) {
                cur->left->next = cur->right;
                if (cur->next) {
                    cur->right->next = cur->next->left;
                }
                cur = cur->next;
            }
            pre = pre->left;
        }
    }
};
