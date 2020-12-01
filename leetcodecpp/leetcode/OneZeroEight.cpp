//
// Created by John on 2020/2/19.
//

#include "OneZeroEight.h"
#include "TreeNode.h"
#include <vector>

using namespace std;

class Solution{
public:
    TreeNode* sortedArrayToBST(vector<int> & nums) {
        if (nums.size() == 0) {
            return NULL;
        }
        TreeNode * head = helper(nums, 0, nums.size() - 1);
        return head;
    }

private:
    TreeNode* helper(vector<int> nums, int low, int high) {
        if (low > high) {
            return NULL;
        }
        int mid = low + (high - low) / 2;
        TreeNode *node = new TreeNode(nums[mid]);
        node->left = helper(nums, low, mid - 1);
        node->right = helper(nums, mid + 1, high);
        return node;
    }
};