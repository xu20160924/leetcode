//
// Created by John on 2020/3/17.
//
#include "vector"
using namespace std;

class Solution{
    // wrong answer
//public:
//    vector<vector<int> > merge(vector<vector<int> > & intervals) {
//        for (int i = 1; i < intervals.size(); i++) {
//            if (intervals[i-1][1] >= intervals[i][0] && intervals[i-1][0] <= intervals[i][1]) {
//                if (intervals[i-1][0] < intervals[i][0]) {
//                    intervals[i][0] = intervals[i-1][0];
//                }
//                if (intervals[i-1][1] > intervals[i][1]) {
//                    intervals[i][1] = intervals[i-1][1];
//                }
////                if (intervals[i-1][1] > intervals[i][1]) {
////                    intervals[i][1] = intervals[i-1][1];
////                    //                    intervals[i][0] = min(intervals[i-1][0], intervals[i][0]);
////                } else {
////                    intervals[i][1] = intervals[i-1][1];
////                }
//                intervals.erase(intervals.begin()+(i-1));
//                i -= 1;
//            }
//        }
//        return intervals;
//    }
public:
    vector<vector<int> > merge(vector<vector<int> > & intervals) {
        if (intervals.size() == 0 || intervals.size() == 1) {
            return intervals;
        }
        // initialize
        int u = 0, v = 0;
        vector<vector<int> > ans;
        sort(intervals.begin(), intervals.end());
        while (v < intervals.size()) {
            if (intervals[v][0] > intervals[u][1]) {
                ans.push_back(intervals[u]);
                u = v;
            } else if (intervals[v][1] <= intervals[u][1]) {
                ++ v;
            } else {
                intervals[u][1] = intervals[v][1];
                ++ v;
            }
        }
        ans.push_back(intervals[u]);
        return ans;
    }

};

//int main() {
//    vector<vector<int> > intervals;
//    vector<int> pair1, pair2, pair3, pair4, pair5;
////    pair1.push_back(1);
////    pair1.push_back(3);
////
////    pair2.push_back(2);
////    pair2.push_back(6);
////
////    pair3.push_back(8);
////    pair3.push_back(10);
////
////    pair4.push_back(15);
////    pair4.push_back(18);
//
////    pair1.push_back(1);
////    pair1.push_back(4);
////
////    pair2.push_back(5);
////    pair2.push_back(6);
//
////    pair1.push_back(1);
////    pair1.push_back(4);
////
////    pair2.push_back(0);
////    pair2.push_back(4);
//
//    pair1.push_back(1);
//    pair1.push_back(3);
//
//    pair2.push_back(2);
//    pair2.push_back(6);
//
//    pair3.push_back(8);
//    pair3.push_back(10);
//
//    pair4.push_back(15);
//    pair4.push_back(18);
//
////    pair3.push_back(8);
////    pair3.push_back(10);
////
////    pair4.push_back(15);
////    pair4.push_back(18);
//
//    intervals.push_back(pair1);
//    intervals.push_back(pair2);
//    intervals.push_back(pair3);
//    intervals.push_back(pair4);
////    intervals.push_back(pair5);
////    intervals.push_back(pair3);
////    intervals.push_back(pair4);
//
//    Solution * solution = new Solution();
//    solution->merge(intervals);
//}