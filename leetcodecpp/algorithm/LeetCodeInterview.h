//
// Created by John on 2020/2/14.
//

#ifndef UNTITLED_LEETCODEINTERVIEW_H
#define UNTITLED_LEETCODEINTERVIEW_H

#include <MacTypes.h>
#include "iostream"
#include "vector"
#include "unordered_map"
#include "map"
#include "queue"
#include "unordered_map"
#include "stack"
#include "deque"

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


// This is the interface that allows for creating nested lists.
// You should not implement it, or speculate about its implementation
class NestedInteger {
private:
    int val = NULL;
    vector<NestedInteger> list;
public:

    // Return true if this NestedInteger holds a single integer, rather than a nested list.
    bool isInteger() const {
        return val != NULL;
    };
    // Return the single integer that this NestedInteger holds, if it holds a single integer
    // The result is undefined if this NestedInteger holds a nested list
    int getInteger() const {
        return val;
    };
    // Return the nested list that this NestedInteger holds, if it holds a nested list
    // The result is undefined if this NestedInteger holds a single integer
    const vector<NestedInteger> &getList() const {
        return list;
    };
    vector<NestedInteger> &getList() {
        return list;
    };
    NestedInteger(int val) {
        this->val = val;
    }
    NestedInteger(vector<NestedInteger> list) {
        this->list = list;
    }
    NestedInteger(int val, vector<NestedInteger> list) {
        this->val = val;
        this->list = list;
    }
};

template<typename T, size_t n>
void print_array(T const(& arr)[n]) {
    for (size_t i = 0; i < n; i++) {
        cout << arr[i] << ' ' ;
    }
}



#endif //UNTITLED_LEETCODEINTERVIEW_H
