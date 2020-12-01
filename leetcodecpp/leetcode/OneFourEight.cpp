//
// Created by John on 2020/1/27.
//

#include "OneFourEight.h"
#include <iostream>

using namespace std;

struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};


/**
 * bottom-up merge sort
 * solution from leetcode
 * sort list
 */
class Solution {
public:
    static ListNode *sortList(ListNode *head) {
        if (!head || !(head->next)) {
            return head;
        }

        ListNode* cur = head;
        int length = 0;
        while (cur) {
            length++;
            cur = cur->next;
        }

        ListNode dummy(0);
        dummy.next = head;
        ListNode *left, *right, *tail;
        for (int step = 1; step < length; step <<= 1) {
            cur = dummy.next;
            tail = &dummy;
            while (cur) {
                left = cur;
                right = split(left, step);
                cur = split(right, step);
                tail = merge(left, right, tail);
            }
        }
        return dummy.next;
    }

private:
    /**
     * Divide the linked list into two lists,
     * while the first list contains first n nodes
     * return the second list's head
     */
    static ListNode* split(ListNode *head, int n){
        for (int i = 1; head && i < n; i++) {
            head = head->next;
        }
        if (!head) {
            return NULL;
        }
        ListNode *second = head->next;
        head->next = NULL;
        return second;
    }

    /**
     * merge the tow sorted linked list l1 and l2
     * then append the merged sorted linked list to the node head
     * return the tail of merge sorted linked list
     * @param l1
     * @param l2
     * @param head
     * @return
     */
private:
    static ListNode* merge(ListNode* l1, ListNode* l2, ListNode* head) {
        ListNode *cur = head;
        while (l1 && l2) {
            if (l1->val > l2->val) {
                cur->next = l2;
                cur = l2;
                l2 = l2->next;
            } else {
                cur->next = l1;
                cur = l1;
                l1 = l1->next;
            }
        }
        cur->next = (l1 ? l1: l2);
        while (cur->next) {
            cur = cur->next;
        }
        return cur;
    }
};

//int main() {
//    ListNode* list = new ListNode(4);
//    ListNode* list2 = new ListNode(2);
//    ListNode* list3 = new ListNode(1);
//    ListNode* list4 = new ListNode(3);
//    list->next = list2;
//    list2->next = list3;
//    list3->next = list4;
//
//    Solution::sortList(list);
//
////    for (int i = 1; i < 10; i <<= 1) {
////        cout << "result: " << i << endl;
////    }
//}
