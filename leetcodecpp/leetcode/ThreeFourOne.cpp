//
// Created by John on 2020/2/29.
//

#include <iostream>
#include "vector"
#include "stack"
#include "iterator"
#include "../algorithm/LeetCodeInterview.h"


using namespace std;




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
        auto res = begins.top()->getInteger();
        begins.top()++;
        return res;
//        return (begins.top()++)->getInteger();
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


//    int next() {
//        hasNext();
//        return (begins.top()++) -> getInteger();
//    }
//
//    bool hasNext() {
//        while (begins.size()) {
//            if (begins.top() == ends.top()) {
//                begins.pop();
//                ends.pop();
//            } else {
//                auto x = begins.top();
//                if (x->isInteger()) {
//                    return true;
//                }
//                begins.top()++;
//                begins.push(x->getList().begin());
//                ends.push(x->getList().end());
//            }
//        }
//        return false;
//    }

    NestedIterator() {

    }
};
int main() {
//    NestedInteger * nestedInteger = new NestedInteger();
    vector<NestedInteger> v1, v2, lists;
    NestedInteger n1 = *new NestedInteger(1);
    NestedInteger n12 = *new NestedInteger(1);
    v1.push_back(n1);
    v1.push_back(n1);
    NestedInteger n11 = *new NestedInteger(v1);


    NestedInteger n2 = *new NestedInteger(2);

    NestedInteger n21 = *new NestedInteger(3);
    NestedInteger n22 = *new NestedInteger(3);
    v2.push_back(n21);
    v2.push_back(n22);
    NestedInteger n222 = *new NestedInteger(v2);


    lists.push_back(n11);
    lists.push_back(n2);
    lists.push_back(n222);


    NestedIterator nestedIterator = *new NestedIterator(lists);
    cout << nestedIterator.next() << endl;
    cout << nestedIterator.next() << endl;
    cout << nestedIterator.next() << endl;
    cout << nestedIterator.next() << endl;
    cout << nestedIterator.next() << endl;
}