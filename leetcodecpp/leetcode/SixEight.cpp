//
// Created by caidaoliuhai on 2025/12/28.
//
using namespace std;

#include "vector"
#include "iostream"

class Solution {
public:
    vector<string> fullJustify(vector<string>& words, int maxWidth) {
        vector<string> res;
        int currentWidth = 0;
        int currentCount = 0;
        int k = 0;
        int n = words.size();
        int currentRemain = maxWidth;
        for (int i = 0; i < words.size(); i++) {
            if (static_cast<int>(words[i].size()) > currentRemain) {
                int gapWidth = maxWidth - currentWidth;
                int evenGap = 0, remainder = 0;
                if (currentCount == 1) {
                    evenGap = gapWidth;
                } else {
                    int divisor = currentCount - 1;
                    evenGap = gapWidth / divisor;
                    remainder = gapWidth % divisor;
                }
                string whiteGap(evenGap, ' ');
                string str;

                for (int j = k; j < i; j++) {
                    str += words[j];
                    if (remainder-- > 0) {
                        str += ' ';
                    }
                    if (j != i - 1) {
                        str += whiteGap;
                    }
                }
                if (currentCount == 1) {
                    str += whiteGap;
                }
                res.push_back(str);
                k = i;
                currentRemain = maxWidth;
                currentWidth = 0;
                currentCount = 0;
            }

            currentWidth += words[i].length();
            currentCount++;
            currentRemain -= words[i].length();
            currentRemain--;
        }
        if (currentCount > 0) {
            string str;
            for (int i = n - currentCount; i < n; i++) {
                str += words[i];
                str += ' ';
                // if (str.size() < maxWidth) {
                //
                // }
            }
            if (str.size() > maxWidth) {
                str.pop_back();
            } else {
                string whiteGap(maxWidth - str.size(), ' ');
                str += whiteGap;
            }

            res.push_back(str);
        }

        return res;
    }
};

int main() {
  Solution *solution = new Solution();
//  vector<string> vec{"This", "is", "an", "example", "of", "text", "justification."};
  vector<string> vec{"What","must","be","acknowledgment","shall","be"};
//  vector<string> vec{"Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"};
//  vector<string> vec{"ask","not","what","your","country","can","do","for","you","ask","what","you","can","do","for","your","country"};
  vector<string> res = solution->fullJustify(vec, 16);
  for (string s : res) {
      cout << s << endl;
  }
};
