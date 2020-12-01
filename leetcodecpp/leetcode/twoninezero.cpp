//
// Created by John on 2020/1/21.
//

#include <string>
#include <sstream>
#include <vector>
#include <map>
#include "twoninezero.h"
using namespace std;


class Solution {
public:
    static bool wordPattern(std::string pa, std::string str) {
        std::string w;
        std::stringstream  ss(str);
        std::vector<std::string> words;

        while (ss >> w) {
            words.push_back(w);
        }

        if (words.size() != pa.size()) {
            return false;
        }
        std::map<char, std::string> ma;
        std::map<std::string, char> mb;

        for(size_t i = 0; i < words.size(); i++) {
            ma[pa[i]] = words[i];
            mb[words[i]]= pa[i];
        }

        for(size_t i = 0; i < words.size(); i++) {
            if (ma[pa[i]] != words[i] || mb[words[i]] != pa[i]) {
                return false;
            }
        }
        return true;
    }
};