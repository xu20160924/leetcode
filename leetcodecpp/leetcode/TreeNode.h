//
// Created by John on 2020/2/19.
//

#ifndef UNTITLED_TREENODE_H
#define UNTITLED_TREENODE_H

#include <MacTypes.h>

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;

    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};
#endif //UNTITLED_TREENODE_H
