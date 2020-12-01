//
// Created by John on 2020/4/11.
//

#include "vector"
using namespace std;

class Solution{
public:
    void mergeSortedArray(vector<int> A, int m, vector<int> B, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        while (i >= 0 && j >= 0) {
            if (A[i] > B[j]) {
                A[k--] = A[i--];
            } else {
                A[k--] = B[j--];
            }
        }
        while (j >= 0) {
            A[k--] = B[j--];
        }
    }
};
