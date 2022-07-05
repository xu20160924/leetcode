////
//// Created by John on 2020/5/10.
////
//#include "queue"
//#include "utility"
//
//using namespace std;
//
//class Solution {
//    // 计算x的数位之和
//    int get(int x) {
//        int res = 0;
//        for (; x; x /= 10) {
//            res += x % 10;
//        }
//        return res;
//    }
//
//public:
//    int movingCount(int m, int n, int k) {
//        if (!k) {
//            return 1;
//        }
//        queue<pair<int, int>> Q;
//        // 向右和向下的方向数组
//        int dx[2] = {0, 1};
//        int dy[2] = {1, 0};
//        vector<vector<int>> vis(m, vector<int>(n, 0));
//        Q.push(make_pair(0, 0));
//        vis[0][0] = 1;
//        int ans = 1;
//        while (!Q.empty()) {
//            auto [x, y] = Q.front();
//            Q.pop();
//            for (int i = 0; i < 2; ++i) {
//                int tx = dx[i] + x;
//                int ty = dy[i] + y;
//                if (tx < 0 || tx >= m || ty <0 || ty >= n ||
//                    vis[tx][ty] || get(tx) + get(ty) > k) {
//                    continue;
//                }
//                // tx， ty 是当前计算后的值
//                Q.push(make_pair(tx, ty));
//                // 记录已经访问的节点
//                vis[tx][ty] = 1;
//                ans++;
//            }
//        }
//        return ans;
//    }
////    int movingCount(int m, int n, int k) {
////        if (!k) {
////            return 1;
////        }
////        vector<vector<int>> vis(m, vector<int>(n, 0));
////        int ans = 1;
////        vis[0][0] =1;
////        for (int i = 0; i < m; ++i) {
////           for (int j = 0; j < n; ++j) {
////               if ((i == 0 && j == 0) || get(i) + get(j) > k) {
////                   continue;
////               }
////               if (i - 1 >= 0) {
////                   vis[i][j] |= vis[i - 1][j];
////               }
////               if (j - 1 >= 0) {
////                   vis[i][j] |= vis[i][j - 1];
////               }
////               ans += vis[i][j];
////           }
////        }
////        return ans;
////    }
//};
////
////int main() {
////    Solution *solution = new Solution();
////    solution->movingCount(2, 3, 1);
////}