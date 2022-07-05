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



#endif //UNTITLED_LEETCODEINTERVIEW_H
