//
// Created by John on 2025/4/28.
//
#include <iostream>
#include <string>
#include <unordered_map>
#include <vector>

using namespace std;

class Solution {
public:
    void test(vector<string> arr) {
        unordered_map<string, int> map;
        for (string a : arr) {
            map[a]++;
        }
        // Print the map contents to verify it works
        for (const auto& p : map) {
            cout << p.first << ": " << p.second << endl;
        }
    }
};

int main() {
    vector<string> arr = {"foo", "bar"};
    Solution solution;
    solution.test(arr);
    return 0;
}
