//
// Created by John on 2020/2/12.
//

#include "OneOneThree.h"
#include <vector>
#include <stack>

using namespace std;

class Solution{
//public:
//    vector<vector<int> > pathSum(TreeNode* root, int sum) {
//        vector<vector<int> > ans; vector<int> curr; // 分别记录所有满足条件的路径，一条满足条件的路径
//        if (!root) {
//            return ans;
//        }
//        stack<TreeNode*> stk; TreeNode *prev = nullptr;
//        while (root || !stk.empty()) { // 模拟系统递归栈
//            while (root) {
//                stk.push(root); sum -= root->val; curr.push_back(root->val); //入栈、更新剩余和、路径
//                root = root->left;
//            } // 递归访问左结点
//            root = stk.top(); // 不能再左了，取得右拐点(根节点）
//            if (!root->left && !root->right && (sum == 0)) { //条件: 是叶子结点且剩余和为0
//                ans.push_back(curr); // 满足条件,保存路径
//            }
//            if (!root->right || root->right == prev) {  //右结点不存在或已经访问 回溯
//                stk.pop(); sum += root->val; curr.pop_back(); // 出栈、更新剩余和、路径
//                prev = root; // 标记已访问
//                root = nullptr; //用于回溯到上一级
//            } else { // 递归访问右结点
//                root = root->right;
//            }
//        }
//    }

public:
    vector<vector<int> > pathSum(TreeNode* root, int sum) {
        vector<vector<int> > ans; vector<int> curr;
        if(!root) {
            return ans;
        }
        stack<TreeNode*> stk; TreeNode *prev = nullptr;
        while (!stk.empty() || root) {
            while (root) {
                stk.push(root); sum -= root->val; curr.push_back(root->val);
                root = root->left;
            }
            root = stk.top();
            if (!root->left && !root->right && (sum == 0)) {
                ans.push_back(curr);
            }
            if (!root->right || root->right == prev) {
                stk.pop(); sum += root->val; curr.pop_back();
                prev = root;
                root = nullptr;
            } else {
                root = root->right;
            }
        }
    }

};
//int main(){
//    Solution *solution = new Solution();
//    TreeNode *root = new TreeNode(5);
//    TreeNode *four = new TreeNode(4);
//    TreeNode *eight = new TreeNode(8);
//    TreeNode *eleven = new TreeNode(11);
//    TreeNode *thirteen = new TreeNode(13);
//    TreeNode *seven = new TreeNode(7);
//    TreeNode *two = new TreeNode(2);
//    TreeNode *rightFour = new TreeNode(4);
//    TreeNode *five = new TreeNode(5);
//    TreeNode *one = new TreeNode(1);
//    eleven->left = seven;
//    eleven->right = two;
//    rightFour->left = five;
//    rightFour->right = one;
//    four->left = eleven;
//    eight->left = thirteen;
//    eight->right = rightFour;
//    root->left = four;
//    root->right = eight;
//    solution->pathSum(root, 22);
//};