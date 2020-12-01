//
// Created by John on 2020/3/5.
//

#include "vector"
#include "stack"

using namespace std;

class Solution{
public:
    int largestRectangleArea(vector<int> & heights) {
        //push end prevent cannot find smaller one on the right
        heights.push_back(0);
        stack<int> stk;
        int maxArea = 0;
        for (int i = 0; i < heights.size(); ++i) {
            while (!stk.empty() && heights[i] < heights[stk.top()]) {
                int top = stk.top();
                stk.pop();
                maxArea = max(maxArea, heights[top]* (stk.empty() ? i : (i - stk.top() - 1)));
            }
            stk.push(i);
        }
        return maxArea;
    }
};