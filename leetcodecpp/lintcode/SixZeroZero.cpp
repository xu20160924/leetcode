//
// Created by John on 2020/3/19.
//
#include <iostream>
#include "vector"
using namespace std;

class Solution{
public:
    // brute force
//    int minArea(vector<vector<char> > & image, int x, int y) {
//        int left = y, right = y, up = x, down = x;
//        for (int i = 0; i < image.size(); ++i) {
//            for (int j = 0; j < image[i].size(); ++j) {
//                if (image[i][j] == '1') {
//                    left = min(left, j);
//                    right = max(right, j);
//                    up = min(up, i);
//                    down = max(down, i);
//                }
//            }
//        }
//        return (right - left + 1) * (down - up + 1);
//    }

    // dfs
//    int minArea(vector<vector<char> > & image, int x, int y) {
//        int left = y, right = y, up = x, down = x;
//
//    }
//    void dfs(vector<vector<char> > & image, int x, int y, int & left, int & right, int & up, int & down) {
//        if (x < 0 || x >= image.size() || y < 0 || y >= image[0].size() || image[x][y] != '1') {
//            return;
//        }
//        left = min(left, y);
//        right = max(right, y);
//        up = min(up, x);
//        down = max(down, x);
//        image[x][y] = '2';
//        dfs(image, x + 1, y, left, right, up, down);
//        dfs(image, x - 1, y, left, right, up, down);
//        dfs(image, x, y + 1, left, right, up, down);
//        dfs(image, x, y - 1, left, right, up, down);
//    }

    // binary search
    int minArea(vector<vector<char> > & image, int x, int y) {
        int m = image.size(), n = image[0].size();
        int up = binary_search(image, true, 0, x, 0, n, true);
        int down = binary_search(image, true, x + 1, m, 0, n, false);
        // There up and down decrease access element,
        // since outside of the up and down is unnecessary part in calculate
        int left = binary_search(image, false, 0, y, up, down, true);
        int right = binary_search(image, false, y + 1, n, up, down, false);
        return (right - left) * (down - up);
    }

    /**
     *
     * @param image
     * @param h  horizontal flag
     * @param i restrict the start
     * @param j restrict the end
     * @param low  restrict the minimum
     * @param high restrict the maximum
     * @param opt  control decrease or increase counts
     * @return
     */
    int binary_search(vector<vector<char> > & image, bool h, int i, int j, int low, int high, bool opt) {
        while (i < j) {
            int k = low, mid = (i + j) / 2;
            while (k < high && (h ? image[mid][k] : image[k][mid]) == '0') {    // find zero counts, h control access row or column
                ++k;
            }
            // if is up and left we just count that dont have 1 counts,
            // because we cannot use right and down subtract that have 1
            // In other words left and up is reduce who dont have 1
            // right and down is expands who have 1
            if (k < high == opt) {
                j = mid;
            } else {
                i = mid + 1;
            }
        }
        return i;
    }
};

//int main() {
//    vector<vector<char> > image;
//    vector<char> row1, row2, row3;
//    row1.push_back('0');
//    row1.push_back('0');
//    row1.push_back('1');
//    row1.push_back('0');
//
//    row2.push_back('0');
//    row2.push_back('1');
//    row2.push_back('1');
//    row2.push_back('0');
//
//    row3.push_back('0');
//    row3.push_back('1');
//    row3.push_back('0');
//    row3.push_back('0');
//
//    image.push_back(row1);
//    image.push_back(row2);
//    image.push_back(row3);
//
//
//    Solution * solution = new Solution();
//    cout << solution->minArea(image, 1, 2) << endl;
//}
