//
// Created by John on 2020/2/29.
//

#include <iostream>
#include "vector"
#include "stack"
#include "iterator"

using namespace std;


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
    vector<NestedInteger> & getList() {
        return list;
    };
    NestedInteger(int val) {
        this->val = val;
    }
    NestedInteger(vector<NestedInteger> list) {
        this->list = list;
    }
};

class NestedIterator{
//public:
//    vector<NestedInteger> list;
//    NestedIterator(vector<NestedInteger> & nestedList) {
//        this->list = nestedList;
//    }
//    int next() {
//        NestedInteger nestedInteger = list[0];
//        if (nestedInteger.getList().empty()) {
//            return nestedInteger.getInteger();
//        }
//        NestedInteger nes = nestedInteger.getList().front();
//        nestedInteger.getList().erase()
//        //        NestedInteger * nestedInteger = new NestedInteger();
//
//    }
//    bool hasNext() {
//        return list.empty() || list.back().getList().empty();
//    }


private:
    stack<vector<NestedInteger>::iterator> begins, ends;

public:
    NestedIterator(vector<NestedInteger> & nestedList) {
        begins.push(nestedList.begin());
        ends.push(nestedList.end());
    }

    int next() {
        hasNext();
        return (begins.top()++) -> getInteger();
    }

    bool hasNext() {
        while (begins.size()) {
            if (begins.top() == ends.top()) {
                begins.pop();
                ends.pop();
            } else {
                auto x = begins.top();
                if (x->isInteger()) {
                    return true;
                }
                begins.top()++;
                begins.push(x->getList().begin());
                ends.push(x->getList().end());
            }
        }
        return false;
    }

    NestedIterator() {

    }
};
//int main() {
////    NestedInteger * nestedInteger = new NestedInteger();
//    vector<NestedInteger> v1, v2, lists;
//    NestedInteger n1 = *new NestedInteger(1);
//    NestedInteger n12 = *new NestedInteger(1);
//    v1.push_back(n1);
//    v1.push_back(n1);
//    NestedInteger n11 = *new NestedInteger(v1);
//
//
//    NestedInteger n2 = *new NestedInteger(2);
//
//    NestedInteger n21 = *new NestedInteger(1);
//    NestedInteger n22 = *new NestedInteger(1);
//    v2.push_back(n21);
//    v2.push_back(n22);
//    NestedInteger n222 = *new NestedInteger(v2);
//
//
//    lists.push_back(n11);
//    lists.push_back(n2);
//    lists.push_back(n222);
//
//
//    NestedIterator nestedIterator = *new NestedIterator(lists);
//    cout << nestedIterator.next() << endl;
//    cout << nestedIterator.next() << endl;
//    cout << nestedIterator.next() << endl;
//    cout << nestedIterator.next() << endl;
//    cout << nestedIterator.next() << endl;
//}