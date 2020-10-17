//
// Created by Yang on 2020/10/14.
//

#include "TreeNode.h"
#include "queue.h"
// Created by John on 2020/10/14.
//

#include "TreeNode.h"
#include "queue"

using namespace std;


class Solution{
public:
    TreeNode* addOneRow(TreeNode* root, int v, int d) {
        if (d == 1) {
            TreeNode * newNode = new TreeNode(v);
            newNode->left = root;
            return newNode;
        }

        queue<TreeNode*> queue;
        queue.push(root);
        int depth = 1;
        while (depth < d - 1) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode* node = queue.front();
                queue.pop();
                if (node->left != NULL) {
                    queue.push(node->left);
                }
                if (node->right != NULL) {
                     queue.push(node->right);
                }
            }
            depth++;
        }
        while (!queue.empty()) {
            TreeNode* node = queue.front();
            queue.pop();
            TreeNode * temp = node->left;
            node->left = new TreeNode(v);
            node->left->left = temp;
            temp = node->right;
            node->right = new TreeNode(v);
            node->right->right = temp;
        }
        return root;
    }
};

//int main() {
//    TreeNode * root = new TreeNode(1);
//    TreeNode * two = new TreeNode(2);
//    TreeNode * three = new TreeNode(3);
//    TreeNode * four = new TreeNode(4);
//
//    two->left = four;
//    root->left = two;
//    root->right = three;
//
//
////    TreeNode * root = new TreeNode(4);
////    TreeNode * two = new TreeNode(2);
////    TreeNode * six = new TreeNode(6);
////    TreeNode * three = new TreeNode(3);
////    TreeNode * one = new TreeNode(1);
////    TreeNode * five = new TreeNode(5);
////    six->left = five;
////    two->left = three;
////    two->right = one;
////    root->left = two;
////    root->right = six;
//
//
//    Solution *solution = new Solution();
//    solution->addOneRow(root, 5, 4);
//}

