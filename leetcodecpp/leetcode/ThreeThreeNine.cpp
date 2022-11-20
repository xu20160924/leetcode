//
// Created by caidaoliuhai on 2022/11/16.
//
#include "../algorithm/LeetCodeInterview.h"

class Solution {

//    recursion solution
//public:
//    int depthSum(vector<NestedInteger>& nested) {
//        return ds(1, nested);
//    }
//private:
//    int ds(int level, vector<NestedInteger> nested) {
//        int sum = 0;
//        for (NestedInteger ni : nested) {
//            if (ni.isInteger()) {
//                sum += level * ni.getInteger();
//            } else {
//                sum += ds(level++, ni.getList());
//            }
//        }
//        return sum;
//    }

public:
    int depthSum(vector<NestedInteger> &nestedList) {
        deque<pair<int, NestedInteger>> q;
        int level = 1;
        for (NestedInteger n : nestedList) {
            q.push_back({ level, n});
        }

        int res = 0;
        while (!q.empty()) {
            auto pair = q.front();
            q.pop_front();
            if (pair.second.isInteger()) {
                level--;
                res = (level * (pair.second.getInteger()));
                cout << res << endl;
            } else {
                level++;
                for (NestedInteger nestedInteger : pair.second.getList()) {
                    q.push_front({level, nestedInteger});
                }
            }
        }
        return res;
    }
};

int main () {
    Solution* solution = new Solution();
//    NestedInteger oneN({NestedInteger(1), NestedInteger(1)});
//    NestedInteger two(2);
//    NestedInteger threeN({NestedInteger(3), NestedInteger(3)});

    NestedInteger oneN({NestedInteger(1), NestedInteger(1)});
    NestedInteger two(2);
    NestedInteger threeN({NestedInteger(3), NestedInteger(3)});

//    NestedInteger oneN(1);
//    NestedInteger two(4, {NestedInteger(6)});
//    NestedInteger threeN({, NestedInteger(1)});

    vector<NestedInteger> pass{oneN, two, threeN};
    int res = solution->depthSum(pass);
    cout << res << endl;
}