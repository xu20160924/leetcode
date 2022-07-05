//
// Created by John on 2020/2/5.
//

#include "../algorithm/LeetCodeInterview.h"
#include "stack"

class Solution{
//public:
//    static ListNode* rotateRight(ListNode * head, int k) {
//        if (!head) {
//            return head;
//        }
//        int len = 1;
//        ListNode *newH, *tail;
//        newH = tail = head;
//        while (tail->next) {
//            tail = tail->next;
//            len++;
//        }
//        tail->next = head;
//        if (k %= len) {
//            for (auto i = 0; i < len -k; i ++) {
//                tail = tail->next;
//            }
//        }
//        newH = tail->next;
//        tail->next = NULL;
//        return newH;
//    }

//public:
//    static ListNode* rotateRight(ListNode * head, int k) {
//        if (!k || !head || !head->next) {
//            return head;
//        }
//        ListNode *fast = head;
//        int lens = 1;
//        while (k--) {
//            if (fast->next) {
//                fast = fast->next;
//                lens++;
//            } else {
//                fast = head;
//                k %= lens;
//            }
//        }
//        if (fast == head) {
//            return head;
//        }
//        ListNode *slow = head;
//        while(fast->next) {
//            fast = fast->next;
//            slow = slow->next;
//        }
//        ListNode *newhead = slow->next; // next is fast
//        slow->next = NULL;
//        fast->next = head;
//        return newhead;
//    }
//public:
//    ListNode* rotateRight(ListNode * head, int k) {
//        if (!head) {
//            return head;
//        }
//        int len = 1; // number of nodes
//        ListNode *newH, *tail;
//        newH = tail = head;
//
//        while (tail->next) { // get the number of nodes in the list
//            tail = tail->next;
//            len++;
//        }
//        tail->next = head; // circle the link
//
//        if (k %= len) {
//            for (auto i = 0; i < len - k; i++) {
//                tail->next;     // the tail node is the(len - k) -th node(1st node is head)
//            }
//        }
//        newH = tail->next;
//        tail->next = NULL;
//        return newH;
//    }

public:
    static ListNode* rotateRight(ListNode *head, int k) {
        if (!head) {
            return head;
        }
        int len = 1;
        ListNode *p = head;
        while (p->next) {
            len++;
            p = p->next;
        }
        p->next = head;

        if (k %= len) {
            for (int i = 0; i < len - k; ++i, p = p->next);
        }
        ListNode* newHead = p->next;
        p->next = NULL;
        return newHead;
    }

    // myself
//    static ListNode* rotateRight(ListNode *head, int k) {
//        if (!head) {
//            return head;
//        }
//        ListNode *dummy = new ListNode(0);
//        dummy->next = head;
//        int total = 0;
//
//        while (dummy->next) {
//            total++;
//            dummy = dummy->next;
//        }
//        dummy->next = head;
//
//        if (k / total) {
//            k = (total - (k % total) + 1);
//        } else {
//            k = (total - k + 1);
//        }
//
//        ListNode *tail;
//        while (--k >= 0) {
//            if (k == 0) {
//                tail = dummy;
//            }
//            dummy = dummy->next;
//        }
//        tail->next = NULL;
//        return dummy;
//    }
};


/**
 * Input: head = [1,2,3,4,5], k = 2
 * [0,1,2], k = 4
 * [2,0,1]
 * 2 0 1
 * 1 2 0
 * 0 1 2
 * 2 0 1
 */

//int main() {
////    cout << (2 % 5) << endl;
//
////    ListNode * node1 = new ListNode(1);
////    ListNode * node2 = new ListNode(2);
////    ListNode * node3 = new ListNode(3);
////    ListNode * node4 = new ListNode(4);
////    ListNode * node5 = new ListNode(5);
////
////    node4->next = node5;
////    node3->next = node4;
////    node2->next = node3;
////    node1->next = node2;
////    Solution::rotateRight(node1, 2);
//
////        cout << 4 % 3 << endl;
//
//
//    ListNode * zero1 = new ListNode(0);
//    ListNode * node1 = new ListNode(1);
//    ListNode * node2 = new ListNode(2);
//
//    node1->next = node2;
//    zero1->next = node1;
//    Solution::rotateRight(zero1, 4);
//}