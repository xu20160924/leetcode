//
// Created by John on 2020/3/2.
//
#include <cstdlib>
#include "set"
#include "vector"
//#include "unordered_map"
#include "unordered_map"
#include "../algorithm/LeetCodeInterview.h"
using namespace std;

class Solution{
public:
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

    Solution() {

    }


    // https://leetcode.com/problems/insert-delete-getrandom-o1/discuss/85422/AC-C%2B%2B-Solution.-Unordered_map-%2B-Vector
    bool insert(int val) {
        if (m.count(val)) {
            return false;
        }
        m.insert({val, nums.size()});
        nums.emplace_back(val);
        return true;
    }


//    Suppose you have a vector (not indices, but actual values in those positions)
//
//    0 1 2 3 4 5 6
//    and you want to remove the value 3. You can turn this into
//
//    0 1 2 6 4 5

//  warning: above content is from the above url, the key of removing is swap the last
//  element with deleted element.
    bool remove(int val) {
        if (!m.count(val)) {
            return false;
        }
        int last = nums.back();
        m[last] = m[val];
        nums[m[val]] = last;
        nums.pop_back();
        m.erase(val);
        return true;
    }
    int getRandom() {
        return nums.at(rand() % nums.size());
    }

//    bool insert(int val) {
//        if (std::find(nums.begin(), nums.end(), val) == nums.end()) {
//            nums.push_back(val);
//            return true;
//        }
//        return false;
//    }
//
//    bool remove(int val) {
//        if (std::find(nums.begin(), nums.end(), val) != nums.end()) {
//            nums.erase(std::remove(nums.begin(), nums.end(), val), nums.end());
//            return true;
//        }
//        return false;
//    }
//
//    int getRandom() {
//        int size = nums.size();
//        return nums.at(rand() % size);
//    }

private:
    vector<int> nums;
    unordered_map<int, int> m;
};




int main() {
//    Solution * solution = new Solution();
//    solution->insert(1);
//    solution->remove(2);
//    solution->insert(2);
//    solution->insert(3);
//    cout << solution->getRandom() << endl;
//    solution->remove(1);
//    solution->insert(2);
//    cout << solution->getRandom() << endl;

    Solution * solution = new Solution();
    solution->insert(1);
    solution->insert(3);
    solution->insert(2);
    solution->remove(3);
    cout << solution->getRandom() << endl;
    solution->remove(1);
    solution->insert(2);
    cout << solution->getRandom() << endl;
}
