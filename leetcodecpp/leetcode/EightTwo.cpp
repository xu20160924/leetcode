//
// Created by John on 2022/4/11.
//

#include "../algorithm/LeetCodeInterview.h"

class Solution {
public:
//    static ListNode *deleteDuplicates(ListNode *head) {
//        if (!head) {
//            return head;
//        }
//        ListNode dummy = ListNode(0);
//        dummy.next = head;
//        ListNode *curr = &dummy;
//
//        while (head != nullptr) {
//            if (head->next != nullptr && head->val == head->next->val) {
//                while (head->next != nullptr && head->val == head->next->val) {
//                    head = head->next;
//                }
//                curr->next = head->next;
//            } else {
//                curr = curr->next;
//            }
//            head = head->next;
//        }
//        return dummy.next;
//    }

    /**
     * iterative solution refer:
     * https://leetcode.com/problems/add-two-numbers/discuss/1340/A-summary-about-how-to-solve-Linked-List-problem-C%2B%2B
     */
//    static ListNode* deleteDuplicates2(ListNode* head) {
//        ListNode* dummy = new ListNode(0);
//        dummy->next = head;
//        ListNode* cur = dummy;
//        int duplicate;
//        while (cur->next && cur->next->next) {
//            if (cur->next->val == cur->next->next->val) {
//                duplicate = cur->next->val;
//                while (cur->next && duplicate == cur->next->val) {
//                    cur->next = cur->next->next;
//                }
//            } else {
//                cur = cur->next;
//            }
//        }
//        return dummy->next;
//    }

    /**
     * recursive solution refer:
     * https://leetcode.com/problems/add-two-numbers/discuss/1340/A-summary-about-how-to-solve-Linked-List-problem-C%2B%2B
     */
    static ListNode *deleteDuplicates(ListNode *head) {
        if (!head) {
            return 0;
        }
        if (!head->next) {
            return head;
        }
        int val = head->val;
        ListNode *p = head->next;
        if (val != p->val) {
            head->next = deleteDuplicates(p);
            return head;
        } else {
            while (p && p->val == val) {
                p = p->next;
            }
            return deleteDuplicates(p);
        }
    }


//    static ListNode* deleteDuplicates(ListNode* head) {
//        if (!head) {
//            return head;
//        }
//        ListNode dummy = ListNode(0);
//        dummy.next = head;
//        ListNode* curr = &dummy;
//        int duplicate = -1;
//        while (head != nullptr) {
//            if (head->next && head->val == head->next->val) {
//                duplicate = head->val;
//                while (head->next && duplicate == head->next->val) {
//                    head = head->next;
//                }
//                curr->next = head->next;
//            } else {
//                curr = curr->next;
//            }
//            head = head->next;
//        }
//        return dummy.next;
//    }
};


//int main() {
//    ListNode l1 = ListNode(1);
//    ListNode l11 = ListNode(2);
//    ListNode l111 = ListNode(3);
//    ListNode l1111 = ListNode(3);
//    ListNode l11111 = ListNode(3);
//    ListNode l111111 = ListNode(4);
//    ListNode l1111111 = ListNode(4);
//    ListNode l11111111 = ListNode(5);
//    l1111111.next = &l11111111;
//    l111111.next = &l1111111;
//    l11111.next = &l111111;
//    l1111.next = &l11111;
//    l111.next = &l1111;
//    l11.next = &l111;
//    l1.next = &l11;
//
//    Solution::deleteDuplicates(&l1);
//}