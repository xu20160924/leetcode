//
// Created by John on 2022/4/10.
//

#include "../algorithm/LeetCodeInterview.h"

class Solution {
public:
    static ListNode* deleteDuplicates(ListNode* head) {
        if (!head) {
            return head;
        }
        ListNode *t = head, *p = head->next;
        int pre = head->val;
        while (p) {
            if (pre != p->val) {
                t->next = p;
                pre = p->val;
                t = t->next;
            }
            p = p->next;
        }
        t->next = NULL;
        return head;
    }
};

//ListNode* dummy = head;
//while (head != nullptr && head->next != nullptr) {
//while (head->val == head->next->val) {
//head->next = head->next->next;
//}
//head = head->next;
//}
//return dummy;

//        int pre = -1;
//        while (head != nullptr) {
//            pre = head->val;
//
//            ListNode& temp = *head;
//            while (head != nullptr && pre == head->val) {
//                head = head->next;
//            }
//            temp.next = head;
//        }

