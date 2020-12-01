//
// Created by John on 2020/4/11.
//
#include "vector"

using namespace std;

class Solution {
public:
    void merge(vector<int> A, int m, vector<int> B, int n) {
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
//    void merge(int A[], int m, int B[], int n) {
//        int p = m - 1, q = n - 1, i = m + n - 1;
//        while (q >= 0) {
//            if (p < 0 || B[q] >= A[p]) {
//                A[i--] = B[q--];
//            } else {
//                A[i--] = A[p--];
//            }
//        }
//    }
};

//int main() {
//    Solution *solution = new Solution();
//    vector<int> A = {1, 2, 3, 0, 0, 0};
//    vector<int> B = {2, 5, 6};
//    solution->merge(A, 3, B, 3);
//}
