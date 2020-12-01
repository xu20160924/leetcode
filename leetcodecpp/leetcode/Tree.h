//
// Created by John on 2020/3/19.
//

#ifndef UNTITLED_TREE_H
#define UNTITLED_TREE_H

#include <MacTypes.h>

class PrefectBinaryTree {
public:
    int val;
    PrefectBinaryTree * left;
    PrefectBinaryTree * right;
    PrefectBinaryTree * next;
    PrefectBinaryTree() : val(0), left(NULL), right(NULL), next(NULL) {}

    PrefectBinaryTree(int _val) : val(_val), left(NULL), right(NULL), next(NULL) {}

    PrefectBinaryTree(int _val, PrefectBinaryTree* _left, PrefectBinaryTree* _right, PrefectBinaryTree* _next)
            : val(_val), left(_left), right(_right), next(_next) {}
};

#endif //UNTITLED_TREE_H
