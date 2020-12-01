//
// Created by John on 2020/2/4.
//

#include <cmath>
#include "FourFiveEight.h"

class Solution{
public:
    static int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int states = minutesToTest / minutesToDie + 1;
        return ceil(log(buckets) / log(states));
    }
};