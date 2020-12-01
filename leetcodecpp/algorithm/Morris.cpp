//
// Created by John on 2020/10/10.
//

#include <MacTypes.h>
#include <stdio.h>

using namespace std;

struct TreeNode {
    int val;
    TreeNode * left;
    TreeNode * right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

void inorderMorrisTraversal(TreeNode *root) {
    TreeNode *cur = root, *prev = NULL;
    while (cur != NULL) {
        if (cur->left == NULL) {
            printf("%d\n ", cur->val);
            cur = cur->right;
        } else {
            prev = cur->left;
            while (prev->right != NULL && prev->right != cur) {
                prev = prev->right;
            }
            if (prev->right == NULL) {
                prev->right = cur;
                cur = cur->left;
            } else {
                prev->right = NULL;
                printf("%d\n ", cur->val);
                cur = cur->right;
            }
        }
    }
}

//int main() {
//   TreeNode * root = new TreeNode(1);
//   TreeNode * two = new TreeNode(2);
//   TreeNode * seven = new TreeNode(7);
//   TreeNode * four = new TreeNode(4);
//   TreeNode * three = new TreeNode(3);
//   TreeNode * five = new TreeNode(5);
//   TreeNode * nine = new TreeNode(9);
//   TreeNode * eight = new TreeNode(8);
//
//   four->left = three;
//   four->right = five;
//   two->left = three;
//   two->right = four;
//   nine->left = eight;
//   seven->right = eight;
//   eight->left = nine;
//   root->right = seven;
//   root->left = two;
//   inorderMorrisTraversal(root);
//}

