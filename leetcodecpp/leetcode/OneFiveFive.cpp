//
// Created by John on 2020/2/18.
//

#include "OneFiveFive.h"
#include <limits.h>
#include <stack>

using namespace std;

class Solution{
//    int min = INT_MAX;
//    stack<int> stack;
    long min = INT_MAX;
    std::stack<long> stack;

public:
    /** initialize your data structure here. */
//    Solution() {
//    }
//
//    void push(int x) {
//        if (x <= min) {
//            stack.push(min);
//            min = x;
//        }
//        stack.push(x);
//    }
//
//    void pop() {
//        int num = stack.top();
//        stack.pop();
//        if (num == min) {
//            min = stack.top();
//            stack.pop();
//        }
//
//    }
//
//    int top() {
//        return stack.top();
//    }
//
//    int getMin() {
//        return min;
//    }



    void push(int x) {
        if (stack.empty()) {
            stack.push(0L);
            min = x;
        } else {
            stack.push(x-min);
            if (x < min) {
                min = x;
            }
        }
    }

    void pop() {
        if (stack.empty()) {
            return;
        }
        long pop = stack.top();
        stack.pop();
        if (pop < 0) {
            min = min - pop;
        }
    }

    int top() {
        long top = stack.top();
        if (top > 0) {
            return top + min;
        } else {
            return min;
        }
    }

    int getMin() {
        return (int)min;
    }
};

//int main() {
//    Solution * solution = new Solution();
//    solution->push(-2);
//    solution->push(0);
//    solution->push(1);
//    solution->push(-3);
//    printf("%d\n", solution->getMin());
//    solution->pop();
//    printf("%d\n", solution->top());
//    printf("%d\n", solution->getMin());
//
//
//}