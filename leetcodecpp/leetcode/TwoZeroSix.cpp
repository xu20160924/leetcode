//
// Created by caidaoliuhai on 2025/6/10.
//
#include "../algorithm/LeetCodeInterview.h"

using namespace std;

class Solution {
public:
    ListNode* reverseList(ListNode* head) {
        ListNode* pre = head;
        ListNode* dummy = new ListNode(0);
        dummy->next = head;
        ListNode* current = dummy->next;
        head = head->next;
        while (head != NULL) {

            current->next = pre;
            current = current->next;
            pre = head;
            head = head->next;

        }
        return dummy->next;
    }
};