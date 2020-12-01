//
// Created by John on 2020/3/2.
//
#include <cstdlib>
#include "set"
#include "vector"
//#include "unordered_map"
#include "unordered_map"
using namespace std;

class Solution{
public:
    Solution() {

    }
//    bool insert(int val) {
//        if (m.find(val) != m.end()) {
//            return false;
//        }
//        nums.__emplace_back(val);
////        nums.push_back(val);
//        m[val] = nums.size() - 1;
//        return true;
//    }
//
//    bool remove(int val) {
//        if (m.find(val) == m.end()) {
//            return false;
//        }
//        int last = nums.back();
//        m[last] = m[val];
//        nums[m[val]] = last;
//        nums.pop_back();
//        m.erase(val);
//        return true;
//    }
//    int getRandom() {
//        return nums[rand() % nums.size()];
//    }



//    bool insert(int val) {
//        auto curr = sets.find(val);
//        if (curr != sets.end()) {
//            return false;
//        }
//        sets.insert(val);
//        nums.push_back(val);
//        return true;
//    }
//    bool remove(int val) {
//        auto curr = sets.find(val);
//        if (curr == sets.end()) {
//            return false;
//        }
//        sets.erase(val);
//        nums.erase(val);
//
//    }
//    int getRandom() {
//        return nums[rand() % nums.size()];
//    }


private:
//    vector<int> nums;
//    unordered_map<int, int> m;
    vector<int> nums;
    set<int> sets;
};

//int main() {
////    Solution * solution = new Solution();
////    solution->insert(1);
////    solution->remove(2);
////    solution->insert(2);
////    solution->insert(3);
////    solution->getRandom();
////    solution->remove(1);
////    solution->insert(2);
////    solution->getRandom();
//}
