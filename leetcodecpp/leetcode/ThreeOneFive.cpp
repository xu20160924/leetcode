//
// Created by John on 2020/2/24.
//

#include "ThreeOneFive.h"
#include <vector>
#include "set"
#include "unordered_map"
#include "../algorithm/FenwickTree.h"

using namespace std;

struct BSTNode {
    int val;
    int count;
    int left_count;
    BSTNode * left;
    BSTNode * right;
    BSTNode(int val): val(val), count(1), left_count(0), left{nullptr}, right{nullptr} {}
    ~BSTNode() {delete left; delete right;}
    int less_or_equal() const { return count + left_count; }
};

class Solution{
public:
    vector<int> countSmaller(vector<int> & nums) {
        if (nums.empty()) return {};
        reverse(nums.begin(), nums.end());
        unique_ptr<BSTNode> root(new BSTNode(nums[0]));
        vector<int> ans{0};
        for (int i = 1; i < nums.size(); ++i) {
            ans.push_back(insert(root.get(), nums[i]));
        }
        reverse(ans.begin(), ans.end());
        return ans;
    }

private:
    // Returns the number of elements smaller than val under root.
    int insert(BSTNode * root, int val) {
        if (root->val == val) {
            ++root->count;
            return root->left_count;
        } else if (val < root->val) {
            ++root->left_count;
            if (root->left == nullptr) {
                root->left = new BSTNode(val);
                return 0;
            }
            return insert(root->left, val);
        } else {
            if (root->right == nullptr) {
                root->right = new BSTNode(val);
                return root->less_or_equal();
            }
            return root->less_or_equal() + insert(root->right, val);
        }
    }
//    vector<int> countSmaller(vector<int> & nums) {
//        // Sort the unique numbers   5, 2, 6, 1 -> 1, 2, 5, 6
//        set<int> sorted(nums.begin(), nums.end());
//        // Map the number to its rank
//        unordered_map<int, int> ranks;
//        int rank = 0;
//        for (const int num : sorted) {
//            ranks[num] = ++rank;
//        }
//        vector<int> ans;
//        FenwickTree tree(ranks.size());
//        // Scan the numbners in reversed order
//        for (int i = nums.size() - 1; i >= 0 ; --i) {
//            // Check how many numbers are smaller than the current number.
//            ans.push_back(tree.query(ranks[nums[i]] - 1));
//            // Increase the count of the rank of current number.
//            tree.update(ranks[nums[i]], i);
//        }
//        reverse(ans.begin(), ans.end());
//        return ans;
//    }
};

//int main() {
//    vector<int> nums;
//    nums.push_back(5);
//    nums.push_back(2);
//    nums.push_back(6);
//    nums.push_back(1);
//
//    Solution * solution = new Solution();
//    solution->countSmaller(nums);
//}