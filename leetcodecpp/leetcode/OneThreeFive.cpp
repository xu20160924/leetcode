//
// Created by John on 2025/5/29.
//
#include "vector"
#include "iostream"

using namespace std;


class Solution {
public:
    int candy(vector<int> &ratings) {
        int totalCandy = 1;
        int previousRate = ratings[0];
        int previousCandy = 1;
        int peakLength = 1;
        int valleyLength = 0;

        for (int i = 1; i < ratings.size(); i++) {
            int currentCandy = 1;
            int rate = ratings[i];

            if (rate < previousRate) {
                valleyLength++;
                if (peakLength == valleyLength) {
                    valleyLength++;
                }
                currentCandy = 1;
                totalCandy += valleyLength;
                // 如果在这里修改peakLength 需要考虑到下次循环的时候如果不是增加的情况，那么这里的peakLength重置就会影响到下次小于的情况。

            } else if (rate >= previousRate) {
                currentCandy += (rate == ratings[i - 1] ? 0 : previousCandy);
                totalCandy += currentCandy;
                valleyLength = 0;
                peakLength = currentCandy;
            }
            previousCandy = currentCandy;
            previousRate = rate;
        }
        return totalCandy;
    }
};

int main(int argc, char *argv[]) {
    Solution *solution = new Solution();
    // vector<int> ratings = {1, 0, 2};
    vector<int> ratings = {1,2,3,1,0};
    // vector<int> ratings = {1, 2, 2};
    // vector<int> ratings = {1, 3, 2, 2, 1};
    // vector<int> ratings = {1, 2, 87, 87, 87, 2, 1};
    std::cout << solution->candy(ratings) << endl;
}
