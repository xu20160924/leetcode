//
// Created by John on 2020/3/25.
//

#include <bitstring.h>
#include "iostream"

using namespace std;

class Solution{
public:
    int reverseBits(int num) {
        int max = 0;
        int cnt = 0, cntPre = 0;
        while (num) {
//            cout << bit_set(num) << endl;
            cout << bitset<32>(num) << endl;
            if (1 & num) {
                cnt++;
            } else {
                if (cntPre + cnt + 1 > max) {
                    max = cntPre + cnt + 1;
                }
                cntPre = cnt;
                cnt = 0;
            }
            num >>= 1;
        }
        if (cntPre + cnt + 1 > max) {
            max = cntPre + cnt + 1;
        }
        return max;
    }
};

//int main() {
//    Solution *solution = new Solution();
//    solution->reverseBits(1775);
//}