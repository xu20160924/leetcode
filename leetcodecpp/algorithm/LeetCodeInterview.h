//
// Created by John on 2020/2/14.
//

#ifndef UNTITLED_LEETCODEINTERVIEW_H
#define UNTITLED_LEETCODEINTERVIEW_H

#include <MacTypes.h>
#include "iostream"

using namespace std;

struct ListNode {
//    int val;
//    ListNode *next;
//    ListNode(int x) : val(x), next(NULL) {}

     int val;
     ListNode *next;
     ListNode() : val(0), next(nullptr) {}
     ListNode(int x) : val(x), next(nullptr) {}
     ListNode(int x, ListNode *next) : val(x), next(next) {}
};

struct Node {
    int val;
    Node* next;
    Node* random;

    Node(int _val) {
        val = _val;
        next = NULL;
        random = NULL;
    }
};

ListNode* createListNode(int *array, int size) {
    ListNode *root, *head = new ListNode();
    head->next = root;

    for (int i = 0; i < size; ++i) {

        root->val = array[i];   // current node
        root->next = NULL;

        if ((i + 1) < size) {
            ListNode *p = new ListNode(); // next node
            p->val = array[i + 1];

            root->next = p;
            root = root->next;
        }
    }
    return head->next;
}



#endif //UNTITLED_LEETCODEINTERVIEW_H
