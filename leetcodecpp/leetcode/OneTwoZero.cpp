//
// Created by John on 2020/4/30.
//
#include "vector"
using namespace std;

class Solution {
public:
    // bottom to up solution
    int minimumTotal(vector<vector<int>> triangle) {
        int n = triangle.size();
        vector<int> minlen(triangle.back());
        for (int layer = n - 2; layer >= 0; layer--) {  // for each layer
            for (int i = 0; i <= layer; i++) { // check layer's every 'node'
                // find the lesser of its two children,
                // and sum the current value in the triangle with it.
                minlen[i] = min(minlen[i], minlen[i + 1]) + triangle[layer][i];
            }
        }
        return minlen[0];
    }
};