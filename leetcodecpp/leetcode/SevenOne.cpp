//
// Created by caidaoliuhai on 2026/1/3.
//
#include "string"
#include "iostream"

using namespace std;

class Solution{
public:
    string simplifyPath(string path) {
        int j = 0;
        vector<string> v;
        string curr;

        path += '/';
        int n = path.size();

        for (int i = 0; i < n; i++) {
            // int i = 0, j = 0, k = 0;
            switch(path[i]) {
                case '/':
                    if (j == 2 && j == curr.size()) {
                        if (!v.empty()) {
                            v.pop_back();
                        }
                        curr.clear();
                        j = 0;
                        continue;
                    }
                    if (j == 1 && j == curr.size()) {
                        curr.clear();
                        j = 0;
                        continue;
                    }
                    if (!curr.empty()) {
                        v.push_back(curr);
                        j = 0;
                        curr.clear();
                    }
                    break;
                case '.':
                    curr += path[i];
                    j++;
                    break;
                default:
                    curr += path[i];
                    break;
            }
        }

        string res;
        // res += '/';
        for (int i = 0; i < v.size(); i++) {
            res += '/';
            res += v[i];
        }


        return res.empty() ? "/" : res;
    }
};

int main() {
    string s = "/a/./b/../../c/";
    Solution *solution = new Solution();
    solution->simplifyPath(s);
}