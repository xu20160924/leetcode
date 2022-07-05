//
// Created by John on 2022/4/17.
//
#include "../algorithm/LeetCodeInterview.h"
#include "vector"

class Solution{
public:
//    bool isPalindrome(ListNode* head) {
//        vector<int> v;
//        while (head) {
//            v.push_back(head->val);
//            head = head->next;
//        }
//        for (int i = 0; i < v.size() / 2; ++i) {
//            if (v[i] != v[v.size() - i - 1]) {
//                return false;
//            }
//        }
//        return true;
//    }
static
    bool isPalindrome(ListNode* head) {
        if (!head || !head->next) {
            return true;
        }
        // fast is double nodes of slow, so this can make slow end at middle node
        ListNode *slow = head, *fast = head->next;
        while (fast && fast->next) {
            slow = slow->next;
            fast = fast->next->next;
        }
        // because slow end at middle node, so slow->next is beginning of right half list
        fast = slow->next;
        slow->next = NULL;
        ListNode newHead(0);
        ListNode *next = NULL, *p = fast;
        while (p) {
            next = p->next;
            p->next = newHead.next;
            newHead.next = p;
            p = next;
        }
        fast = newHead.next;
        while (fast) {
            if (fast->val != head->val) {
                return false;
            }
            fast = fast->next;
            head = head->next;
        }
        return fast == NULL;
    }
};

//int main() {
//    ListNode l1 = ListNode(1);
//    ListNode l11 = ListNode(2);
//    ListNode l111 = ListNode(2);
//    ListNode l1111 = ListNode(1);
//    l111.next = &l1111;
//    l11.next = &l111;
//    l1.next = &l11;
//
//    Solution::isPalindrome(&l1);
//}

