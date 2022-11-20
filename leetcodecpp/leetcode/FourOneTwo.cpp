//
// Created by John on 2020/2/29.
//
#include "ostream"
#include "vector"

using namespace std;

class Solution{
public:
//    vector<string> fizzBuzz(int n) {
//        vector<string> res;
//        for (int i = 1; i < n + 1; i++) {
//            if (i % 3 == 0 && i % 5 == 0) {
//                res.push_back("FizzBuzz");
//                continue;
//            }
//            if (i % 3 == 0) {
//                res.push_back("Fizz");
//                continue;
//            }
//            if (i % 5 == 0) {
//                res.push_back("Buzz");
//                continue;
//            }
//            res.push_back(to_string(i));
//        }
//        return res;
//    }
    vector<string> fizzBuzz(int n) {
        vector<string> res;
        for (int i = 1; i < n + 1; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                res.push_back("FizzBuzz");
                continue;
            }
            if (i % 3 == 0) {
                res.push_back("Fizz");
                continue;
            }
            if (i % 5 == 0) {
                res.push_back("Buzz");
                continue;
            }
            res.push_back(to_string(i));
        }
        return res;
    }
};

//int main() {
//    Solution * solution = new Solution();
//    solution->fizzBuzz(15);
//}
