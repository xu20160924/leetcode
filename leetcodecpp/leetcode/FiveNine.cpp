//
// Created by caidaoliuhai on 2025/12/16.
//
#include "vector"
#include "iostream"

using namespace std;

class Solution {
public:
//    vector<vector<int>> generateMatrix(int n) {
//        int t = 0;      // top
//        int b = n-1;    // bottom
//        int l = 0;      // left
//        int r = n-1;    // right
//        vector<vector<int>> ans(n,vector<int>(n));
//        int k=1;
//        while(k<=n*n){
//            for(int i=l;i<=r;++i,++k) ans[t][i] = k;
//            ++t;
//            for(int i=t;i<=b;++i,++k) ans[i][r] = k;
//            --r;
//            for(int i=r;i>=l;--i,++k) ans[b][i] = k;
//            --b;
//            for(int i=b;i>=t;--i,++k) ans[i][l] = k;
//            ++l;
//        }
//        return ans;
//    }

    vector<vector<int>> generateMatrix(int n) {
        int total = n * n;

        vector<vector<int>> res(n, vector<int>(n));
        int x = 0, y = 0;
        int* forward = &y;
        int direction = 1;
        int top = 0, bottom = n - 1, left = 0, right = n - 1;

        for (int i = 1; i <= total; i++) {

            res[x][y] = i;

            if (forward == &y && direction == 1 && y == right) { // forward to ↓
                forward = &x;
                top++;
                direction = 1;
            } else if (forward == &x && direction == 1 && x == bottom) { // forward to ←
                forward = &y;
                right--;
                direction = -1;
            } else if (forward == &y && direction == -1 && y == left) { // forward to ↑
                forward = &x;
                bottom--;
                direction = -1;
            } else if (forward == &x && direction == -1 && x == top) { // forward to →
                forward = &y;
                left++;
                direction = 1;
            }

            (*forward) += direction;
        }
        return res;
    }

    //            // 根据当前移动方向和位置判断是否需要转向
//            if (current == horiz && dir == 1 && y == right) {
//                // 向右移动到右边界，改为向下
//                current = vert;
//                top++; // 上边界收缩
//            } else if (current == vert && dir == 1 && x == bottom) {
//                // 向下移动到底边界，改为向左
//                current = horiz;
//                dir = -1;
//                right--; // 右边界收缩
//            } else if (current == horiz && dir == -1 && y == left) {
//                // 向左移动到左边界，改为向上
//                current = vert;
//                dir = -1;
//                bottom--; // 下边界收缩
//            } else if (current == vert && dir == -1 && x == top) {
//                // 向上移动到上边界，改为向右
//                current = horiz;
//                dir = 1;
//                left++; // 左边界收缩
//            }


//    vector<vector<int>> generateMatrix(int n) {
//        vector<vector<int>> res(n, vector<int>(n, 0));
//
//        // 定义四个边界
//        int top = 0, bottom = n - 1, left = 0, right = n - 1;
//
//        int x = 0, y = 0;
//        int* horiz = &y; // 水平移动时操作y
//        int* vert = &x;  // 垂直移动时操作x
//
//        // 初始方向：向右（水平移动，增加）
//        int* current = horiz;
//        int dir = 1; // 1=增加，-1=减少
//
//        int num = 1;
//
//        while (num <= n * n) {
//            res[x][y] = num++;
//
//            // 根据当前移动方向和位置判断是否需要转向
//            if (current == horiz && dir == 1 && y == right) {
//                // 向右移动到右边界，改为向下
//                current = vert;
//                top++; // 上边界收缩
//            } else if (current == vert && dir == 1 && x == bottom) {
//                // 向下移动到底边界，改为向左
//                current = horiz;
//                dir = -1;
//                right--; // 右边界收缩
//            } else if (current == horiz && dir == -1 && y == left) {
//                // 向左移动到左边界，改为向上
//                current = vert;
//                dir = -1;
//                bottom--; // 下边界收缩
//            } else if (current == vert && dir == -1 && x == top) {
//                // 向上移动到上边界，改为向右
//                current = horiz;
//                dir = 1;
//                left++; // 左边界收缩
//            }
//
//            // 移动一步
//            (*current) += dir;
//        }
//
//        return res;
//    }
};

int main() {
    Solution *solution = new Solution();
    vector<vector<int>> res = solution->generateMatrix(4);
    cout << "end" << endl;
}