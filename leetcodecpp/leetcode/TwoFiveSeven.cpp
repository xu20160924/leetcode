//
// Created by John on 2020/2/22.
//

#include "TwoFiveSeven.h"
#include "TreeNode.h"
#include <string>
#include <vector>

using namespace std;
class Solution {
//public:
//    vector<string> binaryTreePaths(TreeNode * root) {
//        vector<string> res;
//        dfs(root, res, "");
//        return res;
//    }
//
//private:
//    void dfs(TreeNode * node, vector<string> & res, string str) {
//        if (node == NULL) {
//            return;
//        }
//        str += to_string(node->val) + "->";
//        if (node->left == NULL && node->right == NULL) {
//            str = str.substr(0, str.size() - 2);
//            res.push_back(str);
//            str.clear();
//        }
//        dfs(node->left, res, str);
//        dfs(node->right, res, str);
//    }
//};

    void binaryTreePaths(vector<string> &result, TreeNode *root, string t) {
        if (!root->left && !root->right) {
            result.push_back(t);
            return;
        }
        if (root->left) {
            binaryTreePaths(result, root->left, t + "->" + to_string(root->left->val));
        }
        if (root->right) {
            binaryTreePaths(result, root->right, t + "->" + to_string(root->right->val));
        }
    }
    vector<string> binaryTreePaths(TreeNode * root) {
        vector<string> result;
        if (!root) {
            return result;
        }
        binaryTreePaths(result, root, to_string(root->val));
        return result;
    }

public:
    int insertBits(int N, int M, int i, int j) {
        uint32_t mask1 = UINT32_MAX << i;
        uint32_t mask2 = UINT32_MAX >> (32 - j - 1);
        uint32_t mask = mask1 & mask2;
        return (N & (~mask)) + ((M << i) & mask);
    }


};
//int main (){
//    TreeNode * root = new TreeNode(1);
//    TreeNode * two = new TreeNode(2);
//    TreeNode * three = new TreeNode(3);
//    TreeNode * five = new TreeNode(5);
//    two->right = five;
//    root->left = two;
//    root->right = three;
//    Solution * solution = new Solution();
//    vector<string> res = solution->binaryTreePaths(root);

//    string a = "123132";
//    printf("%s", a.substr(0,2));
//};