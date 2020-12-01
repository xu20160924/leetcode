//
// Created by John on 2020/4/27.
//

#include "vector"
#include "set"

using namespace std;

class Solution {
public:
    vector<vector<int>> getSkyline(vector<vector<int>> &buildings) {
        vector<pair<int, int>> h;
        multiset<int> m;
        vector<vector<int>> res;

        // 1. 将每一个建筑分成两个部分, 例如[2, 9, 10] 可以转换成[2, -10][9, 10]
        // 我们用负值来表示左边界
        for (const auto &b:buildings) {
            h.push_back({b[0], -b[2]});
            h.push_back({b[1], b[2]});
        }

        // 2. 根据x值对分段进行排序
        sort(h.begin(), h.end());
        int prev = 0, cur = 0;
        m.insert(0);

        // 3. 遍历
        for (auto i : h) {
            if (i.second < 0) {
                m.insert(-i.second); // 左端点，高度入堆
            } else {
                m.erase(m.find(i.second)); // 右端点，高度出堆
            }
            cur = *m.rbegin();          // 当前最大高度
            // 当前最大高度不等于最大高度prev表示这是一个转折点
            if (cur != prev) {
                res.push_back({i.first, cur}); // 添加结果
                prev = cur;             // 更新最大高度
            }
        }
        return res;
    }



//    vector<vector<int>> getSkyline(vector<vector<int>> & buildings) {
//        multiset<pair<int, int>> all;
//        vector<vector<int>> res;
//
//        for (auto& e : buildings) {
//            // critical point, left corner
//            all.insert(make_pair(e[0], -e[2]));
//            // critical point, right corner
//            all.insert(make_pair(e[1], e[2]));
//        }
//
//        // 保存当前位置所有高度
//        multiset<int> heights({0});
//        // 保存上一个位置的横坐标以及高度
//        vector<int> last = {0, 0};
//
//        for (auto& p: all) {
//            if (p.second < 0) {
//                // 左端点，高度入堆
//                heights.insert(-p.second);
//            } else {
//                // 右端点，移除高度
//                heights.erase(heights.find(p.second));
//            }
//            // 当前关键点，最大高度
//            auto maxHeight = *heights.rbegin();
//
//            // 当前最大高度如果不同于上一个高度，说明这是一个转折点
//            if (last[1] != maxHeight) {
//                // 更新last, 并加入结果集
//                last[0] = p.first;
//                last[1] = maxHeight;
//                res.push_back(last);
//            }
//        }
//        return res;
//    }
};


//int main() {
//    vector<vector<int>> buildings;
//    vector<int> b1, b2, b3, b4, b5;
//    b1.push_back(2);
//    b1.push_back(9);
//    b1.push_back(10);
//
//    b2.push_back(3);
//    b2.push_back(7);
//    b2.push_back(15);
//
//    b3.push_back(5);
//    b3.push_back(12);
//    b3.push_back(12);
//
//    b4.push_back(15);
//    b4.push_back(20);
//    b4.push_back(10);
//
//    b5.push_back(19);
//    b5.push_back(24);
//    b5.push_back(8);
//
//    buildings.push_back(b1);
//    buildings.push_back(b2);
//    buildings.push_back(b3);
//    buildings.push_back(b4);
//    buildings.push_back(b5);
//
//    Solution *solution = new Solution();
//    solution->getSkyline(buildings);
//
//}
