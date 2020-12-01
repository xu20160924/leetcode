//
// Created by John on 2020/1/26.
//

#include "SixFiveFour.h"
#include <istream>
#include <vector>
#include <map>
#include <iostream>

using namespace std;

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;

    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

class Solution {
//public:
//    static TreeNode* constructMaximumBinaryTree(vector<int>& nums) {
//        vector<TreeNode*> stk;
//        for (int i = 0; i < nums.size(); ++i) {
//            TreeNode* cur = new TreeNode(nums[i]);
//            while (!stk.empty() && stk.back()-> val < nums[i]) {
//                cur->left = stk.back();
//                stk.pop_back();
//            }
//            if (!stk.empty()) {
//                stk.back()->right = cur;
//            }
//            stk.push_back(cur);
//        }
//        return stk.front();
//    }

public:
   static TreeNode *constructMaximumBinaryTree(vector<int> &nums) {
//     sort and uniquely identify the elements
       map<int, TreeNode *> nodes;
        for (int num : nums) {
            auto it = nodes.insert(pair<int, TreeNode*>(num, new TreeNode(num))).first;
            if (it != nodes.begin()) {
                cout<< "second:" << it->second <<  "first" << it->first << endl;
                auto cc = next(it, 1);
                auto bb = next(it, -1);
                cout<< "cc.second" << cc->second << "cc.first" << cc->first << endl;
                cout<< "bb.second" << bb->second << "bb.first" << bb->first << endl;

                it->second->left = next(it, -1)->second;
                nodes.erase(nodes.begin(), it);
            }


            if (next(it, 1) != nodes.end()) {
                auto nn = next(it, 1);
                auto ee = nodes.end();
                cout<< "nn.second " << nn->second << "nn.first " << nn->first << endl;
                cout<< "ee.second " << ee->second << "ee.first " << ee->first << endl;

                next(it, 1)->second->right = it->second;
            }
        }
        return nodes.rbegin()->second;
    }
};
//
//int main() {
//    vector<int> nums;
//    nums.push_back(3);
//    nums.push_back(2);
//    nums.push_back(1);
//    nums.push_back(6);
//    nums.push_back(0);
//    nums.push_back(5);
////    3,2,1,6,0,5=
////    TreeNode (*a);
////    a = constructMaximumBinaryTree;
////    a = constructMaximumBinaryTree;
////    var = (*a)(nums);
//    TreeNode result = *Solution::constructMaximumBinaryTree(nums);
//};
//