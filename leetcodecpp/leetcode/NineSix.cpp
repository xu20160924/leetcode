//
// Created by John on 2020/2/20.
//

#include "NineSix.h"

class Solution{
public:
    int numTrees(int n) {
        long C = 1;
        for (int i = 0; i < n; i++) {
            C = C * 2 * (2 * i + 1) / (i + 2);
        }
        return int(C);
    }
};