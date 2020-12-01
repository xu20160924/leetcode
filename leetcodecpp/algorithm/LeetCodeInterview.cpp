//
// Created by John on 2020/2/14.
//

#include "LeetCodeInterview.h"
#include "../leetcode/TreeNode.h"
#include <vector>
#include <string>
#include <cstdlib>
#include <iostream>
#include <stack>
#include <algorithm>
#include <queue>

using namespace std;

class Solution {
public:
    bool canPermutePalindrome(string s) {
        vector<int> hash(256, 0);
        for (auto c : s) {
            ++hash[c];
        }
        int cnt = 0;
        for (int i = 0; i < hash.size(); ++i) {
            if (hash[i] % 2 == 1) {
                ++cnt;
            }
        }
        return cnt <= 1;
    }

public:
    bool oneEditAway(string first, string second) {
        int size1 = first.size(), size2 = second.size();
        if (abs(size1 - size2) > 1) {
            return false;
        }
        int i = 0, j = 0, c = 0;
        while (i < first.length() && j < second.length()) {
            if (first[i] == second[j]) {
                j++;
                i++;
            } else if (i + 1 < first.length() && first[i + 1] == second[j]) {
                c++;
                i++;
            } else if (j + 1 < second.length() & first[i] == second[j + 1]) {
                c++;
                j++;
            } else {
                c++;
                i++;
                j++;
            }
        }
        return c + abs(int(i - first.length())) + abs(int(j - second.length())) < 2;
    }

public:
    string compressString(string S) {
        string res = "";
        char curr = S[0];
        int num = 1;
        for (int i = 0; i < S.size(); i++) {
            if (curr == S[i]) {
                num++;
                continue;
            } else {
                res += curr;
                res.append(to_string(num));
                num = 1, curr = S[i];
            }
        }
        res += curr;
        res.append(to_string(num));
        return res.size() > S.size() ? S : res;
    }

public:
    void rotate(vector<vector<int> > &matrix) {
//        for (int i = matrix.size() - 1; i >= 0; i--) {
//            for (int j = 0; j < matrix[0].size(); j++) {
//                matrix[j][matrix.size()-i - 1] = matrix[j][matrix.size()-i - 1] ^ matrix[i][j];
//                matrix[i][j] = matrix[i][j] ^ matrix[j][matrix.size()-i - 1];
//                matrix[j][matrix.size()-i - 1] = matrix[j][matrix.size()-i - 1] ^ matrix[i][j];
//            }
//        }
        int len = matrix.size();
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len / 2; j++) {
                if (matrix[i][len - j - 1] == matrix[i][j]) {
                    continue;
                }
                matrix[i][len - j - 1] = matrix[i][j] ^ matrix[i][len - j - 1];
                matrix[i][j] = matrix[i][len - j - 1] ^ matrix[i][j];
                matrix[i][len - j - 1] = matrix[i][j] ^ matrix[i][len - j - 1];

            }
        }

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len - i; j++) {
                if (matrix[i][j] == matrix[len - 1 - j][len - 1 - i]) {
                    continue;
                }
                matrix[i][j] = matrix[i][j] ^ matrix[len - 1 - j][len - 1 - i];
                matrix[len - 1 - j][len - 1 - i] = matrix[len - 1 - j][len - 1 - i] ^ matrix[i][j];
                matrix[i][j] = matrix[i][j] ^ matrix[len - 1 - j][len - 1 - i];

            }
        }
    }

public:
    bool isFlipedString(string s1, string s2) {
        if (s1.size() != s2.size()) {
            return false;
        }
        int num1 = 0, num2 = 0;
        for (int i = 0; i < s1.size(); i++) {
            num1 += int(s1[i]);
            num2 += int(s2[i]);
        }
        if (num1 != num2) {
            return false;
        }
        return true;
    }

public:
    ListNode *removeDuplicateNodes(ListNode *head) {
        ListNode *pre = head;
        ListNode *curr = head;
        bool cf = false;
        while (curr != NULL) {
            while (pre != curr) {
                if (pre->val == curr->val) {
                    cf = true;
                }
                if (cf && pre->next == curr) {
                    break;
                }
                pre = pre->next;
            }
            pre->next = curr->next;
            cf = false;
            pre = head;
            curr = curr->next;
        }
        return head;
    }

public:
    int kk = 0, res = 0;
public:
    int kthToLast(ListNode *head, int k) {
        kk = k;
        find(head);
        return res;
    }

private:
    void find(ListNode *head) {
        if (head == NULL) {
            return;
        }
        find(head->next);
        if (kk > 0) {
            if (--kk == 0) {
                res = head->val;
            }
        } else {
            return;
        }
    }

public:
    void deleteNode(ListNode *node) {
        while (node != NULL) {
            node->val = node->next->val;
            if (node->next->next == NULL) {
                node->next = NULL;
            }
            node = node->next;
        }
    }

public:
    ListNode *partition(ListNode *head, int x) {
        ListNode *a1 = head, *a2 = head;
        while (a1 != NULL) {
            if (a1->val < x) {
                swap(a1, a2);
                a2 = a2->next;
            }
            a1 = a1->next;
        }
        return head;
    }

private:
    void swap(ListNode *a1, ListNode *a2) {
        int temp = a1->val;
        a1->val = a2->val;
        a2->val = temp;
    }

public:
    ListNode *addTwoNumbers(ListNode *l1, ListNode *l2) {
        int carray = 0;
        ListNode *dummy = new ListNode(0);
        ListNode *curr = dummy;
        dummy->next = l1;
        while (l1 != NULL || l2 != NULL) {
            int x = (l1 != NULL) ? l1->val : 0;
            int y = (l2 != NULL) ? l2->val : 0;
            int num = x + y + carray;
            carray = num / 10;
            curr->next = new ListNode(num % 10);
            curr = curr->next;
            if (l1 != NULL) {
                l1 = l1->next;
            }
            if (l2 != NULL) {
                l2 = l2->next;
            }
        }
        if (carray > 0) {
            curr->next = new ListNode(carray);
        }
        return dummy->next;
    }

public:
    ListNode *detectCycle(ListNode *head) {
        if (head == NULL || head->next == NULL) {
            return NULL;
        }
        ListNode *slow = head;
        ListNode *fast = head;
        while (fast != NULL && fast->next != NULL) {
            fast = fast->next->next;
            slow = slow->next;
            if (slow == fast) {
                ListNode *slow2 = head;
                while (slow2 != slow) {
                    slow = slow->next;
                    slow2 = slow2->next;
                }
                return slow;
            }
        }
        return NULL;
    }

public:
    vector<ListNode * > listOfDepth(TreeNode * tree) {
        vector<ListNode* > ret;
        if (!tree) {
            return ret;
        }
        queue<TreeNode*> q;
        q.push(tree);
        while (!q.empty()) {
            int len = q.size();
            ListNode * head = new ListNode(-1);
            ListNode * tail = head;
            for (int i = 0; i < len; i++) {
                TreeNode * cur = q.front(); q.pop();
                tail->next = new ListNode(cur->val);
                tail = tail->next;
                tail->next = NULL;
                if (cur->left) {
                    q.push(cur->left);
                }
                if (cur->right) {
                    q.push(cur->right);
                }
            }
            ret.push_back(head->next);
        }
        return ret;
    }

//public:
//    int depth(TreeNode * root) {
//        if (root == NULL) {
//            return 0;
//        }
//        return max(depth(root->left), depth(root->right)) + 1;
//    }
//
//    bool isBalanced(TreeNode * root) {
//        if (root == NULL) {
//            return true;
//        }
//        int left = depth(root->left);
//        int right = depth(root->right);
//        return abs(left - right) <= 1 && isBalanced(root->right) && isBalanced(root->right);
//    }

    int dfsHeight(TreeNode * root) {
        if (root == NULL) {
            return 0;
        }
        int leftHeight = dfsHeight(root->left);
        if (leftHeight == -1) {
            return -1;
        }
        int rightHeight = dfsHeight(root->right);
        if (rightHeight == -1) {
            return -1;
        }
        if (abs(leftHeight - rightHeight) > 1) {
            return -1;
        }
        return max(leftHeight, rightHeight) + 1;
    }
    bool isBalanced(TreeNode * root) {
        return dfsHeight(root) != -1;
    }


//    void dfs(vector<vector<int> > & res, vector<int> & trace, vector<int> & left, vector<int> & right,
//            int posl, int posr) {
//        if (posl == left.size()) {
//            vector<int> temp = trace;
//            auto beg = right.begin() + posr;
//            temp.insert(temp.end(), beg, right.end());
//            res.push_back(temp);
//            return;
//        } else if (posr == right.size()) {
//            vector<int> temp = trace;
//            auto beg = left.begin() + posl;
//            temp.insert(temp.end(), beg, left.end());
//            res.push_back(temp);
//            return;
//        }
//        trace.push_back(left[posl]);
//        dfs(res, trace, left, right, posl + 1, posr);
//        trace.pop_back();
//        trace.push_back(right[posr]);
//        dfs(res, trace, left, right, posl, posr + 1);
//        trace.pop_back();
//    }
//    vector<vector<int> > BSTSequences(TreeNode * root) {
//        if (root == NULL) {
//            return ;
//        }
//        if (root->left==NULL && root->right==NULL) {
//            return {{root->val}};
//        }
//        vector<vector<int> > res;
//        vector<vector<int> > resl = BSTSequences(root->left);
//        vector<vector<int> > resr = BSTSequences(root->right);
//        for (auto vl: resl) {
//            vector<int> trace = {root->val};
//            for (auto vr : resr) {
//                dfs(res, trace, vl, vr, 0, 0);
//            }
//        }
//        return res;
//    }
};

class StackOfPlates {
private:
    int size;
    vector<stack<int> > stack_sets;
public:
    StackOfPlates(int cap) {
        size = cap;
    }

    void push(int val) {
        if (size == 0) {
            return;
        }
        if (stack_sets.size() == 0 || stack_sets[stack_sets.size() - 1].size() == size) {
            stack<int> tmp;
            tmp.push(val);
            stack_sets.push_back(tmp);
        } else {
            stack_sets[stack_sets.size() - 1].push(val);
        }
    }

    int popAt(int index) {
        if (stack_sets.size() == 0 || index < 0 || index >= stack_sets.size()) {
            return -1;
        }
        int ret = stack_sets[index].top();
        stack_sets[index].pop();
        if (stack_sets[index].empty()) {
            stack_sets.erase(stack_sets.begin() + index);
        }
        return ret;
    }
    bool isValidBST(TreeNode * root) {
    }
};

//class MyQueue {
//
//public:
//    stack<int> s1, s2;
//    int front;
//
//    MyQueue() {
//
//    }
//
//    /** Push element x to the back of queue. */
//    void push(int x) {
//        if (s1.empty()) {
//            front = x;
//        }
//        while (!s1.empty()) {
//            s2.push(s1.top());
//            s1.pop();
//        }
//        s2.push(x);
//        while (!s2.empty()) {
//            s1.push(s2.top());
//            s2.pop();
//        }
//    }
//
//    /** Removes the element from in front of queue and returns that element. */
//    int pop() {
//        int num = s1.top();
//        s1.pop();
//        if (!s1.empty()) {
//            front = s1.top();
//        }
//        return num;
//    }
//
//    /** Get the front element. */
//    int peek() {
//        return front;
//    }
//
//
//
//public:
//    stack<int> s1, s2;
//    int front;
//
//    MyQueue() {
//    }
//
//    void push(int x) {
//        if (s1.empty()) {
//            front = x;
//        }
//        s1.push(x);
//    }
//
//
//    int pop() {
//        if (s2.empty()) {
//            while (!s1.empty()) {
//                s2.push(s1.top());
//                s1.pop();
//            }
//        }
//        s2.pop();
//    }
//
//    int peek() {
//        if (!s1.empty()) {
//            return s2.top();
//        }
//        return front;
//    }
//
//    bool empty() {
//        return s1.empty() && s2.empty();
//    }
//};

class SortedStack {
public:
    stack<int> stack;

    SortedStack() {

    }

    void push(int val) {
        if (!stack.empty() && peek() < val) {
            int swap = peek();
            pop();
            push(val);
            push(swap);
        } else {
            stack.push(val);
        }
    }

    void pop() {
        if (!isEmpty()) {
            stack.pop();
        }
    }

    int peek() {
        if (isEmpty()) {
            return stack.top();
        }
    }

    bool isEmpty() {
        return stack.empty();
    }
};


//class AnimalShelf {
//public:
//    vector<vector<int> > animals;
//    int cat = 0, dog = 0;
//    AnimalShelf() {
//
//    }
//
//    void enqueue(vector<int> animal) {
//        vector<int>::iterator  it = animal.begin();
//        for (; it != animal.end(); it++) {
//            if (*it == 0) {
//                cat++;
//            }
//            if (*it == 1) {
//                dog++;
//            }
//        }
//    }
//
//    vector<int> dequeueAny() {
//        vector<int> res;
//        if (!) {
//
//        }
//    }
//
//    vector<int> dequeueDog() {
//        if (!animals.empty()) {
////            vector<int, allocator<int> > a = find(animals[animals.size()], animals[animals.size() - 1], 1);
////            animals[animals.size() - 1].erase();
//
//        }
//    }
//
//    vector<int> dequeueCat() {
//
//    }
//};

//int main() {
//    SortedStack *sortedStack = new SortedStack();
////    sortedStack->push(1);
////    sortedStack->push(2);
////    sortedStack->push(3);
////
////    sortedStack->pop();
////    sortedStack->peek();
//    sortedStack->pop();
//    sortedStack->pop();
//    sortedStack->push(1);
//    sortedStack->pop();
//    sortedStack->isEmpty();
//}



//int main() {
////        ListNode *root = new ListNode(1);        `
////        ListNode *two = new ListNode(2);
////        ListNode *three = new ListNode(3);
////        ListNode *four = new ListNode(4);
////        ListNode *five = new ListNode(5);
////        ListNode *six = new ListNode(6);
//
//
////        five->next = six;
////        four->next = five;
////        three->next = four;
////        two->next = three;
////        root->next = two;
//
//    ListNode *two = new ListNode(0);
////    ListNode *four = new ListNode(4);
////    ListNode *three = new ListNode(3);
//    ListNode *five = new ListNode(7);
//    ListNode *six = new ListNode(3);
//
////    ListNode *four2 = new ListNode(4);
//
////    four->next = three;
////    two->next = four;
////
////    six->next = four2;
//    five->next = six;
////
//
//    Solution *solution = new Solution();
//    solution->addTwoNumbers(two, five);
//    printf("over");
//}

//int main() {
////    string first = "intention";
////    string second = "execution";
////    string str = "aabcccccaaa";
////    Solution *solution = new Solution();
////    cout << solution->compressString(str) << endl;
////    int a = 7;
////    int b = 3;
////    a = a ^ b;
////    b = b ^ a;
////    a = a ^ b;
////    printf("%d\n", a);
////    printf("%d\n", b);
//
//    vector<vector<int> > matrix;
//    vector<int> num1, num2, num3;
//    num1.push_back(1);
//    num1.push_back(2);
//    num1.push_back(3);
//
//    num2.push_back(4);
//    num2.push_back(5);
//    num2.push_back(6);
//
//    num3.push_back(7);
//    num3.push_back(8);
//    num3.push_back(9);
//
//    matrix.push_back(num1);
//    matrix.push_back(num2);
//    matrix.push_back(num3);
//
//    Solution *solution = new Solution();
//    solution->rotate(matrix);
//
//};
